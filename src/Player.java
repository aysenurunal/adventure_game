import java.util.Scanner;

public class Player{
    private int damage;
    private int health;
    private int orjHealth;
    private int money;
    private String charName;
    private String name;
    private Inventory inventory;
    private Scanner input= new Scanner(System.in);


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }

    public void selectChar(){

        GameChar[] charList= {new Samurai(),new Knight(),new Archer()};

        System.out.println("---------------------------------------------------");
        for (GameChar gameChar :charList){
            System.out.println("ID: "+ gameChar.getId() + " Character: "+ gameChar.getName() +" Damage: "+gameChar.getDamage()+" Health: " + gameChar.getHealth()+" Money: " + gameChar.getMoney() );
        }
        System.out.println("---------------------------------------------------");
        System.out.println("please enter a your char: ");
        int selectChar= input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Your Character: "+this.getCharName() + " Damage: "+ this.getDamage() + " Health: "+ this.getHealth()+ " Money: "+ this.getMoney());
    }


    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printPlayerInfo(){
        System.out.println("Your weapon: " + this.getInventory().getWeapon().getName()+
                " Your armor: " + this.getInventory().getArmor().getName()+
                " Your dodge: " + this.getInventory().getArmor().getBlock()+
                " Your damage: "+ this.getTotalDamage()+ " Your health: "+this.getHealth() + " Your money: "+ this.getMoney());
    }



    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }
}
