package depths;
//This class will be all static and focus on functions that deal with magic
public class Magic {
	public static void MentalBlastMessage(Player Player, CurrentEnemy enemy){
		int randomNum = (int)(Math.random() * 3 + 1);
		switch (randomNum){
		case 1:
			System.out.println("Focusing hard on the lessons of the past, you kneel and hold your hand up to your face.\nYou begin to recite the chants of the Mental Blast spell in your mind.");
			GameMechanics.pause(2000);
			System.out.println("Soon, a ball of light begins to form within your hand.\nYou rise to your feet just before the ball fully forms, and you hurl the powerful light at the " + enemy.name + "!!!");
			break;
		case 2:
			System.out.println("You, slowly, begin to compile mystic keywords within your brain.");
			GameMechanics.pause(3000);
			System.out.println("Finally! You begin focusing on the words and their mythical meaning.\nAs you focus, a blue sphere of pure mental energy gathers within your hand. \nOnce finished,You arch your hand back and toss the sphere!!");
			break;
		case 3:
			System.out.println("Pausing for only a moment, you are able to fully remember the Mental Blast chant in a couple of seconds");
			GameMechanics.pause(1000);
			System.out.println("After fully collecting the lyrics of the chant within your head, you begin to sing the words outloud. \nAs you slowly finish the chant, a ball of light collects itself within your hands, and you throw the sphere towards " + enemy.name + "!!");
			break;
		default:
			System.out.println("ERROR - Magic, MentalBlastMessage()");

		}
	}
	
	public static void AugmentStengthMessage(Player Player, CurrentEnemy enemy){
		int randomNum = (int)(Math.random() * 3 + 1);
		switch (randomNum){
		case 1:
			System.out.println("Grinning at the idea of how strong you're going to get, you begin to recite the Augment Strength chant in your head.");
			GameMechanics.pause(2000);
			System.out.println("The " + enemy.name + "watches in horror as you physically seem to grow stronger right before his very eyes!");
			break;
		case 2:
			System.out.println("At an attempt of humor, you enter a stance as if you were going Super Saiyan as you yell out the chant for the Augment Strength spell!");
			GameMechanics.pause(3000);
			System.out.println("After a couple of moments and weird glances from the " + enemy.name + " you complete the spell and laugh as you grow stronger!");
			break;
		case 3:
			System.out.println("Chuckling silently to yourself, you begin to whisper the Augment Strength to yourself.");
			GameMechanics.pause(2000);
			System.out.println("A yellow glowing aura surrounds your body as you complete the hymn, and your eyes widen as you feel yourself gaining immense strength!");
			break;
		default:
			System.out.println("ERROR - Magic, AugmentStrengthMessage()");

		}
	}
	
	public static void MysticBarrierMessage(Player player, CurrentEnemy enemy){
		int randomNum = (int)(Math.random() * 3 + 1);
		switch (randomNum){
		case 1:
			System.out.println("Figuring you need the protection, you begin to hum the tune of the Mystic Barrier spell.");
			GameMechanics.pause(2000);
			System.out.println("As you finish the song, a light blue bubble surrounds you, and you continue the battle, with newfound protection.");
			break;
		case 2:
			System.out.println("Deciding to establish a sort of shield, you begin to sing the chant of the Mystic Barrier spell");
			GameMechanics.pause(2000);
			System.out.println("After the song ceases, you find yourself enclosed within a blue tinted bubble!");
			break;
		case 3:
			System.out.println("Smiling, you clasp your hands together and begin to whisper the Mystic Barrier spell into them.");
			GameMechanics.pause(3000);
			System.out.println("After you finish whispering the song, a blue tinted bubble begins to form around you.");
			break;
		default:
			System.out.println("ERROR - Magic, MysticBarrierMessage()");

		}	
	}
}

