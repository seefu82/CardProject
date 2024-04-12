/**
 * All the actual cards will inherit from this class. Basic blueprint. All cards
 * have a name and a cost.
 */
abstract class Card {

	protected String name;
	protected int cost;

	// default constructor
	protected Card() {
		this.cost = -1;
		this.name = "default name";
	}

	// overloaded constructor
	protected Card(String name, int cost) {
		this.name = name;
		this.cost = cost;

	}

	// setters
	protected void setName(String name) {
		this.name = name;
	}

	protected void setCost(int cost) {
		this.cost = cost;
	}

	// getters
	protected String getName() {
		return name;
	}

	protected int getCost() {
		return cost;
	}

	protected abstract void printCardStats();

}
