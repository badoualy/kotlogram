package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static com.github.badoualy.telegram.tl.api.TestUtils.constructorList;
import static com.github.badoualy.telegram.tl.api.TestUtils.getRandomTLObject;
import static com.github.badoualy.telegram.tl.api.TestUtils.newInstanceOf;

@Test
public class TLApiTest {


    @BeforeTest
    protected void findClasses() {

    }

    @Test
    public void testComputeSerializationSize() throws Exception {
        for (Class<? extends TLObject> constructor : constructorList) {
            TLObject object = getRandomTLObject(constructor);
            int size = object.computeSerializedSize();
            byte[] serialized = object.serialize();
            int realSize = serialized.length;

            Assert.assertEquals(size, realSize, "Invalid size " + object.getClass().getSimpleName());
        }
    }

    @Test
    public void testSerializeDeserialize() throws Exception {
        for (Class<? extends TLObject> constructor : constructorList) {
            TLObject object = getRandomTLObject(constructor);
            byte[] serialized = object.serialize();
            TLObject deserialized = newInstanceOf(constructor);
            deserialized.deserialize(new ByteArrayInputStream(serialized), TLApiContext.getInstance());
        }
    }

}
