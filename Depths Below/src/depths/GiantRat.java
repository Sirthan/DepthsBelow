package depths;

public class GiantRat extends EnemyEntity{
	
	public static int Estr = 3, Emag = 1, Eluc = 2, Eacc = 2, Edef = 1, Espe = 3, EHP = 20, EMP = 5, EMaxHP = 15, EMaxMP = 5, Elvl = 1, EXPgiven = 10, Ggiven = 10;
	public static String sound = "snarling";
	public static String[] attacks = {"basic", "claw"};
	public static String name = "Giant Rat";
	public static String basicAttackMessage = "The Giant Rat crunches up and jumps forward at you, teeth beared!!";
	public static String genderPronoun = "him";
	public static String damageAdjective = "cut";
	public static String deathCry = "The Giant Rat lets out one final screach of pain, then collapses to the ground.";
	@Override
	public String randomAttack() {
		
		return null;
	}
	@Override
	public int basicAttack(Player player) {
		return 0;
		
		
	}
	
	
}
