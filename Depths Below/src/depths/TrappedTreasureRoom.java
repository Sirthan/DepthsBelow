package depths;

import java.util.Scanner;
public class TrappedTreasureRoom {
	public static void enter(Player player){
		System.out.println("Carefully, you enter the next room, constantly looking out for whatever may come next. \nYou cautiously search the center of the room, only to find a chest.");
		GameMechanics.staggerText("....", 700);
		System.out.println("After scouting out the entire room, it seems safe enough... but you can never tell with the depths. \nShould you open the chest??");
		if(player.gift.equalsIgnoreCase("Elders Wisdom")){
			System.out.println("Something within you is telling you not to open the chest...");
		}
		Scanner sc5 = new Scanner(System.in);
		String input = sc5.nextLine();
		if(input.equalsIgnoreCase("Yes")||input.equalsIgnoreCase("Ye")||input.equalsIgnoreCase("Y")){
			System.out.println("Deciding that any danger the chest may contain will be outweighed by the chance of treasure, you greedily open the chest!");
			GameMechanics.staggerText("......", 500);
			String trap = RandomTrap();
			if(trap.equals("Explosion")){
				System.out.println("Suddenly, the chest exploads before you!!");
				int damage = (int) ((Math.random() * 9 + 1) * player.lvl);
				System.out.println("You're blown backwards and suffer " + damage + " points of damage!!");
				player.HP -= damage;
				if(player.HP <= 0){
					if(GameMechanics.checkArray("Fancy Cupcake", player.items)){
						System.out.println("You fall to the ground, hurt and injured, unsure if you could keep going... ");
						GameMechanics.pause(500);
						System.out.println("But then, you remember the Fancy Cupcake you aquired earlier, and decide to eat it as a last ditch effort!");
						System.out.println("Suddenly, you feel invigorated and inspired to continue the adventure!!");
						player.HP = (player.MaxHP / 4);
						int fancyIndex = GameMechanics.indexArray("Fancy Cupcake", player.items);
						player.items[fancyIndex] = "Fancy Cup cakeWrapper";
						
					} else {
					Combat.DeathMessage(player);
					System.out.println("Game Over...");
					System.out.println("Here are your final stats - ");
					player.statSheet();
					System.out.println("You cleared " + (player.floorsCleared - 1) + " floors and cleared " + player.roomsCleared + " rooms.");
					System.out.println("Lastly, you were defeated by being stupid");
					System.exit(0);
					}
				}
				System.out.println("After you overcome the initial shock of the exploasion, you get up and continue forth on your journy...");
				RoomChoice.ChooseAction(player);
			}
		} else {
			System.out.println("\"Treasure is great, but living is better\", you silently think to yourself, and you decide to leave the treasure behind...");
			GameMechanics.pause(1000);
			RoomChoice.ChooseAction(player);
		}
			
			
		}
	
	public static String RandomTrap(){
		int randomNum = (int) (Math.random() * 1 + 1);
		switch(randomNum){
		case 1:
			return "Explosion";
		default:
			return "Explosion";
		}
	}
}
