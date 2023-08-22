package Stack2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

        private JTextField expressionField;
        private JLabel resultLabel;
        private JButton evaluateButton;

        public View() {
            setTitle("Expresión Matemática");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 150);

            expressionField = new JTextField();
            resultLabel = new JLabel("Resultado:");
            evaluateButton = new JButton("Evaluar");

            setLayout(new GridLayout(3, 1));
            add(expressionField);
            add(evaluateButton);
            add(resultLabel);

            setVisible(true);
        }

        public void addEvaluateListener(ActionListener listener) {
            evaluateButton.addActionListener(listener);
        }

        public String getExpression() {
            return expressionField.getText();
        }

        public void setResult(double result) {
            resultLabel.setText("Resultado: " + result);
        }


    }

