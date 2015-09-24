package io.github.picoledelimao.mdl.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MDLField implements MDLElement {

	protected String name;
	
	public MDLField(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		Matcher matches = Pattern.compile("^\\w*$").matcher(newName);
		if (!matches.find()) {
			throw new RuntimeException("Illegal field name. Only [a-zA-Z_0-9] is supported.");
		}
		name = newName;
	}
	 
	protected String sliceString(String s, Pair<Integer, Integer> bounds) {
		return s.substring(0, bounds.first) + s.substring(bounds.second);
	}
	
	@Override
	public Pair<Integer, Integer> getTokenDelimiter(String input) {
		String regex = "(^|(\\W+))" + name + "((\\s*,)|(\\W+(([^\\}]*\\}\\s*)|([^(,||\\{|\\})]+))?\\s*,))";
		Matcher matches = Pattern.compile(regex).matcher(input);
		if (!matches.find()) {
			return null;
		}
		int nameStartOffset = input.substring(matches.start()).indexOf(name);
		return new Pair<Integer, Integer>(matches.start() + nameStartOffset, matches.end());
	}
	 
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<Integer, Integer> bounds = getTokenDelimiter(input);
		if (bounds == null) {
			throw new MDLNotFoundException("Could not find field " + name + ".");
		}
		String contents = input.substring(bounds.first, bounds.second);
		contents =  contents.substring(contents.indexOf(name) + name.length());
		return new Pair<String, String>(sliceString(input, bounds), contents);
	}
	
	protected StringBuilder print(StringBuilder sb) {
		return new StringBuilder(name.isEmpty() ? "" : name + " ").append(sb).append(",\n");
	}
	
	@Override
	public String toString() {
		return print(new StringBuilder()).toString(); 
	}
	
	@Override
	public String toMDL() {
		return toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof MDLField))
			return false;
		MDLField other = (MDLField) obj;
		return name.equals(other.name);
	}
	
}
