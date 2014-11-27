package depths;

public class CombatRoom extends RoomEntity{

	public void entrance(Player player) {
		CurrentEnemy EnemyToFight = randomEnemy();
		System.out.println("Nervously, you enter the room.\nYou hear an odd " + EnemyToFight.sound + " coming from the center of the room. \nSlowly, you approach to find a " + EnemyToFight.name + "!" );
		Combat.fightMenu(player, EnemyToFight);
		RoomChoice.ChooseAction(player);
		
		
	}
	
	public static CurrentEnemy randomEnemy(){
		int randomNum = (int) (Math.random() * 3 + 1);
		
		switch (randomNum){
		case 1:
			CurrentEnemy currentEnemyGR = new CurrentEnemy(GiantRat.Estr, GiantRat.Emag, GiantRat.Eluc, GiantRat.Edef, GiantRat.Espe, GiantRat.EHP, GiantRat.EMP, GiantRat.Elvl, GiantRat.EXPgiven, GiantRat.Ggiven, GiantRat.name, GiantRat.attacks, GiantRat.sound, GiantRat.genderPronoun, GiantRat.basicAttackMessage, GiantRat.damageAdjective, GiantRat.deathCry);
			return currentEnemyGR;
		case 2:
			CurrentEnemy currentEnemyVB = new CurrentEnemy(VampireBat.Estr, VampireBat.Emag, VampireBat.Eluc, VampireBat.Edef, VampireBat.Espe, VampireBat.EHP, VampireBat.EMP, VampireBat.Elvl, VampireBat.EXPgiven, VampireBat.Ggiven, VampireBat.name, VampireBat.attacks, VampireBat.sound, VampireBat.genderPronoun, VampireBat.basicAttackMessage, VampireBat.damageAdjective, VampireBat.deathCry);
			return currentEnemyVB;
		case 3:
			CurrentEnemy currentEnemySD = new CurrentEnemy(StrayDog.Estr, StrayDog.Emag, StrayDog.Eluc, StrayDog.Edef, StrayDog.Espe, StrayDog.EHP, StrayDog.EMP, StrayDog.Elvl, StrayDog.EXPgiven, StrayDog.Ggiven, StrayDog.name, StrayDog.attacks, StrayDog.sound, StrayDog.genderPronoun, StrayDog.basicAttackMessage, StrayDog.damageAdjective, StrayDog.deathCry);
			return currentEnemySD;
		}
		 //Estr, Emag, Eluc, Edef, Espe, EHP, EMP, Elvl, EXPgiven, Ggiven, Name, attacks, sound, GenderPronoun, and basicAttackMessage are the values needed in the constructor
		return null;
	}
}
