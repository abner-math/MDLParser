package io.github.picoledelimao.mdl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLObjectArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLModel extends MDLBoundedObject {

	private String modelName;
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
	private MDLObjectArray<MDLEventObject> events;
	private MDLObjectArray<MDLCamera> cameras;
	private MDLObjectArray<MDLCollisionShape> shapes;
	
	public MDLModel() {
		super("Model");
		try {
			this.modelName = "NoName.mdl";
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
			this.events = new MDLObjectArray<>("", false, MDLEventObject.class.getDeclaredConstructor());
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
	
	public int getNumEvents() {
		return events.getObjects().size();
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
	
	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String newModelName) {
		this.modelName = newModelName;
	}
	
	public static MDLModel parseFromFile(String filename) throws IOException, MDLNotFoundException, MDLParserErrorException {
		 FileReader inputFile = new FileReader(filename);
		 BufferedReader bufferReader = new BufferedReader(inputFile);
		 StringBuilder sb = new StringBuilder();
		 String line;
		 while ((line = bufferReader.readLine()) != null) {
			 sb.append(line + "\n");
		 }
		 bufferReader.close();
		 MDLModel model = new MDLModel();
		 model.setModelName(filename);
		 model.parse(sb.toString());
		 try {
			 int nameIndex = filename.lastIndexOf("\\") + 1;
			 model.setValue("\"" + filename.substring(nameIndex).replace(".mdl", "") + "\"");
			 model.setModelName(filename.substring(nameIndex));
		 } catch (Exception e) { }
		return model;
	}
	
	public void writeToFile(String filename) throws IOException {
		FileWriter outputFile = new FileWriter(filename);
		outputFile.write(toMDL());
		outputFile.close();
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = parse(token.second, blendTime);
		input = parse(token.first, version, sequences, globalSequences, textures, materials, textureAnims, 
				geosets, geosetAnims, bones, lights, helpers, attachments, pivotPoints, particleEmitters, 
				particleEmitters2, ribbonEmitters, events, cameras, shapes);
		return new Pair<String, String>(input, contents);
	}

	@Override
	public String toMDL() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = dateFormat.format(Calendar.getInstance().getTime());
		StringBuilder sb = new StringBuilder("//+-----------------------------------------------------------------------------\n")
				.append("//| " + modelName + "\n")
				.append("//| Generated by MDLParser v1.0\n//| " + date + "\n")
				.append("//| http://www.picoledelimao.github.io\n")
				.append("//+-----------------------------------------------------------------------------\n");
		sb.append(version.toMDL());
		sb.append(print(new StringBuilder()));
		sb.append(print(sequences, globalSequences, textures, materials, textureAnims, geosets, geosetAnims,
				bones, lights, helpers, attachments, pivotPoints, particleEmitters, particleEmitters2, 
				ribbonEmitters, events, cameras, shapes));
		return sb.toString();
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		MDLNumber<Integer> numGeosets = new MDLNumber<>("NumGeosets", 0, false);
		MDLNumber<Integer> numGeosetAnims = new MDLNumber<>("NumGeosetAnims", 0, false);
		MDLNumber<Integer> numHelpers = new MDLNumber<>("NumHelpers", 0, false);
		MDLNumber<Integer> numBones = new MDLNumber<>("NumBones", 0, false);
		MDLNumber<Integer> numLights = new MDLNumber<>("NumLights", 0, false);
		MDLNumber<Integer> numEvents = new MDLNumber<>("NumEvents", 0, false);
		MDLNumber<Integer> numAttachments = new MDLNumber<>("NumAttachments", 0, false);
		MDLNumber<Integer> numParticleEmitters = new MDLNumber<>("NumParticleEmitters", 0, false);
		MDLNumber<Integer> numParticleEmitters2 = new MDLNumber<>("NumParticleEmitters2", 0, false);
		MDLNumber<Integer> numRibbonEmitters = new MDLNumber<>("NumRibbonEmitters", 0, false);
		numGeosets.setValue(getNumGeosets());
		numGeosetAnims.setValue(getNumGeosetAnims());
		numHelpers.setValue(getNumHelpers());
		numBones.setValue(getNumBones());
		numLights.setValue(getNumLights());
		numEvents.setValue(getNumEvents());
		numAttachments.setValue(getNumAttachments());
		numParticleEmitters.setValue(getNumParticleEmitters());
		numParticleEmitters2.setValue(getNumParticleEmitters2());
		numRibbonEmitters.setValue(getNumRibbonEmitters());
		return super.print(print(numGeosets, numGeosetAnims, numHelpers, numBones, numLights, numAttachments, numEvents, numParticleEmitters,
				numParticleEmitters2, numRibbonEmitters, blendTime, minimumExtent, maximumExtent, boundsRadius));
	}
	
}
