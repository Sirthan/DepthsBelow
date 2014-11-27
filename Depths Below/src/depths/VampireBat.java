package depths;

public class VampireBat extends EnemyEntity{
	
	public static int Estr = 2, Emag = 2, Eluc = 3, Eacc = 2, Edef = 0, Espe = 5, EHP = 15, EMP = 10, EMaxHP = 15, EMaxMP = 10, Elvl = 1, EXPgiven = 10, Ggiven = 10;
	public static String sound = "screeching";
	public static String[] attacks = {"basic", "bloodsuck"};
	public static String name = "Vampire Bat";
	public static String basicAttackMessage = "The Vampire Bat swoops down and assults you with his claws.";
	public static String genderPronoun = "him";
	public static String damageAdjective = "punctured";
	public static String deathCry = "The Vampire Bat falls onto the ground, twitching slightly just before he dies. ";
	@Override
	public String randomAttack() {
		
		return null;
	}
	@Override
	public int basicAttack(Player player) {
		return 0;
		
		
	}
	
	
}
