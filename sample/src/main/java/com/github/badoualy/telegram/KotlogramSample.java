package com.github.badoualy.telegram;

import com.github.badoualy.telegram.api.Kotlogram;
import com.github.badoualy.telegram.api.TelegramApiStorage;
import com.github.badoualy.telegram.api.TelegramApp;
import com.github.badoualy.telegram.api.TelegramClient;
import com.github.badoualy.telegram.mtproto.DataCenter;
import com.github.badoualy.telegram.mtproto.auth.AuthKey;
import com.github.badoualy.telegram.mtproto.exception.RpcErrorException;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLUserSelf;
import com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode;
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static com.github.badoualy.telegram.C.*;

public class KotlogramSample {


    public static void main(String[] args) throws InterruptedException {
        TelegramApp app = new TelegramApp(API_ID, API_HASH, MODEL, SYSTEM_VERSION, APP_VERSION, LANG_CODE);

        // This is a synchronous client, that will block until the response arrive (or until timeout)
        // A client which return an Observable<T> where T is the response type will be available soon
        TelegramClient client = Kotlogram.getDefaultClient(app, new ApiStorage());

        // You can start making requests
        try {
            TLAbsSentCode sentCode = client.authSendCode(PHONE_NUMBER, 5);
            System.out.println("Authentication code: ");
            String code = new Scanner(System.in).nextLine();
            TLAuthorization authorization = client.authSignIn(PHONE_NUMBER, sentCode.getPhoneCodeHash(), code);
            TLUserSelf self = (TLUserSelf) authorization.getUser();
            System.out.println("You are now signed in as " + self.getFirstName() + " " + self.getLastName());

            // Start making cool stuff!
            TLAbsDialogs dialogs = client.messagesGetDialogs(0, 0, 0);
            // Do something with recent chats :)
        } catch (RpcErrorException e) {
            // Error with the request, invalid argument, etc
            e.printStackTrace();
        } catch (IOException e) {
            // Network error
            e.printStackTrace();
        }

        client.close(); // Important, do not forget this, or your process won't finish
        System.err.println("------------------------- GOOD BYE");
    }

    private static class ApiStorage implements TelegramApiStorage {


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
        public void saveNearestDc(@NotNull DataCenter dataCenter) {
            try {
                FileUtils.write(NEAREST_DC_FILE, dataCenter.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Nullable
        @Override
        public DataCenter loadNearestDc() {
            try {
                String[] infos = FileUtils.readFileToString(NEAREST_DC_FILE).split(":");
                return new DataCenter(infos[0], Integer.parseInt(infos[1]));
            } catch (IOException e) {
                if (!(e instanceof FileNotFoundException))
                    e.printStackTrace();
            }

            return null;
        }
    }
}
