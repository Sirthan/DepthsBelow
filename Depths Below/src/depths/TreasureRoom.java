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
				System.out.println("Inside the chest you find a glass bottled filled with a white liquid... \nShould you drink it?");
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
					System.out.println("A few moments later you feel... diffrent? \nYou can't place your finger on it but it feels as if you've changed slightly.");
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
			} else if(treasure.equalsIgnoreCase("STR Potion")||treasure.equalsIgnoreCase("MAG Potion")||treasure.equalsIgnoreCase("LUC Potion")||treasure.equalsIgnoreCase("ACC Potion")||treasure.equalsIgnoreCase("DEF Potion")||treasure.equalsIgnoreCase("SPE Potion")||treasure.equalsIgnoreCase("MAXHP Potion")||treasure.equalsIgnoreCase("MAXMP Potion")){
				System.out.println("Inside the chest, sitting at the bottom, is a werid shaped bottle labled \"" + treasure + "\"... \nShould you drink it?");
				String input2 = sc5.nextLine();
				if(input2.equalsIgnoreCase("Yes")||input2.equalsIgnoreCase("Ye")||input2.equalsIgnoreCase("Y")){
					GameMechanics.addArray(treasure + " Bottle", player.items);
					System.out.print("You drink the bottle and feel as if you ");
					switch (treasure){
					case "MAG Potion":
						System.out.println("just became a lot smarter!");
						player.mag += 3;
						break;
					case "STR Potion":
						System.out.println("just got a lot stronger!");
						player.str += 3;
						break;
					case "LUC Potion":
						System.out.println("just got a lot luckier!");
						player.luc += 3;
						break;
					case "ACC Potion":
						System.out.println("just became a lot more accurate!");
						player.acc += 3;
						break;
					case "DEF Potion":
						System.out.println("just became a lot more beefy!");
						player.def += 3;
						break;
					case "SPE Potion":
						System.out.println("just got a lot faster!");
						player.spe += 3;
						break;
					case "MAXHP Potion":
						System.out.println("just got a lot more healthy!");
						player.MaxHP += 20;
						player.HP += 20;
						break;
					case "MAXMP Potion":
						System.out.println("just got a lot more mentally endurant!");
						player.MaxMP += 20;
						player.MP += 20;
						break;
					}
					RoomChoice.ChooseAction(player);	
				} else {
					System.out.println("Deciding to avoid oddly shaped potions with mysterious tags, you leave the potion in the chest and continue on..");
					RoomChoice.ChooseAction(player);
				}
			}else if(treasure.equalsIgnoreCase("Lifesteal Glyph")||treasure.equalsIgnoreCase("Moneydrain Glyph")||treasure.equalsIgnoreCase("Manasteal Glyph")||treasure.equalsIgnoreCase("Shieldgenerate Glyph")||treasure.equalsIgnoreCase("EXPsteal glyph")){
				System.out.print("Inside the chest you find an odd glowing fragment of a stone, with a picture of a ");
				switch(treasure){
				case "Lifesteal Glyph":
					System.out.println("bloodied Staff of Asclepius etched into it.\nTake the fragment with you?");
					break;
				case "Moneydrain Glyph":
					System.out.println("diamond surrounding a circle etched into it.\nTake the fragment with you?");
					break;
				case "Manasteal Glyph":
					System.out.println("blue flame being stolen by another carved into it. \nTake the fragment with you?");
					break;
				case "Shieldgenerate Glyph":
					System.out.println("barrier protecting an older man from an onslaught of attacks carved into it.\nTake the fragment with you?");
					break;
				case "EXPsteal Glyph":
					System.out.println("light green orb being stolen by another carved into it. \nTake the fragment with you?");
					break;
				}
				String input3 = sc5.nextLine();
				if(input3.equalsIgnoreCase("Yes")||input3.equalsIgnoreCase("Ye")||input3.equalsIgnoreCase("Y")){
					GameMechanics.addArray(treasure, player.items);
					System.out.println("As you pick up the stone, a strange feeling radiates throughout your body.");
					if(player.GlyphNum > 0) System.out.println("The other fragments in your possession seem to glow even brighter!");
					player.GlyphNum++;
					RoomChoice.ChooseAction(player);
				} else {
					System.out.println("Deciding that you won't pick up possibly cursed stones, you return to the quest at hand without a second thought to the stone.");
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
		int randomNum = (int)  (Math.random() * 16 + 1);
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
		case 4:
			if(GameMechanics.checkArray("STR Potion Bottle", player.items)){
				
			} else {
			return "STR Potion";
			}
		case 5:
			if(GameMechanics.checkArray("MAG Potion Bottle", player.items)){
				
			} else {
			return "MAG Potion";
			}
		case 6:
			if(GameMechanics.checkArray("LUC Potion Bottle", player.items)){
				
			} else {
			return "LUC Potion";
			}
		case 7:
			if(GameMechanics.checkArray("ACC Potion Bottle", player.items)){
				
			} else {
			return "ACC Potion";
			}
		case 8:
			if(GameMechanics.checkArray("DEF Potion Bottle", player.items)){
				
			} else {
			return "DEF Potion";
			}
		case 9:
			if(GameMechanics.checkArray("SPE Potion Bottle", player.items)){
				
			} else {
			return "SPE Potion";
			}
		case 10:
			if(GameMechanics.checkArray("MAXHP Potion Bottle", player.items)){
				
			} else {
			return "MAXHP Potion";
			}
		case 11:
			if(GameMechanics.checkArray("MAXMP Potion Bottle", player.items)){
				
			} else {
			return "MAXMP Potion";
			}
		case 12:
			if(GameMechanics.checkArray("Lifesteal Glyph", player.items)){
				
			} else {
			return "Lifesteal Glyph";
			}
		case 13:
			if(GameMechanics.checkArray("Moneydrain Glyph", player.items)){
					
			} else {
			return "Moneydrain Glyph";
			}
		case 14:
			if(GameMechanics.checkArray("Manasteal Glyph", player.items)){
					
			} else {
			return "Manasteal Glyph";
			}
		case 15:
			if(GameMechanics.checkArray("Shieldgenerate Glyph", player.items)){
					
			} else {
			return "Shieldgenerate Glyph";
			}
		case 16:
			if(GameMechanics.checkArray("EXPsteal Glyph", player.items)){
					
			} else {
			return "EXPsteal Glyph";
			}
			
		default:
			return "";
		}
	}
}
