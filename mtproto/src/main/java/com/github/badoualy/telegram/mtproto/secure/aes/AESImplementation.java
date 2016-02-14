package com.github.badoualy.telegram.mtproto.secure.aes;

import java.io.IOException;

public interface AESImplementation {
    void AES256IGEDecrypt(byte[] src, byte[] dest, int len, byte[] iv, byte[] key);

    void AES256IGEEncrypt(byte[] src, byte[] dest, int len, byte[] iv, byte[] key);

    void AES256IGEEncrypt(String sourceFile, String destFile, byte[] iv, byte[] key) throws IOException;

    void AES256IGEDecrypt(String sourceFile, String destFile, byte[] iv, byte[] key) throws IOException;
}
