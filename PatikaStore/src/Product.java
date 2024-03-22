public class Product {
    private static int idCounter = 1;
    private int id;
    private double price;
    private double discountRate;
    private int stock;
    private String name;
    private Brand brand;
    private int storage;
    private double inc;
    private int battery;
    private int ram;
    private String color;

    public Product(double price, double discountRate, int stock, String name, Brand brand, int storage, double inc, int battery, int ram, String color) {
        this.id = idCounter++;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
        this.storage = storage;
        this.inc = inc;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }

    public Product(double price, double discountRate, int stock, String name, Brand brand, int storage, double inc, int ram) {
        this.id = idCounter++;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
        this.storage = storage;
        this.inc = inc;
        this.ram = ram;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getStorage() {
        return storage;
    }

    public double getInc() {
        return inc;
    }

    public int getBattery() {
        return battery;
    }

    public int getRam() {
        return ram;
    }

    public String getColor() {
        return color;
    }
}
