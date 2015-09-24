package io.github.pcioledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLBoolean;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLAnim extends MDLBoundedObject {

	private MDLNumberArray<Float> interval;
	private MDLNumber<Float> rarity;
	private MDLNumber<Float> moveSpeed;
	private MDLBoolean nonLooping;
	
	public MDLAnim() {
		super("Anim");
		this.interval = new MDLNumberArray<>("Interval", Float.class, 2);
		this.rarity = new MDLNumber<>("Rarity", 0.0f, false);
		this.moveSpeed = new MDLNumber<>("MoveSpeed", 0.0f, false);
		this.nonLooping = new MDLBoolean("NonLooping");
	}
	
	public Float[] getInterval() {
		return interval.getValues();
	}
	
	public void setInterval(Float[] newInterval) {
		this.interval.setValues(newInterval);
	}
	
	public float getRarity() {
		return rarity.getValue();
	}
	
	public void setRarity(float newRarity) {
		this.rarity.setValue(newRarity);
	}
	
	public float getMoveSpeed() {
		return moveSpeed.getValue();
	}
	
	public void setMoveSpeed(float newMoveSpeed) {
		this.moveSpeed.setValue(newMoveSpeed);
	}
	
	public boolean isNonLooping() {
		return nonLooping.getValue();
	}
	
	public void setNonLooping(boolean nonLooping) {
		this.nonLooping.setValue(nonLooping);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		parse(token.second, interval, rarity, moveSpeed, nonLooping);
		setInterval(interval.getValues());
		setRarity(rarity.getValue());
		setMoveSpeed(moveSpeed.getValue());
		setNonLooping(nonLooping.getValue());
		return new Pair<String, String>(token.first, "");
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(interval, rarity, moveSpeed, nonLooping, minimumExtent, maximumExtent, boundsRadius));
	}
	
}
