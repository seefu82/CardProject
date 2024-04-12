
public class PotOfGreed extends SpellCard {
	// constructor
	public PotOfGreed() {
		super("Pot of Greed", 3, "Draw 2 additional cards from your deck");

	}

	public void draw(Deck deck) {
		deck.drawCards(2);
	}

}
