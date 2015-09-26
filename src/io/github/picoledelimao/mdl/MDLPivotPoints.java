package io.github.picoledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLObjectArray;

public class MDLPivotPoints extends MDLObjectArray<MDLNumberArray> {

	public MDLPivotPoints() throws NoSuchMethodException, SecurityException {
		super("PivotPoints", true, MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), "", Float.class, 3);
	}

}
