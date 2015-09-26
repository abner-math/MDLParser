package io.github.picoledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLBoolean;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLObject;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.MDLString;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLBitmap extends MDLObject {

	private MDLString image;
	private MDLNumber<Integer> replaceableId;
	private MDLBoolean wrapWidth;
	private MDLBoolean wrapHeight;
	
	public MDLBitmap() {
		super("Bitmap");
		this.image = new MDLString("Image", true);
		this.replaceableId = new MDLNumber<>("ReplaceableId", 0, false);
		this.wrapWidth = new MDLBoolean("WrapWidth");
		this.wrapHeight = new MDLBoolean("WrapHeight");
	}
	
	public String getImage() {
		return image.getValue();
	}
	
	public void setImage(String newImage) {
		this.image.setValue(newImage);
	}
	
	public int getReplaceableId() {
		return replaceableId.getValue();
	}
	
	public void setReplaceableId(int newReplaceableId) {
		this.replaceableId.setValue(newReplaceableId);
	}
	
	public boolean isWrapWidth() {
		return wrapWidth.getValue();
	}
	
	public void setWrapWidth(boolean wrapWidth) {
		this.wrapWidth.setValue(wrapWidth);
	}
	
	public boolean isWrapHeight() {
		return wrapHeight.getValue();
	}
	
	public void setWrapHeight(boolean wrapHeight) {
		this.wrapHeight.setValue(wrapHeight);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = parse(token.second, image, replaceableId, wrapWidth, wrapHeight);
		setImage(image.getValue());
		setReplaceableId(replaceableId.getValue());
		setWrapHeight(wrapWidth.getValue());
		setWrapHeight(wrapHeight.getValue());
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(image, replaceableId, wrapWidth, wrapHeight));
	}
	
}
