package com.cvr.Encryption;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

public class EncryptionClass {
	//AES
	private static final String AES= "AES";
	private static final String AES_CIPHER_ALGORITHM= "AES/CBC/PKCS5PADDING";

	// secret key
	public static SecretKey createAESKey() throws Exception
	{
	    SecureRandom securerandom= new SecureRandom();
	    KeyGenerator keygenerator= KeyGenerator.getInstance(AES);
	    keygenerator.init(256, securerandom);
	    SecretKey key= keygenerator.generateKey();
	    return key;
	}

	public static byte[] createInitializationVector()
	{
	    byte[] initializationVector= new byte[16];
	    SecureRandom secureRandom= new SecureRandom();
	    secureRandom.nextBytes(initializationVector);
	    return initializationVector;
	}

	public static String do_AESEncryption(String plainText,SecretKey secretKey,byte[] initializationVector) throws Exception
	{
	    Cipher cipher= Cipher.getInstance(AES_CIPHER_ALGORITHM);
	    IvParameterSpec ivParameterSpec= new IvParameterSpec(initializationVector);
	    cipher.init(Cipher.ENCRYPT_MODE,secretKey,ivParameterSpec);
	    return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8)));
	}

	public static String do_AESDecryption(String cipherText,SecretKey secretKey,byte[] initializationVector) throws Exception
	{
	    Cipher cipher= Cipher.getInstance(AES_CIPHER_ALGORITHM);
	    IvParameterSpec ivParameterSpec= new IvParameterSpec(initializationVector);
	    cipher.init(Cipher.DECRYPT_MODE,secretKey,ivParameterSpec);
	    return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
	}
	
	
	//Hmac(256)
	public static String generateHmac(byte[] key, String msg) throws UnsupportedEncodingException {

		HMac hmac = new HMac(new SHA256Digest());
		byte[] result = new byte[hmac.getMacSize()];
		byte[] msgAry = msg.getBytes("UTF-8");
		hmac.init(new KeyParameter(key));
		hmac.reset();
		hmac.update(msgAry, 0, msgAry.length);
		hmac.doFinal(result, 0);
		return Base64.getEncoder().encodeToString(result);
	}
	
	
	

}
