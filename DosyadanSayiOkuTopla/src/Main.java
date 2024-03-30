import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            int result = 0;
            while ((line = reader.readLine()) != null) {
                result += Integer.parseInt(line);
            }
            System.out.println("Dosyadaki sayıların toplamı : " + result);

            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}