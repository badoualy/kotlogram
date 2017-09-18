package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.api.utils.DumpUtils;
import com.github.badoualy.telegram.tl.core.TLObject;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;

public class Benchmark {

    private static final int TEST_COUNT = 10000;

    public static void main(String[] args) throws IOException, DecoderException {
        Collection<File> files = DumpUtils.loadAll("tl/" + DumpUtils.dumpDir);
        TLApiTestContext context = TLApiTestContext.INSTANCE;
        StringBuilder builder = new StringBuilder();
        long totalTimeSerialize = 0;
        long totalTimeDeserialize = 0;
        long totalTimeComplete = 0;
        int totalTestCount = files.size() * TEST_COUNT;

        for (File file : files) {
            byte[] serialized = DumpUtils.load(file);
            // Deserialize and check if json is identical
            TLObject tlObject = context.deserializeMessage(serialized);
            builder.append("Starting benchmark for constructor: ").append(tlObject.toString()).append('\n');

            long start = System.nanoTime();
            for (int i = 0; i < TEST_COUNT; i++)
                tlObject.serialize();
            long duration = (System.nanoTime() - start);
            totalTimeSerialize += duration;
            builder.append(String.format("\tSerialized %d times in %d µs", TEST_COUNT, duration / 1000)).append('\n');

            start = System.nanoTime();
            for (int i = 0; i < TEST_COUNT; i++)
                context.deserializeMessage(serialized);
            duration = (System.nanoTime() - start);
            totalTimeDeserialize += duration;
            builder.append(String.format("\tDeserialized %d times in %d µs", TEST_COUNT, duration / 1000)).append('\n');

            start = System.nanoTime();
            for (int i = 0; i < TEST_COUNT; i++)
                context.deserializeMessage(tlObject.serialize());
            duration = (System.nanoTime() - start);
            totalTimeComplete += duration;
            builder.append(String.format("\tSerialized then deserialized %d times in %d µs", TEST_COUNT, duration / 1000)).append('\n');
        }

        File file = new File("./result.txt");
        System.out.println("Write results to " + file.getAbsolutePath());
        FileUtils.writeStringToFile(file, builder.toString(), Charset.forName("UTF-8"));

        double averageSerialize = (double) totalTimeSerialize / totalTestCount;
        double averageDeserialize = (double) totalTimeDeserialize / totalTestCount;
        double averageComplete = (double) totalTimeComplete / totalTestCount;
        averageSerialize /= 1000d;
        averageDeserialize /= 1000d;
        averageComplete /= 1000d;

        System.out.println("Final results: ");
        System.out.println("\tSerialize " + totalTestCount + " objects in average (ms) " + averageSerialize);
        System.out.println("\tDeserialized " + totalTestCount + " objects in average (ms) " + averageDeserialize);
        System.out.println("\tSerialize and Deserialized " + totalTestCount + " objects in average (ms) " + averageComplete);
    }
}
