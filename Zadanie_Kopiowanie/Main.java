import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Path to txt
        String wejsciePlik = "plik_wejsciowy.txt";
        String wyjsciePlik = "plik_docelowy.txt";

        // Przygotowanie pliku wejściowego z przykładową zawartością
        try (BufferedWriter przygotowanie = new BufferedWriter(new FileWriter(wejsciePlik))) {
            przygotowanie.write("Hello Vistula Hello Vistula Hello Vistula Hello Vistula Hello Vistula Hello Vistula Jan Gołaszewski");
        } catch (IOException e) {
            System.out.println("Błąd podczas przygotowywania pliku: " + e.getMessage());
            return;
        }

        // Kopiowanie zawartości pliku z zamianą spacji na myślniki
        try (
                BufferedReader czytnik = new BufferedReader(new FileReader(wejsciePlik));
                BufferedWriter pisarz = new BufferedWriter(new FileWriter(wyjsciePlik))
        ) {
            String linia;
            while ((linia = czytnik.readLine()) != null) {
                // Zamiana spacji na myślniki
                String zmodyfikowanaLinia = linia.replace(" ", "-");
                pisarz.write(zmodyfikowanaLinia);
                pisarz.newLine(); // Dodanie nowej linii w pliku docelowym
            }
            System.out.println("Kopiowanie zakończone pomyślnie!");
        } catch (IOException e) {
            System.out.println("Błąd podczas kopiowania pliku: " + e.getMessage());
        }
    }
}
