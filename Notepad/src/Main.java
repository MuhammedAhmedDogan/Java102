import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File notepad = new File("notepad.txt");
        if (!notepad.exists()) {
            notepad.createNewFile();
        }

        reader();

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\n1- Notepad içeriğine ekleme yap\n2- Notepad içeriğini sıfırdan yaz");
            String select = scan.nextLine();
            if (select.equalsIgnoreCase("1")) {
                System.out.println("Bir metin girin : ");
                String text = scan.nextLine();
                appendWriter(text);
                break;
            } else if (select.equalsIgnoreCase("2")) {
                System.out.println("Bir metin girin : ");
                String text = scan.nextLine();
                overWriter(text);
                break;
            } else {
                System.out.println("Hatalı giriş yaptınız.");
            }
        }
        scan.close();
    }

    public static void reader() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("notepad.txt"));

        System.out.println("----------- Notepad İçeriği -----------");
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void overWriter(String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("notepad.txt", false));
        writer.write(text);
        writer.newLine();
        System.out.println("Girilen metin notepad içerisine kaydedildi.");
        writer.close();
    }

    public static void appendWriter(String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("notepad.txt", true));
        writer.write(text);
        writer.newLine();
        System.out.println("Girilen metin notepad içerisine kaydedildi.");
        writer.close();
    }

}