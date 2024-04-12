
public class Polymorph extends SpellCard implements TargetsUnit {

	// constructor
	public Polymorph() {
		super("Polymorph", 4, "Target unit turns into a 1/1 sheep");

	}

	@Override
	public void targetUnit(UnitCard unit) {
		unit.setName("Sheep");
		unit.setAtk(1);
		unit.setHp(1);
		unit.setMaxHp(1);
	}

}
