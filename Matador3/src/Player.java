public class Player
{
    private String owner;
    private BankAccount account;
    private static float startBalance = 30000;
    public int id;
    public static int counter;

    public Player(String owner)
    {
        this.owner = owner;
        this.id = ++counter;

        account = new BankAccount(startBalance);
    }

    @Override
    public String toString() {
        return owner+" : " +account.toString() +"\n";
    }

    public BankAccount getAccount()
    {
        return account;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public int getId()
    {
        return id;
    }
}
