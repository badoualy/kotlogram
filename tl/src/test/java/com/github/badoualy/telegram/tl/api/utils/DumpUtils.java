package com.github.badoualy.telegram.tl.api.utils;

import com.github.badoualy.telegram.tl.StreamUtils;
import com.github.badoualy.telegram.tl.api.AbsTLApiTest;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.HexDump;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;

public class DumpUtils {

    public static final String dumpDir = "./src/test/resources/dump/";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    public static Collection<File> loadAll() {
        return loadAll(dumpDir);
    }

    public static Collection<File> loadAll(String path) {
        return FileUtils.listFiles(new File(path), new String[]{"dump"}, true);
    }

    public static byte[] load(File file) throws IOException, DecoderException {
        Charset charset = Charset.forName("UTF-8");
        return (byte[]) new Hex(charset).decode(FileUtils.readFileToString(file, charset));
    }

    public static String loadJson(File file) throws IOException, DecoderException {
        file = new File(file.getAbsolutePath().replace(".dump", ".json"));
        return FileUtils.readFileToString(file, Charset.forName("UTF-8"));
    }

    public static <T extends TLObject> void dump(T object, byte[] serialized) {
        try {
            String path = getFilePath(object.getClass());
            FileUtils.writeStringToFile(new File(dumpDir + path + ".json"), toJson(object), Charset.forName("UTF-8"));
            FileUtils.writeStringToFile(new File(dumpDir + path + ".dump"), StreamUtils.toHexString(serialized), Charset.forName("UTF-8"));
            HexDump.dump(serialized, 0, new FileOutputStream(dumpDir + path + ".dump2"), 0); // More friendly dump
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T extends TLObject> String toJson(T object) {
        String json = gson.toJson(object);
        if(json.contains("\r\n"))
            return json;

        return json.replace("\n", "\r\n");
    }

    private static String getFilePath(Class<?> clazz) {
        String fileName = clazz.getSimpleName();
        String packageName = clazz.getPackage().getName();
        String folder = packageName.replace(AbsTLApiTest.BASE_PACKAGE, "").replace(".", "").trim();
        if (!folder.isEmpty())
            fileName = folder + File.separatorChar + fileName;
        return fileName;
    }

}
