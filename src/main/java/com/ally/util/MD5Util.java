package com.ally.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	public static String getMd5Pwd(String password) {
		try {
			MessageDigest mDigest = MessageDigest.getInstance("MD5");
			mDigest.update(password.getBytes());
			String newPwd = new BigInteger(1, mDigest.digest()).toString(16);
			return newPwd;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
