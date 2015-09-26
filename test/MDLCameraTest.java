import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLCamera;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLCameraTest {

	@Test
	public void test() throws MDLNotFoundException, MDLParserErrorException {
		String s1 = "Camera \"Camera\" {\n\tFieldOfView 0.785398,\n\tFarClip 1200,\n\tNearClip 1000,\n\tPosition { 90.3714, -65.3949, 204.669 },\n\tTarget {\n\t\tPosition { 0.641652, 12.7995, 172.906 },\n\t}\n}\n";
		MDLCamera camera1 = new MDLCamera();
		camera1.parse(s1);
		Assert.assertEquals(s1, camera1.toMDL());
		String s2 = "Camera \"Name2\" {\n\tFieldOfView 0.785398,\n\tFarClip 10000,\n\tNearClip 1,\n\tPosition { 301.642, -0.452886, 414.786 },\n\tTarget {\n\t\tPosition { -0.0724153, -0.452886, 113.072 },\n\t}\n}\n";
		MDLCamera camera2 = new MDLCamera();
		camera2.parse(s2);
		Assert.assertEquals(s2, camera2.toMDL());
	}

}
