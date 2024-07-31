package Design_Patterns_And_Principles.ProxyPatternExample;

interface Image {
    void display();
}

 class RealImage implements Image {
    private String imagePath;

    public RealImage(String imagePath) {
        this.imagePath = imagePath;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        // Simulate loading image from a remote server
        System.out.println("Loading image from server: " + imagePath);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + imagePath);
    }
}
 class ProxyImage implements Image {
    private RealImage realImage;
    private String imagePath;

    public ProxyImage(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(imagePath);
        }
        realImage.display();
    }
}

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image is loaded and displayed from the remote server
        image1.display();
        System.out.println();

        // Image is already loaded, so it's displayed directly from cache
        image1.display();
        System.out.println();

        // Another image is loaded and displayed from the remote server
        image2.display();
    }
}


