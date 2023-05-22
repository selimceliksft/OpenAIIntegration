package com.example.demo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextArea inputArea;
    private JTextArea outputArea;

    public GUI() {
        super("chatSCS");
        setLayout(new BorderLayout());

        createInputComponents();
        createOutputComponents();
        createButton();

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void createInputComponents() {
        JLabel inputLabel = new JLabel("Send Message");
        inputArea = new JTextArea(20, 60);
        JScrollPane scrollPane = new JScrollPane(inputArea);

        JPanel inputPanel = new JPanel();
        inputPanel.add(inputLabel);
        inputPanel.add(scrollPane);

        add(inputPanel, BorderLayout.NORTH);
    }

    private void createOutputComponents() {
        JLabel outputLabel = new JLabel("The response");
        outputArea = new JTextArea(20, 60);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel outputPanel = new JPanel();
        outputPanel.add(outputLabel);
        outputPanel.add(scrollPane);

        add(outputPanel, BorderLayout.CENTER);
    }

    private void createButton() {
        JButton calculateButton = new JButton("Generate Response");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateResponse();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void generateResponse() {
        try {
            String input = inputArea.getText();

            OpenAIConnection openAI = new OpenAIConnection();
            String response = openAI.chatGPT(input);

            outputArea.setText(response);
        } catch (Exception ex) {
            outputArea.setText("Error occurred");
        }
    }

    
}
