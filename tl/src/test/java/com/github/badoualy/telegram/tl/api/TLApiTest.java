package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.api.utils.DumpUtils;
import com.github.badoualy.telegram.tl.core.TLObject;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public final class TLApiTest extends AbsTLApiTest implements ITest {

    private Class<? extends TLObject> clazz;

    private TLApiTest(Class<? extends TLObject> clazz) {
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    @Test
    public <T extends TLObject> void runTest() throws Exception {
        T object = (T) getRandomTLObject(clazz);

        int serializedSize = object.computeSerializedSize();
        byte[] bytes = object.serialize();
        Assert.assertEquals(serializedSize, bytes.length);

        T deserializedObject = newInstanceOf((Class<T>) clazz);
        deserializedObject.deserialize(new ByteArrayInputStream(bytes), TLApiTestContext.getInstance());

        DumpUtils.dump(object, bytes);
    }

    @Override
    public String getTestName() {
        return clazz.getCanonicalName().replace(BASE_PACKAGE + ".", "");
    }

    public static class TLApiTestFactory {

        @Factory
        public Object[] generateTestSuite() {
            AbsTLApiTest.init();
            return constructorList.stream().map(TLApiTest::new).toArray();
        }
    }
}
