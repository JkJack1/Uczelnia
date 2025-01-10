public class Main {
    public static void main(String[] args){
        // Tworzymy obiekt Account z przykładowymi danymi
        Account account = new Account("Jan G", 9000, "999-323-323-444");

        try
        {
            // Próba wykonania przelewu większego niż dostępne środki
            System.out.println("Balance before: " + account.balance);
            System.out.println("Attempting transfer of 1500...");
            account.transfer(1500);
        }
        catch (NotEnoughMoneyException e)
        {
            // Obsługa własnego wyjątku
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e)
        {
            // Obsługa innych wyjątków
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
        finally
        {
            // Wyświetlanie aktualnego stanu konta
            System.out.println("Final account balance: " + account.getBalance());
        }

    }

}
