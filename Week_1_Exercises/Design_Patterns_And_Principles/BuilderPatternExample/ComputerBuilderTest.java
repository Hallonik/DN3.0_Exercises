package Design_Patterns_And_Principles.BuilderPatternExample;

// Product class - Computer
 class Computer {
    private String cpu;
    private int ram;
    private int storage;

    // Private constructor that takes the Builder as a parameter
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    // Builder class for Computer
    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;

        public Builder() {
            // Set default values if needed
        }

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder storage(int storage) {
            this.storage = storage;
            return this;
        }

        // Build method that returns an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }

    // Getters for Computer attributes
    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }
}

// Test class to demonstrate the Builder pattern
public class ComputerBuilderTest {
    public static void main(String[] args) {
        // Creating different configurations of Computer using the Builder pattern
        Computer computer1 = new Computer.Builder()
                .cpu("Intel i7")
                .ram(16)
                .storage(512)
                .build();

        Computer computer2 = new Computer.Builder()
                .cpu("AMD Ryzen 5")
                .ram(8)
                .storage(256)
                .build();

        // Displaying the configurations
        System.out.println("Configuration of Computer 1:");
        System.out.println("CPU: " + computer1.getCpu());
        System.out.println("RAM: " + computer1.getRam() + " GB");
        System.out.println("Storage: " + computer1.getStorage() + " GB");

        System.out.println("\nConfiguration of Computer 2:");
        System.out.println("CPU: " + computer2.getCpu());
        System.out.println("RAM: " + computer2.getRam() + " GB");
        System.out.println("Storage: " + computer2.getStorage() + " GB");
    }
}