package io.github.picoledelimao.mdl.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MDLBooleanTest.class, MDLNumberArrayTest.class, MDLNumberTest.class, MDLStringTest.class,
		MDLVersionTest.class, MDLAnimTest.class })
public class AllTests {

}
