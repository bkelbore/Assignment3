//CMSC 203 CRN 22297
//Instructor: Dr. Grinber
//Assigmnet3
//Due Date 10/11/2021
/*Assignment Description: encoding a message or information in such a way that only 
/* authorized parties can access it and those who are not authorized cannot. 
//In an encryption scheme, the intended information or message, referred to as plaintext, is encrypted using an encryption algorithm – a cipher – generating ciphertext that can be read only if decrypted. */
//Integrity Pledge: I pledge that I have completed the programming assignment independently.
//I have not copied the code from a student or any source. Bereket Kelbore

public class CryptoManager {
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;
	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */

	public static boolean stringInBounds (String plainText) {
		// throw new RuntimeException("method not implemented");
		boolean boundary = true;
		for (int index = 0; index < plainText.length(); index++)
		{
			if (!(plainText.charAt(index) >= LOWER_BOUND && plainText.charAt(index) <= UPPER_BOUND))
				boundary = false;
		}
		return boundary;
	}
	/**
	 * Encrypts a string according to the Caesar Cipher. The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */

	public static String encryptCaesar(String plainText, int key)
	{
		//throw new RuntimeException("method not implemented");
		String encryptedText = "";
		if (stringInBounds(plainText))
		{
			for (int index=0; index<plainText.length(); index++)
			{
				char thisChar = plainText.charAt(index);
				int encryptedCharint = ((int)thisChar+key);
				while (encryptedCharint > UPPER_BOUND)
				{
					encryptedCharint -= RANGE;
				}
				encryptedText += (char)encryptedCharint;
			}
		}
		return encryptedText;
	}
	/**
	 * Encrypts a string according the Bellaso Cipher. Each character in plainText is offset
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */

	public static String encryptBellaso(String plainText, String bellasoStr)
	{
		//throw new RuntimeException("method not implemented");
		String encryptedText = "";
		int bellasoStrLength = bellasoStr.length();
		for (int index = 0; index < plainText.length(); index++)
		{
			char thisChar = plainText.charAt(index);
			int encryptedCharint = ((int)thisChar+(int)bellasoStr.charAt(index%bellasoStrLength));
			while (encryptedCharint > (int)UPPER_BOUND)
			{
				encryptedCharint -= RANGE;
			}
			encryptedText += (char)encryptedCharint;
		}
		return encryptedText;
	}
	/**
	 * Decrypts a string according to the Caesar Cipher. The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */

	public static String decryptCaesar(String encryptedText, int key)
	{
		//throw new RuntimeException("method not implemented");
		String decryptedText = "";
		for (int index =0; index < encryptedText.length(); index++)
		{
			char thisChar = encryptedText.charAt(index);
			int decryptedCharint = ((int)thisChar-key);
			while (decryptedCharint < LOWER_BOUND)
			{
				decryptedCharint += RANGE;
			}
			decryptedText += (char)decryptedCharint;
		}
		return decryptedText;
	}
	/**
	 * Decrypts a string according the Bellaso Cipher. Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText. This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */

	public static String decryptBellaso(String encryptedText, String bellasoStr)
	{
		// throw new RuntimeException("method not implemented");
		String decryptedText = "";
		int bellasoStrLength = bellasoStr.length();
		for (int index = 0; index < encryptedText.length(); index ++)
		{
			char thisChar = encryptedText.charAt(index);
			int decryptedCharint = ((int)thisChar-(int)bellasoStr.charAt(index%bellasoStrLength));
			while (decryptedCharint < (int)LOWER_BOUND)
			{
				decryptedCharint += RANGE;
			}
			decryptedText += (char)decryptedCharint;
		}
		return decryptedText;
	}
}