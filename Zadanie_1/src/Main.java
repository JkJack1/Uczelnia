public class Main {
    public static void main(String[] args) {
        try {
            // Wywołujemy metodę generującą NullPointerException
            TestNullPointer.generateNullPointerException();
        } catch (NullPointerException e) {
            // Obsługujemy wyjątek NullPointerException

            // Komunikat informujący użytkownika o wystąpieniu wyjątku
            System.out.println("Wystąpił wyjątek: NullPointerException!");

            // Wywołanie metody printStackTrace(), która wyświetli ślad stosu
            e.printStackTrace();

            // Wywołanie metody toString() w celu uzyskania informacji o wyjątku
            System.out.println("Szczegóły wyjątku: " + e);
        }
    }
}
