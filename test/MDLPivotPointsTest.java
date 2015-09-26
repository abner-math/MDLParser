

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLPivotPoints;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLPivotPointsTest {

	@Test
	public void test() throws NoSuchMethodException, SecurityException, MDLNotFoundException, MDLParserErrorException {
		String s1 = "PivotPoints 37 {\n\t{ 9.47552, 10.2343, 3.8504 },\n\t{ 9.33513, -11.5053, 3.97766 },\n\t{ -2.63601, -11.0603, 13.5353 },\n\t{ -2.63601, 10.3252, 13.68 },\n\t{ 6.23146, -12.0074, 56.8127 },\n\t{ 0, -45.0778, 87.0996 },\n\t{ -0.498965, 33.8277, 126.408 },\n\t{ -0.498965, -34.9657, 127.171 },\n\t{ -0.328993, -24.6091, 154.096 },\n\t{ -0.328992, 23.476, 154.117 },\n\t{ -0.350553, -0.089206, 165.208 },\n\t{ 0, 0, 0 },\n\t{ 0, 45.0846, 87.1798 },\n\t{ 6.1068, 12.1421, 56.7576 },\n\t{ -8.19712, -0.020047, 136.97 },\n\t{ 1.47246, -12.1842, 92.6048 },\n\t{ 0.788778, 11.5649, 91.7432 },\n\t{ 18.3652, 0, 84.5494 },\n\t{ 0, 0, 0 },\n\t{ -0.610399, 9.42982, 159.333 },\n\t{ -0.6104, -9.38088, 159.41 },\n\t{ 0, -0.185762, 112.74 },\n\t{ -2.6, -10.9738, -0.358917 },\n\t{ -2.6, 10.2501, 0.220009 },\n\t{ 0, -45.0778, 71.0962 },\n\t{ 0, 43.2839, 71.2737 },\n\t{ 5.4031, 0, 143.548 },\n\t{ 0, 0, 0 },\n\t{ 1.66223, 0, 178.382 },\n\t{ -2.83879, 0, 216.465 },\n\t{ 0, 0, 0 },\n\t{ 0, 0, 0 },\n\t{ 0, 0, 0 },\n\t{ 0, 0, 0 },\n\t{ 0, 0, 0 },\n\t{ 0, 0, 0 },\n\t{ 0, 0, 0 },\n}\n";
		MDLPivotPoints points = new MDLPivotPoints();
		points.parse(s1);
		Assert.assertEquals(s1, points.toMDL());
	}

}
