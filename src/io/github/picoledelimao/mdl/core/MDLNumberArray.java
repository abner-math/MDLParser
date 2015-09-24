package io.github.picoledelimao.mdl.core;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MDLNumberArray<T extends Number & Comparable> extends MDLNumeric<T> {

	public static final String ARRAY_REGEX = "\\{\\s*" + NUMBER_REGEX + "\\s*(,\\s*" + NUMBER_REGEX + "\\s*)*\\s*\\}";
	
	private T[] values;
	private int size;
	
	public MDLNumberArray(String name, Class<T> clazz, int size) {
		super(name, clazz);
		setSize(size);
	}
	
	public T[] getValues() {
		return values;
	}
	
	public void setValues(T[] newValues) {
		if (newValues == null) {
			throw new IllegalArgumentException("Number array cannot be null.");
		} else if (newValues.length != size) {
			throw new IllegalArgumentException("Illegal number array size.");
		}
		this.values = newValues;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int newSize) {
		this.size = newSize;
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		Matcher matches = Pattern.compile(ARRAY_REGEX).matcher(token.second);
		if (!matches.find()) {
			throw new MDLParserErrorException("Could not parse number array for field " + name + ".");
		}
		String group = matches.group();
		matches = Pattern.compile(NUMBER_REGEX).matcher(group);
		T[] values = (T[])Array.newInstance(clazz, 0);
		while (matches.find()) {
			T value = convertFromString(matches.group());
			int length = values.length;
			values = Arrays.copyOf(values, length + 1);
			values[length] = value;
		}
		setValues(values);
		return new Pair<String, String>(token.first, "");
	}
	
	@Override
	protected StringBuilder print(StringBuilder sb) {
		StringBuilder s = new StringBuilder("{ ");
		for (int i = 0; i < values.length; i++) {
			s.append(printNumber(values[i]));
			if (i != values.length - 1)
				s.append(", ");
		}
		s.append(" }");
		return super.print(s);
	}
	
}
