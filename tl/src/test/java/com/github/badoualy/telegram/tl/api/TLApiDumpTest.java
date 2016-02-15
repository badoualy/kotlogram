package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.api.utils.DumpUtils;
import com.github.badoualy.telegram.tl.core.TLObject;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.io.FilenameUtils;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TLApiDumpTest implements ITest {
    private File file;

    public TLApiDumpTest(File file) {
        this.file = file;
    }

    @Test
    public void runTest() throws IOException, DecoderException {
        byte[] realSerialized = DumpUtils.load(file);
        String realJson = DumpUtils.loadJson(file);

        // Deserialize and check if json is identical
        TLObject tlObject = TLApiTestContext.getInstance().deserializeMessage(realSerialized);
        String json = DumpUtils.toJson(tlObject);
        Assert.assertEquals(json, realJson, file.getName());

        // Re-serialize and check bytes
        byte[] serialized = tlObject.serialize();
        Assert.assertEquals(serialized, realSerialized, file.getName());
    }

    @Override
    public String getTestName() {
        return FilenameUtils.removeExtension(file.getName());
    }

    /**
     * Deserialize each previously dumped TL types and ensure that the result is correct
     */
    public static class TestFactory {

        @Factory
        public Object[] generateTestSuite() throws IOException, DecoderException {
            return DumpUtils.loadAll().stream().map(TLApiDumpTest::new).toArray();
        }
    }
}
