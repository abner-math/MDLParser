import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.MDLCollisionShape;
import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;

public class MDLCollisionShapeTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, MDLNotFoundException, MDLParserErrorException {
		String s1 = "CollisionShape \"Sphere\" {\n\tObjectId 38,\n\tParent 20,\n\tSphere,\n\tVertices 1 {\n\t\t{ 0, 0, 65 },\n\t}\n\tBoundsRadius 65,\n}\n";
		MDLCollisionShape shape1 = new MDLCollisionShape();
		shape1.parse(s1);
		Assert.assertEquals(s1, shape1.toMDL());
		String s2 = "CollisionShape \"Sphere2\" {\n\tObjectId 39,\n\tParent 20,\n\tSphere,\n\tVertices 1 {\n\t\t{ 0, 0, 135 },\n\t}\n\tBoundsRadius 50,\n}\n";
		MDLCollisionShape shape2 = new MDLCollisionShape();
		shape2.parse(s2);
		Assert.assertEquals(s2, shape2.toMDL());
		String s3 = "CollisionShape \"UNNAMED\" {\n\tObjectId 40,\n\tSphere,\n\tVertices 1 {\n\t\t{ 1, 2, 3 },\n\t}\n\tBoundsRadius 10,\n}\n";
		MDLCollisionShape shape3 = new MDLCollisionShape();
		shape3.parse(s3);
		Assert.assertEquals(s3, shape3.toMDL());
		String s4 = "CollisionShape \"UNNAMED\" {\n\tObjectId 41,\n\tBox,\n\tVertices 2 {\n\t\t{ 10, 15, 20 },\n\t\t{ 15, 20, 25 },\n\t}\n}\n";
		MDLCollisionShape shape4 = new MDLCollisionShape();
		shape4.parse(s4);
		Assert.assertEquals(s4, shape4.toMDL());
	}

}
