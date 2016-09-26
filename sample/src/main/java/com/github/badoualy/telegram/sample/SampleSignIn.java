package com.github.badoualy.telegram.sample;

import com.github.badoualy.telegram.api.Kotlogram;
import com.github.badoualy.telegram.api.TelegramClient;
import com.github.badoualy.telegram.tl.api.TLUser;
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization;
import com.github.badoualy.telegram.tl.api.auth.TLSentCode;
import com.github.badoualy.telegram.tl.exception.RpcErrorException;

import java.io.IOException;
import java.util.Scanner;

import static com.github.badoualy.telegram.sample.C.ApiStorage;
import static com.github.badoualy.telegram.sample.C.PHONE_NUMBER;
import static com.github.badoualy.telegram.sample.C.application;

public class SampleSignIn {

    public static void main(String[] args) {
        // This is a synchronous client, that will block until the response arrive (or until timeout)
        TelegramClient client = Kotlogram.getDefaultClient(application, new ApiStorage());

        // You can start making requests
        try {
            // Send code to account
            TLSentCode sentCode = client.authSendCode(false, PHONE_NUMBER, true);
            System.out.println("Authentication code: ");
            String code = new Scanner(System.in).nextLine();

            // Auth with the received code
            TLAuthorization authorization = client.authSignIn(PHONE_NUMBER, sentCode.getPhoneCodeHash(), code);
            TLUser self = authorization.getUser().getAsUser();
            System.out.println("You are now signed in as " + self.getFirstName() + " " + self.getLastName() + " @" + self.getUsername());
        } catch (RpcErrorException | IOException e) {
            e.printStackTrace();
        } finally {
            client.close(); // Important, do not forget this, or your process won't finish
        }
    }

}
