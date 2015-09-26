package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLBoolean;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLParticleEmitter2 extends MDLTVertex {

	private MDLBoolean alphaKey;
	private MDLAnimatedObject<MDLNumber> speed;
	private MDLAnimatedObject<MDLNumber> variation;
	private MDLAnimatedObject<MDLNumber> latitude;
	private MDLAnimatedObject<MDLNumber> gravity;
	private MDLAnimatedObject<MDLNumber> emissionRate;
	private MDLAnimatedObject<MDLNumber> width;
	private MDLAnimatedObject<MDLNumber> length;
	private MDLAnimatedObject<MDLNumber> visibility;
	private MDLSegmentColor segmentColor;
	private MDLNumberArray<Float> alpha;
	private MDLNumberArray<Float> particleScaling;
	private MDLNumberArray<Float> lifeSpanUVAnim;
	private MDLNumberArray<Float> decayUVAnim;
	private MDLNumberArray<Float> tailUVAnim;
	private MDLNumberArray<Float> tailDecayUVAnim;
	private MDLNumber<Integer> rows;
	private MDLNumber<Integer> cols;
	private MDLNumber<Integer> textureID;
	private MDLNumber<Float> time;
	private MDLNumber<Float> lifeSpan;
	private MDLNumber<Float> tailLength;
	private MDLBoolean sortPrimsFarZ;
	private MDLBoolean lineEmitter;
	private MDLBoolean modelSpace;
	private MDLBoolean unshaded;
	private MDLBoolean unfogged;
	private MDLBoolean xyQuad;
	private MDLBoolean squirt;
	private MDLBoolean both;
	
	public MDLParticleEmitter2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super("ParticleEmitter2");
		this.alphaKey = new MDLBoolean("AlphaKey");
		this.speed = new MDLAnimatedObject<>("Speed", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.variation = new MDLAnimatedObject<>("Variation", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.latitude = new MDLAnimatedObject<>("Latitude", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.gravity = new MDLAnimatedObject<>("Gravity", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.emissionRate = new MDLAnimatedObject<>("EmissionRate", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.width = new MDLAnimatedObject<>("Width", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.length = new MDLAnimatedObject<>("Length", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.visibility = new MDLAnimatedObject<>("Visibility", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(1), true);
		this.segmentColor = new MDLSegmentColor();
		this.alpha = new MDLNumberArray<>("Alpha", Float.class, 3);
		this.particleScaling = new MDLNumberArray<>("ParticleScaling", Float.class, 3);
		this.lifeSpanUVAnim = new MDLNumberArray<>("LifeSpanUVAnim", Float.class, 3);
		this.decayUVAnim = new MDLNumberArray<>("DecayUVAnim", Float.class, 3);
		this.tailUVAnim = new MDLNumberArray<>("TailUVAnim", Float.class, 3);
		this.tailDecayUVAnim = new MDLNumberArray<>("TailDecayUVAnim", Float.class, 3);
		this.rows = new MDLNumber<>("Rows", 0, false);
		this.cols = new MDLNumber<>("Columns", 0, false);
		this.textureID = new MDLNumber<>("TextureID", -1, false);
		this.time = new MDLNumber<>("Time", 0.0f, false);
		this.lifeSpan = new MDLNumber<>("LifeSpan", 0.0f, false);
		this.tailLength = new MDLNumber<>("TailLength", 0.0f, false);
		this.sortPrimsFarZ = new MDLBoolean("SortPrimsFarZ");
		this.lineEmitter = new MDLBoolean("LineEmitter");
		this.modelSpace = new MDLBoolean("ModelSpace");
		this.unshaded = new MDLBoolean("Unshaded");
		this.unfogged = new MDLBoolean("Unfogged");
		this.xyQuad = new MDLBoolean("XYQuad");
		this.squirt = new MDLBoolean("Squirt");
		this.both = new MDLBoolean("Both");
	}
	
	public boolean isAlphaKey() {
		return alphaKey.getValue();
	}
	
	public void setAlphaKey(boolean alphaKey) {
		this.alphaKey.setValue(alphaKey);
	}
	
	public MDLAnimatedObject<MDLNumber> getSpeed() {
		return speed;
	}
	
	public MDLAnimatedObject<MDLNumber> getVariation() {
		return variation;
	}
	
	public MDLAnimatedObject<MDLNumber> getLatitude() {
		return latitude;
	}
	
	public MDLAnimatedObject<MDLNumber> getGravity() {
		return gravity;
	}
	
	public MDLAnimatedObject<MDLNumber> getEmissionRate() {
		return emissionRate;
	}
	
	public MDLAnimatedObject<MDLNumber> getWidth() {
		return width;
	}
	
	public MDLAnimatedObject<MDLNumber> getLength() {
		return length;
	}
	
	public MDLAnimatedObject<MDLNumber> getVisibility() {
		return visibility;
	}
	
	public MDLSegmentColor getSegmentColor() {
		return segmentColor;
	}
	
	public Float[] getAlpha() {
		return alpha.getValues();
	}
	
	public void setAlpha(Float[] newAlpha) {
		this.alpha.setValues(newAlpha);
	}
	
	public Float[] getParticleScaling() {
		return alpha.getValues();
	}
	
	public void setParticleScaling(Float[] newParticleScaling) {
		this.particleScaling.setValues(newParticleScaling);
	}
	
	public Float[] getLifeSpanUVAnim() {
		return lifeSpanUVAnim.getValues();
	}
	
	public void setLifeSpanUVAnim(Float[] newLifeSpanUVAnim) {
		this.lifeSpanUVAnim.setValues(newLifeSpanUVAnim);
	}
	
	public Float[] getDecayUVAnim() {
		return decayUVAnim.getValues();
	}
	
	public void setDecayUVAnim(Float[] newDecayUVAnim) {
		this.decayUVAnim.setValues(newDecayUVAnim);
	}
	
	public Float[] getTailUVAnim() {
		return tailUVAnim.getValues();
	}
	
	public void setTailUVAnim(Float[] newTailUVAnim) {
		this.tailUVAnim.setValues(newTailUVAnim);
	}
	
	public Float[] getTailDecayUVAnim() {
		return tailDecayUVAnim.getValues();
	}
	
	public void setTailDecayUVAnim(Float[] newTailDecayUVAnim) {
		this.tailDecayUVAnim.setValues(newTailDecayUVAnim);
	}
	
	public int getRows() {
		return rows.getValue();
	}
	
	public void setRows(int newRows) {
		this.rows.setValue(newRows);
	}
	
	public int getCols() {
		return cols.getValue();
	}
	
	public void setCols(int newCols) {
		this.cols.setValue(newCols);
	}
	
	public int getTextureID() {
		return textureID.getValue();
	}
	
	public void setTextureID(int newTextureID) {
		this.textureID.setValue(newTextureID);
	}
	
	public float getTime() {
		return time.getValue();
	}
	
	public void setTime(float newTime) {
		this.time.setValue(newTime);
	}
	
	public float getLifeSpan() {
		return lifeSpan.getValue();
	}
	
	public void setLifeSpan(float newLifeSpan) {
		this.lifeSpan.setValue(newLifeSpan);
	}
	
	public float getTailLength() {
		return tailLength.getValue();
	}
	
	public void setTailLength(float newTailLength) {
		this.tailLength.setValue(newTailLength);
	}
	
	public boolean isSortPrimsFarZ() {
		return sortPrimsFarZ.getValue();
	}
	
	public void setSortPrimsFarZ(boolean sortPrimsFarZ) {
		this.sortPrimsFarZ.setValue(sortPrimsFarZ);
	}
	
	public boolean isLineEmitter() {
		return lineEmitter.getValue();
	}
	
	public void setLineEmitter(boolean lineEmitter) {
		this.lineEmitter.setValue(lineEmitter);
	}
	
	public boolean isModelSpace() {
		return modelSpace.getValue();
	}
	
	public void setModelSpace(boolean modelSpace) {
		this.modelSpace.setValue(modelSpace);
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
	
	public boolean isXYQuad() {
		return xyQuad.getValue();
	}
	
	public void setXYQuad(boolean xyQuad) {
		this.xyQuad.setValue(xyQuad);
	}
	
	public boolean isSquirt() {
		return squirt.getValue();
	}
	
	public void setSquirt(boolean squirt) {
		this.squirt.setValue(squirt);
	}
	
	public boolean isBoth() {
		return both.getValue();
	}
	
	public void setBoth(boolean both) {
		this.both.setValue(both);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, alphaKey, speed, variation, latitude, gravity, emissionRate, width, length,
				visibility, segmentColor, alpha, particleScaling, lifeSpanUVAnim, decayUVAnim, tailUVAnim,
				tailDecayUVAnim, rows, cols, textureID, time, lifeSpan, tailLength, sortPrimsFarZ, lineEmitter,
				modelSpace, unshaded, unfogged, xyQuad, squirt, both);
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(alphaKey, speed, variation, latitude, gravity, emissionRate, width, length,
				visibility, segmentColor, alpha, particleScaling, lifeSpanUVAnim, decayUVAnim, tailUVAnim,
				tailDecayUVAnim, rows, cols, textureID, time, lifeSpan, tailLength, sortPrimsFarZ, lineEmitter,
				modelSpace, unshaded, unfogged, xyQuad, squirt, both));
	}
	
}
