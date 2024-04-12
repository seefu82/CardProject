
public class FireBall extends SpellCard implements TargetsPlayer, TargetsUnit {

	// constructor
	public FireBall() {
		super("Fireball", 4, "Deal 6 damage to target.");
	}

	@Override
	public void targetUnit(UnitCard unit) {
		unit.takeDamage(6);
	}

	@Override
	public void targetPlayer(Player player) {
		player.playerTakeDamage(6);
	}

}
