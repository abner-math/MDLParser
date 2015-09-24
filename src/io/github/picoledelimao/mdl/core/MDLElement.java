package io.github.picoledelimao.mdl.core;

public interface MDLElement {

	public Pair<Integer, Integer> getTokenDelimiter(String input);
	
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException;
	
	public String toMDL();
	
}
