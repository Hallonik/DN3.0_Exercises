import java.util.ArrayList;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

  
     // Getters and setters
     public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Inventory {
    private ArrayList<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        printInventory();
    }

    public void updateProduct(int productId, String productName, int quantity, double price) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                product.setProductName(productName);
                product.setQuantity(quantity);
                product.setPrice(price);
                break;
            }
        }
        printInventory();
    }

    public void deleteProduct(int productId) {
        products.removeIf(product -> product.getProductId() == productId);
        printInventory();
    }

    public void printInventory() {
        System.out.println("Current Inventory:");
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId() +
                               ", Name: " + product.getProductName() +
                               ", Quantity: " + product.getQuantity() +
                               ", Price: " + product.getPrice());
        }
        System.out.println();
    }
}

public class IMS {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding products to the inventory
        inventory.addProduct(new Product(1, "Product A", 10, 25.0));
        inventory.addProduct(new Product(2, "Product B", 20, 30.0));

        // Updating a product in the inventory
        inventory.updateProduct(1, "Product A Updated", 15, 30.0);

        // Deleting a product from the inventory
        inventory.deleteProduct(2);
    }
}