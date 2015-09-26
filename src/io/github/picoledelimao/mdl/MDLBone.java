package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLBoolean;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLBone extends MDLNode {

	private MDLBoolean geosetIdMultiple;
	private MDLNumber<Integer> geosetId;
	private MDLBoolean geosetAnimIdNone;
	private MDLNumber<Integer> geosetAnimId;

	public MDLBone() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super("Bone");
		this.geosetIdMultiple = new MDLBoolean("GeosetId Multiple");
		this.geosetId = new MDLNumber<>("GeosetId", 0, true);
		this.geosetAnimIdNone = new MDLBoolean("GeosetAnimId None");
		this.geosetAnimId = new MDLNumber<>("GeosetAnimId", 0, true);
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
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, geosetIdMultiple, geosetAnimIdNone);
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
		return super.print(print(geosetIdMultiple.getValue() ? geosetIdMultiple : geosetId,
				geosetAnimIdNone.getValue() ? geosetAnimIdNone : geosetAnimId));
	}
	
}
