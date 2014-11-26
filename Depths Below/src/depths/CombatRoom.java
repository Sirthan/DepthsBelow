package depths;

public class CombatRoom extends RoomEntity{

	public void entrance(Player player) {
		CurrentEnemy EnemyToFight = randomEnemy();
		System.out.println("Nervously, you enter the room.\nYou hear an odd " + EnemyToFight.sound + " coming from the center of the room. \nSlowly, you approach to find a " + EnemyToFight.name + "!" );
		Combat.fightMenu(player, EnemyToFight);
		RoomChoice.ChooseAction(player);
		
		
	}
	
	public static CurrentEnemy randomEnemy(){
		CurrentEnemy currentEnemy = new CurrentEnemy(GiantRat.Estr, GiantRat.Emag, GiantRat.Eluc, GiantRat.Edef, GiantRat.Espe, GiantRat.EHP, GiantRat.EMP, GiantRat.Elvl, GiantRat.EXPgiven, GiantRat.Ggiven, GiantRat.name, GiantRat.attacks, GiantRat.sound, GiantRat.genderPronoun, GiantRat.basicAttackMessage, GiantRat.damageAdjective, GiantRat.deathCry);
		 //Estr, Emag, Eluc, Edef, Espe, EHP, EMP, Elvl, EXPgiven, Ggiven, Name, attacks, sound, GenderPronoun, and basicAttackMessage are the values needed in the constructor
		
		return currentEnemy;
	}
}
