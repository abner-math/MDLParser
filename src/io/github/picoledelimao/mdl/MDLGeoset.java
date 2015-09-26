package io.github.picoledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLBoolean;
import io.github.picoledelimao.mdl.core.MDLMatrix;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLObjectArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLGeoset extends MDLBoundedObject {

	private MDLObjectArray<MDLNumberArray> vertices;
	private MDLObjectArray<MDLNumberArray> normals;
	private MDLObjectArray<MDLNumberArray> tvertices;
	private MDLObjectArray<MDLNumber> vertexGroup;
	private MDLMatrix faces;
	private MDLMatrix groups;
	private MDLObjectArray<MDLAnim> anims;
	private MDLNumber<Integer> materialID;
	private MDLNumber<Integer> selectionGroup;
	private MDLBoolean unselectable;
	
	public MDLGeoset() throws NoSuchMethodException, SecurityException {
		super("Geoset");
		this.vertices = new MDLObjectArray<>("Vertices", true, MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), "", Float.class, 3);
		this.normals = new MDLObjectArray<>("Normals", true, MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), "", Float.class, 3);
		this.tvertices = new MDLObjectArray<>("TVertices", true, MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), "", Float.class, 2);
		this.vertexGroup = new MDLObjectArray<>("VertexGroup", false, MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), "", new Integer(0), true);
		this.faces = new MDLMatrix("Faces", MDLTriangles.class.getDeclaredConstructor());
		this.groups = new MDLMatrix("Groups", MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), "Matrices", Integer.class, -1);
		this.anims = new MDLObjectArray<>("", false, MDLAnim.class.getDeclaredConstructor());
		this.materialID = new MDLNumber<>("MaterialID", -1, false);
		this.selectionGroup = new MDLNumber<>("SelectionGroup", 0, true);
		this.unselectable = new MDLBoolean("Unselectable");
	}

	public MDLObjectArray<MDLNumberArray> getVertices() {
		return vertices;
	}
	
	public MDLObjectArray<MDLNumberArray> getNormals() {
		return normals;
	}
	
	public MDLObjectArray<MDLNumberArray> getTVertices() {
		return tvertices;
	}
	
	public MDLObjectArray<MDLAnim> getAnims() {
		return anims;
	}
	
	public int getMaterialID() {
		return materialID.getValue();
	}
	
	public void setMaterialID(int newMaterialID) {
		this.materialID.setValue(newMaterialID);
	}
	
	public int getSelectionGroup() {
		return selectionGroup.getValue();
	}
	
	public void setSelectionGroup(int newSelectionGroup) {
		this.selectionGroup.setValue(newSelectionGroup);
	}
	
	public boolean isUnselectable() {
		return unselectable.getValue();
	}
	
	public void setUnselectable(boolean unselectable) {
		this.unselectable.setValue(unselectable);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, vertices, normals, tvertices, vertexGroup, faces, groups, materialID, selectionGroup, unselectable);
		contents = anims.parse(contents).second;
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(vertices, normals, tvertices, vertexGroup, faces, groups, minimumExtent, maximumExtent, boundsRadius, anims, materialID, selectionGroup, unselectable));
	}
	
}
