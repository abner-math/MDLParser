package io.github.pcioledelimao.mdl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLElement;
import io.github.picoledelimao.mdl.core.MDLField;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumeric;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLAnimatedObject<T extends MDLNumeric> implements MDLElement {

	private String name;
	private T staticValue;
	private MDLAnimationKeys<T> animatedValues;
	private boolean showStatic;
	
	public MDLAnimatedObject(String name, Constructor<T> constructor, Object... constructorParams) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		setName(name); 
		this.staticValue = constructor.newInstance(MDLAnimationKey.getNewConstructorParams("static " + name, constructorParams));
		this.animatedValues = new MDLAnimationKeys<>(name, constructor, constructorParams);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		if (newName == null || newName.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}
		this.name = newName;
	}
	
	public boolean isStatic() {
		return showStatic;
	}
	
	public void setStatic(boolean showStatic) {
		this.showStatic = showStatic;
	}

	@Override
	public Pair<Integer, Integer> getTokenDelimiter(String input) {
		Pair<Integer, Integer> animatedDelimiter = animatedValues.getTokenDelimiter(input);
		if (animatedDelimiter != null) {
			return animatedDelimiter;
		}
		return staticValue.getTokenDelimiter(input);
	}

	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<Integer, Integer> bounds = animatedValues.getTokenDelimiter(input);
		String contents = null;
		if (bounds != null) {
			contents = input.substring(bounds.first, bounds.second);
			contents = animatedValues.parse(contents).second;
			showStatic = false;
		} else {
			bounds = staticValue.getTokenDelimiter(input);
			contents = input.substring(bounds.first, bounds.second);
			contents = staticValue.parse(contents).second;
			showStatic = true;
		}
		return new Pair<String, String>(MDLField.sliceString(input, bounds), contents);
	}

	@Override
	public String toMDL() {
		if (showStatic) {
			return staticValue.toMDL();
		} else {
			return animatedValues.toMDL();
		}
	}

}
