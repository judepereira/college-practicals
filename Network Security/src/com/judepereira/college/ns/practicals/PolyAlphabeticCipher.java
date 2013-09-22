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

import static java.lang.System.out;

public class PolyAlphabeticCipher {

    public static void main(String[] args) {
        String plainText = "The quick brown fox jumps over the lazy dog";
        String key = "Hello world";
        out.println("The plain text is: " + plainText);
        out.println("The key is: " + key);
        String cipherText = "";
        boolean encoded = false;
        int i = 0;
        while (!encoded) {
            for (int j = 0; j < key.length(); j++, i++) {
                try {
                    cipherText += (char) (plainText.charAt(i) + key.charAt(j));
                } catch (IndexOutOfBoundsException ex) {
                    // this means that the plain text is encoded
                    encoded = true;
                    break;
                }
            }
        }
        out.println("The cipher text is: " + cipherText);
        String decodedText = "";
        boolean decoded = false;
        i = 0;
        while (!decoded) {
            for (int j = 0; j < key.length(); j++, i++) {
                try {
                    decodedText += (char) (cipherText.charAt(i) - key.charAt(j));
                } catch (IndexOutOfBoundsException ex) {
                    // this means that the cipher text is decoded
                    decoded = true;
                    break;
                }
            }
        }
        out.println("The decoded text is: " + decodedText);
    }
}
