package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;



/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private Controller controller;

    public SimpleGUIWithFileChooser(){
        controller = new Controller();

        final JPanel canvas = new JPanel();
        final JPanel fileChooserPanel = new JPanel();
        fileChooserPanel.setLayout(new BorderLayout());
        canvas.setLayout(new BorderLayout());
        final JTextField textField = new JTextField(controller.getPath());
        final JButton browseButton = new JButton("Browse...");
        fileChooserPanel.add(textField, BorderLayout.CENTER);
        fileChooserPanel.add(browseButton, BorderLayout.LINE_END);
        canvas.add(fileChooserPanel, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        final JButton saveButton = new JButton("Save");
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(saveButton, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                switch (result) {
                    case JFileChooser.APPROVE_OPTION -> {
                        final File selectedFile = fileChooser.getSelectedFile(); 
                        controller.setFile(selectedFile);
                        textField.setText(selectedFile.getPath());
                    }
                    case JFileChooser.CANCEL_OPTION -> {}
                    default -> JOptionPane.showMessageDialog(frame, "An error has occurred");
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.save(textArea.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } 
        });
    }

    public void display(){
        frame.setVisible(true);
    }

    public static void main(String[] args){
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser();
        gui.display();
    }

}
