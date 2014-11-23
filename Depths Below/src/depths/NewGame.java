package depths;

import java.util.Scanner;

public class NewGame { 
	public static int statPoints = 13; //Comes into play when the player is choosing stats 
	static public int tstr = 0, tmag = 0, tluc = 0, tacc = 0, tdef = 0, tspe = 0, tHP = 10, tMP = 0; //All different stats that will be used in the game
	public static void NewChar(){
		System.out.println("\"What is the name of the powerful soul who wishes to brave the Depths alone?\"");
		Scanner sc = new Scanner(System.in);
		String Name = sc.nextLine();
		System.out.println("\"" + Name + "? Such an odd name, I cannot tell if this is bravery or foolishness...\"");
		System.out.println("\"So tell me, " + Name + ", what do your stats look like?\"");
		boolean key = true; //To allow the player to re-enter stats if he/she messes up in choosing them.
		while (key){
			key = false;
			tstr = statChoice("strength"); //The string in this method is used as text to let the player in on what stat they are choosing. The method automatically lowers the statPoints.
			tmag = statChoice("magic power");
			tluc = statChoice("luck");
			tacc = statChoice("accuracy");
			tdef = statChoice("defense");
			tspe = statChoice("speed");
			tHP = ((statChoice("Health Points") * 10) + 10); //HP and MP are multiplied by ten, and HP auto starts at 10 so the player doesn't automatically die when they start the game.
			tMP = (statChoice("Mystic Energy") * 10);
			tstatSheet(); //This method just prints out the player's current stats.
			System.out.println("Are you okay with these stats?(Note - You cannot change them later)");
			String statConfermation = sc.nextLine();
			if(statConfermation.equalsIgnoreCase("yes")||statConfermation.equalsIgnoreCase("ye")||statConfermation.equalsIgnoreCase("y")){
				Player player = new Player(Name, tstr, tmag, tluc, tacc, tdef, tspe, tHP, tMP); //This is cementing the stats in the Player class
				player.statSheet();
				ChooseGift(player);
				
			} else {
				Reset(); //this method just resets the game for the process to go through again.
				key = true;
			}
		}
		}
		
	
	public static int statChoice(String str){
		boolean tempKey = true; //Just to loop if bad commands are put in.
		while (tempKey){
			tempKey = false;
			tstatSheet(); //Prints out to screen the user's current stats.
			System.out.println("You currently have " + statPoints + " stat points left to allocate. \nHow many do you want to put into " + str + "?");
			Scanner sc1 = new Scanner(System.in);
			String statallocate = sc1.nextLine();
			try{ //Prevents program from crashing at mistype / bad input.
				int tStat = Integer.parseInt(statallocate);
				if (tStat > statPoints){ //To prevent player from going over limit of statPoints.
					System.out.println("This number exceedes your limit of " + statPoints + ". Please try again.");
					tempKey = true;
				} else { 
					statPoints -= tStat; //lowers statPoints by number entered
					return tStat; //Returns value of stat entered.
				}
			} catch (NumberFormatException nfe){
				System.out.println("That was not a number, please enter a number.");
				tempKey = true;
			}
		}
		return(404); //This should never return unless things have gone horribly wrong
	}
	
	
	public static void tstatSheet(){ //This method just prints out the player's stats this far
		System.out.println("\tStats");
		System.out.println("--------------------------");
		System.out.println("Strength - " + tstr + "\tMagic Power - " + tmag);
		System.out.println("Luck - " + tluc + "    \tAccuaracy - " + tacc);
		System.out.println("Defense - " + tdef + " \tSpeed - " + tspe);
		System.out.println("Health - " + tHP + "   \tMystic Energy - " + tMP);
	}
	
	public static void Reset(){ //Just for reseting all the stats, used if the player accidentally misinputs a stat
		tstr = 0;
		tluc = 0;
		tmag = 0; 
		tacc = 0;
		tdef = 0; 
		tspe = 0;
		tHP = 0;
		tMP = 0;
		statPoints = 13;
	}
	
	public static void ChooseGift(Player player){
		System.out.println("\"I see... I think I have a rough representation of you, "  + player.name + ", but I still can't make out who you really are.\nThe next thing you are allowed to have before entering the Depths is a Gift. \nWhat is your Gift? \"");
		boolean tempkey = true;
		while (tempkey){
			tempkey = false;
			System.out.println(">Mystic Abilities \n>Combat Aptitude  \n>Endurance Mastery \n>Elder's Wisdom \n>Earth Telekinesis");
			Scanner sctemp = new Scanner(System.in);
			String userchoice = sctemp.nextLine();
			if(userchoice.equalsIgnoreCase("CA")||userchoice.equalsIgnoreCase("Combat")||userchoice.equalsIgnoreCase("Aptitude")||userchoice.equalsIgnoreCase("Combat Aptitude")||userchoice.equalsIgnoreCase("C")||userchoice.equalsIgnoreCase("CombatAptitude")){
				CombatAptitude(player);
			} else if(userchoice.equalsIgnoreCase("EM")||userchoice.equalsIgnoreCase("Endurance")||userchoice.equalsIgnoreCase("Mastery")||userchoice.equalsIgnoreCase("Endurance Mastery")||userchoice.equalsIgnoreCase("En")||userchoice.equalsIgnoreCase("EnduranceMastery")){
				EnduranceMastery(player);
			} else if (userchoice.equalsIgnoreCase("MA")||userchoice.equalsIgnoreCase("Mystic")||userchoice.equalsIgnoreCase("Abilities")||userchoice.equalsIgnoreCase("Mystic Abilities")||userchoice.equalsIgnoreCase("M")||userchoice.equalsIgnoreCase("MysticAbilities")){
				MysticAbilities(player);
			} else if(userchoice.equalsIgnoreCase("EW")||userchoice.equalsIgnoreCase("Elder's")||userchoice.equalsIgnoreCase("Wisdom")||userchoice.equalsIgnoreCase("Elder's Wisdom")||userchoice.equalsIgnoreCase("El")||userchoice.equalsIgnoreCase("Elder'sWisdom")||userchoice.equalsIgnoreCase("Elders")||userchoice.equalsIgnoreCase("Elders Wisdom")||userchoice.equalsIgnoreCase("EldersWisdom")){
				EldersWisdom(player);
			} else if(userchoice.equalsIgnoreCase("ET")||userchoice.equalsIgnoreCase("Earth")||userchoice.equalsIgnoreCase("Telekinesis")||userchoice.equalsIgnoreCase("Earth Telekinesis")||userchoice.equalsIgnoreCase("Ea")||userchoice.equalsIgnoreCase("EarthTelekinesis")){
				EarthTelekinesis(player);
			} else {
				System.out.println("That is not a choosable gift, please enter a choosable gift!");
				tempkey=true;
			}
		}
		try{
			Thread.sleep(10000);
		} catch ( InterruptedException e){
			
		}
		
		
		System.out.println("\"It appears you have chosen your gift.\nI believe you have all you need, " + player.name + ", I hope you are ready for the depths!\nGood luck.\"");
		depthsIntro.Enter(player);
		
	}
	public static void CombatAptitude(Player player){
		System.out.println("As soon as the words leave your mouth, your body begins to feel much stronger. \nYou vision fades to white and you hear a rugged, powerful voice shout out to you. \n\"The Depths will rip you to shreads if you lack natural talent in combat and actual skills.\nLuckily for you, I can give you these abilities\" \nYour vision returns to normal and you return, feeling as if you were a natural born master of combat!");
		player.gift = "Combat Aptitude";
	}
	public static void MysticAbilities(Player player){
		System.out.println("Before you can even mutter your choice, a daydream intercepts your vision. \n3 figures, each holding paired torches, stand before your sight, but you are only able to make out the outline of them due to the blinding light. \nThe frontmost figure walks twoards you and touches your forehead.\nWith her touch, you mind seems to unlock and you discover the secrets of basic magic! \nSoon after she returns to her position, your daydream cuts out and you return to the present - changed.");
		player.gift= "Mystic Abilities";
	}
	public static void EnduranceMastery(Player player){
		System.out.println("The words begin to leave your mouth, and soon after you body feels as if it was being crushed. \nYour vision suddenly fades to scene of a titanic man holding up a immense sphere. \nThe titan looks at you with solemn eyes that depict years of hardship.\n\"Mortal who wishes the gift of Endurance, I alone hold the heavens and sky, and I will grant you the gift of great endurance.\n Take this gift, and use it to clear the Depths and purge it of evil!\"\nThe vision fades away and you are left with nothing more than what feels to be great endurance.");
		player.gift = "EnduranceMastery";
	}
	public static void EldersWisdom(Player player){
		System.out.println("");//This is a placeholder
		player.gift = "EldersWisdom";
	}
	public static void EarthTelekinesis(Player player){
		System.out.println("");//This is a placeholer
		player.gift = "EarthTelekinesis";
	}
}
