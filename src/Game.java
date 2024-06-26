import java.util.Scanner;

public class Game {
    private Scanner input= new Scanner(System.in);

    public void start(){
        System.out.println("Welcome to the adventure game!");
        System.out.println("Please enter your name: ");
        String playerName=input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Dear " + player.getName()+ " welcome to adventure island! ");
        System.out.println("To begin the game, please select a character: ");
        player.selectChar();

        Location location=null;
        while (true){
            player.printPlayerInfo();
            System.out.println("Locations:");
            System.out.println("1-Safe House.There is no enemy here.");
            System.out.println("2-Store. You can buy weapon or armor");
            System.out.println("3-Cave. There might be zombie. The award is food.");
            System.out.println("4-Forest. There might be vampire. The award is firewood.");
            System.out.println("5-River. There might be bear. The award is water.");
            System.out.println("To end the game press 0");
            System.out.println("Select a location you want");
            int selectLoc= input.nextInt();
            switch (selectLoc){
                case 0:
                    location=null;
                    break;
                case 1:
                    location=new SafeHouse(player);
                    break;
                case 2:
                    location=new ToolStore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location= new Forest(player);
                    break;
                case 5:
                    location= new River(player);
                    break;
                default:
                    System.out.println("Please press reasonable area!");
        }
        if (location==null){
            System.out.println("GAME OVER");
            break;
        }
        if (!location.onLocation()){
            System.out.println("Game Over!");
            break;
        }


        }


    }
}
