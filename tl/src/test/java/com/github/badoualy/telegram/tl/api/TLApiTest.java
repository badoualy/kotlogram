package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.api.utils.DumpUtils;
import com.github.badoualy.telegram.tl.core.TLObject;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

/**
 * Unit test to generate random TLObject for each type, and serialize then deserialize it and check if still equals.
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public final class TLApiTest extends AbsTLApiTest implements ITest {

    private final Class<? extends TLObject> clazz;

    private TLApiTest(Class<? extends TLObject> clazz) {
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    @Test
    public <T extends TLObject> void runTest() throws Exception {
        T object = (T) getRandomTLObject(clazz);

        int serializedSize = object.computeSerializedSize();
        byte[] bytes = object.serialize();
        Assert.assertEquals(serializedSize, bytes.length, "Serialized size is different from computed size");

        T deserializedObject = newInstanceOf((Class<T>) clazz);
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        deserializedObject.deserialize(is, TLApiTestContext.getInstance());
        Assert.assertEquals(is.available(), 0, "Deserialization did not consume whole payload of " + bytes.length + " bytes");
        Assert.assertEquals(DumpUtils.toJson(deserializedObject), DumpUtils.toJson(object), "Deserialization of serialized object returned an object non-equals");

        //DumpUtils.dump(object, bytes);
    }

    @Override
    public String getTestName() {
        return clazz.getCanonicalName().replace(BASE_PACKAGE + ".", "");
    }

    /**
     * Serialize and deserialize each TL types and check equality
     */
    public static class TLApiTestFactory {

        @Factory
        public Object[] generateTestSuite() {
            AbsTLApiTest.init();
            return constructorList.stream().map(TLApiTest::new).toArray();
        }
    }
}
