package io.github.picoledelimao.mdl;

import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.MDLString;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLAttachment extends MDLTVertex {

	private MDLNumber<Integer> attachmentID; 
	private MDLString path;
	private MDLAnimatedObject<MDLNumber> visibility;
	
	public MDLAttachment() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		super("Attachment");
		this.attachmentID = new MDLNumber<>("AttachmentID", 0, true);
		this.path = new MDLString("Path", false);
		this.visibility = new MDLAnimatedObject<>("Visibility", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Float(1), true);
	}
	
	public int getAttachmentID() {
		return attachmentID.getValue();
	}
	
	public void setAttachmentID(int newAttachmentID) {
		this.attachmentID.setValue(newAttachmentID);
	}
	
	public String getPath() {
		return path.getValue();
	}
	
	public void setPath(String newPath) {
		this.path.setValue(newPath);
	}
	
	public MDLAnimatedObject<MDLNumber> getVisibility() {
		return visibility;
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = token.second;
		contents = parse(contents, attachmentID, path, visibility);
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(attachmentID, path, visibility));
	}
	
}
