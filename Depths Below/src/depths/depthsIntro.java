package depths;
//this class just focuses on the player as he enters the depths
public class DepthsIntro {
	public static void Enter(Player player){
		System.out.println("You begin your walk towards the entrance to the Depths.\nYour eyes begin to tear up as you approach the cavern knowing you may not see the light of day again.\nOnce you reach the entrance, you look back, knowing this is it, and you begin to descend the stairs.");
		GameMechanics.staggerText("....", 2000);
		System.out.println("After a long while you reach the bottom of the stairs.\nYou sigh a sigh of relef as you don't see an enemy in sight yet.");
		GameMechanics.pause(3000);
		RoomChoice.ChooseAction(player);
		
	}

}
