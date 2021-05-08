package com.SecureMessage.demo.controller;
import org.springframework.stereotype.Component;

import java.security.*;
import java.security.spec.ECParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.interfaces.ECPublicKey;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.SecretKeySpec;

import java.util.*;
import java.nio.ByteBuffer;
import java.io.Console;

import static javax.xml.bind.DatatypeConverter.printHexBinary;
import static javax.xml.bind.DatatypeConverter.parseHexBinary;

@Component
public class CryptoUtil {

    public void main(String[] args) throws Exception {
        String[] keyPair1 = GetKey();
        String[] keyPair2 = GetKey();
        String shared1 = GetSharedKey(keyPair1[1],keyPair2[0]);
        String shared2 = GetSharedKey(keyPair2[1],keyPair1[0]);
        System.out.println(shared1);
        System.out.println(shared2);
        String encryptedText= encryptText("hello world",shared1);
        String text = decryptText(encryptedText,shared2);
        System.out.println(text);
    }
    // return a String[]
    // index 0 public key
    // index 1 private key
    public String[] GetKey() throws Exception{
        String[] key = new String[2];
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
        kpg.initialize(256);
        KeyPair kp = kpg.generateKeyPair();
        byte[] publicKey = kp.getPublic().getEncoded();
        byte[] privateKey = kp.getPrivate().getEncoded();
        key[0] = printHexBinary(publicKey); // public key
        key[1] = printHexBinary(privateKey); // private key
        return key;
    }

    /*
        input as parameter description
        return String sharedkey
     */
    public String GetSharedKey(String _myPrivateKey, String _otherPublicKey)throws Exception{
        KeyFactory kf = KeyFactory.getInstance("EC");
        byte[] otherPk = parseHexBinary(_otherPublicKey);
        X509EncodedKeySpec pkSpec = new X509EncodedKeySpec(otherPk);
        PublicKey otherPublicKey = kf.generatePublic(pkSpec);
        KeyFactory kf2 = KeyFactory.getInstance("EC");
        byte[] myk = parseHexBinary(_myPrivateKey);
        //X509EncodedKeySpec pkSpec2 = new X509EncodedKeySpec(myk);
        PKCS8EncodedKeySpec pkSpec2 = new PKCS8EncodedKeySpec(myk);
        PrivateKey myPublicKey = kf2.generatePrivate(pkSpec2);
        // Perform key agreement
        KeyAgreement ka = KeyAgreement.getInstance("ECDH");
        // ka.init(kp.getPrivate());
        ka.init(myPublicKey);
        ka.doPhase(otherPublicKey, true);

        // Read shared secret
        byte[] sharedSecret = ka.generateSecret();
        // Derive a key from the shared secret and both public keys
        MessageDigest hash = MessageDigest.getInstance("SHA-256");
        byte[] derivedKey = hash.digest(sharedSecret);
        return printHexBinary(derivedKey);
    }
    /*
        input: String shared key
        get an aes key, private call only
     */
    public SecretKey getSecretEncryptionKey(String _derivedKey) throws Exception{
//        KeyGenerator generator = KeyGenerator.getInstance("AES");
//        generator.init(256); // The AES key size in number of bits
//        SecretKey secKey = generator.generateKey();
        byte[] derivedKey = parseHexBinary(_derivedKey);
        SecretKey key = new SecretKeySpec(derivedKey, 0, derivedKey.length, "AES");
        return key;
    }
    /*
        input:
        plaintext: message content
        derivedKey: sharedkey
        output：
        encrypted string
     */
    public String encryptText(String plainText,String derivedKey) throws Exception{
        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        SecretKey secKey = getSecretEncryptionKey(derivedKey);
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
        return printHexBinary(byteCipherText);
    }

    /*
       input:
       CipherText: encrypted string
       derivedKey: sharedkey
       output：
       content
    */
    public String decryptText(String CipherText, String derivedKey) throws Exception {
        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        SecretKey secKey = getSecretEncryptionKey(derivedKey);
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secKey);
        byte[] byteCipherText = parseHexBinary(CipherText);
        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
        return new String(bytePlainText);
    }
}