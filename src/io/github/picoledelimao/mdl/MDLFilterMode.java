package io.github.picoledelimao.mdl;

public enum MDLFilterMode {
	
	NONE, TRANSPARENT, BLEND, ADDITIVE, ADD_ALPHA, MODULATE;
	
	@Override
	public String toString() {
		switch (this) {
		case NONE:
			return "None";
		case TRANSPARENT:
			return "Transparent";
		case BLEND:
			return "Blend";
		case ADDITIVE:
			return "Additive";
		case ADD_ALPHA:
			return "AddAlpha";
		case MODULATE:
			return "Modulate";
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
	
	public static MDLFilterMode getValue(String value) {
		for (MDLFilterMode type : values()) {
			if (type.toString().equals(value)) {
				return type;
			}
		}
		return null;
	}
	
}
