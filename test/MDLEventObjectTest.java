import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLEventObject;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLEventObjectTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MDLNotFoundException, MDLParserErrorException {
		String s1 = "EventObject \"SNDzAITM\" {\n\tObjectId 38,\n\tEventTrack 3 {\n\t\t2,\n\t\t4,\n\t\t6,\n\t}\n}\n";
		MDLEventObject obj1 = new MDLEventObject();
		obj1.parse(s1);
		Assert.assertEquals(s1, obj1.toMDL());
		String s2 = "EventObject \"SPLxFAR1\" {\n\tObjectId 39,\n}\n";
		MDLEventObject obj2 = new MDLEventObject();
		obj2.parse(s2);
		Assert.assertEquals(s2, obj2.toMDL());
	}

}
