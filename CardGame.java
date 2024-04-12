public class CardGame {

	private static Player user;
	private static Player ai;

	// to keep track of resources ?
	private static int turnCount = 0;

	private static void initialize() {
		user = new Player(30);
		ai = new Player(30);

		// shuffle
		user.getDeck().shuffle();
		ai.getDeck().shuffle();

		// starting hand
		user.drawCards(4);
		ai.drawCards(4);

	}

	/**
	 * Method checks to see if a player is still alive
	 * 
	 * @param player
	 * @return boolean
	 */
	public boolean checkHealth(Player player) {
		int playerHP = player.getLifePoints();
		if (playerHP > 0) {
			return true;
		} else {
			return false;
		}
	}

	private static void userTakeTurn() {
		user.setMana(turnCount);

	}

	private static void aiTakeTurn() {
		ai.setMana(turnCount);
	}

	// Default: user plays first
	private static void round() {
		turnCount++;

	}

	/**
	 * THis method name can change. It's just a placeholder.
	 */
	public static void battleLogic() {

		user.getCard(0).printCardStats();
		user.getCard(1).printCardStats();
		user.getCard(2).printCardStats();
		user.getCard(3).printCardStats();

		// while both players are alive, the game keeps going.
		while (user.getLifePoints() > 0 && ai.getLifePoints() > 0) {
			round();
		}

	}

	public static void main(String[] args) {
		initialize();
		battleLogic();

	}

}
