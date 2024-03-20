import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Kullanıcıdan veri almak için Scanner sınıfından input nesnesi üretildi.
        Scanner input = new Scanner(System.in);

        // Kullanıcıdan metin istendi.
        System.out.println("Bir metin giriniz : ");
        String text = input.nextLine();

        // Girilen metin kelimelerine ayrılıp bir array içerisine atıldı.
        String[] words = text.split(" ");

        // Kelimeleri içerisine atmak için boş bir hashMap tanımlandı.
        HashMap<String, Integer> wordsMap = new HashMap<>();

        // Kelimeler Key olarak hashMap içerisine atıldı. Value eğer kelime daha önce varsa 1 artırıldı. Yoksa 1 olarak eklendi.
        for (String word : words) {
            word = word.toLowerCase();
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        int maxCount = 0;
        String mostRepeatedWord = "";

        // HashMap'in key setini gezen döngü.
        for (String word : wordsMap.keySet()) {
            int count = wordsMap.get(word);

            // Key değerine karşılık gelen value değerlerinden en büyük olanı maxCount değişkenine, key değeri mostRepeatedWord değerine atıldı.
            if (count > maxCount) {
                maxCount = count;
                mostRepeatedWord = word;
            }
        }

        // Çıktı
        System.out.println("\nMetin içerisinde çok tekrar eden kelime : " + "'" + mostRepeatedWord + "'" + " " + maxCount + " kere tekrarlandı.");

    }
}