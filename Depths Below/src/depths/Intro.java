//Programmed By Nathaniel Singewald

package depths;
import java.util.Scanner;
//This class focuses on the opening scene
public class Intro {
public static String version= "Early Alpha 1.1.1"; //Just here to make it easier on me to change the version number easier
	public static void main (String[] args){	
		boolean key = true; //This is to allow the user multiple chances to enter input (see if statement at line 22 for examples) 
		while (key){
			key = false;
			System.out.println("  / _ \\___ ___  / /_/ /  ___"); //This (line 10 - Line 15) is ASCII art spelling out Depths Below
			System.out.println(" / // / -_) _ \\/ __/ _ \\(_-<");
			System.out.println("/____/\\__/ .__/\\__/_//_/___/");
			System.out.println("  / _ )_/_// /__ _    __    ");
			System.out.println(" / _  / -_) / _ \\ |/|/ /    ");
			System.out.println("/____/\\__/_/\\___/__,__/     \n");
			System.out.println("Programmed by Nathaniel Singewald, ASCII art by http://patorjk.com/software/taag/.");
			System.out.println("Version "+ version + "\n\n");
			System.out.println("\t\t>New Game");
			System.out.println("\t\t>Version Notes");
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			if(choice.equalsIgnoreCase("New Game")||choice.equalsIgnoreCase("NewGame")||choice.equalsIgnoreCase("NewG")||choice.equalsIgnoreCase("NGame")||choice.equalsIgnoreCase("NG")||choice.equalsIgnoreCase("N")){
				NewGame.NewChar();
			} else if (choice.equalsIgnoreCase("Version Notes")||choice.equalsIgnoreCase("VersionNotes")||choice.equalsIgnoreCase("VN")||choice.equalsIgnoreCase("VNotes")||choice.equalsIgnoreCase("V")){
				System.out.println("   Version " + version);
				System.out.println(">Battle System was added!\n>First enemy - Giant Rat was added!\n>3 of the 5 gifts have features(the other 2 will be added tomorrow)\n>Minor bug Fixes!\n>3 spells have been added\n>Level up feature has been added\n>And Tons, tons more!!");
				key = true; //This returns the user to the start menu
			} else {
				System.out.println("That was not a choice, please reenter.");
				key = true; //This is so I can have the user re-input commands, so the game doesn't randomly crash..
			}
		}
	}
}
