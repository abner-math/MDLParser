package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLBoolean;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLParticleEmitter extends MDLTVertex {

	private MDLBoolean emitterUsesMDL;
	private MDLBoolean emitterUsesTGA;
	private MDLAnimatedObject<MDLNumber> emissionRate;
	private MDLAnimatedObject<MDLNumber> gravity;
	private MDLAnimatedObject<MDLNumber> longitude;
	private MDLAnimatedObject<MDLNumber> latitude;
	private MDLAnimatedObject<MDLNumber> visibility;
	private MDLParticle particle;
	
	public MDLParticleEmitter() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super("ParticleEmitter");
		this.emitterUsesMDL = new MDLBoolean("EmitterUsesMDL");
		this.emitterUsesTGA = new MDLBoolean("EmitterUsesTGA");
		this.emissionRate = new MDLAnimatedObject<>("EmissionRate", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.gravity = new MDLAnimatedObject<>("Gravity", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.longitude = new MDLAnimatedObject<>("Longitude", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.latitude = new MDLAnimatedObject<>("Latitude", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.visibility = new MDLAnimatedObject<>("Visibility", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(1), true);
		this.particle = new MDLParticle();
	}
	
	public boolean isEmitterUsesMDL() {
		return emitterUsesMDL.getValue();
	}
	
	public void setEmitterUsesMDL(boolean emitterUsesMDL) {
		this.emitterUsesMDL.setValue(emitterUsesMDL);
	}
	
	public boolean isEmitterUsesTGA() {
		return emitterUsesTGA.getValue();
	}
	
	public void setEmitterUsesTGA(boolean emitterUsesTGA) {
		this.emitterUsesTGA.setValue(emitterUsesTGA);
	}
	
	public MDLAnimatedObject<MDLNumber> getEmissionRate() {
		return emissionRate;
	}
	
	public MDLAnimatedObject<MDLNumber> getGravity() {
		return gravity;
	}
	
	public MDLAnimatedObject<MDLNumber> getLatitude() {
		return latitude;
	}
	
	public MDLAnimatedObject<MDLNumber> getLongitude() {
		return longitude;
	}
	
	public MDLAnimatedObject<MDLNumber> getVisibility() {
		return visibility;
	}
	
	public MDLParticle getParticle() {
		return particle;
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, emitterUsesMDL, emitterUsesTGA, emissionRate, gravity, longitude, latitude, visibility, particle);
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(emitterUsesMDL, emitterUsesTGA, emissionRate, gravity, longitude, latitude, visibility, particle));
	}
	
}
