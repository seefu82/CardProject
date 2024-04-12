import java.util.ArrayList;

public class Player {
	// instance variables
	private int lifePoints; // player's life points
	private int mana; // player's resources
	private Deck deck;
	private ArrayList<Card> hand; // player's card hand
	private ArrayList<UnitCard> inPlay;

	// constructor
	protected Player() {
		this.lifePoints = 30;
		this.deck = new Deck();
		loadDeck();
		hand = new ArrayList<>();
	}

	// constructor with only the life points as an argument. This is the one we use.
	protected Player(int lifePoints) {
		this.lifePoints = lifePoints;
		this.mana = 0;
		this.deck = new Deck();
		loadDeck();
		hand = new ArrayList<>();
		inPlay = new ArrayList<>();
	}

	// setter
	protected void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	protected void setMana(int mana) {
		this.mana = mana;
	}

	// getters
	protected int getLifePoints() {
		return lifePoints;
	}

	protected int getMana() {
		return mana;
	}

	protected Deck getDeck() {
		return deck;
	}

	// gets a card from hand at index
	protected Card getCard(int index) {
		return hand.get(index);
	}

	protected void playerTakeDamage(int damage) {
		this.lifePoints -= damage;
	}

	protected void playerGainLife(int lifeGain) {
		this.lifePoints += lifeGain;
	}

	// Just a start, a few creatures
	// The values on the generic unit cards, can be changed to load from a csv file
	// (comma separated values file)
	private void createUnitCards() {
		// This player's deck calls the add method, to add new objects.
		// In the parentheses (" Name " , Cost , Attack Power, Health points )
		deck.add(new UnitCard("Fodder Goblin", 1, 2, 1));
		deck.add(new UnitCard("Fodder Goblin", 1, 2, 1));
		deck.add(new UnitCard("Fodder Goblin", 1, 2, 1));

		deck.add(new UnitCard("RiverCroc", 2, 2, 3));
		deck.add(new UnitCard("RiverCroc", 2, 2, 3));
		deck.add(new UnitCard("RiverCroc", 2, 2, 3));

		deck.add(new UnitCard("Bloodfen Raptor", 2, 3, 2));
		deck.add(new UnitCard("Bloodfen Raptor", 2, 3, 2));
		deck.add(new UnitCard("Bloodfen Raptor", 2, 3, 2));

		deck.add(new UnitCard("Kodiak Bear", 3, 4, 3));
		deck.add(new UnitCard("Kodiak Bear", 3, 4, 3));
		deck.add(new UnitCard("Kodiak Bear", 3, 4, 3));

		deck.add(new UnitCard("Chillwind Yeti", 4, 4, 5));
		deck.add(new UnitCard("Chillwind Yeti", 4, 4, 5));
		deck.add(new UnitCard("Chillwind Yeti", 4, 4, 5));

		deck.add(new UnitCard("Boulderfist Ogre", 6, 6, 7));
		deck.add(new UnitCard("Boulderfist Ogre", 6, 6, 7));
		deck.add(new UnitCard("Boulderfist Ogre", 6, 6, 7));

	}

	// Build the spell card objects.
	private void createSpellCards() {
		// just straight up creates the specific spell
		deck.add(new FrostBolt());
		deck.add(new FrostBolt());
		deck.add(new FrostBolt());

		deck.add(new PotOfGreed());
		deck.add(new PotOfGreed());
		deck.add(new PotOfGreed());

		deck.add(new FireBall());
		deck.add(new FireBall());
		deck.add(new FireBall());

		deck.add(new Polymorph());
		deck.add(new Polymorph());
		deck.add(new Polymorph());

	}

	protected void drawCards(int numCards) {
		for (int i = 0; i < numCards; i++) {
			// draw a card
			Card drawnCard = deck.drawCard();
			// add it to the player's hand
			hand.add(drawnCard);
		}
	}

	// This is more to make the code look clean. Separate the unit card creation,
	// and the spell creation.
	private void loadDeck() {
		createUnitCards();
		createSpellCards();
	}

	protected void beginTurnUnitReset() {

		// readies all units already in play
		for (UnitCard unit : inPlay) {
			unit.setCanAttack(true);

			// if the unit is frozen, un-freeze it. It cannot attack this turn
			if (unit.getFrozen()) {
				unit.setFrozen(false);
				unit.setCanAttack(false);
			}
		}

	}

}
