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

package com.judepereira.practicals.aj;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * User: Jude Pereira
 * Date: 10/11/13
 * Time: 10:21 AM
 */
@WebServlet(name = "CalculatorServlet", urlPatterns = "/servlets/calc")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line = br.readLine();
        // logic: the string we read from the above is as follows:
        // n1=23&n2=123&op=*
        // The idea is to split it with the delimiter as &, then iterate
        // over all the parts. Each part will now be key=value
        // Then match key to n1, n2, or op, and accordingly set the corresponding variable
        String[] parts = line.split("&");
        double n1 = 0, n2 = 0, result = 0;
        // let the default operation be +
        char op = '+';
        for (String part : parts) {
            String key = part.split("=")[0];
            String value = part.split("=")[1];
            if (key.equals("n1")) n1 = Double.parseDouble(value);
            else if (key.equals("n2")) n2 = Double.parseDouble(value);
            else // the operator is url encoded, eg: + = %2B
                if (key.equals("op")) op = java.net.URLDecoder.decode(value,
                        "UTF-8").charAt(0);
        }
        switch (op) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                result = n1 / n2;
                break;
            case '%':
                result = n1 % n2;
                break;
        }
        ServletOutputStream outputStream = response.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("Result: " + result);
        bw.flush();
    }
}