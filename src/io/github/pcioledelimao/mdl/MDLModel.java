package io.github.pcioledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLModel extends MDLBoundedObject {

	private MDLNumber<Integer> blendTime;
	private MDLVersion version;
	private MDLSequences sequences;
	private MDLGlobalSequences globalSequences;
	private MDLTextures textures;
	
	public MDLModel() {
		super("Model");
		try {
			this.blendTime = new MDLNumber<>("BlendTime", 0, false);
			this.version = new MDLVersion();
			this.sequences = new MDLSequences();
			this.globalSequences = new MDLGlobalSequences();
			this.textures = new MDLTextures();
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	public int getNumGeosets() {
		return 0;
	}
	
	public int getNumGeosetAnims() {
		return 0;
	}
	
	public int getNumHelpers() {
		return 0;
	}
	
	public int getNumBones() {
		return 0;
	}
	
	public int getNumAttachments() {
		return 0;
	}
	public int getNumParticleEmitters() {
		return 0;
	}
	
	public int getNumParticleEmitters2() {
		return 0;
	}
	
	public int getNumRibbonEmitters() {
		return 0;
	}
	
	public int getBlendTime() {
		return blendTime.getValue();
	}
	
	public void setBlendTime(int newBlendTime) {
		this.blendTime.setValue(newBlendTime);
	}

	public MDLVersion getVersion() {
		return version;
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = parse(token.second, blendTime);
		input = parse(token.first, version, sequences, globalSequences, textures);
		return new Pair<String, String>(input, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		MDLNumber<Integer> numGeosets = new MDLNumber<>("NumGeosets", 0, false);
		MDLNumber<Integer> numGeosetAnims = new MDLNumber<>("NumGeosetAnims", 0, false);
		MDLNumber<Integer> numHelpers = new MDLNumber<>("NumHelpers", 0, false);
		MDLNumber<Integer> numBones = new MDLNumber<>("NumBones", 0, false);
		MDLNumber<Integer> numAttachments = new MDLNumber<>("NumAttachments", 0, false);
		MDLNumber<Integer> numParticleEmitters = new MDLNumber<>("NumParticleEmitters", 0, false);
		MDLNumber<Integer> numParticleEmitters2 = new MDLNumber<>("NumParticleEmitters2", 0, false);
		MDLNumber<Integer> numRibbonEmitters = new MDLNumber<>("NumRibbonEmitters", 0, false);
		numGeosets.setValue(getNumGeosets());
		numGeosetAnims.setValue(getNumGeosetAnims());
		numHelpers.setValue(getNumHelpers());
		numBones.setValue(getNumBones());
		numAttachments.setValue(getNumAttachments());
		numParticleEmitters.setValue(getNumParticleEmitters());
		numParticleEmitters2.setValue(getNumParticleEmitters2());
		numRibbonEmitters.setValue(getNumRibbonEmitters());
		return super.print(print(numGeosets, numGeosetAnims, numHelpers, numBones, numAttachments, numParticleEmitters,
				numParticleEmitters2, numRibbonEmitters, blendTime, minimumExtent, maximumExtent, boundsRadius));
	}
	
	@Override
	public String toMDL() {
		StringBuilder sb = new StringBuilder();
		sb.append(version.toMDL());
		sb.append(print(new StringBuilder()));
		sb.append(print(sequences, globalSequences, textures));
		return sb.toString();
	}
	
}
