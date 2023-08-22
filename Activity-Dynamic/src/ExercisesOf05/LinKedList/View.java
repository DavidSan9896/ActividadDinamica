package ExercisesOf05.LinKedList;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import com.toedter.calendar.JDateChooser;


public class View extends JFrame {
    private TitledBorder title;

    private TaskManager taskManager;
    private JPanel mainPanel;
    private JComboBox<String> userComboBox;
    private JTextArea taskTextArea;
    private JButton addButton;
    private JButton viewButton;
    private JDateChooser datePicker; // Using JDateChooser from JCalendar library

    public View() {
        taskManager = new TaskManager();

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));
        title = BorderFactory.createTitledBorder("Usuarios");
        userComboBox = new JComboBox<>();
        userComboBox.setBorder(title);
        userComboBox.addItem("User1");
        userComboBox.addItem("User2");
        userComboBox.addItem("User3");

        title = BorderFactory.createTitledBorder("Describcion de la tarea");
        taskTextArea = new JTextArea(5, 20);
        taskTextArea.setBorder(title);


        title = BorderFactory.createTitledBorder("Fecha de Vencimiento");
        datePicker = new JDateChooser();
        datePicker.setBorder(title);
        datePicker.setDateFormatString("yyyy-MM-dd");

        addButton = new JButton("Añadir Tarea");
        addButton.addActionListener(e -> {
            String description = taskTextArea.getText();
            Date dueDate = datePicker.getDate();
            String assignedTo = (String) userComboBox.getSelectedItem();
            taskManager.addTask(description, dueDate, assignedTo);
            taskTextArea.setText("");
        });

        viewButton = new JButton("Ver Tareas Añadidas ");
        viewButton.addActionListener(e -> {
            String username = (String) userComboBox.getSelectedItem();
            LinkedList<Task> userTasks = taskManager.getTasksForUser(username);
            StringBuilder tasksText = new StringBuilder();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (Task task : userTasks) {
                tasksText.append("Descripción De tarea: ").append(task.description)
                        .append("\nFecha de Vencimiento: ").append(dateFormat.format(task.dueDate))
                        .append("\nAsignado Por: ").append(task.assignedTo)
                        .append("\n\n");
            }
            JOptionPane.showMessageDialog(null, tasksText.toString(), "Tasks for " + username, JOptionPane.INFORMATION_MESSAGE);
        });

        mainPanel.add(userComboBox);
        mainPanel.add(new JScrollPane(taskTextArea));
        mainPanel.add(datePicker);
        mainPanel.add(addButton);
        mainPanel.add(viewButton);

        add(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new View().setVisible(true));
    }
}
