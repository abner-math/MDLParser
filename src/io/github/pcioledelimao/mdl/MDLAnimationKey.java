package io.github.pcioledelimao.mdl;

import java.lang.reflect.Constructor;

import io.github.picoledelimao.mdl.core.MDLNumeric;

public class MDLAnimationKey<T extends MDLNumeric> {

	private T value;
	private T inTan;
	private T outTan;
	private Constructor<T> constructor;
	private Object[] constructorParams;
	
	public MDLAnimationKey() {
		
	}
	
}
