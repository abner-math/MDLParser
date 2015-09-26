package io.github.picoledelimao.mdl;

import java.util.List;

import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLObjectArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLModel extends MDLBoundedObject {

	private MDLNumber<Integer> blendTime;
	private MDLVersion version;
	private MDLSequences sequences;
	private MDLGlobalSequences globalSequences;
	private MDLTextures textures;
	private MDLMaterials materials;
	private MDLTextureAnims textureAnims;
	private MDLObjectArray<MDLGeoset> geosets;
	private MDLObjectArray<MDLGeosetAnim> geosetAnims;
	private MDLObjectArray<MDLBone> bones;
	private MDLObjectArray<MDLLight> lights;
	private MDLObjectArray<MDLHelper> helpers;
	private MDLObjectArray<MDLAttachment> attachments;
	private MDLPivotPoints pivotPoints;
	private MDLObjectArray<MDLParticleEmitter> particleEmitters;
	private MDLObjectArray<MDLParticleEmitter2> particleEmitters2;
	private MDLObjectArray<MDLRibbonEmitter> ribbonEmitters;
	private MDLObjectArray<MDLCamera> cameras;
	private MDLObjectArray<MDLCollisionShape> shapes;
	
	public MDLModel() {
		super("Model");
		try {
			this.blendTime = new MDLNumber<>("BlendTime", 0, false);
			this.version = new MDLVersion();
			this.sequences = new MDLSequences();
			this.globalSequences = new MDLGlobalSequences();
			this.textures = new MDLTextures();
			this.materials = new MDLMaterials();
			this.textureAnims = new MDLTextureAnims();
			this.geosets = new MDLObjectArray<>("", false, MDLGeoset.class.getDeclaredConstructor());
			this.geosetAnims = new MDLObjectArray<>("", false, MDLGeosetAnim.class.getDeclaredConstructor());
			this.bones = new MDLObjectArray<>("", false, MDLBone.class.getDeclaredConstructor());
			this.lights = new MDLObjectArray<>("", false, MDLLight.class.getDeclaredConstructor());
			this.helpers = new MDLObjectArray<>("", false, MDLHelper.class.getDeclaredConstructor());
			this.attachments = new MDLObjectArray<>("", false, MDLAttachment.class.getDeclaredConstructor());
			this.pivotPoints = new MDLPivotPoints();
			this.particleEmitters = new MDLObjectArray<>("", false, MDLParticleEmitter.class.getDeclaredConstructor());
			this.particleEmitters2 = new MDLObjectArray<>("", false, MDLParticleEmitter2.class.getDeclaredConstructor());
			this.ribbonEmitters = new MDLObjectArray<>("", false, MDLRibbonEmitter.class.getDeclaredConstructor());
			this.cameras = new MDLObjectArray<>("", false, MDLCamera.class.getDeclaredConstructor());
			this.shapes = new MDLObjectArray<>("", false, MDLCollisionShape.class.getDeclaredConstructor());
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	public MDLSequences getSequences() {
		return sequences;
	}
	
	public MDLGlobalSequences getGlobalSequences() {
		return globalSequences;
	}
	
	public MDLTextures getTextures() {
		return textures;
	}
	
	public MDLMaterials getMaterials() {
		return materials;
	}
	
	public MDLTextureAnims getTextureAnims() {
		return textureAnims;
	}
	
	public List<MDLGeoset> getGeosets() {
		return geosets.getObjects();
	}
	
	public List<MDLGeosetAnim> getGeosetAnims() {
		return geosetAnims.getObjects();
	}
	
	public List<MDLBone> getBones() {
		return bones.getObjects();
	}
	
	public List<MDLLight> getLights() {
		return lights.getObjects();
	}
	
	public List<MDLHelper> getHelpers() {
		return helpers.getObjects();
	}
	
	public List<MDLAttachment> getAttachments() {
		return attachments.getObjects();
	}
	
	public MDLPivotPoints getPivotPoints() {
		return pivotPoints;
	}
	
	public List<MDLParticleEmitter> getParticleEmitters() {
		return particleEmitters.getObjects();
	}
	
	public List<MDLParticleEmitter2> getParticleEmitters2() {
		return particleEmitters2.getObjects();
	}
	
	public List<MDLRibbonEmitter> getRibbonEmitters() {
		return ribbonEmitters.getObjects();
	}
	
	public List<MDLCamera> getCameras() {
		return cameras.getObjects();
	}
	
	public List<MDLCollisionShape> getCollisionShapes() {
		return shapes.getObjects();
	}
	
	public int getNumGeosets() {
		return geosets.getObjects().size();
	}
	
	public int getNumGeosetAnims() {
		return geosetAnims.getObjects().size();
	}
	
	public int getNumHelpers() {
		return helpers.getObjects().size();
	}
	
	public int getNumBones() {
		return bones.getObjects().size();
	}
	
	public int getNumLights() {
		return lights.getObjects().size();
	}
	
	public int getNumAttachments() {
		return attachments.getObjects().size();
	}
	
	public int getNumParticleEmitters() {
		return particleEmitters.getObjects().size();
	}
	
	public int getNumParticleEmitters2() {
		return particleEmitters2.getObjects().size();
	}
	
	public int getNumRibbonEmitters() {
		return ribbonEmitters.getObjects().size();
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
		input = parse(token.first, version, sequences, globalSequences, textures, materials, textureAnims, 
				geosets, geosetAnims, bones, lights, helpers, attachments, pivotPoints, particleEmitters, 
				particleEmitters2, ribbonEmitters, cameras, shapes);
		return new Pair<String, String>(input, contents);
	}

	@Override
	public String toMDL() {
		StringBuilder sb = new StringBuilder();
		sb.append(version.toMDL());
		sb.append(print(new StringBuilder()));
		sb.append(print(sequences, globalSequences, textures, materials, textureAnims, geosets, geosetAnims,
				bones, lights, helpers, attachments, pivotPoints, particleEmitters, particleEmitters2, 
				ribbonEmitters, cameras, shapes));
		return sb.toString();
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		MDLNumber<Integer> numGeosets = new MDLNumber<>("NumGeosets", 0, false);
		MDLNumber<Integer> numGeosetAnims = new MDLNumber<>("NumGeosetAnims", 0, false);
		MDLNumber<Integer> numHelpers = new MDLNumber<>("NumHelpers", 0, false);
		MDLNumber<Integer> numBones = new MDLNumber<>("NumBones", 0, false);
		MDLNumber<Integer> numLights = new MDLNumber<>("NumLights", 0, false);
		MDLNumber<Integer> numAttachments = new MDLNumber<>("NumAttachments", 0, false);
		MDLNumber<Integer> numParticleEmitters = new MDLNumber<>("NumParticleEmitters", 0, false);
		MDLNumber<Integer> numParticleEmitters2 = new MDLNumber<>("NumParticleEmitters2", 0, false);
		MDLNumber<Integer> numRibbonEmitters = new MDLNumber<>("NumRibbonEmitters", 0, false);
		numGeosets.setValue(getNumGeosets());
		numGeosetAnims.setValue(getNumGeosetAnims());
		numHelpers.setValue(getNumHelpers());
		numBones.setValue(getNumBones());
		numLights.setValue(getNumLights());
		numAttachments.setValue(getNumAttachments());
		numParticleEmitters.setValue(getNumParticleEmitters());
		numParticleEmitters2.setValue(getNumParticleEmitters2());
		numRibbonEmitters.setValue(getNumRibbonEmitters());
		return super.print(print(numGeosets, numGeosetAnims, numHelpers, numBones, numLights, numAttachments, numParticleEmitters,
				numParticleEmitters2, numRibbonEmitters, blendTime, minimumExtent, maximumExtent, boundsRadius));
	}
	
}
