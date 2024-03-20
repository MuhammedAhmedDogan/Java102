import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> teams = new LinkedList<>();            // Takım listesi
        LinkedList<List<String>> matchList = new LinkedList<>();  // Eşleşme listesi
        LinkedList<List<String>> fixture = new LinkedList<>();    // Fikstur listesi ( Eşleşme listesinin fikstür olarak sıralanmış hali )
        int numberOfTeams;                                        // Takım sayısı ( tek sayı ise +1 )

        // Takımlar takım listesine eklendi
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");
        teams.add("Boluspor");    // Takım sayısı tek olma durumunu kontrol etmek için kodu aç.

        // Takım sayısı tek sayı ise takımlara BAY eklendi.
        if (teams.size() % 2 != 0) {
            teams.add("BAY");
        }

        // Takım sayısı bir sabite atıldı.
        numberOfTeams = teams.size();

        // Fikstür listesini oluşturan döngüler.
        while (fixture.size() < (numberOfTeams * (numberOfTeams - 1))) {
            // Eşleşme listesi oluşturmak için geçici bir takımlar listesi oluşturuldu.
            LinkedList<String> tempTeams = new LinkedList<>(teams);

            // Eşleşme listesine eşleşmeler eklendi.
            while (tempTeams.size() > 1) {
                for (int i = 1; i < tempTeams.size(); i++) {
                    ArrayList<String> match = new ArrayList<>();
                    match.add(tempTeams.getFirst());
                    match.add(tempTeams.get(i));
                    matchList.add(match);
                    matchList.add(match.reversed());
                }
                tempTeams.removeFirst();
            }

            // Random sınıfından random nesnesi üretildi.
            Random random = new Random();

            long loopStartTime = System.currentTimeMillis();    // Döngü süresini kontrol etmek için başlangıç anı kaydı alındı.
            long maxTime = 10;                                  // Max döngü süresi belirlendi

            // Match listteki eşleşmeleri rastgele sırayla fixture listesine ekleyen döngü
            while (!matchList.isEmpty()) {
                // Eklenecek random eşleşme içerisindeki takımların round içerisinde başka maçı olduğunu kontrol etmek için kontrol listesi oluşturuldu.
                LinkedList<List<String>> controlList = new LinkedList<>();

                // Random sınıfından random nesnesi oluşturuldu.
                int r = random.nextInt(matchList.size());

                // Random bir matchList eşleşmesi fixture listesine ve kontrol listesine eklendi. Eklenen eleman matchList'ten silindi.
                fixture.add(matchList.get(r));
                controlList.add(matchList.get(r));
                matchList.remove(r);

                // Round içerisinde aynı takımın tekrar maçı olmaması için kontrol eden döngüler.
                for (int i = 0; i < ((numberOfTeams / 2) - 1); i++) {
                    boolean isTeamHasMatch = false;
                    r = random.nextInt(matchList.size());

                    // controlList ile girilen random eşleşmeyi kontrol eden döngü.
                    for (List<String> control : controlList) {
                        if ((control.contains(matchList.get(r).getFirst()) || control.contains(matchList.get(r).getLast()))) {
                            isTeamHasMatch = true;
                        }
                    }

                    if (isTeamHasMatch) {
                        i--;
                    } else {    // Kontrolleri yapılan random bir matchList eşleşmesi fixture listesine ve kontrol listesine eklendi. Eklenen eleman matchList'ten silindi.
                        fixture.add(matchList.get(r));
                        controlList.add(matchList.get(r));
                        matchList.remove(r);
                    }

                    // Döngü istenen sürenin dışına çıkarsa döngüleri kıran şart.
                    if (System.currentTimeMillis() - loopStartTime >= maxTime) {
                        matchList.clear();
                        fixture.clear();
                        break;
                    }

                }

            }
        }

        // Print fixture
        int round = 1;
        System.out.println("----------------- ROUND " + round++ + " -----------------");
        for (int i = 0; i < fixture.size(); i++) {
            System.out.println(fixture.get(i).getFirst() + " vs " + fixture.get(i).getLast());
            if ((i + 1) % (numberOfTeams / 2) == 0 && i != fixture.size() - 1) {
                System.out.println("----------------- ROUND " + round++ + " -----------------");
            }

        }

    }
}