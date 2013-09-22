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

public class DiffieHellman {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out.print("Value for n: ");
        int n = Integer.parseInt(sc.nextLine());
        verifyPrime(n);
        out.print("Value for g: ");
        int g = Integer.parseInt(sc.nextLine());
        verifyPrime(g);
        out.print("Value for x: ");
        int x = Integer.parseInt(sc.nextLine());
        out.print("Value for y: ");
        int y = Integer.parseInt(sc.nextLine());
        int A = (int) (Math.pow(g, x) % n);
        int B = (int) (Math.pow(g, y) % n);
        int K1 = (int) (Math.pow(B, x) % n);
        int K2 = (int) (Math.pow(A, y) % n);
        if (K1 == K2) {
            out.println("The symmetric key is " + K1);
        } else {
            out.println("Something went wrong");
        }
    }

    private static void verifyPrime(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                throw new IllegalArgumentException(x + " is not a prime number");
            }
        }
    }
}
