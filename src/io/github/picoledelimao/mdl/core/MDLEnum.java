package io.github.picoledelimao.mdl.core;

public abstract class MDLEnum implements MDLElement {

	private boolean required;
	private String defaultValue;
	private String[] allowedValues;
	private String value;
	
	public MDLEnum(boolean required, String defaultValue, String... allowedValues) {
		setAllowedValues(allowedValues);
		setDefaultValue(defaultValue);
		setRequired(required);
	}
	
	public boolean isRequired() {
		return required;
	}
	
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public String getDefaultValue() {
		return defaultValue;
	}
	
	public void setDefaultValue(String newDefaultValue) {
		if (!newDefaultValue.equals(this.defaultValue) && isValid(newDefaultValue)) 
			throw new IllegalArgumentException("Enum values must be unique.");
		this.defaultValue = newDefaultValue;
	}
	
	public String[] getAllowedValues() {
		return allowedValues;
	}
	
	private boolean containsRepeated(String[] values) {
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) {
				if (i == j) continue;
				if (values[i].equals(values[j]) || values[i].equals(defaultValue)) return true;
			}
		}
		return false;
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
			this.value = defaultValue;
		} else {
			if (!newValue.equals(defaultValue) && !isValid(newValue)) 
				throw new MDLParserErrorException("Value is not allowed on enum.");
			this.value = newValue;
		}
	}

	@Override
	public Pair<Integer, Integer> getTokenDelimiter(String input) {
		for (String value : allowedValues) {
			MDLField obj = new MDLField(value) { };
			Pair<Integer, Integer> delimiter = obj.getTokenDelimiter(input);
			if (delimiter != null) return delimiter;
		}
		return null;
	}

	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<Integer, Integer> delimiter = getTokenDelimiter(input);
		String newValue = null;
		if (delimiter != null) {
			for (String value : allowedValues) {
				MDLBoolean b = new MDLBoolean(value);
				b.parse(input);
				if (b.getValue()) {
					newValue = value;
				}
			}
		} else {
			if (required) throw new MDLNotFoundException("Cannot find a value for enum.");
		}
		setValue(newValue);
		return new Pair<String, String>(input, "");
	}

	@Override
	public String toMDL() {
		if (value.equals(defaultValue) && !required) return "";
		return value + ",\n";
	}
	
}
