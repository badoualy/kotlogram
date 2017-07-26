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
import java.util.ArrayList;

/**
 * Unit test that will read all dump and try to de-serialize then re-serialize then, checking each time if the content
 * and the bytes are equals
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLApiDumpTest implements ITest {

    private File file;

    private TLApiDumpTest(File file) {
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
            ArrayList<TLApiDumpTest> list = new ArrayList<>();
            for (File file : DumpUtils.loadAll()) {
                list.add(new TLApiDumpTest(file));
            }
            return list.toArray();
        }
    }
}
