package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller controller = new SimpleController();

    public SimpleGUI(){
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        final JButton printButton = new JButton("Print");
        final JButton showHistoryButton = new JButton("Show history");
        canvas.add(textField, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        final JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(printButton);
        buttonsPanel.add(showHistoryButton);
        canvas.add(buttonsPanel, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setString(textField.getText());
                controller.print();
            }
        });

        showHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                List<String> printedStrings = controller.getPrintedStrings();
                String finalText = "";
                for(String string : printedStrings){
                    finalText += string + "\n";
                }
                textArea.setText(finalText);
            }
        });
    }

    public void display(){
        frame.setVisible(true);
    }

    public static void main(String[] args){
        final SimpleGUI gui = new SimpleGUI();
        gui.display();
    }

}