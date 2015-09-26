package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLObject;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.MDLString;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLParticle extends MDLObject {

	private MDLAnimatedObject<MDLNumber> lifeSpan;
	private MDLAnimatedObject<MDLNumber> initVelocity;
	private MDLString path;
	
	public MDLParticle() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super("Particle");
		this.lifeSpan = new MDLAnimatedObject<>("LifeSpan", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.initVelocity = new MDLAnimatedObject<>("InitVelocity", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(0), true);
		this.path = new MDLString("Path", true);
	}
	
	public MDLAnimatedObject<MDLNumber> getLifeSpan() {
		return lifeSpan;
	}
	
	public MDLAnimatedObject<MDLNumber> initVelocity() {
		return initVelocity;
	}
	
	public String getPath() {
		return path.getValue();
	}
	
	public void setPath(String newPath) {
		this.path.setValue(newPath);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second; 
		contents = parse(contents, lifeSpan, initVelocity, path);
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(lifeSpan, initVelocity, path));
	}
	
}
