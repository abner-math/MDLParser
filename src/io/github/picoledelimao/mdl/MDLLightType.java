package io.github.picoledelimao.mdl;

public enum MDLLightType {
	
	OMNIDIRECTIONAL, DIRECTIONAL, AMBIENT;
	
	@Override
	public String toString() {
		switch (this) {
		case OMNIDIRECTIONAL:
			return "Omnidirectional";
		case DIRECTIONAL:
			return "Directional";
		case AMBIENT:
			return "Ambient";
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
	
	public static MDLLightType getValue(String value) {
		for (MDLLightType type : values()) {
			if (type.toString().equals(value)) {
				return type;
			}
		}
		return null;
	}
	
}
