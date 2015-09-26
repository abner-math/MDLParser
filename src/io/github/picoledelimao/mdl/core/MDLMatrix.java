package io.github.picoledelimao.mdl.core;

import java.lang.reflect.Constructor;

public class MDLMatrix extends MDLObjectArray<MDLIterable> {

	public MDLMatrix(String name, Constructor constructor, Object... constructorParams) {
		super(name, false, constructor, constructorParams);
	}

	@Override
	public StringBuilder print(StringBuilder sb) {
		String name = this.name;
		int total = 0;
		for (MDLIterable e : objects) {
			total += e.size();
		}
		setName(name + " " + objects.size() + " " + total);
		sb = super.print(sb);
		setName(name);
		return sb;
	}
	
}
