package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLObject;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLTVertexAnim extends MDLObject {

	private MDLAnimatedObject<MDLNumberArray> translation;
	private MDLAnimatedObject<MDLNumberArray> rotation;
	private MDLAnimatedObject<MDLNumberArray> scaling;
	
	public MDLTVertexAnim(String name) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super(name);
		this.translation = new MDLAnimatedObject<>("Translation", MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), Float.class, new Integer(3));
		this.rotation = new MDLAnimatedObject<>("Rotation", MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), Float.class, new Integer(4));
		this.scaling = new MDLAnimatedObject<>("Scaling", MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), Float.class, new Integer(3));
	}
	
	public MDLAnimatedObject<MDLNumberArray> getTranslation() {
		return translation;
	}
	
	public MDLAnimatedObject<MDLNumberArray> getRotation() {
		return rotation;
	}
	
	public MDLAnimatedObject<MDLNumberArray> getScaling() {
		return scaling;
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, translation, rotation, scaling);
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(sb.append(print(translation, rotation, scaling)));
	}
	
}
