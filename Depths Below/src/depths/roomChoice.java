package depths;

import java.util.Scanner;

//This class functions as a "passage" between screens, it will focus on randomizing the next room and giving the illusion of choice :P
public class RoomChoice {
	public static void ChooseAction(Player player) {
		boolean key = true;
		while (key) {
			key = false;
			System.out.println("You look around for any exits.\nLike a labyrinth or a maze, there are doors leading in all directions. \nWhat one will you go through?\n>North\n>South\n>East\n>West");
			Scanner sc1 = new Scanner(System.in);
			String choice = sc1.nextLine();
			if (choice.equalsIgnoreCase("east")|| choice.equalsIgnoreCase("west")|| choice.equalsIgnoreCase("north")|| choice.equalsIgnoreCase("south")|| choice.equalsIgnoreCase("n")|| choice.equalsIgnoreCase("s")|| choice.equalsIgnoreCase("e")||choice.equalsIgnoreCase("w")) {
				//Long list above is for checking if the input North, South, east or west
				System.out.println("Slowly, you begin trudging to the next room, worried about what fate awaits you there.");
				GameMechanics.pause(2000);
				RandomRoom(player);
			} else {
				System.out.println("That wasn't a valid choice, please choose a valid choice...");
				key = true;
			}
		}
	}
	public static void RandomRoom(Player player){
		player.roomsCleared++;
		//if(player.roomsCleared > (3 * player.floorsCleared)){
			//This takes the player to the boss room
		//}
		int randomNumber = (int) (Math.random() * 6 + 1);
		if(randomNumber < 5){
			//This takes the player to a combat room
			CombatRoom combatroom = new CombatRoom();
			combatroom.entrance(player);
		} else if(randomNumber == 6){
			//This takes the player to a special room, Items or trap...
			int randomnumber2 = (int) (Math.random() * 2 + 1);
			if(randomnumber2 == 1)TreasureRoom.enter(player);
			else if (randomnumber2 == 2)TrappedTreasureRoom.enter(player);
		} else if(randomNumber == 7){
			//This takes the player to a shop or blank room
		} else {
			CombatRoom combatroom = new CombatRoom();
			combatroom.entrance(player);
		}
}
}
