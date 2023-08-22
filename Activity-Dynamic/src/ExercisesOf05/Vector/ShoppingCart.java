package ExercisesOf05.Vector;

import java.util.Vector;

/**
 * Carro de la compras
 */
public class ShoppingCart {
    private Vector<CartItem> cartItems = new Vector<>();

    public void addItem(CartItem item) {
        cartItems.add(item);
    }

    public Vector<CartItem> getCartItems() {
        return cartItems;
    }
}

