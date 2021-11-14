import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;
    private int defaultHealth;

    public Player(String name){

        this.name = name;
        this.inventory = new Inventory();
    }
    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("*********");
        for (GameChar gameChar : charList) {

            System.out.println("ID:"+gameChar.getName() +
                    "\tKarakter:" + gameChar.getName() +
                    "\t Hasar:"+gameChar.getName()+
                    "\t Sağlık:" + gameChar.getHealth() +
                    " \t Para: " + gameChar.getMoney());
    }
        System.out.print("Lütfen karakter  giriniz: ");
        String selectChar = input.nextLine();
        switch (selectChar.toLowerCase()){
            case "samurai" :
                initPlayer(new Samurai());
                break;
            case "archer":
                initPlayer(new Archer());
                break;
            case "knight":
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }

    }
        public void initPlayer(GameChar gameChar){
            this.setDamage(gameChar.getDamage());
            this.setHealth(gameChar.getHealth());
            this.setMoney(gameChar.getMoney());
            this.setCharName(gameChar.getName());

    }
    public void printInfo(){
        System.out.println(
                "Para: " + this.getMoney() +
                        "\nSağlık: " + this.getHealth() +
                        "\nSilah: " + this.getInventory().getWeapon().getName() +
                        "\nZırh: " + this.getInventory().getArmor().getName() +
                        "\nHasar: " + this.getTotalDamage() +
                        "\nBlocklama: " + this.getInventory().getArmor().getBlock());

    }

    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage(){
        return damage;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getHealth(){
        return health;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public int getMoney(){
        return money;
    }
    public void setCharName(String charName){
        this.charName = charName;
    }
    public String getCharName(){
        return charName;
    }
    public String getName(){
        return name;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }
    public Armor getArmor(){
        return this.getInventory().getArmor();
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}