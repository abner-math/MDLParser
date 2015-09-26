package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLBoolean;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLNumberArray;
import io.github.picoledelimao.mdl.core.MDLObject;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLGeosetAnim extends MDLObject {

	private MDLNumber<Integer> geosetId;
	private MDLAnimatedObject<MDLNumber> alpha;
	private MDLAnimatedObject<MDLNumberArray> color;
	private MDLBoolean dropShadow;
	
	public MDLGeosetAnim() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super("GeosetAnim");
		this.geosetId = new MDLNumber<>("GeosetId", -1, false);
		this.alpha = new MDLAnimatedObject<>("Alpha", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(1), false);
		this.color = new MDLAnimatedObject<>("Color", MDLNumberArray.class.getDeclaredConstructor(String.class, Class.class, Integer.class), Integer.class, 3);
		this.dropShadow = new MDLBoolean("DropShadow");
	}

	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, geosetId, alpha, color, dropShadow);
		return new Pair<String, String>(token.first, contents);
	}

	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(geosetId, alpha, color, dropShadow));
	}
	
}
