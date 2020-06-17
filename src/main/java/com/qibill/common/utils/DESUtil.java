package com.qibill.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author qibill
 */
public class DESUtil {
	
	private static final String DES = "DES";

	public static void main(String[] args) throws Exception {
		BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
		String str = strin.readLine();
		System.out.println(encrypt(str, "Bio-San#17"));
	}

	/**
	 * 加密
	 * @param data
	 * @param key
	 * @return
	 */
	public static String encrypt(String data, String key) {
		byte[] bt = null;

		try {
			bt = encrypt(data.getBytes(), key.getBytes());
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		return (new BASE64Encoder()).encode(bt);
	}

	/**
	 * 解密
	 * @param data
	 * @param key
	 * @return
	 */
	public static String decrypt(String data, String key) {
		if (data == null) {
			return null;
		} else {
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] buf = null;
			try {
				buf = decoder.decodeBuffer(data);
			} catch (IOException var7) {
				var7.printStackTrace();
			}
			byte[] bt = null;
			try {
				bt = decrypt(buf, key.getBytes());
			} catch (Exception var6) {
				var6.printStackTrace();
			}
			return new String(bt);
		}
	}

	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance(DES);
		cipher.init(1, securekey, sr);
		return cipher.doFinal(data);
	}

	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance(DES);
		cipher.init(2, securekey, sr);
		return cipher.doFinal(data);
	}

	public static String md5(String plainText) {
		String md5sString = "";

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte[] b = md.digest();
			StringBuilder buf = new StringBuilder();

			for (int value : b) {
				int i = value;
				if (i < 0) {
					i += 256;
				}

				if (i < 16) {
					buf.append("0");
				}

				buf.append(Integer.toHexString(i));
			}

			md5sString = buf.toString();
		} catch (NoSuchAlgorithmException var7) {
			var7.printStackTrace();
			md5sString = var7.toString();
		}

		return md5sString;
	}
}
