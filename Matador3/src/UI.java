import java.util.Scanner;

public class UI {

    private int maxPlayers = 6;

    public void createAccounts(){
        String input = "";
        System.out.println("Skriv navnet på spillets deltagere");
        System.out.println("tast Q for at quitte");

        while(!input.toUpperCase().equals("Q") && Main.players.size() < maxPlayers)
        {
            input = getUserInput("Skriv navnet på spiller nr "+(Main.players.size()+1));
            if (input.toUpperCase().equals("Q"))
            {
                break;
            }
            Main.players.add(new Player(input));
        }
        System.out.println("Tak, spillets deltagere er registreret.");
    }

    public static String getUserInput(String msg){
        System.out.println(msg);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }
}
