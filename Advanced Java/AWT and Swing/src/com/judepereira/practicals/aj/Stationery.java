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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Stationery extends JFrame {
    private JList jlst;
    private JLabel jl, j2;
    private JScrollPane jsp;
    private String product[] = {"Pen", "Pencil", "Notebook", "Eraser", "File"};
    private String price[] = {"10", "5", "20", "10", "30"};

    public Stationery() {
        setLayout(new FlowLayout());
        jlst = new JList(product);
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jsp = new JScrollPane(jlst);
        jl = new JLabel("Choose a product");
        j2 = new JLabel();
        add(jsp);
        add(jl);
        add(j2);

        jlst.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                int index = jlst.getSelectedIndex();

                if (index != -1) {
                    jl.setText("Current selection: " + product[index]);
                    j2.setText("Price is: " + price[index]);
                } else
                    jl.setText("Choose a Product");

            }
        });

        setSize(200, 200);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Stationery();
    }


}
