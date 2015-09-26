

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLAnimatedObject;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLNumber;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLAnimatedObjectTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MDLNotFoundException, MDLParserErrorException {
		String s1 = "static TextureID 0,\n";
		MDLAnimatedObject<MDLNumber> anim1 = new MDLAnimatedObject<>("TextureID", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Integer(-1), false);
		anim1.parse(s1);
		Assert.assertTrue(anim1.isStatic());
		Assert.assertEquals(s1, anim1.toMDL());
		String s2 = "TextureID 1 {\n\tDontInterp,\n\t0: 0,\n}\n";
		MDLAnimatedObject<MDLNumber> anim2 = new MDLAnimatedObject<>("TextureID", MDLNumber.class.getDeclaredConstructor(String.class, Number.class, Boolean.class), new Integer(-1), false);
		anim2.parse(s2);
		Assert.assertFalse(anim2.isStatic());
		Assert.assertEquals(s2, anim2.toMDL());
	}

}
