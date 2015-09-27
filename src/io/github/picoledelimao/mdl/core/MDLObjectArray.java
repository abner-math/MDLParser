package io.github.picoledelimao.mdl.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MDLObjectArray<T extends MDLElement> extends MDLObject implements MDLIterable<T> {

	protected Constructor<T> constructor;
	protected Object[] constructorParams;
	protected boolean showQuantity;
	protected List<T> objects;
	
	public MDLObjectArray(String name, Boolean showQuantity, Constructor<T> constructor, Object... constructorParams) {
		super(name);
		setConstructor(constructor);
		setConstructorParams(constructorParams);
		setObjects(new ArrayList<T>());
		setShowQuantity(showQuantity);
	}
	
	public boolean isShowQuantity() {
		return showQuantity;
	}
	
	public void setShowQuantity(boolean showQuantity) {
		if (showQuantity) {
			setValue(String.valueOf(objects.size()));
		} else {
			setValue("");
		}
		this.showQuantity = showQuantity;
	}
	
	public Constructor<T> getConstructor() {
		return constructor;
	}
	
	public void setConstructor(Constructor<T> newConstructor) {
		this.constructor = newConstructor;
	}
	
	public Object[] getConstructorParams() {
		return constructorParams;
	}
	
	public void setConstructorParams(Object... newConstructorParams) {
		this.constructorParams = newConstructorParams;
	}
	
	public List<T> getObjects() {
		return objects;
	}
	
	public void setObjects(List<T> newObjects) {
		this.objects = newObjects;
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		if (name.isEmpty()) {
			contents = input;
		}
		objects.clear();
		while (true) {
			try {
				T obj = constructor.newInstance(constructorParams);
				if (obj.getTokenDelimiter(contents) == null) {
					break;
				}
				contents = obj.parse(contents).first;
				objects.add(obj);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException  e) {
				throw new IllegalArgumentException("Constructor parameters are not compatible for array " + name + ".");
			} 
		}
		setObjects(objects);
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		setShowQuantity(showQuantity);
		for (T obj : objects) {
			sb.append(obj.toMDL());
		}
		if (name.isEmpty()) return sb;
		sb = super.print(sb);
		if (sb.toString().equals(name + " 0 {\n}\n"))
			return new StringBuilder();
		return sb;
	}
	
	@Override
	public int size() {
		int size = 0;
		for (MDLElement e : objects) {
			if (e instanceof MDLIterable) {
				size += ((MDLIterable)e).size();
			} else {
				size += 1;
			}
		}
		return size;
	}
	
}
