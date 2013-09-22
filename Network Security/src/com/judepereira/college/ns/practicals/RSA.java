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

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

    private static BigInteger p, q, n, d, e, ph, t;
    private static SecureRandom r;

    private static BigInteger encrypt(BigInteger msg, BigInteger e, BigInteger n) {
        return msg.modPow(e, n);
    }

    private static BigInteger decrypt(BigInteger msg, BigInteger d, BigInteger n) {
        return msg.modPow(d, n);
    }

    public static void main(String[] args) {
        r = new SecureRandom();
        p = new BigInteger(512, 100, r);
        q = new BigInteger(512, 100, r);
        System.out.println("prime nos p and q are " + p.intValue() + " , "
                + q.intValue());
        n = p.multiply(q);
        ph = (p.subtract(new BigInteger("1")));
        ph = ph.multiply(q.subtract(new BigInteger("1")));
        e = new BigInteger("2");
        while (ph.gcd(e).intValue() > 1 || e.compareTo(ph)
                != -1) {
            e = e.add(new BigInteger("1"));//or "2" when bug
            d = e.modInverse(ph);
            System.out.println("public key is (" + n.intValue() + " , "
                    + e.intValue() + ")");
            System.out.println("pvt key is (" + n.intValue() + " , "
                    + d.intValue() + ")");
            BigInteger msg = new BigInteger("15");
            System.out.println("\nMessage is: " + msg);
            BigInteger enmsg = encrypt(msg, e, n);
            System.out.println("\nEncrypted msg is: " + enmsg.intValue());
            BigInteger demsg = decrypt(enmsg, d, n);
            System.out.println("\nDecrypted msg is: " + demsg.intValue());
        }
    }
}
