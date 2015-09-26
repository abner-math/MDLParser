

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MDLBooleanTest.class, MDLNumberArrayTest.class, MDLNumberTest.class, MDLStringTest.class,
		MDLVersionTest.class, MDLAnimTest.class, MDLSequencesTest.class, MDLGlobalSequencesTest.class, 
		MDLBitmapTest.class, MDLTexturesTest.class, MDLEnumTest.class, MDLBooleanArrayTest.class,
		MDLAnimationKeyTest.class, MDLAnimationKeysTest.class, MDLAnimatedObjectTest.class, MDLLayerTest.class,
		MDLMaterialTest.class, MDLMaterialsTest.class, MDLTVertexAnimTest.class, MDLTextureAnimsTest.class,
		MDLMatrixTest.class, MDLGeosetTest.class, MDLGeosetAnimTest.class, MDLBoneTest.class, MDLHelperTest.class,
		MDLAttachmentTest.class, MDLPivotPointsTest.class, MDLParticleTest.class, MDLParticleEmitterTest.class,
		MDLParticleEmitter2Test.class, MDLRibbonEmitterTest.class, MDLLightTest.class, MDLCameraTest.class })
public class AllTests {

}
