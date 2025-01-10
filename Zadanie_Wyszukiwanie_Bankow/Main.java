import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Tworzymy obiekt skanera do odczytu danych od użytkownika
        Scanner scanner = new Scanner(System.in);

        // Pobieramy trzy pierwsze cyfry numeru konta
        System.out.print("Wprowadź trzy pierwsze cyfry numeru konta: ");
        String prefix = scanner.nextLine();

        // Sprawdzamy, czy dane wejściowe są poprawne
        if (!prefix.matches("\\d{3}")) {
            System.out.println("Nieprawidłowe dane. Podaj dokładnie trzy cyfry.");
            scanner.close();
            return;
        }

        // Adres pliku z danymi banków
        String resourceUrl = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

        try {
            // Utwórz URL za pomocą URI
            URL url = URI.create(resourceUrl).toURL();

            // Pobieramy dane z serwera i przetwarzamy je
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Czytamy dane linia po linii
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                // Sprawdzamy, czy linia zaczyna się od podanego prefiksu
                if (line.startsWith(prefix)) {
                    // Rozdzielamy dane na części
                    String[] data = line.split("\\t");

                    if (data.length >= 2) {
                        // Wyświetlamy informacje o banku
                        System.out.println("Kod banku: " + data[0]);
                        System.out.println("Nazwa banku: " + data[1]);
                        found = true;
                        break;
                    }
                }
            }

            // Jeśli nie znaleziono banku
            if (!found) {
                System.out.println("Nie znaleziono banku odpowiadającego podanym cyfrom.");
            }

            // Zamykamy strumień
            reader.close();
        } catch (Exception e) {
            // Obsługujemy błąd w prosty sposób
            System.out.println("Wystąpił błąd: " + e.getMessage());
        } finally {
            // Zamykamy skaner
            scanner.close();
        }
    }
}
