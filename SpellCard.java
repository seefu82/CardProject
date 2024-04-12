
abstract class SpellCard extends Card {
	protected String description;

	public SpellCard(String name, int cost, String description) {
		super(name, cost);
		this.description = description;
	}

	public SpellCard() {
		super();
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	protected String getDescription() {
		return description;
	}

	protected void printCardStats() {
		System.out.printf("Card name: %s cost: %d description: %s\n", this.name, this.cost, this.description);
	}

}
