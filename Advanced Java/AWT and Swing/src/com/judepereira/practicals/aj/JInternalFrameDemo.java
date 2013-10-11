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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: Jude Pereira
 * Date: 10/11/13
 * Time: 11:01 AM
 */
public class JInternalFrameDemo extends JFrame {

    private JDesktopPane jdpDesktop;
    private static int openFrameCount = 0;

    public JInternalFrameDemo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jdpDesktop = new JDesktopPane();
        createFrame();
        setContentPane(jdpDesktop);
        setJMenuBar(createMenuBar());
        setSize(1280, 720);
        setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Frame");
        JMenuItem menuItem = new JMenuItem("New");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createFrame();
            }
        });
        menu.add(menuItem);
        menuBar.add(menu);
        return menuBar;
    }

    protected void createFrame() {
        MyInternalFrame frame = new MyInternalFrame();
        frame.setVisible(true);
        jdpDesktop.add(frame);
    }

    public static void main(String[] args) {
        new JInternalFrameDemo();
    }

    private class MyInternalFrame extends JInternalFrame {

        private static final int xPosition = 30, yPosition = 30;

        public MyInternalFrame() {
            super("Frame #" + (++openFrameCount), true, true, true, true);
            setSize(300, 150);
            setLocation(xPosition * openFrameCount, yPosition * openFrameCount);
        }
    }
}
