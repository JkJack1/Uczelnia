public class TestNullPointer {
    public static void generateNullPointerException() {
        String str = null;
        // Próba wywołania metody na obiekcie, który jest nullem
        str.length();
    }
}
