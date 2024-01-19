/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;

/**
 *
 * @author HELLO
 */
import Common.Library;
import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;
import view.Validation;

public class FruitDAO {

    private int id = 0;
    private ArrayList<Fruit> fruitList = new ArrayList<>();
    private Library common = new Library();
    private ArrayList<Fruit> orderList = new ArrayList<>();
    private Validation validation = new Validation();
    private Hashtable<String, ArrayList<Fruit>> orderLists = new Hashtable<>();

    public void createFruit() {
        while (true) {
            id++;
            String name = common.getString("Enter name of fruit");
            int quantity = common.getInt("Enter quantity of fruit", 1, 999);
            String origin = common.getString("Enter origin of the fruit");
            double price = common.getDouble("Enter price", 0, Integer.MAX_VALUE);
            Fruit fruit = new Fruit(id, name, price, quantity, origin);
            fruitList.add(fruit);
            if (!validation.checkInputYN("Do you want to continue (Y/N)")) {
                return;
            }
        }
    }

    public void buyFruit() {
        ArrayList<Fruit> tempOrderList = new ArrayList<>();
        String customerName = common.getString("Enter customer name");
        while (true) {
            printList();
            int order = common.getInt("Enter item", 0, fruitList.size());
            for (Fruit fruit : fruitList) {
                if (order == fruit.getFruitId()) {
                    System.out.println("You selected: " + fruit.getFruitName());
                    int quantity = common.getInt("Enter quantity", 0, fruit.getFruitQuantity());
                    fruit.setFruitQuantity(fruit.getFruitQuantity() - quantity);
                    Fruit tempFruit = new Fruit(fruit.getFruitId(), fruit.getFruitName(), fruit.getFruitPrice(), quantity, fruit.getFruitOrigin());
                    tempOrderList.add(tempFruit);
                    orderList.add(tempFruit);
                    if (!orderLists.containsKey(customerName)) {
                        orderLists.put(customerName, new ArrayList<>());
                    }
                    orderLists.get(customerName).add(tempFruit);
                    if (validation.checkInputYN("Do you want to order now(Y/N)")) {
                        System.out.println("Product | Quantity | Price | Ammount");
                        for (Fruit orderFruit : tempOrderList) {
                            System.out.println(orderFruit.getFruitName() + "  " + orderFruit.getFruitQuantity() + "  " + orderFruit.getFruitPrice() + "  " + orderFruit.getFruitPrice() * quantity);
                        }
                        return;
                    }
                }
            }
        }
    }

    public void viewOrderList() {
        System.out.println("Order Lists:");
        for (String customerName : orderLists.keySet()) {
            System.out.println("Customer: " + customerName);
            ArrayList<Fruit> customerOrderList = orderLists.get(customerName);
            for (Fruit fruit : customerOrderList) {
                System.out.println(fruit.getFruitName() + " - Quantity: " + fruit.getFruitQuantity() + ", Price: " + fruit.getFruitPrice());
            }
            System.out.println("------------------------------------");
        }
    }

    public void printList() {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (Fruit fruit : fruitList) {
            System.out.print("      ");
            System.out.format("%-15s%-18s%-13s%-10s%n", fruit.getFruitId(), fruit.getFruitName(), fruit.getFruitOrigin(), fruit.getFruitPrice());
        }
    }
}
