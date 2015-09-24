package io.github.pcioledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLObjectArray;
import io.github.picoledelimao.mdl.core.MDLNumber;

public class MDLGlobalSequences extends MDLObjectArray<MDLNumber> {

	public MDLGlobalSequences() throws NoSuchMethodException, SecurityException {
		super("GlobalSequences", true, MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), "Duration", new Integer(0), false);
	}
	
}
