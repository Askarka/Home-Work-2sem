package HomeWork.general;

public class Player {
    private int hp;
    private String name;
    private String battleCry;
    public Player(String name) {
        this(name,
                "Lerooooy Jenkinsss");
    }
    public Player(String name, String battleCry) {
        hp = 100;
        this.name = name;
        this.battleCry = battleCry;
    }
    public void shoutBattleCry() {
        System.out.println(name + ": " + battleCry);
    }
}
