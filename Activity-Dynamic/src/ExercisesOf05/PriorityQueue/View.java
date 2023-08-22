package ExercisesOf05.PriorityQueue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class View extends JFrame {
    private PriorityQueue<Patient> QueuePriority;
    private JTextArea txtAreaPatient;

    public  View() {

        QueuePriority = new PriorityQueue<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel name = new JLabel("Nombre:");
        JTextField txtName = new JTextField();
        JLabel gravity = new JLabel("Gravedad:");
        JTextField txtGravity = new JTextField();
        JButton add = new JButton("Agregar paciente");
        JButton treat = new JButton("Tratar Pacientes");
        txtAreaPatient = new JTextArea();

        add(name);
        add(txtName);
        add(gravity);
        add(txtGravity);
        add(add);
        add(treat);
        add(new JScrollPane(txtAreaPatient));

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                int gravity = Integer.parseInt(txtGravity.getText());

                Patient newPatient = new Patient(name, gravity);
                QueuePriority.add(newPatient);
                txtName.setText("");
                txtGravity.setText("");
                txtAreaPatient.append("Nuevo paciente agregado: " + newPatient.getName() + "\n");

            }
        });
        treat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                treatPatients();
            }
        });
    }

    public void treatPatients() {
        List<Patient> patientsTreated = new ArrayList<>();

        while (!QueuePriority.isEmpty()) {
            Patient currentPatient = QueuePriority.poll();
            patientsTreated.add(0, currentPatient);
        }
        txtAreaPatient.append("Lista de pacientes tratados:\n");
        for (Patient patient : patientsTreated) {
            txtAreaPatient.append("Gravedad: " + patient.getGravity() + " - " + patient.getName() +"\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                View view = new View();
                view.setVisible(true);
                view.treatPatients();
            }
        });
    }
}
