import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	ArrayList<Card> deckList;

	// default constructor
	protected Deck() {
		this.deckList = new ArrayList<>();
	}

	/**
	 * Use this method to build the deck
	 * 
	 * @param Card
	 */
	protected void add(Card card) {
		deckList.add(card);
	}

	/**
	 * randomizes the positions of all the cards in the deck
	 */
	protected void shuffle() {
		Collections.shuffle(deckList);
	}

	/**
	 * Returns a Card object removed from the deckList
	 * 
	 * @return Card
	 * @throws IndexOutOfBoundsException
	 */
	protected Card drawCard() throws IndexOutOfBoundsException {
		if (deckList.isEmpty()) {
			throw new IndexOutOfBoundsException("Cannot Draw.  Deck is empty.");
		}
		return deckList.remove(0);
	}

	/**
	 * draws X number of cards, by calling drawCard() X number of times
	 * 
	 * @param number
	 * @return ArrayList<Card>
	 */
	protected ArrayList<Card> drawCards(int number) {
		ArrayList<Card> drawnCards = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			drawnCards.add(drawCard());
		}
		return drawnCards;
	}

}
