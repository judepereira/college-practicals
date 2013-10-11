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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: Jude Pereira
 * Date: 10/11/13
 * Time: 11:03 AM
 */
public class Cards extends JFrame {
    private CardLayout cl = new CardLayout();
    private JButton prevButton = new JButton("Previous");
    private JButton nextButton = new JButton("Next");
    private Panel contentPanel = new Panel(cl);

    public Cards() {
        setSize(400, 200);
        setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
        add(prevButton, BorderLayout.WEST);
        add(nextButton, BorderLayout.EAST);
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cl.previous(contentPanel);
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cl.next(contentPanel);
            }
        });
        Panel firstCard = new Panel();
        firstCard.add(new Label("Hello world!"));
        firstCard.add(new Label("This is the first card"));
        contentPanel.add(firstCard);
        Panel secondCard = new Panel();
        secondCard.add(new Label("This is the second card"));
        secondCard.add(new Label("Poke!"));
        contentPanel.add(secondCard);
        // show the first one by default
        //cl.first(contentPanel);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Cards();
    }
}
