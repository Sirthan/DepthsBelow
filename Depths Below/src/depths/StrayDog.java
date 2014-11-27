package depths;

public class StrayDog extends EnemyEntity{
	
	public static int Estr = 3, Emag = 0, Eluc = 1, Eacc = 1, Edef = 2, Espe = 5, EHP = 25, EMP = 0, EMaxHP = 25, EMaxMP = 0, Elvl = 2, EXPgiven = 15, Ggiven = 17;
	public static String sound = "growling";
	public static String[] attacks = {"basic", "claw"};
	public static String name = "Stray Dog";
	public static String basicAttackMessage = "The Stray hungrily runs towards you, looking as if he was going to bite ";
	public static String genderPronoun = "him";
	public static String damageAdjective = "punctured";
	public static String deathCry = "The stray whimpers as he collapses to the grond, looking at you with dejected puppy dog eyes. ";
	@Override
	public String randomAttack() {
		
		return null;
	}
	@Override
	public int basicAttack(Player player) {
		return 0;
		
		
	}
	
	
}
