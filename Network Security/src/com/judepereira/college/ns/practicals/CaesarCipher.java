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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CaesarCipher {

    public static void main(String[] args) {
        int i;
        try {
            File ip = new File("C:\\Documents and Settings\\Administrator\\Desktop\\plain text file.txt");
            File op = new File("C:\\Documents and Settings\\Administrator\\Desktop\\cipher text file.txt");
            FileInputStream fis = new FileInputStream(ip);
            FileOutputStream fos = new FileOutputStream(op);
            while ((i = fis.read()) != -1) {
                fos.write(i + 3);
            }
            System.out.println("File encoded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
