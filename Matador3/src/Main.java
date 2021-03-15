/**
 * Matador
 * En digital version af det klassiske matador spil
 * Anvendt i undervisingen på Dat 1, cphbusiness academy
 *
 * @author Tess Gaston
 * @version 1.0
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    public static ArrayList<Player> players = new ArrayList<Player>();
    public static UI ui = new UI();


    public static void main(String[] args) throws IOException {
        System.out.println("Velkommen til Matador ");
        //Hvis et spil er i gang, vil der blive loadet data fra sidste session, ellers vil brugeren blive bedt om at registrere deltagere
        try{
            readAccountData();
            //todo: show options (continue last game or start a new game)
        }catch(IOException e){
            System.out.println("Ingen data gemt");
            ui.createAccounts();
        }
        //print information om de kontoer der er i spillet
        System.out.println(getPlayerData());
        System.out.println(findPlayer("Oliver"));
        System.out.println(findPlayerID(3));

        //Test af metode til at trække beløb fra den første konto (accounts.get(0)) der blev oprettet i spillet

//        int input=0;
//        try {
//            input = Integer.parseInt(UI.getUserInput("Træk beløb fra "+accounts.get(0).getOwner()+"'s konto"));
//        }catch (InputMismatchException e){
//            System.out.println(e.toString());
//        }
//
//        accounts.get(0).withdrawAmount(input);
        // gem spillets tilstand
        saveGameData();
    }

    /**
     * Denne metode læser sidste sessions spildata fra en tekstfil, hvor hver linie repræsenterer en spillers konto
     * For hver linie i tekstfilen oprettes en konto med liniens saldo og ejernavn
     * @throws IOException
     */

    public static void readAccountData() throws IOException{
        String [] accountLine;
        File file = new File("data.txt");

        Scanner scan = new Scanner(file);
        int count = 0;

        while(scan.hasNextLine())
        {
            String line = scan.nextLine();
            accountLine = line.split(" : ");
            players.add(new Player(accountLine[1]));
            int index = players.size()-1;//minus 1 fordi arrays starter med index 0
            players.get(index).setOwner(accountLine[0]);


            count++;
        }

    }

    /**
     * Denne metode gemmer sessionens tilstand, dvs listen af konti i formen ejernavn:saldo
     */
    public static void saveGameData(){
        String gamedata = "";
        //todo: kald metoden printAccounts() metoden istedet for at gennemløbe igen (Dont Repeat yourself)
        for (Player p: players) {
            gamedata = gamedata + p.getOwner()+":"+p.getAccount().getBalance()+"\n"+"";
        }

        try{
            FileWriter writer = new FileWriter("data.txt");
            writer.write(gamedata);
            writer.close();
        }catch (IOException e){
            System.out.println(e.getCause());
        }
    }

    /**
     * Denne metode printer alle konti ud
     */
    public static String getPlayerData(){
       String s = "";
        for (Player p: players) {
            s += p.toString();
        }
        return s;
    }

    public static Player findPlayer(String navn)
    {
        Player tmpP = new Player("tmp");
        for (int i = 0; i < players.size(); i++)
        {
            if (navn.equals(players.get(i).getOwner()))
            {
                tmpP = players.get(i);
            }
        }
        return tmpP;

    }
    public static Player findPlayerID(int id)
    {
        Player tmpP = new Player("tmp");
        for (int i = 0; i < players.size(); i++)
        {
            if (players.get(i).getId() == id)
            {
                tmpP = players.get(i);
            }
        }
        return tmpP;
    }
}



