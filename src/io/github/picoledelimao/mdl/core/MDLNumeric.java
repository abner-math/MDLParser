package io.github.picoledelimao.mdl.core;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@SuppressWarnings("rawtypes")
public abstract class MDLNumeric<T extends Number & Comparable> extends MDLField {

	public static final String NUMBER_REGEX = "[-]?\\d+(\\.\\d+((e|E)[-]?\\d+)?)?";
	
	protected Class<T> clazz;
	protected boolean required;
	
	public MDLNumeric(String name, Class<T> clazz, Boolean required) {
		super(name);
		this.clazz = clazz;
		this.required = required;
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
			double value = number.doubleValue();
			if (value - (int)value == 0.0) {
				return String.valueOf((int)value);
			}
			int numFractionDigits = 32;
			for (int i = 31; i > 0; i--) {
				float reduced = Float.valueOf(String.format(Locale.ENGLISH, "%." + i + "f", value));
				if (reduced - value == 0.0f) {
					numFractionDigits = i;
				}
			}
			DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
			df.setRoundingMode(RoundingMode.HALF_DOWN);
			df.setMaximumFractionDigits(numFractionDigits);
			return df.format(value);
		} else if (number.getClass().equals(Float.class)) {
			float value = number.floatValue();
			if (value - (int)value == 0.0f) {
				return String.valueOf((int)value);
			}
			//if (Math.abs(value) < 1e-7) {
			//	return String.valueOf(value).replaceAll("E", "e");
			//}
			int numFractionDigits = 10;
			for (int i = 9; i > 0; i--) {
				float reduced = Float.valueOf(String.format(Locale.ENGLISH, "%." + i + "f", value));
				if (reduced - value == 0.0f) {
					numFractionDigits = i;
				}
			}
			DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
			df.setRoundingMode(RoundingMode.HALF_DOWN);
			df.setMaximumFractionDigits(numFractionDigits);
			return df.format(value);
		} 
		return number.toString();
	}

	public boolean isRequired() {
		return required;
	}
	
	public void setRequired(boolean required) {
		this.required = required;
	}
	
}
