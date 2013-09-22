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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModifiedCaesarCipher {

    public static String encrypt(int shift, String line) {
        String result = "";
        int offset;
        for (int i = 0; i < line.length(); i++) {
            offset = ((int) line.charAt(i) + shift) % 256;
            result += (char) (offset);
        }
        return result;
    }

    public static String decrypt(int shift, String line) {
        String result = "";
        int offset;
        for (int i = 0; i < line.length(); i++) {
            offset = ((int) line.charAt(i) - shift) % 256;
            if (offset < 0) {
                offset += 256;
            }
            result += (char) (offset);
        }
        return result;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        System.out.println("Menu:\n1: Encryption\n2: Decryption");
        choice = Integer.parseInt(in.readLine());
        System.out.print("Enter the shift: ");
        int shift = Integer.parseInt(in.readLine());
        System.out.print("Enter the line: ");
        String line = in.readLine();
        System.out.println("Result:");
        switch (choice) {
            case 1:
                System.out.println(encrypt(shift, line));
                break;
            case 2:
                System.out.println(decrypt(shift, line));
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }
}
