package depths;

public class depthsIntro {
	public static void Enter(Player player){
		System.out.println("You begin your walk twoards the entrance to the Depths.\nYour eyes begin to tear up as you approach the cavern knowing you may not see the light of day again.\nOnce you reach the entrance, you look back, knowing this is it, and you begin to descend the stairs.");
		staggerText("...", 1000);
		
	}
	public static void staggerText(String text, int ammount){
		for(int i = 0; i < text.length(); i++){
			try{
				Thread.sleep(ammount);
			} catch (InterruptedException e){
				
			}
			System.out.println(text.substring(i,(i+1)));
			
		}
	}
}
