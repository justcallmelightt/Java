class Character {
    String name;
    int hp;
    int attack;
    int defense;

    Character(String name, int hp, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    boolean isAlive() {
        return hp > 0;
    }

    void takeDamage(int damage) {
        int actual = damage - defense;
        if (actual < 1) actual = 1;
        hp -= actual;
        if (hp <= 0) {
            hp = 0;
            System.out.println(name + "이(가) 쓰러졌습니다.");
        }
    }

    void attackTarget(Character target) {
        int dmg = this.attack - target.defense;
        if (dmg < 1) dmg = 1;
        System.out.println(name + "의 공격! " + target.name + "에게 " + dmg + " 데미지");
        target.takeDamage(this.attack);
    }

    String getStatus() {
        return name + " | HP: " + hp + " | 공격력: " + attack + " | 방어력: " + defense;
    }
}

public class Q20 {
    public static void main(String[] args) {
        Character warrior = new Character("전사", 100, 30, 10);
        Character mage    = new Character("마법사", 70, 45, 5);

        System.out.println(warrior.getStatus());
        System.out.println(mage.getStatus());
        System.out.println();

        while (warrior.isAlive() && mage.isAlive()) {
            warrior.attackTarget(mage);
            if (!mage.isAlive()) break;
            mage.attackTarget(warrior);
        }

        System.out.println("-- 전투 종료 --");
        System.out.println(warrior.getStatus());
        System.out.println(mage.getStatus());
    }
}
