package io.github.picoledelimao.mdl.test;

import org.junit.Assert;
import org.junit.Test;

import io.github.picoledelimao.mdl.core.MDLNumber;

public class MDLNumberTest {

	@Test
	public void test() {
		String easy1 = "easy 2,";
		MDLNumber<Integer> e1 = new MDLNumber<>("easy", 0, true);
		try {
			e1.parse(easy1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(2, e1.getValue(), 0);
		Assert.assertEquals("easy 2,\n", e1.toMDL());
		String easy2 = "float1 4.5, float2 8.0,";
		MDLNumber<Float> e2 = new MDLNumber<>("float2", 0.0f, true);
		try {
			e2.parse(easy2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(8.0, e2.getValue(), 0);
		Assert.assertEquals("float2 8,\n", e2.toMDL());
		String medium1 = "v12 8, v1 88,";
		MDLNumber<Integer> m1 = new MDLNumber<>("v1", 0, true);
		try {
			m1.parse(medium1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(88, m1.getValue(), 0);
		Assert.assertEquals("v1 88,\n", m1.toMDL());
		String hard1 = "ana dkaskdsa dsam dadsamodas ana 123, daksknadsnads ana";
		MDLNumber<Integer> n1 = new MDLNumber<>("ana", 0, true);
		try {
			n1.parse(hard1);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(123, n1.getValue(), 0); 
		Assert.assertEquals("ana 123,\n", n1.toMDL());
		String hard2 = ".... dsadas ....dasindasnida anananana ana123 ana4.0 ana1 2.0 2ana 0.9 ana 0.8,idsa ana";
		MDLNumber<Double> n2 = new MDLNumber<>("ana", 0.0, true);
		try {
			n2.parse(hard2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(0.8, n2.getValue(), 0);
		Assert.assertEquals("ana 0.8,\n", n2.toMDL());
		n2.setValue(0.0);
		Assert.assertEquals("ana 0,\n", n2.toMDL());
		MDLNumber<Double> notFound = new MDLNumber<>("Notfound", 0.0, false);
		try {
			notFound.parse(hard2);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(0.0, notFound.getValue(), 0);
		Assert.assertEquals("", notFound.toMDL());
		notFound.setValue(10.0);
		Assert.assertEquals(10.0, notFound.getValue(), 0);
		Assert.assertEquals("Notfound 10,\n", notFound.toMDL());
		notFound.setValue(0.0);
		Assert.assertEquals(0, notFound.getValue(), 0);
		Assert.assertEquals("", notFound.toMDL());
	}

}
