public class ToolStore extends NormalLoc{

    public ToolStore(Player player){
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu= true;
        while (showMenu) {
            System.out.println("Welcome to the store!");
            System.out.println("1-Weapons");
            System.out.println("2-Armors");
            System.out.println("3-Exit");
            int selectCase = Location.input.nextInt();
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    showMenu=false;
                    break;
            }
        }
        return true;
    }
    public void printWeapon(){
        System.out.println("Weapons");
        for (Weapon w: Weapon.weapons()){
            System.out.println(w.getId() + " - " +w.getName()+ ": money: "+ w.getPrice() + " damage: "+ w.getDamage());
        }
        System.out.println("To exit press 0");
    }

    public void buyWeapon(){
        System.out.println("Please select a weapon");
        int selectWeaponID= input.nextInt();

        if(selectWeaponID != 0 ){
            Weapon selectedWeapon = Weapon.getWeaponObjbyId(selectWeaponID);
            if (selectedWeapon != null){

            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Your budget not enough");
            }else{
                //satın almanın gerçekleştiği alan
                System.out.println("You bought " + selectedWeapon.getName() );
                int balance =this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Your new budget: " + this.getPlayer().getMoney());
                System.out.println("Your former weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Your current weapon: " + this.getPlayer().getInventory().getWeapon().getName());

            }
        }
        }
    }


    public void printArmor(){
        System.out.println("Armors: ");
        for(Armor a: Armor.armors()){
            System.out.println(a.getId() + " - "+ a.getName()+" Price: " +a.getPrice()+ " Armor: "+ a.getBlock() );
        }
        System.out.println("To exit press 0");
    }

    public void buyArmor() {
        System.out.println("select an armor");
        int selectArmorID = input.nextInt();

        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjbyId(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Your budget not enough");
                } else {
                    System.out.println("You brought " + selectedArmor.getName());
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                }
            }
        }
    }


}
