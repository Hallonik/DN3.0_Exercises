package Algorithm_DataStructures.Exercise3.Sorting_Customer_Orders;

class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

public class OrderSorting {
    // Bubble Sort to sort orders by totalPrice
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort to sort orders by totalPrice
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 150.50),
            new Order(202, "Bob", 120.75),
            new Order(303, "Charlie", 200.25),
            new Order(404, "David", 180.30),
            new Order(505, "Eve", 100.80)
        };

        System.out.println("Orders before sorting:");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer: " + order.getCustomerName() + ", Total Price: " + order.getTotalPrice());
        }

        // Sorting using Bubble Sort
        bubbleSort(orders);

        System.out.println("\nOrders after Bubble Sort:");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer: " + order.getCustomerName() + ", Total Price: " + order.getTotalPrice());
        }

        Order[] ordersQuickSort = {
            new Order(101, "Alice", 150.50),
            new Order(202, "Bob", 120.75),
            new Order(303, "Charlie", 200.25),
            new Order(404, "David", 180.30),
            new Order(505, "Eve", 100.80)
        };

        // Sorting using Quick Sort
        quickSort(ordersQuickSort, 0, ordersQuickSort.length - 1);

        System.out.println("\nOrders after Quick Sort:");
        for (Order order : ordersQuickSort) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer: " + order.getCustomerName() + ", Total Price: " + order.getTotalPrice());
        }
    }
}
