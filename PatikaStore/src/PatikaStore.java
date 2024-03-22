import java.util.*;

public class PatikaStore {
    private HashMap<Integer, Brand> brands;
    private List<Product> phones;
    private List<Product> notebooks;

    public PatikaStore() {
        this.brands = new HashMap<>();
        this.phones = new ArrayList<>();
        this.notebooks = new ArrayList<>();
        // Marka ekleme
        this.brands.put(1, new Brand("1", "Apple"));
        this.brands.put(2, new Brand("2", "Asus"));
        this.brands.put(3, new Brand("3", "Casper"));
        this.brands.put(4, new Brand("4", "HP"));
        this.brands.put(5, new Brand("5", "Huawei"));
        this.brands.put(6, new Brand("6", "Lenovo"));
        this.brands.put(7, new Brand("7", "Monster"));
        this.brands.put(8, new Brand("8", "Samsung"));
        this.brands.put(9, new Brand("9", "Xiaomi"));
    }

    public void run() {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("--------------- PatikaStore Ürün Yönetim Paneli ----------------");
            System.out.println("1- Notebook işlemleri");
            System.out.println("2- Cep Telefonu işlemleri");
            System.out.println("3- Marka Listele");
            System.out.println("4- Ürün Listele");
            System.out.println("0- Çıkış");
            String menuInput = input.nextLine();

            if (menuInput.equalsIgnoreCase("1")) {
                for (; ; ) {
                    System.out.println("--------------- Notebook Menüsü ---------------");
                    System.out.println("1- Ürün ekle");
                    System.out.println("2- Ürün sil");
                    System.out.println("0- Menüye dön");
                    String notebookInput = input.nextLine();
                    if (notebookInput.equalsIgnoreCase("1")) {
                        this.addNotebook();
                        break;
                    } else if (notebookInput.equalsIgnoreCase("2")) {
                        if (notebooks.isEmpty()) {
                            System.out.println("Notebook listesinde silinecek ürün bulunmuyor");
                            break;
                        } else {
                            this.deleteNotebook();
                            break;
                        }
                    } else if (notebookInput.equalsIgnoreCase("0")) {
                        break;
                    } else {
                        System.out.println("Hatalı giriş yaptınız");
                    }
                }
            } else if (menuInput.equalsIgnoreCase("2")) {
                for (; ; ) {
                    System.out.println("--------------- Cep Telefonları Menüsü ---------------");
                    System.out.println("1- Ürün ekle");
                    System.out.println("2- Ürün sil");
                    System.out.println("0- Menüye dön");
                    String phonesInput = input.nextLine();
                    if (phonesInput.equalsIgnoreCase("1")) {
                        this.addPhone();
                        break;
                    } else if (phonesInput.equalsIgnoreCase("2")) {
                        if (phones.isEmpty()) {
                            System.out.println("Cep telefonları listesinde silinecek ürün bulunmuyor");
                            break;
                        } else {
                            this.deletePhone();
                            break;
                        }
                    } else if (phonesInput.equalsIgnoreCase("0")) {
                        break;
                    } else {
                        System.out.println("Hatalı giriş yaptınız");
                    }
                }
            } else if (menuInput.equalsIgnoreCase("3")) {
                this.printBrands();
            } else if (menuInput.equalsIgnoreCase("4")) {
                this.printProducts();
            } else if (menuInput.equalsIgnoreCase("0")) {
                System.out.println("Çıkış yapıldı");
                break;
            } else {
                System.out.println("Hatalı giriş yaptınız");
            }
        }
    }

    private void addPhone() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.print("Ürünün adı : ");
        String name = input.nextLine();
        System.out.print("Renk : ");
        String color = input.nextLine();
        System.out.print("Marka ID : ");
        int brandId = input.nextInt();
        System.out.print("Fiyatı : ");
        double price = input.nextDouble();
        System.out.print("İndirim oranı : ");
        double discountRate = input.nextDouble();
        System.out.print("Stok adedi : ");
        int stock = input.nextInt();
        System.out.print("Depolama alanı (GB) : ");
        int storage = input.nextInt();
        System.out.print("Ekran Boyutu (inc) : ");
        double inc = input.nextInt();
        System.out.print("Pil gücü (mAh) : ");
        int battery = input.nextInt();
        System.out.print("RAM (GB) : ");
        int ram = input.nextInt();

        phones.add(new Product(price, discountRate, stock, name, brands.get(brandId), storage, inc, battery, ram, color));
        System.out.println("Ürün Eklendi");
    }

    private void deletePhone() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.print("Silinmek istenen ürüne ait ID no : ");
        int id = input.nextInt();
        for (Product product : phones) {
            if (product.getId() == id) {
                System.out.println("Ürün silindi");
                break;
            } else {
                System.out.println("Girilen ID cep telefonları listesinde bulunamadı.");
                break;
            }
        }
        phones.removeIf(product -> product.getId() == id);

    }

    private void addNotebook() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.print("Ürünün adı : ");
        String name = input.nextLine();
        System.out.print("Marka ID : ");
        int brandId = input.nextInt();
        System.out.print("Fiyatı : ");
        double price = input.nextDouble();
        System.out.print("İndirim oranı : ");
        double discountRate = input.nextDouble();
        System.out.print("Stok adedi : ");
        int stock = input.nextInt();
        System.out.print("Depolama alanı (GB) : ");
        int storage = input.nextInt();
        System.out.print("Ekran Boyutu (inc) : ");
        double inc = input.nextInt();
        System.out.print("RAM (GB) : ");
        int ram = input.nextInt();

        notebooks.add(new Product(price, discountRate, stock, name, brands.get(brandId), storage, inc, ram));
        System.out.println("Ürün Eklendi");
    }

    private void deleteNotebook() {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.print("Silinmek istenen ürüne ait ID no : ");
        int id = input.nextInt();
        for (Product product : notebooks) {
            if (product.getId() == id) {
                System.out.println("Ürün silindi");
                break;
            } else {
                System.out.println("Girilen ID notebook listesinde bulunamadı.");
                break;
            }
        }
        notebooks.removeIf(product -> product.getId() == id);
    }

    private void printBrands() {
        System.out.println("| ID | MARKA");
        System.out.println("|-----------");
        for (Integer key : brands.keySet()) {
            System.out.println("| " + brands.get(key).getId() + "  | " + brands.get(key).getName());
        }
    }

    private void printProducts() {
        System.out.println("Notebook Listesi");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı        | Fiyat        | Marka     | Depolama   | Ekran     | RAM      |");
        for (Product product : notebooks) {
            System.out.format("| %-2d | %-15s | %-9.1f TL | %-9s | %-10d | %-9.1f | %-8d |\n", product.getId(), product.getName(), product.getPrice(), product.getBrand().getName(), product.getStorage(), product.getInc(), product.getRam());
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Cep Telefonu Listesi");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı        | Fiyat        | Marka     | Depolama   | Ekran     | RAM      | Pil      | Renk         |");
        for (Product product : phones) {
            System.out.format("| %-2d | %-15s | %-9.1f TL | %-9s | %-10d | %-9.1f | %-8d | %-8d | %-12s |\n", product.getId(), product.getName(), product.getPrice(), product.getBrand().getName(), product.getStorage(), product.getInc(), product.getRam(), product.getBattery(), product.getColor());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
    }

}
