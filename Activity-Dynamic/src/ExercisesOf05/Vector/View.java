package ExercisesOf05.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private ShoppingCart shoppingCart = new ShoppingCart();
    private JList<String> cartItemList;
    private JLabel totalLabel;

    public View() {
        setTitle("Shopping Cart");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cartItemList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(cartItemList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton addButton = new JButton("Añadir Producto");
        panel.add(addButton);

        totalLabel = new JLabel("Total: $0000");
        panel.add(totalLabel);

        add(panel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Nombre Del Producto:");
            int price = Integer.parseInt(JOptionPane.showInputDialog("Ingrese El valor del producto:"));

            CartItem item = new CartItem(name, price);
            shoppingCart.addItem(item);

            updateItemListAndTotal();
        });
    }

    private void updateItemListAndTotal() {
        DefaultListModel<String> model = new DefaultListModel<>();
        double total = 0;

        for (CartItem item : shoppingCart.getCartItems()) {
            model.addElement(item.getName() + " - $" + item.getPrice());
            total += item.getPrice();
        }

        cartItemList.setModel(model);
        totalLabel.setText("Total: $" + total);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new View().setVisible(true));
    }
}

