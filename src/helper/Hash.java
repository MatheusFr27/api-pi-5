package helper;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public String encript(String password) {

		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(password.getBytes("UTF-8"));

			String encryptedPassword = new BigInteger(1, messageDigest.digest()).toString(16);

			return encryptedPassword;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}
	}

	public boolean checkPassword(String password, String encryptedPassword) {

		if (password.equals(encryptedPassword)) {
			return true;
		}

		return false;

	}

}
