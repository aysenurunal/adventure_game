import java.awt.*;
import java.util.Locale;
import java.util.Random;
public abstract class Battle extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public Battle(Player player, String name,Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation(){
        int obsNumber= this.randomObstacleNumber();
        System.out.println("You are in "+ this.getName());
        System.out.println("Be Careful! " + obsNumber+ " many "+this.getObstacle().getName()+ " live here!");
        System.out.println("Press  R-run or B-battle!");
        String selectCase= input.nextLine().toUpperCase();
        if (selectCase.equals("B")&& combat(obsNumber)){
            System.out.println(this.getName() + " killed all obstacles!!!");
            return true;

        }
        if (this.getPlayer().getHealth()<=0){
            System.out.println("You are dead");
            return false;
        }
        return true;
    }
    public int randomObstacleNumber(){
        Random r= new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }

    public boolean combat(int obsNumber){
        for (int i=0;i<obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrjHealth());
            playerStarts();
            obstacleStarts(i);
            while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                System.out.println("Press R-run or H-hit");
                String selectCombat=input.nextLine().toUpperCase();
                if(selectCombat.equals("H")){
                    System.out.println("You hit");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println("The obstacle hit you");
                        int obstacleDamage = this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage<0){
                            obstacleDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();
                    }

                }else{
                    return false;
                }
            }
            if(this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("You killed the enemy");
                System.out.println(this.getObstacle().getAward() +" is given to you.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Your current money: " + this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
            System.out.println("Your Health: "+ this.getPlayer().getHealth());
            System.out.println(this.getObstacle().getName() +"'s Health: "+this.getObstacle().getHealth());
            System.out.println();
        }

    public void playerStarts(){
        System.out.println("Player's values:");
        System.out.println("Health: "+ this.getPlayer().getHealth());
        System.out.println("Weapon: "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor: "+ this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Damage: "+ this.getPlayer().getTotalDamage());
        System.out.println("Dodge: "+ this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money: "+ this.getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStarts(int i){
        System.out.println((i+1) + ". " +this.getObstacle().getName()+" 's value: ");
        System.out.println("Name: " +this.getObstacle().getName());
        System.out.println("Health: "+ this.getObstacle().getHealth());
        System.out.println("Damage: "+ this.getObstacle().getDamage());
        System.out.println("Award: "+ this.getObstacle().getAward());
        System.out.println();
    }



    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
