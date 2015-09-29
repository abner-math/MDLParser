package io.github.picoledelimao.mdl.core;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class MDLBooleanArray extends MDLField {

	public static final String ARRAY_REGEX = "\\{\\s*\\w+\\s*(,\\s*\\w+\\s*)*\\s*\\}";
	
	private MDLBoolean[] values;
	private int size;
	
	public MDLBooleanArray(String name, String... values) {
		super(name);
		setSize(size);
		MDLBoolean[] mdlValues = new MDLBoolean[values.length];
		for (int i = 0; i < values.length; i++) {
			mdlValues[i] = new MDLBoolean(values[i]);
		}
		setValues(mdlValues);
	}
	
	public MDLBoolean[] getValues() {
		return values;
	}
	
	public void setValues(MDLBoolean[] newValues) {
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
		for (MDLBoolean b : values) {
			b.setValue(false);
		}
		try {
			Pair<String, String> token = super.parse(input);
			Matcher matches = Regexes.getMatches(ARRAY_REGEX, token.second);
			if (!matches.find()) {
				throw new MDLParserErrorException("Could not parse number array for field " + name + ".");
			}
			String contents = matches.group();
			matches = Regexes.getMatches("\\w+", contents);
			while (matches.find()) {
				String name = matches.group();
				for (MDLBoolean b : values) {
					if (name.equals(b.getName())) {
						b.setValue(true);
					}
				}
			}
			return new Pair<String, String>(token.first, "");
		} catch (MDLNotFoundException e) {
			return new Pair<String, String>(input, "");
		}
	}
	
	@Override
	protected StringBuilder print(StringBuilder sb) {
		StringBuilder s = new StringBuilder("{ ");
		List<MDLBoolean> active = new ArrayList<>();
		for (MDLBoolean b : values) {
			if (b.getValue()) active.add(b);
		}
		if (active.isEmpty()) return new StringBuilder();
		for (int i = 0; i < active.size(); i++) {
			s.append(active.get(i).getName());
			if (i != active.size() - 1)
				s.append(", ");
		}
		s.append(" }");
		return super.print(s);
	}
	
}
