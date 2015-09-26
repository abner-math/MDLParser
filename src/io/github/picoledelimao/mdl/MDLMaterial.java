package io.github.picoledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLBoolean;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLObjectArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLMaterial extends MDLObjectArray<MDLLayer> {

	private MDLBoolean constantColor;
	private MDLBoolean sortPrimsFarZ;
	private MDLBoolean fullResolution;
	private MDLNumber<Integer> priorityPlane;
	
	public MDLMaterial() throws NoSuchMethodException, SecurityException {
		super("Material", false, MDLLayer.class.getDeclaredConstructor());
		this.constantColor = new MDLBoolean("ConstantColor");
		this.sortPrimsFarZ = new MDLBoolean("SortPrimsFarZ");
		this.fullResolution = new MDLBoolean("FullResolution");
		this.priorityPlane = new MDLNumber<>("PriorityPlane", 0, false);
	}

	public boolean isConstantColor() {
		return constantColor.getValue();
	}
	
	public void setConstantColor(boolean constantColor) {
		this.constantColor.setValue(constantColor);
	}
	
	public boolean isSortPrimsFarZ() {
		return sortPrimsFarZ.getValue();
	}
	
	public void setSortPrimsFarZ(boolean sortPrimsFarZ) {
		this.sortPrimsFarZ.setValue(sortPrimsFarZ);
	}
	
	public boolean isFullResolution() {
		return fullResolution.getValue();
	}
	
	public void setFullResolution(boolean fullResolution) {
		this.fullResolution.setValue(fullResolution);
	}
	
	public int getPriorityPlane() {
		return priorityPlane.getValue();
	}
	
	public void setPriorityPlane(int newPriorityPlane) {
		this.priorityPlane.setValue(newPriorityPlane);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, constantColor, sortPrimsFarZ, fullResolution, priorityPlane);
		setConstantColor(constantColor.getValue());
		setSortPrimsFarZ(sortPrimsFarZ.getValue());
		setFullResolution(fullResolution.getValue());
		setPriorityPlane(priorityPlane.getValue());
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(constantColor, sortPrimsFarZ, fullResolution, priorityPlane));
	}
	
}
