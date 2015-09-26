package io.github.picoledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLObjectArray;

public class MDLSegmentColor extends MDLObjectArray<MDLNumberArray> {

	public MDLSegmentColor() throws NoSuchMethodException, SecurityException {
		super("SegmentColor", false, MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), "Color", Integer.class, 3);
	}
	
	@Override
	public String toMDL() {
		String mdl = super.toMDL();
		int index = mdl.lastIndexOf("\n");
		return mdl.substring(0, index) + ",\n";
	}

}
