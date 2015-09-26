package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLRibbonEmitter extends MDLTVertex {

	private MDLAnimatedObject<MDLNumber> heightAbove;
	private MDLAnimatedObject<MDLNumber> heightBelow;
	private MDLAnimatedObject<MDLNumber> alpha;
	private MDLAnimatedObject<MDLNumberArray> color;
	private MDLAnimatedObject<MDLNumber> textureSlot;
	private MDLAnimatedObject<MDLNumber> visibility;
	private MDLNumber<Float> emissionRate;
	private MDLNumber<Float> lifeSpan;
	private MDLNumber<Float> gravity;
	private MDLNumber<Integer> rows;
	private MDLNumber<Integer> cols; 
	private MDLNumber<Integer> materialID;
	
	public MDLRibbonEmitter() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super("RibbonEmitter");
		this.heightAbove = new MDLAnimatedObject<>("HeightAbove", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.heightBelow = new MDLAnimatedObject<>("HeightBelow", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.alpha = new MDLAnimatedObject<>("Alpha", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(1), true);
		this.color = new MDLAnimatedObject<>("Color", MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), Float.class, 3);
		this.textureSlot = new MDLAnimatedObject<>("TextureSlot", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Integer(0), true);
		this.visibility = new MDLAnimatedObject<>("Visibility", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(1), true);
		this.emissionRate = new MDLNumber<>("EmissionRate", new Float(0), true);
		this.lifeSpan = new MDLNumber<>("LifeSpan", new Float(0), true);
		this.gravity = new MDLNumber<>("Gravity", new Float(0), false);
		this.rows = new MDLNumber<>("Rows", 0, false);
		this.cols = new MDLNumber<>("Columns", 0, false);
		this.materialID = new MDLNumber<>("MaterialID", -1, false);
	}
	
	public MDLAnimatedObject<MDLNumber> getHeightAbove() {
		return heightAbove;
	}
	
	public MDLAnimatedObject<MDLNumber> getHeightBelow() {
		return heightBelow;
	}
	
	public MDLAnimatedObject<MDLNumber> getAlpha() {
		return alpha;
	}
	
	public MDLAnimatedObject<MDLNumberArray> getColor() {
		return color;
	}
	
	public MDLAnimatedObject<MDLNumber> getTextureSlot() {
		return textureSlot;
	}
	
	public MDLAnimatedObject<MDLNumber> getVisibility() {
		return visibility;
	}
	
	public float getEmissionRate() {
		return emissionRate.getValue();
	}
	
	public void setEmissionRate(float newEmissionRate) {
		this.emissionRate.setValue(newEmissionRate);
	}
	
	public float getLifeSpan() {
		return lifeSpan.getValue();
	}
	
	public void setLifeSpan(float newLifeSpan) {
		this.lifeSpan.setValue(newLifeSpan);
	}
	
	public float getGravity() {
		return gravity.getValue();
	}
	
	public void setGravity(float newGravity) {
		this.gravity.setValue(newGravity);
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
	
	public int getMaterialID() {
		return materialID.getValue();
	}
	
	public void setMaterialID(int newMaterialID) {
		this.materialID.setValue(newMaterialID);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, heightAbove, heightBelow, alpha, color, textureSlot, visibility, emissionRate,
				lifeSpan, gravity, rows, cols, materialID);
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(heightAbove, heightBelow, alpha, color, textureSlot, visibility, emissionRate,
				lifeSpan, gravity, rows, cols, materialID));
	}
	
}
