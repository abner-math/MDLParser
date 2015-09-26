import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLLight;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLLightTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MDLNotFoundException, MDLParserErrorException {
		String s1 = "Light \"UNNAMED\" {\n\tObjectId 18,\n\tDirectional,\n\tstatic AttenuationStart 21,\n\tstatic AttenuationEnd 20,\n\tstatic Color { 0.505882, 0, 0.329412 },\n\tstatic Intensity 10,\n\tstatic AmbColor { 1, 1, 0 },\n\tstatic AmbIntensity 15,\n\tstatic Visibility 0.5,\n}\n";
		MDLLight light1 = new MDLLight();
		light1.parse(s1);
		Assert.assertEquals(s1, light1.toMDL());
		String s2 = "Light \"UNNAMED\" {\n\tObjectId 19,\n\tOmnidirectional,\n\tstatic AttenuationStart 0,\n\tstatic AttenuationEnd 0,\n\tstatic Color { 1, 1, 1 },\n\tstatic Intensity 0,\n\tstatic AmbColor { 1, 1, 1 },\n\tstatic AmbIntensity 0,\n}\n";
		MDLLight light2 = new MDLLight();
		light2.parse(s2);
		Assert.assertEquals(s2, light2.toMDL());
	}

}
