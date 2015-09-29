package io.github.picoledelimao.mdl.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MDLString extends MDLField {

	public static String STRING_REGEX = "\"[^\"]*\"";
	
	private String value;
	private boolean required;
	
	public MDLString(String name, boolean required) {
		super(name);
		setRequired(required);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String newValue) {
		this.value = newValue;
	}
	
	public boolean isRequired() {
		return required;
	}
	
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		try {
			Pair<String, String> token = super.parse(input);
			Matcher matches = Regexes.getMatches("\"[^\"]*\"", token.second);
			if (!matches.find()) {
				throw new MDLParserErrorException("Could not parse string for field " + name + ".");
			}
			setValue(matches.group().replaceAll("\"", ""));
			return new Pair<String, String>(token.first, "");
		} catch (MDLNotFoundException e) {
			if (required) throw e;
		}
		return new Pair<String, String>(input, "");
	}
	
	@Override
	protected StringBuilder print(StringBuilder sb) {
		if (value != null && (required || !value.isEmpty()))
			return super.print(new StringBuilder("\"").append(value).append("\""));
		return new StringBuilder();
	}
	
}
