package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLObjectArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLEventObject extends MDLNode {

	private MDLObjectArray<MDLNumber> eventTrack;
	
	public MDLEventObject() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super("EventObject");
		this.eventTrack = new MDLObjectArray<>("EventTrack", true, MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), "", new Integer(0), true);
	}
	
	public MDLObjectArray<MDLNumber> getEventTracker() {
		return eventTrack;
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second; 
		contents = parse(contents, eventTrack);
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(eventTrack));
	}
	
}
