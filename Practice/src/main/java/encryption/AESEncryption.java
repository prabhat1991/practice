package encryption;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES Implementation using a 128-bit encryption Key
 * @author prabhatkumar
 *
 */
public class AESEncryption {

	public static void main(String[] args) {
		AESEncryption app = new AESEncryption();
		app.run();

	}

	public void run() {
		try {
			String text = "World";
			String key = "Bar12345Bar42345"; // 128 bit key
			// Create key and cipher
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			// encrypt the text
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(text.getBytes());
			System.out.println("Encrypted Text: " + new String(encrypted));
			// decrypt the text
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			String decrypted = new String(cipher.doFinal(encrypted));
			System.out.println("Decrypted Text: " + decrypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
