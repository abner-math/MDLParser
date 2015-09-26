package io.github.picoledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLObjectArray;

public class MDLTriangles extends MDLObjectArray<MDLNumberArray> {

	public MDLTriangles() throws NoSuchMethodException, SecurityException {
		super("Triangles", false, MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), "", Integer.class, -1);
	}

}
