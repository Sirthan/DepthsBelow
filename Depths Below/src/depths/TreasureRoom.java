package depths;

import java.util.Scanner;

public class TreasureRoom {
	public static void enter(Player player){
		System.out.println("Carefully, you enter the next room, constantly looking out for whatever may come next. \nYou cautiously search the center of the room, only to find a chest.");
		GameMechanics.staggerText("....", 500);
		System.out.println("After scouting out the entire room, it seems safe... but you can never tell with the Depths. \nShould you open the chest?");
		Scanner sc5 = new Scanner(System.in);
		String input = sc5.nextLine();
		if(input.equalsIgnoreCase("Yes")||input.equalsIgnoreCase("Ye")||input.equalsIgnoreCase("Y")){
			System.out.println("Deciding that any danger the chest may contain will be outweighed by the chance of treasure, you greedily open the chest");
			GameMechanics.staggerText("....", 500);
			String treasure = RandomTreasure(player);
			if(treasure.equals("Fancy Cupcake")){
				System.out.println("Inside the chest sits a some sort of pink cupcake... \nShould you bring it with you?");
				String input2 = sc5.nextLine();
				if(input2.equalsIgnoreCase("Yes")||input2.equalsIgnoreCase("Ye")||input2.equalsIgnoreCase("Y")){
					GameMechanics.addArray("Fancy Cupcake", player.items);
					System.out.println("You pick up the cupcake and appraise it carefully... \nDeciding the cupcake isn't too bad, you take it with you.");
					RoomChoice.ChooseAction(player);
				} else {
					System.out.println("Deciding that you don't want to touch a random cupcake that may have been sitting in a chest for possibly years, you leave the cupcake in the chest.");
					RoomChoice.ChooseAction(player);
				}
			} else if(treasure.equals("White Potion")){
				System.out.println("Inside the chest you find a glass bottled filled with a white liquid \nShould you drink it?");
				String input2 = sc5.nextLine();
				if(input2.equalsIgnoreCase("Yes")||input2.equalsIgnoreCase("Ye")||input2.equalsIgnoreCase("Y")){
					GameMechanics.addArray("White Potion Bottle", player.items);
					System.out.println("You lift the bottle from its spot and immediately down it... \nYou lightly gag due to how bitter it is...");
					player.swapStats();
					player.swapStats();
					player.swapStats();
					player.swapStats();
					player.swapStats();
					player.HP = player.MaxHP;
					player.MP = player.MaxMP;
					System.out.println("A few moments later you feel... diffrent? \nYou can't place your finger on it but it feels as if you've changed slightly");
					RoomChoice.ChooseAction(player);
				} else {
					System.out.println("Deciding that drinking a random potion thats been setting in a chest for a long time is pobably not a good idea, you leave the potion in the chest.");
					RoomChoice.ChooseAction(player);
				}
			} else if(treasure.equals("Reflect Stone")){
				System.out.println("You pop open the large chest to find a small rock with a light blue aura. \nTake the rock?");
				String input2 = sc5.nextLine();
				if(input2.equalsIgnoreCase("Yes")||input2.equalsIgnoreCase("Ye")||input2.equalsIgnoreCase("Y")){
					GameMechanics.addArray("Reflect Stone", player.items);
					System.out.println("You lift the rock and decide to take it with you, as it may be helpful in the future!");
					RoomChoice.ChooseAction(player);
				} else {
					System.out.println("Thinking the stone may be cursed or something even worse, you leave it in the chest, and return to the adventure.");
					RoomChoice.ChooseAction(player);
				}
			} else {
				System.out.println("Unfortunantly, the chest appears to be empty, someone must have got to it a long time ago...");
				RoomChoice.ChooseAction(player);
			}
			
		} else {
			System.out.println("\"Treasure is great, but being alive is better\", you silently think to yourself, and you decide to leave the treasure behind.");
			GameMechanics.pause(1000);
			RoomChoice.ChooseAction(player);
		}
	}
	
	public static String RandomTreasure(Player player){
		int randomNum = (int)  (Math.random() * 3 + 1);
		switch (randomNum){
		case 1:
			if(GameMechanics.checkArray("Fancy Cupcake", player.items)||GameMechanics.checkArray("Fancy Cupcake Wrapper", player.items)){
				
			} else {
			return "Fancy Cupcake";
			}
		case 2:
			if(GameMechanics.checkArray("White Potion Bottle", player.items)){
				
			} else {
			return "White Potion";
			}
		case 3:
			if(GameMechanics.checkArray("Reflect Stone", player.items)){
				
			} else {
			return "Reflect Stone";
			}
		default:
			return "";
		}
	}
}
