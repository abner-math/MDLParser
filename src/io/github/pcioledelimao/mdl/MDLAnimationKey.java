package io.github.pcioledelimao.mdl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.picoledelimao.mdl.core.MDLElement;
import io.github.picoledelimao.mdl.core.MDLField;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumeric;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLAnimationKey<T extends MDLNumeric> implements MDLElement {

	private int key;
	private T value;
	private T inTan;
	private T outTan;
	private Constructor<T> constructor;
	private Object[] constructorParams;
	private boolean showTanValue;

	public MDLAnimationKey(Boolean showTanValue, Constructor constructor, Object... constructorParams) 
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		setConstructor(constructor);
		setConstructorParams(constructorParams);
		if (showTanValue) {
			inTan = (T)constructor.newInstance(getNewConstructorParams("InTan", constructorParams));
			outTan = (T)constructor.newInstance(getNewConstructorParams("OutTan", constructorParams));
		}
		setShowTanValue(showTanValue);
	}

	public static Object[] getNewConstructorParams(String fieldName, Object[] constructorParams) {
		Object[] newConstructorParams = new Object[constructorParams.length + 1];
		newConstructorParams[0] = fieldName;
		for (int i = 0; i < constructorParams.length; i++) {
			newConstructorParams[i + 1] = constructorParams[i];
		}
		return newConstructorParams;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int newKey) {
		if (newKey < 0) {
			throw new IllegalArgumentException("Key cannot be negative.");
		}
		this.key = newKey;
	}
	
	public Constructor<T> getConstructor() {
		return constructor;
	}
	
	public void setConstructor(Constructor<T> newConstructor) {
		this.constructor = newConstructor;
	}
	
	public Object[] getConstructorParams() {
		return constructorParams;
	}
	
	public void setConstructorParams(Object... newConstructorParams) {
		this.constructorParams = newConstructorParams;
	}
	
	public T getValue() {
		return value;
	}
	
	public Pair<T, T> getTanValue() {
		return new Pair<T, T>(inTan, outTan);
	}
	
	public void setTanValue(Pair<T, T> newTanValue) {
		this.inTan = newTanValue.first; 
		this.outTan = newTanValue.second;
	}
	
	public boolean isShowTanValue() {
		return showTanValue;
	}
	
	public void setShowTanValue(boolean showTanValue) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (showTanValue && inTan == null || outTan == null) {
			inTan = constructor.newInstance(getNewConstructorParams("InTan", constructorParams));
			outTan = constructor.newInstance(getNewConstructorParams("OutTan", constructorParams));
		}
		this.showTanValue = showTanValue;
	}

	@Override
	public Pair<Integer, Integer> getTokenDelimiter(String input) {
		String regex = MDLField.getFieldRegex(MDLNumeric.NUMBER_REGEX + ":");
		if (showTanValue) {
			regex += MDLField.getFieldRegex("InTan") + MDLField.getFieldRegex("OutTan");
		}
		Matcher matches = Pattern.compile(regex).matcher(input);
		if (!matches.find()) {
			return null;
		}
		Matcher idMatches = Pattern.compile(MDLNumeric.NUMBER_REGEX + ":").matcher(input.substring(matches.start()));
		if (!idMatches.find()) {
			return null;
		}
		return new Pair<Integer, Integer>(matches.start() + idMatches.start(), matches.end());
	}

	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<Integer, Integer> bounds = getTokenDelimiter(input);
		if (bounds == null) {
			throw new MDLNotFoundException("Could not find animation key.");
		}
		String contents = input.substring(bounds.first, bounds.second);
		Matcher idMatches = Pattern.compile(MDLNumeric.NUMBER_REGEX).matcher(contents);
		if (!idMatches.find()) {
			throw new MDLNotFoundException("Could not find animation key.");
		}
		int keyId = Integer.valueOf(idMatches.group());
		try {
			value = constructor.newInstance(getNewConstructorParams(keyId + ":", constructorParams));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalArgumentException("Unsupported constructor on MDLAnimationKey.");
		}
		setKey(keyId);
		contents = value.parse(contents).first;
		if (showTanValue) {
			contents = inTan.parse(contents).first;
			contents = outTan.parse(contents).second;
		}
		return new Pair<String, String>(MDLField.sliceString(input, bounds), contents);
	}

	@Override
	public String toMDL() {
		StringBuilder sb = new StringBuilder(value.toMDL());
		if (showTanValue) {
			sb.append("\t").append(inTan.toMDL());
			sb.append("\t").append(outTan.toMDL());
		}
		return sb.toString();
	}
	
}
