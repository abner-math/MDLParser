

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLGlobalSequences;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLGlobalSequencesTest {

	@Test
	public void test() throws NoSuchMethodException, SecurityException, MDLNotFoundException, MDLParserErrorException {
		String sequences1 = "GlobalSequences 1 {\n\tDuration 100,\n}\n";
		String sequences2 = "GlobalSequences 2 {\n\tDuration 3333,\n\tDuration 1600,\n}\n";
		MDLGlobalSequences gs1 = new MDLGlobalSequences();
		gs1.parse(sequences1);
		Assert.assertEquals(sequences1, gs1.toMDL());
		MDLGlobalSequences gs2 = new MDLGlobalSequences();
		gs2.parse(sequences2);
		Assert.assertEquals(sequences2, gs2.toMDL());
	}

}
