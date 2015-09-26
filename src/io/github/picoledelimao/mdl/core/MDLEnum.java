package io.github.picoledelimao.mdl.core;

public class MDLEnum implements MDLElement {

	private String name;
	private boolean required;
	private String[] allowedValues;
	private String value;
	
	public MDLEnum(String name, boolean required, String... allowedValues) {
		setName(name);
		setAllowedValues(allowedValues);
		setRequired(required);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public boolean isRequired() {
		return required;
	}
	
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public String[] getAllowedValues() {
		return allowedValues;
	}
	
	private boolean containsRepeated(String[] values) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) {
				if (i == j) continue;
				if (values[i].equals(values[j])) return true;
			}
		}
		return false;
	}
	
	public String getDefaultValue() {
		return allowedValues[0];
	}
	
	public void setDefaultValue(String newDefaultValue) {
		allowedValues[0] = newDefaultValue;
		setAllowedValues(allowedValues);
	}
	
	public void setAllowedValues(String[] newAllowedValues) {
		if (newAllowedValues == null || newAllowedValues.length == 0) {
			throw new IllegalArgumentException("Allowed values on enum cannot be empty.");
		} else if (containsRepeated(newAllowedValues)) {
			throw new IllegalArgumentException("Enum values must be unique.");
		}
		this.allowedValues = newAllowedValues;
	}
	
	public String getValue() {
		return value;
	}
	
	private boolean isValid(String newValue) {
		for (String value : allowedValues) {
			if (value.equals(newValue)) return true;
		}
		return false;
	}
	
	public void setValue(String newValue) throws MDLParserErrorException {
		if ((newValue == null || newValue.isEmpty()) && !required) {
			this.value = allowedValues[0];
		} else {
			if (!newValue.equals(allowedValues[0]) && !isValid(newValue)) 
				throw new MDLParserErrorException("Value is not allowed on enum.");
			this.value = newValue;
		}
	}

	@Override
	public Pair<Integer, Integer> getTokenDelimiter(String input) {
		for (String value : allowedValues) {
			MDLField obj = new MDLField((name != null && !name.isEmpty() ? name + " " : "") + value) { };
			Pair<Integer, Integer> delimiter = obj.getTokenDelimiter(input);
			if (delimiter != null) return delimiter;
		}
		return null;
	}

	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<Integer, Integer> delimiter = getTokenDelimiter(input);
		String lookAhead = input;
		String newValue = null;
		if (delimiter != null) {
			for (String value : allowedValues) {
				MDLBoolean b = new MDLBoolean((name != null && !name.isEmpty() ? name + " " : "") + value);
				lookAhead = b.parse(lookAhead).first;
				if (b.getValue()) {
					newValue = value;
					break;
				}
			}
		} else {
			if (required) throw new MDLNotFoundException("Cannot find a value for enum.");
		}
		setValue(newValue);
		return new Pair<String, String>(lookAhead, "");
	}

	@Override
	public String toMDL() {
		if (value.equals(allowedValues[0]) && !required) return "";
		return (name != null && !name.isEmpty() ? name + " " : "") + value + ",\n";
	}
	
	@Override
	public String toString() {
		return toMDL();
	}
	
}
