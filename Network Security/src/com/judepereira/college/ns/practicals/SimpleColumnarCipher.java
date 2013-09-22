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

import java.util.Scanner;

import static java.lang.System.out;

public class SimpleColumnarCipher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out.print("Enter the plain text: ");
        final String plainText = sc.nextLine();
        out.println();
        final int cols = 4;
        // calculate the number of rows required
        final int rows = (int) Math.ceil((float) plainText.length() / cols);
        char[][] matrix = getMatrixForString(rows, cols, plainText);
        final int[] key = readColumnOrder(cols);
        out.println();
        out.println();
        // let's encrypt it
        String cipherText = "";
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cipherText += matrix[j][key[i] - 1];
            }
        }
        out.println("Cipher text: " + cipherText);
    }

    private static char[][] getMatrixForString(int rows, int cols, String text) {
        char[][] matrix = new char[rows][cols];
        int x = 0;
        out.println("Here comes the generated rectangle: \n");
        // init the matrix
        for (int i = 0; i < rows; i++) {
            out.print("| ");
            for (int j = 0; j < cols; j++, x++) {
                try {
                    matrix[i][j] = text.charAt(x);
                } catch (IndexOutOfBoundsException ex) {
                    matrix[i][j] = ' ';
                }
                out.print(matrix[i][j] + " | ");
            }
            out.println();
        }
        out.println();
        return matrix;
    }

    private static int[] readColumnOrder(int n) {
        int[] key = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            out.print("Enter a column number: ");
            key[i] = Integer.parseInt(sc.next());
        }
        return key;
    }
}
