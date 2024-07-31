package Design_Patterns_And_Principles.DependencyInjectionExample;

import java.util.HashMap;
import java.util.Map;

 interface CustomerRepository {
    String findCustomerById(int id);
}

 class CustomerRepositoryImpl implements CustomerRepository {
    private Map<Integer, String> customerData;

    public CustomerRepositoryImpl() {
        customerData = new HashMap<>();
        customerData.put(1, "John Doe");
        customerData.put(2, "Jane Smith");
        customerData.put(3, "Alice Johnson");
    }

    @Override
    public String findCustomerById(int id) {
        return customerData.get(id);
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerName(int id) {
        return customerRepository.findCustomerById(id);
    }
}

public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // Create a CustomerRepositoryImpl instance
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Create a CustomerService instance with the injected repository
        CustomerService customerService = new CustomerService(customerRepository);

        // Test the service
        int customerId = 2;
        String customerName = customerService.getCustomerName(customerId);
        System.out.println("Customer ID " + customerId + " is " + customerName);
    }
}

