package com.github.badoualy.telegram;

import com.github.badoualy.telegram.api.Kotlogram;
import com.github.badoualy.telegram.api.TelegramApiStorage;
import com.github.badoualy.telegram.api.TelegramApp;
import com.github.badoualy.telegram.api.TelegramClient;
import com.github.badoualy.telegram.mtproto.DataCenter;
import com.github.badoualy.telegram.mtproto.auth.AuthKey;
import com.github.badoualy.telegram.tl.api.TLDocument;
import com.github.badoualy.telegram.tl.api.TLInputDocumentFileLocation;
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty;
import com.github.badoualy.telegram.tl.api.TLMessage;
import com.github.badoualy.telegram.tl.api.TLMessageMediaDocument;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
import com.github.badoualy.telegram.tl.api.upload.TLFile;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.github.badoualy.telegram.C.API_HASH;
import static com.github.badoualy.telegram.C.API_ID;
import static com.github.badoualy.telegram.C.APP_VERSION;
import static com.github.badoualy.telegram.C.AUTH_KEY_FILE;
import static com.github.badoualy.telegram.C.LANG_CODE;
import static com.github.badoualy.telegram.C.MODEL;
import static com.github.badoualy.telegram.C.NEAREST_DC_FILE;
import static com.github.badoualy.telegram.C.SYSTEM_VERSION;

public class Sample1 {

    public static void main(String[] args) throws InterruptedException {
        //Kotlogram.setDebugLogEnabled(true);
        TelegramApp app = new TelegramApp(API_ID, API_HASH, MODEL, SYSTEM_VERSION, APP_VERSION, LANG_CODE);

        // This is a synchronous client, that will block until the response arrive (or until timeout)
        // A client which return an Observable<T> where T is the response type will be available soon
        TelegramClient client = Kotlogram.getDefaultClient(app, new ApiStorage());

        // You can start making requests
        try {
//            TLAbsSentCode sentCode = client.authSendCode(PHONE_NUMBER, 5);
//            System.out.println("Authentication code: ");
//            String code = new Scanner(System.in).nextLine();
//            TLAuthorization authorization = client.authSignIn(PHONE_NUMBER, sentCode.getPhoneCodeHash(), code);
//            TLUser self = (TLUser) authorization.getUser();
//            System.out.println("You are now signed in as " + self.getFirstName() + " " + self.getLastName());
//            // Start making cool stuff!
//
//            //Get user profile picture
//            TLFileLocation photoLocation = (TLFileLocation) ((TLUserProfilePhoto) self.getPhoto()).getPhotoBig();
//            TLInputFileLocation inputLocation = new TLInputFileLocation(photoLocation.getVolumeId(),
//                                                                        photoLocation.getLocalId(),
//                                                                        photoLocation.getSecret());
//            TLFile photo = client.uploadGetFile(inputLocation, 0, 0);
//            FileUtils.writeByteArrayToFile(PHOTO_FILE, photo.getBytes().getData());

            TLAbsDialogs dialogs = client.messagesGetDialogs(0, 0, new TLInputPeerEmpty(), 0);
            // Do something with recent chats :)

            // TODO: generic types array covariant

//            dialogs.getChats().stream().forEach(c -> {
//                if (c instanceof TLChat) {
//                    TLChat chat = (TLChat) c;
//                    System.out.println("Chat " + chat.getTitle() + " with id " + chat.getId());
//
//                    try {
//                        TLFile file = client.getChatPhoto(chat, true);
//                        if (file != null)
//                            FileUtils.writeByteArrayToFile(new File("./sample/" + chat.getId() + ".jpg"), file.getBytes().getData());
//                    } catch (RpcErrorException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println("-----");
//                }
//            });
        } catch (IOException e) {
            // Network error
            e.printStackTrace();
        }

        client.close(); // Important, do not forget this, or your process won't finish
        System.err.println("------------------------- GOOD BYE");
    }

    private static void downloadFiles(TelegramClient client, TLAbsDialogs dialogs) {
        dialogs.getMessages().stream()
               .forEach(m -> {
                   System.out.println("------");
                   if (m instanceof TLMessage) {
                       TLMessage message = (TLMessage) m;
                       System.out.println(message.getMessage());
                       if (message.getMedia() != null && message.getMedia() instanceof TLMessageMediaDocument) {
                           TLMessageMediaDocument media = (TLMessageMediaDocument) message.getMedia();
                           TLDocument document = (TLDocument) media.getDocument();
                           TLInputDocumentFileLocation input = new TLInputDocumentFileLocation(document.getId(),
                                                                                               document.getAccessHash());

                           //image/webp
                           //application/vnd.android.package-archive
                           System.out.println("Getting " + document.getMimeType());
                           String ext = document.getMimeType().contains("android") ? ".apk" : ".webp";
                           try {
                               ByteArrayOutputStream baos = new ByteArrayOutputStream();
                               int read = 0;
                               while (read < document.getSize()) {
                                   TLFile tlFile = client.uploadGetFile(input, read, document.getSize());
                                   read += tlFile.getBytes().getLength();
                                   baos.write(tlFile.getBytes().getData());
                               }
                               FileUtils.writeByteArrayToFile(new File("./" + document.getId() + ext), baos.toByteArray());
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
                       }
                   }
                   System.out.println("------");
               });
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
        public void saveDc(@NotNull DataCenter dataCenter) {
            try {
                FileUtils.write(NEAREST_DC_FILE, dataCenter.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Nullable
        @Override
        public DataCenter loadDc() {
            try {
                String[] infos = FileUtils.readFileToString(NEAREST_DC_FILE).split(":");
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
        public void saveServerSalt(long salt) {

        }

        @Nullable
        @Override
        public Long loadServerSalt() {
            return null;
        }
    }
}
