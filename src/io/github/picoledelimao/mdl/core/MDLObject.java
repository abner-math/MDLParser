package io.github.picoledelimao.mdl.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MDLObject extends MDLField {

	public static final String VALUE_REGEX = "((\"[^\"]*\")|((\\s+" + MDLNumeric.NUMBER_REGEX + ")+))";
	
	private String value;
	
	public MDLObject(String name) {
		super(name);
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String newValue) {
		this.value = newValue;
	}
	
	@Override
	public Pair<Integer, Integer> getTokenDelimiter(String input) {
		String regex = "(^|(\\W+))" + name + "\\s*" + VALUE_REGEX + "?\\s*\\{";
		Matcher matches = Pattern.compile(regex).matcher(input);
		if (!matches.find()) {
			return null;
		}
		int nameStartIndex = input.substring(matches.start()).indexOf(name);
		Matcher parenthesis = Pattern.compile("\\{|\\}").matcher(input.substring(matches.end()));
		int balance = -1;
		while (parenthesis.find()) {
			String group = parenthesis.group();
			if (group.equals("{")) {
				balance--;
			} else if (group.equals("}")) {
				balance++;
			}
			if (balance == 0) break;
		}
		if (balance != 0) {
			return null;
		}
		return new Pair<Integer, Integer>(nameStartIndex + matches.start(), matches.end() + parenthesis.end());
	}

	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		int parenthesisStartOffset = contents.indexOf("{") + 1;
		int parenthesisEndOffset = contents.length() - 1;
		String strValue = contents.substring(0, parenthesisStartOffset - 1);
		Matcher valueMatches = Pattern.compile(VALUE_REGEX).matcher(strValue);
		if (valueMatches.find()) {
			setValue(valueMatches.group().replaceFirst("^\\s*", ""));
		}
		contents = contents.substring(parenthesisStartOffset, parenthesisEndOffset);
		return new Pair<String, String>(token.first, contents);
	}

	private String indent(StringBuilder sb) {
		String[] lines = sb.toString().split("\n");
		String result = "";
		for (String line : lines) {
			result += "\t" + line + "\n";
		}
		return result;
	}
	
	protected StringBuilder print(StringBuilder sb) {
		return new StringBuilder(name.isEmpty() ? "" : name + " ").append((value == null || value.isEmpty()) ? "" : value + " ")
			.append("{\n").append(sb.toString().isEmpty() ? "" : indent(sb)).append("}");
	}
	
	protected String parse(String contents, MDLElement... elements) throws MDLNotFoundException, MDLParserErrorException {
		for (MDLElement element : elements) {
			contents = element.parse(contents).first;
		}
		return contents;
	}
	
	protected StringBuilder print(MDLElement... elements) {
		StringBuilder sb = new StringBuilder();
		for (MDLElement element : elements) {
			sb.append(element.toMDL());
		}
		return sb;
	}
	
}
