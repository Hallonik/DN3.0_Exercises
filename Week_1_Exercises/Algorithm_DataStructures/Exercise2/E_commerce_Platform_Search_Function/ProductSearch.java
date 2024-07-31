package Algorithm_DataStructures.E_commerce_Platform_Search_Function;

import java.util.Arrays;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }
}

public class ProductSearch {
    private Product[] products;
    private Product[] sortedProducts;

    public ProductSearch(Product[] products) {
        this.products = products;
        this.sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, (a, b) -> Integer.compare(a.getProductId(), b.getProductId()));
    }

    // Linear Search
    public Product linearSearch(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public Product binarySearch(int productId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midProductId = sortedProducts[mid].getProductId();

            if (midProductId == productId) {
                return sortedProducts[mid];
            } else if (midProductId < productId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Product A", "Category A"),
            new Product(202, "Product B", "Category B"),
            new Product(303, "Product C", "Category A"),
            new Product(404, "Product D", "Category C"),
            new Product(505, "Product E", "Category B")
        };

        ProductSearch productSearch = new ProductSearch(products);

        // Perform linear search
        Product foundProductLinear = productSearch.linearSearch(303);
        if (foundProductLinear != null) {
            System.out.println("Linear Search Result: " + foundProductLinear.getProductName());
        } else {
            System.out.println("Product not found (Linear Search)");
        }

        // Perform binary search
        Product foundProductBinary = productSearch.binarySearch(303);
        if (foundProductBinary != null) {
            System.out.println("Binary Search Result: " + foundProductBinary.getProductName());
        } else {
            System.out.println("Product not found (Binary Search)");
        }
    }
}


