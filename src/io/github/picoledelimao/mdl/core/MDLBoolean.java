package io.github.picoledelimao.mdl.core;

public class MDLBoolean extends MDLField {

	private boolean value;

	public MDLBoolean(String name) {
		super(name);
	}
	
	public boolean getValue() {
		return value;
	}
	
	public void setValue(boolean value) {
		this.value = value;
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLParserErrorException {
		try {
			Pair<String, String> token = super.parse(input);
			setValue(true);
			return new Pair<String, String>(token.first, "");
		} catch (MDLNotFoundException e) {
			setValue(false);
		}
		return new Pair<String, String>(input, "");
	}
	
	@Override
	protected StringBuilder print(StringBuilder sb) {
		if (value) 
			return new StringBuilder(name).append(",\n");
		return new StringBuilder();
	}
	
}
