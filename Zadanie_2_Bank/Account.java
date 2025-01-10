public class Account
{
    private String owner;  // Właściciel konta
    public int balance;   // Stan konta
    private String accountNumber;  // Numer konta

    // Konstruktor
    public Account(String owner, int balance, String accountNumber)
    {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    // Gettery i settery
    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    // Metoda symulująca przelew
    public void transfer(int amount) throws NotEnoughMoneyException
    {
        if (amount > balance)
        {
            throw new NotEnoughMoneyException("Not enough funds to complete the transfer.");
        }
        balance -= amount;
        System.out.println("Transfer successful. New balance: " + balance);
    }

}
