package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLBoolean;
import io.github.picoledelimao.mdl.core.MDLBooleanArray;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLBone extends MDLTVertexAnim {

	private MDLNumber<Integer> objectId;
	private MDLNumber<Integer> parentId;
	private MDLBoolean geosetIdMultiple;
	private MDLNumber<Integer> geosetId;
	private MDLBoolean geosetAnimIdNone;
	private MDLNumber<Integer> geosetAnimId;
	private MDLBooleanArray dontInherit;
	private MDLBoolean billboarded;
	private MDLBoolean billboardedLockX;
	private MDLBoolean billboardedLockY;
	private MDLBoolean billboardedLockZ;
	private MDLBoolean cameraAnchored;
	
	public MDLBone(String name) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super(name);
		this.objectId = new MDLNumber<>("ObjectId", 0, true);
		this.parentId = new MDLNumber<>("Parent", -1, false);
		this.geosetIdMultiple = new MDLBoolean("GeosetId Multiple");
		this.geosetId = new MDLNumber<>("GeosetId", 0, true);
		this.geosetAnimIdNone = new MDLBoolean("GeosetAnimId None");
		this.geosetAnimId = new MDLNumber<>("GeosetAnimId", 0, true);
		this.dontInherit = new MDLBooleanArray("DontInherit", "Translation", "Rotation", "Scaling");
		this.billboarded = new MDLBoolean("Billboarded");
		this.billboardedLockX = new MDLBoolean("BillboardedLockX");
		this.billboardedLockY = new MDLBoolean("BillboardedLockY");
		this.billboardedLockZ = new MDLBoolean("BillboardedLockZ");
		this.cameraAnchored = new MDLBoolean("CameraAnchored");
	}
	
	public MDLBone() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		this("Bone");
	}
	
	public int getObjectId() {
		return objectId.getValue();
	}
	
	public void setObjectId(int newObjectId) {
		this.objectId.setValue(newObjectId);
	}
	
	public int getParentId() {
		return parentId.getValue();
	}
	
	public void setParentId(int newParentId) {
		this.parentId.setValue(newParentId);
	}
	
	public int getGeosetId() {
		if (geosetIdMultiple.getValue()) return -1;
		return geosetId.getValue();
	}
	
	public void setGeosetId(int newGeosetId) {
		if (newGeosetId < 0) {
			geosetIdMultiple.setValue(true);
		} else {
			geosetIdMultiple.setValue(false);
			geosetId.setValue(newGeosetId);
		}
	}
	
	public int getGeosetAnimId() {
		if (geosetAnimIdNone.getValue()) return -1;
		return geosetAnimId.getValue();
	}
	
	public void setGeosetAnimId(int newGeosetAnimId) {
		if (newGeosetAnimId < 0) {
			geosetAnimIdNone.setValue(true);
		} else {
			geosetAnimIdNone.setValue(false);
			geosetAnimId.setValue(newGeosetAnimId);
		}
	}
	
	public MDLBoolean[] dontInherit() {
		return dontInherit.getValues();
	}
	
	public void setDontInherit(MDLBoolean[] values) {
		this.dontInherit.setValues(values);
	}
	
	public boolean isBillboarded() {
		return billboarded.getValue();
	}
	
	public void setBillboarded(boolean billboarded) {
		this.billboarded.setValue(billboarded);
	}
	
	public boolean isBillboardedLockX() {
		return billboardedLockX.getValue();
	}
	
	public void setBillboardedLockX(boolean billboardedLockX) {
		this.billboardedLockX.setValue(billboardedLockX);
	}

	public boolean isBillboardedLockY() {
		return billboardedLockY.getValue();
	}
	
	public void setBillboardedLockY(boolean billboardedLockY) {
		this.billboardedLockY.setValue(billboardedLockY);
	}
	
	public boolean isBillboardedLockZ() {
		return billboardedLockZ.getValue();
	}
	
	public void setBillboardedLockZ(boolean billboardedLockZ) {
		this.billboardedLockZ.setValue(billboardedLockZ);
	}
	
	public boolean isCameraAnchored() {
		return cameraAnchored.getValue();
	}
	
	public void setCameraAnchored(boolean cameraAnchored) {
		this.cameraAnchored.setValue(cameraAnchored);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, objectId, parentId, geosetIdMultiple, geosetAnimIdNone, dontInherit,
				billboarded, billboardedLockX, billboardedLockY, billboardedLockZ, cameraAnchored);
		if (!geosetIdMultiple.getValue()) {
			contents = parse(contents, geosetId);
		}
		if (!geosetAnimIdNone.getValue()) {
			contents = parse(contents, geosetAnimId);
		}
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(objectId, parentId, geosetIdMultiple.getValue() ? geosetIdMultiple : geosetId,
				geosetAnimIdNone.getValue() ? geosetAnimIdNone : geosetAnimId, dontInherit, billboarded,
				billboardedLockX, billboardedLockY, billboardedLockZ, cameraAnchored));
	}
	
}
