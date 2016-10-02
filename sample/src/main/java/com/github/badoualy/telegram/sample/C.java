package com.github.badoualy.telegram.sample;

import com.github.badoualy.telegram.api.TelegramApiStorage;
import com.github.badoualy.telegram.api.TelegramApp;
import com.github.badoualy.telegram.mtproto.auth.AuthKey;
import com.github.badoualy.telegram.mtproto.model.DataCenter;
import com.github.badoualy.telegram.mtproto.model.MTSession;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

public final class C {

    // Get them from Telegram's console
    public static final int API_ID = 0;
    public static final String API_HASH = "<YOUR_HASH_HERE>";

    // What you want to appear in the "all sessions" screen
    public static final String APP_VERSION = "AppVersion";
    public static final String MODEL = "Model";
    public static final String SYSTEM_VERSION = "SysVer";
    public static final String LANG_CODE = "en";

    public static TelegramApp application = new TelegramApp(API_ID, API_HASH, MODEL, SYSTEM_VERSION, APP_VERSION, LANG_CODE);

    // Phone number used for tests
    public static final String PHONE_NUMBER = "+00000000000"; // International format

    public static final File ROOT_DIR = new File("sample" + File.separator);
    public static final File AUTH_KEY_FILE = new File(ROOT_DIR, "auth.key");
    public static final File NEAREST_DC_FILE = new File(ROOT_DIR, "dc.save");

    public static class ApiStorage implements TelegramApiStorage {

        @Override
        public void saveAuthKey(@NotNull AuthKey authKey) {
            try {
                FileUtils.writeByteArrayToFile(AUTH_KEY_FILE, authKey.getKey());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Nullable
        @Override
        public AuthKey loadAuthKey() {
            try {
                return new AuthKey(FileUtils.readFileToByteArray(AUTH_KEY_FILE));
            } catch (IOException e) {
                if (!(e instanceof FileNotFoundException))
                    e.printStackTrace();
            }

            return null;
        }

        @Override
        public void saveDc(@NotNull DataCenter dataCenter) {
            try {
                FileUtils.write(NEAREST_DC_FILE, dataCenter.toString(), Charset.forName("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Nullable
        @Override
        public DataCenter loadDc() {
            try {
                String[] infos = FileUtils.readFileToString(NEAREST_DC_FILE, Charset.forName("UTF-8")).split(":");
                return new DataCenter(infos[0], Integer.parseInt(infos[1]));
            } catch (IOException e) {
                if (!(e instanceof FileNotFoundException))
                    e.printStackTrace();
            }

            return null;
        }

        @Override
        public void deleteAuthKey() {
            try {
                FileUtils.forceDelete(AUTH_KEY_FILE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void deleteDc() {
            try {
                FileUtils.forceDelete(NEAREST_DC_FILE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void saveSession(@Nullable MTSession session) {

        }

        @Nullable
        @Override
        public MTSession loadSession() {
            return null;
        }
    }

    private C() {

    }
}
