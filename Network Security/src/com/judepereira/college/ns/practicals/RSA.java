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

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class RSA {
    public static void main(String[] args) {
        try {
            // generate our private/public key pair
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.genKeyPair();
            Key publicKey = kp.getPublic();
            Key privateKey = kp.getPrivate();

            String plainText = "The quick brown fox jumps over the lazy dog!";

            // get the encrypt/decrypt cipher instances
            Cipher eCipher = Cipher.getInstance("RSA");
            Cipher dCipher = Cipher.getInstance("RSA");

            // init the instances
            eCipher.init(Cipher.PUBLIC_KEY, publicKey);
            dCipher.init(Cipher.PRIVATE_KEY, privateKey);

            // encrypt
            byte[] encBytes = eCipher.doFinal(plainText.getBytes("UTF-8"));
            String enc = new String(encBytes, "UTF-8");
            System.out.println("CT: " + enc);

            // decrypt
            byte[] decBytes = dCipher.doFinal(encBytes);
            String dec = new String(decBytes, "UTF-8");
            System.out.println("PT: " + dec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
