public class Game {
    private Player playerA;
    private Player playerB;
    private Dice attackDice;
    private Dice defendDice;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.attackDice = new Dice(6);
        this.defendDice = new Dice(6);
    }

    public void start() {
        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        while (playerA.isAlive() && playerB.isAlive()) {
            performAttack(attacker, defender);

            if (!defender.isAlive()) {
                System.out.println("Player " + (attacker == playerA ? "A" : "B") + " wins!");
                break;
            }

            // Swap roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }

    private void performAttack(Player attacker, Player defender) {
        int attackRoll = attackDice.roll();
        int defendRoll = defendDice.roll();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defendValue = defender.getStrength() * defendRoll;

        int damage = attackDamage - defendValue;
        if (damage > 0) {
            defender.reduceHealth(damage);
        }

        System.out.println("Attacker: " + (attacker == playerA ? "A" : "B") + " attacks with roll " + attackRoll);
        System.out.println("Defender: " + (defender == playerA ? "A" : "B") + " defends with roll " + defendRoll);
        System.out.println("Damage dealt: " + Math.max(damage, 0));
        System.out.println("Defender's remaining health: " + defender.getHealth());
    }
}
