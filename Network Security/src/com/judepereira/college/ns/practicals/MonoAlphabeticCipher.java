/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Jude Pereira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.judepereira.college.ns.practicals;

public class MonoAlphabeticCipher {

    public static void main(String[] args) {
        // the same key applies for upper case letters as well
        String key = "qwertyuiopasdfghjklzxcvbnm";
        String plainText = "Hello mono-alphabetic cipher. The quick brown fox jumps over the lazy dog.";
        String encrypted = encrypt(key, plainText);
        String decrypted = decrypt(key, encrypted);

        System.out.println("Key: " + key);
        System.out.println("Text: " + plainText);
        System.out.println();
        System.out.println("CT: " + encrypted);
        System.out.println("PT: " + decrypted);
    }

    private static void checkKey(String key) {
        // check that the key contains 26 letters
        // NOTE: no check is being made that the sequence is unique
        if (key.length() != 26) {
            throw new IllegalArgumentException("The key specified does not contain 26 letters. Got: " + key.length());
        }
    }

    private static String encrypt(String key, String plainText) {
        checkKey(key);
        String result = "";
        // now do the substitution
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            if (Character.isAlphabetic(c)) {
                char tmp = Character.toLowerCase(c);
                // 97 because its index
                int offset = (int) tmp - 97;
                if (Character.isUpperCase(c)) {
                    result += Character.toUpperCase(key.charAt(offset));
                } else {
                    result += key.charAt(offset);
                }
            } else {
                result += c;
            }
        }
        return result;
    }

    private static String decrypt(String key, String cipherText) {
        checkKey(key);
        String result = "";
        // now do the substitution
        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (Character.isAlphabetic(c)) {
                char tmp = Character.toLowerCase(c);
                // 97 because its index
                int offset = 97 + key.indexOf(tmp + "");
                if (Character.isUpperCase(c)) {
                    result += Character.toUpperCase((char) offset);
                } else {
                    result += (char) offset;
                }
            } else {
                result += c;
            }
        }
        return result;
    }
}
