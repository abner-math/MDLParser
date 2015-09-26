package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLEnum;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLObjectArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLCollisionShape extends MDLNode {

	private MDLEnum collisionType;
	private MDLObjectArray<MDLNumberArray> vertices;
	private MDLNumber<Float> boundsRadius;
	
	public MDLCollisionShape() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super("CollisionShape");
		this.collisionType = new MDLEnum("", true, "Box", "Sphere");
		this.vertices = new MDLObjectArray<>("Vertices", true, MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), "", Float.class, 3);
		this.boundsRadius = new MDLNumber<>("BoundsRadius", new Float(0), false);
	}
	
	public String getCollisionType() {
		return collisionType.getValue();
	}
	
	public void setCollisionType(String newCollisionType) throws MDLParserErrorException {
		this.collisionType.setValue(newCollisionType);
	}
	
	public MDLObjectArray<MDLNumberArray> getVertices() {
		return vertices;
	}
	
	public float getBoundsRadius() {
		return boundsRadius.getValue();
	}
	
	public void setBoundsRadius(float newBoundsRadius) {
		this.boundsRadius.setValue(newBoundsRadius);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, collisionType, vertices, boundsRadius);
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(collisionType, vertices, boundsRadius));
	}
	
}
