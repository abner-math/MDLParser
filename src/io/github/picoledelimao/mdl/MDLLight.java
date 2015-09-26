package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLEnum;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLLight extends MDLNode {

	private MDLEnum lightType;
	private MDLAnimatedObject<MDLNumber> attenuationStart;
	private MDLAnimatedObject<MDLNumber> attenuationEnd;
	private MDLAnimatedObject<MDLNumberArray> color;
	private MDLAnimatedObject<MDLNumber> intensity;
	private MDLAnimatedObject<MDLNumberArray> ambColor;
	private MDLAnimatedObject<MDLNumber> ambIntensity;
	private MDLAnimatedObject<MDLNumber> visibility;
	
	public MDLLight() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super("Light");
		this.lightType = new MDLEnum("", true, MDLLightType.getStringValues());
		this.attenuationStart = new MDLAnimatedObject<>("AttenuationStart", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.attenuationEnd = new MDLAnimatedObject<>("AttenuationEnd", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.color = new MDLAnimatedObject<>("Color", MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), Float.class, 3);
		this.intensity = new MDLAnimatedObject<>("Intensity", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.ambColor = new MDLAnimatedObject<>("AmbColor", MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), Float.class, 3);
		this.ambIntensity = new MDLAnimatedObject<>("AmbIntensity", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.visibility = new MDLAnimatedObject<>("Visibility", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
	}
	
	public MDLLightType getLightType() {
		return MDLLightType.getValue(lightType.getValue());
	}
	
	public void setLightType(MDLLightType newLightType) throws MDLParserErrorException {
		this.lightType.setValue(newLightType.toString());
	}
	
	public MDLAnimatedObject<MDLNumber> getAttenuationStart() {
		return attenuationStart;
	}
	
	public MDLAnimatedObject<MDLNumber> getAttenuationEnd() {
		return attenuationEnd;
	}
	
	public MDLAnimatedObject<MDLNumberArray> getColor() {
		return color;
	}
	
	public MDLAnimatedObject<MDLNumber> getIntensity() {
		return intensity;
	}

	public MDLAnimatedObject<MDLNumberArray> getAmbColor() {
		return ambColor;
	}
	
	public MDLAnimatedObject<MDLNumber> getAmbIntensity() {
		return ambIntensity;
	}
	
	public MDLAnimatedObject<MDLNumber> getVisibility() {
		return visibility;
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, lightType, attenuationStart, attenuationEnd, color, intensity, ambColor, ambIntensity, visibility);
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(lightType, attenuationStart, attenuationEnd, color, intensity, ambColor, ambIntensity, visibility));
	}
	
}
