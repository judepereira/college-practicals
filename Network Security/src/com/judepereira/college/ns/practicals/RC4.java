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

public class RC4 {

    private static char cipher[];

    public static void main(String[] args) {
        int key[] = {1, 2, 3, 4, 5};
        String strPlainText = "Hello World";
        System.out.println("Original String: " + strPlainText);
        int S[] = new int[255];
        cipher = new char[strPlainText.length()];
        for (int i = 0; i < S.length; i++) {
            S[i] = i;
        }
        int i = 0;
        int j = 0;
        for (int k = 0; k < strPlainText.length(); k++) {
            int modk = (k % key.length);
            int Kc = key[modk];
            j = (S[i] + j + Kc) % 256 + 1;
            int temp = S[i];
            S[i] = S[j];
            S[j] = temp;
            int Sc = (S[i] + S[j]) % 256;
            int Ck = S[Sc];
            cipher[k] = (char) (Ck ^ (int) strPlainText.charAt(k));
            i = i + 1;
        }
        for (int k = 0; k < cipher.length; k++) {
            System.out.print("" + cipher[k]);
        }
    }
}
