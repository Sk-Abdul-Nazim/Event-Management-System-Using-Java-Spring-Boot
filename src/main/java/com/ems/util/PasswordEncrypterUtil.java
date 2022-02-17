package com.ems.util;


import java.security.spec.KeySpec;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.directwebremoting.util.Base64;

public class PasswordEncrypterUtil {
	private static PasswordEncrypterUtil instance = null;

	public static PasswordEncrypterUtil getInstance() throws Exception {
		if (null == instance) {
			instance = new PasswordEncrypterUtil();
			return instance;
		}
		return instance;
	}

	public static final String DESEDE_ENCRYPTION_SCHEME = StringConstantsUtil.DES_EDE;
	private KeySpec ks;
	private SecretKeyFactory skf;
	private Cipher cipher;
	private byte[] arrayBytes;
	private String myEncryptionKey;
	private String myEncryptionScheme;
	private SecretKey key;

	private PasswordEncrypterUtil() throws Exception {
		myEncryptionKey = StringConstantsUtil.PASSWORD_ENCRYPTION_KEY;
		myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
		arrayBytes = myEncryptionKey.getBytes(StringConstantsUtil.UTF8);
		ks = new DESedeKeySpec(arrayBytes);
		skf = SecretKeyFactory.getInstance(myEncryptionScheme);
		cipher = Cipher.getInstance(myEncryptionScheme);
		key = skf.generateSecret(ks);
	}

	public String encrypt(String unencryptedString) {
		String encryptedString = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] plainText = unencryptedString.getBytes(StringConstantsUtil.UTF8);
			byte[] encryptedText = cipher.doFinal(plainText);
			encryptedString = new String(Base64.encodeBase64(encryptedText));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedString;
	}

	public String decript(String encryptedString) {
		
		String decryptedText = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] encryptedText = Base64.decodeBase64(encryptedString.getBytes());
			byte[] plainText = cipher.doFinal(encryptedText);
			decryptedText = new String(plainText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedText;
	}
	
	public static String gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    String rr = Integer.toString((1 + r.nextInt(2)) * 100000 + r.nextInt(100000));
	    return rr;
	}
}
