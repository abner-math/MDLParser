package io.github.pcioledelimao.mdl;

import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLObject;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
import io.github.picoledelimao.mdl.core.Pair;

public class MDLVersion extends MDLObject {

	public static final int SUPPORTED_FORMAT_VERSION = 800;
	
	private MDLNumber<Integer> formatVersion;
	
	public MDLVersion() {
		super("Version");
		this.formatVersion = new MDLNumber<>("FormatVersion", 0, true);
	}
	
	public int getFormatVersion() {
		return formatVersion.getValue();
	}
	
	public void setFormatVersion(int newFormatVersion) {
		if (newFormatVersion != SUPPORTED_FORMAT_VERSION) {
			throw new IllegalArgumentException("Unsupported format version.");
		}
		this.formatVersion.setValue(newFormatVersion);
	}
	
	@Override
	public Pair<String, String> parse(String input) throws MDLNotFoundException, MDLParserErrorException {
		Pair<String, String> token = super.parse(input);
		String contents = parse(token.second, formatVersion);
		setFormatVersion(formatVersion.getValue());
		return new Pair<String, String>(token.first, contents);
	}
	
	@Override
	public StringBuilder print(StringBuilder sb) {
		return super.print(print(formatVersion));
	}
	
}
