package io.github.picoledelimao.mdl;

public enum MDLInterpolationType {
	
	DONT_INTERP, LINEAR, HERMITE, BEZIER;
	
	@Override
	public String toString() {
		switch (this) {
		case DONT_INTERP:
			return "DontInterp";
		case LINEAR:
			return "Linear";
		case HERMITE:
			return "Hermite";
		case BEZIER:
			return "Bezier";
		default:
			return "";
		}
	}
	
	public static String[] getStringValues() {
		String[] values = new String[values().length];
		for (int i = 0; i < values().length; i++) {
			values[i] = values()[i].toString();
		}
		return values;
	}
	
	public static MDLInterpolationType getValue(String value) {
		for (MDLInterpolationType type : values()) {
			if (type.toString().equals(value)) {
				return type;
			}
		}
		return null;
	}
	
}
