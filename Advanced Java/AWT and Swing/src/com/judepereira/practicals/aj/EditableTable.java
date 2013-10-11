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

import javax.swing.*;

public class EditableTable {
    public static void main(String args[]) {
        String[] headings = {"Roll no.", "Name", "Address", "E-mail ID", "Phone no."};
        Object[][] data = new Object[][]{
                {"1", "John", "Mumbai", "john@doe.com", "123456"},
                {"2", "Mike", "Bangalore", "mike@chad.com", "456321"},
                {"5", "Tom", "Mumbai", "tom@alice.com", "341256"},
                {"6", "Alice", "Chennai", "alice@ns.com", "345256"}};
        JFrame f = new JFrame("Student details");
        f.setSize(300, 300);
        JTable table = new JTable(data, headings);
        f.add(new JScrollPane(table));
        f.setVisible(true);
    }
}
