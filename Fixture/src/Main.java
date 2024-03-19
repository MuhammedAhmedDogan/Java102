import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> teams = new LinkedList<>();            // Takım listesi
        LinkedList<List<String>> matchList = new LinkedList<>();  // Eşleşme listesi
        int numberOfTeams;                                        // Takım sayısı ( tek sayı ise +1 )

        // Takımlar takım listesine eklendi
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");
        //teams.add("Boluspor");    // Takım sayısı tek olma durumunu kontrol etmek için kodu aç.

        // Takım sayısı tek sayı ise takımlara BAY eklendi.
        if (teams.size() % 2 != 0) {
            teams.add("BAY");
        }

        // Takım sayısı bir sabite atıldı.
        numberOfTeams = teams.size();

        // Eşleşme listesine eşleşmeler eklendi.
        while (teams.size() > 1) {
            for (int i = 1; i < teams.size(); i++) {
                ArrayList<String> match = new ArrayList<>();
                match.add(teams.getFirst());
                match.add(teams.get(i));
                matchList.add(match);
                matchList.add(match.reversed());
            }
            teams.removeFirst();
        }

        // Random sınıfından random nesnesi üretildi.
        Random random = new Random();

        int round = 1;
        while (!matchList.isEmpty()) {
            LinkedList<List<String>> controlList = new LinkedList<>();
            int r = random.nextInt(matchList.size());

            System.out.println("---------- ROUND" + " " + round++ + " ---------");
            System.out.println(matchList.get(r).getFirst() + " vs " + matchList.get(r).getLast());
            controlList.add(matchList.get(r));
            matchList.remove(r);

            for (int i = 0; i < ((numberOfTeams / 2) - 1); i++) {
                boolean isTeamHasMatch = false;
                r = random.nextInt(matchList.size());

                for (List<String> control : controlList) {
                    if ((control.contains(matchList.get(r).getFirst()) || control.contains(matchList.get(r).getLast()))) {
                        isTeamHasMatch = true;
                    }
                }

                if (isTeamHasMatch) {
                    i--;
                } else {
                    System.out.println(matchList.get(r).getFirst() + " vs " + matchList.get(r).getLast());
                    controlList.add(matchList.get(r));
                    matchList.remove(r);
                }
            }
        }

    }
}