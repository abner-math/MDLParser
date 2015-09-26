package io.github.picoledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLObject;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLCamera extends MDLObject {

	private class MDLTarget extends MDLObject {
		
		private MDLNumberArray<Float> position;
		
		public MDLTarget() {
			super("Target");
			this.position = new MDLNumberArray<>("Position", Float.class, 3);
		}

		public Float[] getPosition() {
			return position.getValues();
		}
		
		public void setPosition(Float[] newPosition) {
			this.position.setValues(newPosition);
		}
		
		@Override
		public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
			Pair<String, String> token = super.parse(input);
			String contents = token.second;
			contents = parse(contents, position);
			return new Pair<String, String>(token.first, contents);
		}
		
		@Override
		public StringBuilder print(StringBuilder sb) {
			return super.print(print(position));
		}
		
	}
	
	private MDLNumber<Float> fieldOfView;
	private MDLNumber<Float> farClip;
	private MDLNumber<Float> nearClip;
	private MDLNumberArray<Float> position;
	private MDLTarget target;
	
	public MDLCamera() {
		super("Camera");
		this.fieldOfView = new MDLNumber<>("FieldOfView", new Float(0), true);
		this.farClip = new MDLNumber<>("FarClip", new Float(0), true);
		this.nearClip = new MDLNumber<>("NearClip", new Float(0), true);
		this.position = new MDLNumberArray<>("Position", Float.class, 3);
		this.target = new MDLTarget();
	}

	public float getFieldOfView() {
		return fieldOfView.getValue();
	}
	
	public void setFieldOfView(float newFieldOfView) {
		this.fieldOfView.setValue(newFieldOfView);
	}
	
	public float getFarClip() {
		return farClip.getValue();
	}
	
	public void setFarClip(float newFarClip) {
		this.farClip.setValue(newFarClip);
	}
	
	public float getNearClip() {
		return nearClip.getValue();
	}
	
	public void setNearClip(float newNearClip) {
		this.nearClip.setValue(newNearClip);
	}
	
	public Float[] getPosition() {
		return position.getValues();
	}
	
	public void setPosition(Float[] newPosition) {
		this.position.setValues(newPosition);
	}
	
	public Float[] getTargetPosition() {
		return target.getPosition();
	}
	
	public void setTargetPosition(Float[] newPosition) {
		this.target.setPosition(newPosition);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second; 
		contents = parse(contents, fieldOfView, farClip, nearClip, position, target);
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(fieldOfView, farClip, nearClip, position, target));
	}
	
}
