public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player){
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation(){
        System.out.println("You are in safe house");
        System.out.println("Your health is full now.");
        this.getPlayer().setHealth(this.getPlayer().getOrjHealth());
        return true;
    }
}
