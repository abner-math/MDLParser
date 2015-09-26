package io.github.picoledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLObject;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public abstract class MDLBoundedObject extends MDLObject {

	protected MDLNumberArray<Float> minimumExtent;
	protected MDLNumberArray<Float> maximumExtent;
	protected MDLNumber<Float> boundsRadius;
	
	public MDLBoundedObject(String name) {
		super(name);
		this.minimumExtent = new MDLNumberArray<>("MinimumExtent", Float.class, 3);
		this.maximumExtent = new MDLNumberArray<>("MaximumExtent", Float.class, 3);
		this.boundsRadius = new MDLNumber<>("BoundsRadius", 0.0f, false);
	}
	
	public Float[] getMinimumExtent() {
		return minimumExtent.getValues();
	}
	
	public void setMinimumExtent(Float[] newMinimumExtent) {
		this.minimumExtent.setValues(newMinimumExtent);
	}
	
	public Float[] getMaximumExtent() {
		return maximumExtent.getValues();
	}
	
	public void setMaximumExtent(Float[] newMaximumExtent) {
		this.maximumExtent.setValues(newMaximumExtent);
	}
	
	public Float getBoundsRadius() {
		return boundsRadius.getValue();
	}
	
	public void setBoundsRadius(Float newBoundsRadius) {
		this.boundsRadius.setValue(newBoundsRadius);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = parse(token.second, minimumExtent, maximumExtent, boundsRadius);
		setMinimumExtent(minimumExtent.getValues());
		setMaximumExtent(maximumExtent.getValues());
		setBoundsRadius(boundsRadius.getValue());
		return new Pair<String, String>(token.first, contents);
	}
	
}
