package io.github.picoledelimao.mdl.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MDLNumber<T extends Number & Comparable> extends MDLNumeric<T> implements Comparable<MDLNumber> {
	
	private T value;
	private T defaultValue;
	
	public MDLNumber(String name, T defaultValue, Boolean required) {
		super(name, (Class<T>)getActualClass(defaultValue), required);
		setValue(defaultValue);
		setDefaultValue(defaultValue);
		setRequired(required);
	}
	
	private static Class getActualClass(Object value) {
		if (value.getClass().equals(Double.class)) {
			return Double.class;
		} else if (value.getClass().equals(Float.class)) {
			return Float.class; 
		} else if (value.getClass().equals(Integer.class)) {
			return Integer.class;
		} else if (value.getClass().equals(Short.class)) {
			return Short.class; 
		} else if (value.getClass().equals(Byte.class)) {
			return Byte.class;
		}
		throw new IllegalArgumentException("Unrecognized parametized type.");
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T newValue) {
		this.value = newValue;
	}

	public T getDefaultValue() {
		return defaultValue;
	}
	
	public void setDefaultValue(T newDefaultValue) {
		this.defaultValue = newDefaultValue;
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		try {
			Pair<String, String> token = super.parse(input);
			Matcher matches = Regexes.getMatches(NUMBER_REGEX, token.second);
			if (!matches.find()) {
				throw new MDLParserErrorException("Could not parse number for field " + name + ".");
			}
			setValue(convertFromString(matches.group()));
			return new Pair<String, String>(token.first, "");
		} catch (MDLNotFoundException e) {
			if (required) throw e;
		}
		return new Pair<String, String>(input, "");
	}
	
	@Override
	protected StringBuilder print(StringBuilder sb) {
		if (value != null && (required || !value.equals(defaultValue)))
			return super.print(new StringBuilder(printNumber(value)));
		return new StringBuilder();
	}

	@Override
	public int compareTo(MDLNumber other) {
		return value.compareTo(other.value);
	}
	
}
