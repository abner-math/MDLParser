package io.github.picoledelimao.mdl.core;

@SuppressWarnings("rawtypes")
public abstract class MDLNumeric<T extends Number & Comparable> extends MDLField {

	public static final String NUMBER_REGEX = "[-]?\\d+(\\.\\d*)?";
	
	protected Class<T> clazz;
	
	public MDLNumeric(String name, Class<T> clazz) {
		super(name);
		this.clazz = clazz;
	}

	protected T convertFromString(String s) {
		if (clazz.equals(Double.class)) {
			return (T)Double.valueOf(s);
		} else if (clazz.equals(Float.class)) {
			return (T)Float.valueOf(s);
		} else if (clazz.equals(Integer.class)) {
			return (T)Integer.valueOf(s);
		} else if (clazz.equals(Short.class)) {
			return (T)Short.valueOf(s);
		} else if (clazz.equals(Byte.class)) {
			return (T)Byte.valueOf(s);
		}
		throw new RuntimeException("Unrecognized parametized type.");
	}
	
	protected String printNumber(T number) {
		if (number.getClass().equals(Double.class)) {
			if (number.doubleValue() - (int)number.doubleValue() == 0)
				return String.valueOf((int)number.doubleValue());
		} else if (number.getClass().equals(Float.class)) {
			if (number.floatValue() - (int)number.floatValue() == 0)
				return String.valueOf((int)number.floatValue());
		} 
		return number.toString();
	}
	
}
