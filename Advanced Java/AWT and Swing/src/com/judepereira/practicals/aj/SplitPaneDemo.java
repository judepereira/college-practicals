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

/**
 * User: Jude Pereira
 * Date: 10/11/13
 * Time: 9:41 PM
 */

import javax.swing.*;
import javax.swing.event.*;

public class SplitPaneDemo extends JFrame {
    private JLabel jl;
    private JList jlst;
    private String[] planets = {"Earth", "Mars", "Jupiter", "Venus", "Saturn",
            "Sun", "Neptune", "Uranus", "Mercury"};

    public SplitPaneDemo() {
        jl = new JLabel("", JLabel.CENTER);
        jlst = new JList(planets);
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jlst, jl);
        add(jsplit);
        jlst.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                int index = jlst.getSelectedIndex();
                if (index != -1) {
                    jl.setIcon(new ImageIcon("/home/jude/Extra/college/Practicals/Advanced Java/" + planets[index] + ".jpeg"));
                } else {
                    jl.setText("Choose a Planet");
                }
            }
        });
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String args[]) {
        new SplitPaneDemo();
    }
}