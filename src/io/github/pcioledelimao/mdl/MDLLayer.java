package io.github.pcioledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLBoolean;
import io.github.picoledelimao.mdl.core.MDLEnum;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLObject;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLLayer extends MDLObject {

	private MDLEnum filterMode;
	private MDLAnimatedObject<MDLNumber> alpha;
	private MDLAnimatedObject<MDLNumber> textureID;
	private MDLBoolean twoSided;
	private MDLBoolean unshaded;
	private MDLBoolean unfogged;
	private MDLBoolean sphereEnvMap;
	private MDLBoolean noDepthTest;
	private MDLBoolean noDepthSet;
	
	public MDLLayer() {
		super("Layer");
		this.filterMode = new MDLEnum("FilterMode", true, MDLFilterMode.getStringValues());
		try {
			this.alpha = new MDLAnimatedObject<>("Alpha", MDLNumber.class.getConstructor(String.class, Number.class, Boolean.class), new Float(1), false);
			this.textureID = new MDLAnimatedObject<>("TextureID", MDLNumber.class.getConstructor(String.class, Number.class, Boolean.class), new Integer(0), true);
			this.twoSided = new MDLBoolean("TwoSided");
			this.unshaded = new MDLBoolean("Unshaded");
			this.unfogged = new MDLBoolean("Unfogged");
			this.sphereEnvMap = new MDLBoolean("SphereEnvMap");
			this.noDepthTest = new MDLBoolean("NoDepthTest");
			this.noDepthSet = new MDLBoolean("NoDepthSet");
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}
	
	public MDLFilterMode getFilterMode() {
		return MDLFilterMode.getValue(filterMode.getValue());
	}
	
	public void setFilterMode(MDLFilterMode newFilterMode) throws MDLParserErrorException {
		this.filterMode.setValue(newFilterMode.toString());
	}
	
	public MDLAnimatedObject<MDLNumber> getAlpha() {
		return alpha;
	}
	
	public void setAlpha(MDLAnimatedObject<MDLNumber> newAlpha) {
		this.alpha = newAlpha;
	}
	
	public MDLAnimatedObject<MDLNumber> getTextureID() {
		return textureID;
	}
	
	public void setTextureID(MDLAnimatedObject<MDLNumber> newTextureID) {
		this.textureID = newTextureID;
	}
	
	public boolean isTwoSided() {
		return twoSided.getValue();
	}
	
	public void setTwoSided(boolean twoSided) {
		this.twoSided.setValue(twoSided);
	}
	
	public boolean isUnshaded() {
		return unshaded.getValue();
	}
	
	public void setUnshaded(boolean unshaded) {
		this.unshaded.setValue(unshaded);
	}
	
	public boolean isUnfogged() {
		return unfogged.getValue();
	}
	
	public void setUnfogged(boolean unfogged) {
		this.unfogged.setValue(unfogged);
	}
	
	public boolean isSphereEnvMap() {
		return sphereEnvMap.getValue();
	}
	
	public void setSphereEnvMap(boolean sphereEnvMap) {
		this.sphereEnvMap.setValue(sphereEnvMap);
	}
	
	public boolean isNoDepthTest() {
		return noDepthTest.getValue();
	}
	
	public void setNoDepthTest(boolean noDepthTest) {
		this.noDepthTest.setValue(noDepthTest);
	}
	
	public boolean isNoDepthSet() {
		return noDepthSet.getValue();
	}
	
	public void setNoDepthSet(boolean noDepthSet) {
		this.noDepthSet.setValue(noDepthSet);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		parse(contents, filterMode, alpha, textureID, twoSided, unshaded, unfogged, sphereEnvMap, noDepthTest, noDepthSet);
		setFilterMode(MDLFilterMode.getValue(filterMode.getValue()));
		setAlpha(alpha);
		setTextureID(textureID);
		setTwoSided(twoSided.getValue());
		setUnshaded(unshaded.getValue());
		setUnfogged(unfogged.getValue());
		setSphereEnvMap(sphereEnvMap.getValue());
		setNoDepthTest(noDepthTest.getValue());
		setNoDepthSet(noDepthSet.getValue());
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(sb.append(print(filterMode, alpha, textureID, twoSided, unshaded, unfogged, sphereEnvMap, noDepthTest, noDepthSet)));
	}
	
}
