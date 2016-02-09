package com.github.badoualy.telegram;

import com.github.badoualy.telegram.tl.api.TLApiContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class DecodeHexDump {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    public static void main(String[] args) throws IOException, DecoderException {
        if (args.length != 1) {
            System.err.println("Usage: java -jar tl-decoder.jar <input>");
            System.exit(-1);
        }
        File file = new File(args[0]);
        System.out.println("Using input " + file.getAbsolutePath());

        byte[] payload = load(file);
        TLObject object = TLApiContext.getInstance().deserializeMessage(payload);

        System.out.println("Found " + object.toString() + " " + object.getClass().getCanonicalName() + "\n\n");
        System.out.println(gson.toJson(object));
    }

    public static byte[] load(File file) throws IOException, DecoderException {
        Charset charset = Charset.forName("UTF-8");
        return (byte[]) new Hex(charset).decode(FileUtils.readFileToString(file, charset));
    }
}
