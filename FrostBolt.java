
public class FrostBolt extends SpellCard implements TargetsPlayer, TargetsUnit {

	public FrostBolt() {
		super("Frost Bolt", 2, "Freeze target. Deal 3 damage to it.");
	}

	@Override
	public void targetUnit(UnitCard unit) {
		unit.setFrozen(true);
		unit.takeDamage(3);

		// beginning of each turn, check each creature's frozen status. if they are
		// frozen (frozen = true), set frozen to false. and set canAttack to false.

	}

	@Override
	public void targetPlayer(Player player) {
		// freeze player
		player.playerTakeDamage(3);
	}

}
