package HashSet15;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.*;

public class View extends JFrame {
    private static JTextArea textArea;
    private JButton button;
    private static JTextField field;

    public View() {
        setTitle("Generador");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel,BoxLayout.Y_AXIS));

        inputPanel.add(new JLabel("Ingresa los elementos separados por Comas:"));
        field = new JTextField(20);
        inputPanel.add(field);
        button = new JButton("Generar");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePowerSet();
            }
        });
        inputPanel.add(button);

        add(inputPanel, BorderLayout.SOUTH);
    }

    private  void generatePowerSet() {
        String input = field.getText();
        String[] elements = input.split(",");
        Set<Integer> inputSet = new HashSet<>();

        for (String element : elements) {
            inputSet.add(Integer.parseInt(element.trim()));
        }

        Set<Set<Integer>> powerSet = Power.generatePowerSet(inputSet);

        textArea.setText("Power Set:\n");
        for (Set<Integer> subset : powerSet) {
            textArea.append(subset.toString() + "\n");
        }
    }
}
