package depths;
 //This class will be all static and contain basic functions that will be used all over the game
public class GameMechanics {
	public static void staggerText(String text, int ammount){//This method will just stagger text over a pause. Good for doing something like .(pause).(pause).(pause)
		for(int i = 0; i < text.length(); i++){
			try{
				Thread.sleep(ammount);
			} catch (InterruptedException e){
				
			}
			System.out.print(text.substring(i,(i+1)));
			
		}
	}
	
	public static void pause (int ammount){ //Just so I don't have to do a long try{}catch{} for each pause I want to make
		try{
			Thread.sleep(ammount);
		} catch(InterruptedException e){
			
		}
	}
	
	public static boolean checkArray(String text, String[] arrayToCheck){
		for(int i = 0; i < arrayToCheck.length; i++){
			if(arrayToCheck[i].equalsIgnoreCase(text)){
				return true;
			}
		}
		return false;
	}
	
	  public static void levelupText(){
		  System.out.println(" _                _   _   _ ___ ");
		  System.out.println("| |   _____ _____| | | | | | _ \\");
		  System.out.println("| |__/ -_\\ V / -_| | | |_| |  _/");
		  System.out.println("|____\\___|\\_/\\___|_|  \\___/|_|  ");
	  }
}
