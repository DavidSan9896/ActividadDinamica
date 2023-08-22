package Stack2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class Presenter {
    private final View view;

    public Presenter(View view) {
        this.view = view;
        this.view.addEvaluateListener(new EvaluateListener());
    }

    private class EvaluateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String expression = view.getExpression();
            double result = Evaluator.evaluateExpression(expression);
            view.setResult(result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view = new View();
                new Presenter(view);
            }
        });
    }
}

