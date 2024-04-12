/**
 * Unit cards, are a special type of card. The come into play, and fight until
 * they die.
 */
public class UnitCard extends Card {

	private int atk;
	private int hp;
	private int maxHp;
	private boolean frozen;
	private boolean canAttack;

	protected UnitCard(String name, int cost, int atk, int hp) {
		super(name, cost);
		this.atk = atk;
		this.hp = hp;
		this.frozen = false;
		this.canAttack = false;
	}

	// Setters
	protected void setAtk(int atk) {
		this.atk = atk;
	}

	protected void setHp(int hp) {
		this.hp = hp;
	}

	protected void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	/**
	 * Froze units cannot attack for a turn.
	 * 
	 * @param frozen
	 */
	protected void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}

	/**
	 * 
	 * @param canAttack
	 */
	protected void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}

	// Getters

	protected int getAtk() {
		return atk;
	}

	protected int getHp() {
		return hp;
	}

	protected int getMaxHp() {
		return maxHp;
	}

	protected boolean getFrozen() {
		return frozen;
	}

	protected boolean getCanAttack() {
		return canAttack;
	}

	// methods
	protected void takeDamage(int damage) {
		this.hp -= damage;
	}

	protected void attackUnit(UnitCard unit) {
		unit.takeDamage(atk);
		// can only attack once per turn
		this.canAttack = false;
	}

	protected void attackPlayer(Player player) {
		player.playerTakeDamage(atk);
		// can only attack once per turn
		this.canAttack = false;
	}

	// for testing purporses
	protected void printCardStats() {
		System.out.printf("card name: %s Cost: %d atk:%d hp:%d\n", this.name, this.cost, this.atk, this.hp);
	}

	// to create example
	// UnitCard goblin = new UnitCard("goblin", 2, "a weak creature", 1, 1);

}
