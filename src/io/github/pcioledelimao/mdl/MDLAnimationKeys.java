package io.github.pcioledelimao.mdl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLEnum;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLNumeric;
import io.github.picoledelimao.mdl.core.MDLObject;
import io.github.picoledelimao.mdl.core.MDLObjectArray;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLAnimationKeys<T extends MDLNumeric> extends MDLObjectArray<MDLAnimationKey> {

	private MDLEnum interpolationType;
	private MDLNumber<Integer> globalSeqId;
	
	public MDLAnimationKeys(String name, Constructor<T> constructor, Object... constructorParams) throws NoSuchMethodException, SecurityException {
		super(name, true, MDLAnimationKey.class.getDeclaredConstructor(Boolean.class, constructor.getClass(), constructorParams.getClass()), true, constructor, constructorParams);
		this.interpolationType = new MDLEnum("", true, MDLInterpolationType.getStringValues());
		this.globalSeqId = new MDLNumber<>("GlobalSeqId", -1, false);
	}

	public MDLInterpolationType getInterpolationType() {
		return MDLInterpolationType.getValue(interpolationType.getValue());
	}
	
	public void setInterpolationType(MDLInterpolationType newInterpolationType) throws MDLParserErrorException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (newInterpolationType == null) throw new IllegalArgumentException("Interpolation type cannot be null.");
		boolean showTanValue = newInterpolationType == MDLInterpolationType.HERMITE || newInterpolationType == MDLInterpolationType.BEZIER;
		constructorParams[0] = showTanValue;
		for (MDLAnimationKey key : objects) {
			key.setShowTanValue(showTanValue);
		}
		this.interpolationType.setValue(newInterpolationType.toString());
	}
	
	public Integer getGlobalSeqId() {
		return globalSeqId.getValue();
	}
	
	public void setGlobalSeqId(Integer newGlobalSeqId) {
		this.globalSeqId.setValue(newGlobalSeqId);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		MDLObject obj = new MDLObject(name) {};
		Pair<String, String> token = obj.parse(input);
		String contents = token.second;
		contents = parse(contents, interpolationType, globalSeqId);
		try {
			setInterpolationType(MDLInterpolationType.getValue(interpolationType.getValue()));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalAccessError("Could not set interpolation type.");
		}
		return new Pair<String, String>(token.first, super.parse(input).second);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		sb.append(interpolationType).append(globalSeqId);
		return super.print(sb);
	}
	
}
