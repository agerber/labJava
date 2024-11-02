package edu.uchicago.gerber.labjava.lec06.chat_gpt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//generated by chatGPT
public class LatinDictionaryApp extends JFrame {
    private JTable dictionaryTable;
    private DefaultTableModel tableModel;
    private ArrayList<Entry> dictionary;

    // Entry class to hold Latin and English word pairs
    private static class Entry {
        String latinWord;
        String englishWord;

        Entry(String latinWord, String englishWord) {
            this.latinWord = latinWord;
            this.englishWord = englishWord;
            System.out.println(this.getClass());
        }
    }

    public LatinDictionaryApp() {
        dictionary = new ArrayList<>();

        // Set up the frame
        setTitle("Latin Dictionary");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create table model and JTable
        tableModel = new DefaultTableModel(new Object[]{"Latin", "English"}, 0);
        dictionaryTable = new JTable(tableModel);

        // Create add and delete buttons
        JButton addButton = new JButton("Add Entry");
        JButton deleteButton = new JButton("Delete Selected");

        // Create input fields for Latin and English words
        JTextField latinField = new JTextField(10);
        JTextField englishField = new JTextField(10);

        // Panel for input fields and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Latin:"));
        inputPanel.add(latinField);
        inputPanel.add(new JLabel("English:"));
        inputPanel.add(englishField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        // Add input panel and table to the frame
        add(new JScrollPane(dictionaryTable), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String latinWord = latinField.getText().trim();
                String englishWord = englishField.getText().trim();
                if (!latinWord.isEmpty() && !englishWord.isEmpty()) {
                    Entry entry = new Entry(latinWord, englishWord);
                    dictionary.add(entry);
                    tableModel.addRow(new Object[]{latinWord, englishWord});
                    latinField.setText("");
                    englishField.setText("");
                } else {
                    JOptionPane.showMessageDialog(LatinDictionaryApp.this,
                            "Please enter both Latin and English words.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = dictionaryTable.getSelectedRow();
                if (selectedRow != -1) {
                    dictionary.remove(selectedRow);
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(LatinDictionaryApp.this,
                            "Please select a row to delete.",
                            "Delete Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LatinDictionaryApp().setVisible(true);
        });
    }
}
