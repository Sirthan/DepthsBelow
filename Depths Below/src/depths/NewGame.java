package depths;

import java.util.Scanner;
//This class focuses on the character creation process
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
				System.out.println("\"It appears you have chosen your gift.\nI believe you have all you need, " + player.name + ", I hope you are ready for the depths!\nGood luck.\"");
				DepthsIntro.Enter(player);
				
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
				if (tStat > statPoints || tStat < 0){ //To prevent player from going over limit of statPoints.
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
		tHP = 10;
		tMP = 0;
		statPoints = 13;
	}
	
	public static void ChooseGift(Player player){
		System.out.println("\"I see... I think I have a rough representation of you, "  + player.name + ", but I still can't make out who you really are.\nThe next thing you are allowed to have before entering the Depths is a Gift. \nWhat is your Gift? \"");
		boolean tempkey = true;//Again, just used as a return point if the player enters a bad value
		while (tempkey){
			tempkey = false;
			System.out.println(">Mystic Abilities \n>Combat Aptitude  \n>Endurance Mastery \n>Elder's Wisdom \n>Earth Telekinesis");
			 // A real quick run-down on what each of the gifts do -
			 // Combat Aptitude - gives the player more advanced options in combat
			 // Mystic Abilities - gives the player their first couple of spell
			 // Endurance Mastery - Will most likely prevent a percentage of physical damage received
			 // Elder's Wisdom - Unsure at the moment - Maybe give the player a more in-depth look at combat
			 // Earth Telekinesis - Will allow the player to use ranged attacks, these will cost no magic energy and focus on accuracy, luck, and speed stats instead of just strength
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
			}else if(userchoice.equalsIgnoreCase("Test")){
				
			} else {
				System.out.println("That is not a choosable gift, please enter a choosable gift!");
				tempkey=true;
			}
		}
		try{
			Thread.sleep(15000);
		} catch ( InterruptedException e){
			
		}
		
		
	}
	public static void CombatAptitude(Player player){
		System.out.println("As soon as the words leave your mouth, your body begins to feel much stronger. \nYou vision fades to white and you hear a rugged, powerful voice shout out to you. \n\"The Depths will rip you to shreads if you lack natural talent in combat and actual skills.\nLuckily for you, I can give you these abilities\" \nYour vision reverts to normal and you return, feeling as if you were a natural born master of combat!");
		player.gift = "Combat Aptitude";
	}
	public static void MysticAbilities(Player player){
		System.out.println("Before you can even mutter your choice, a daydream intercepts your vision. \n3 figures, each holding paired torches, stand before your sight, but you are only able to make out the outline of them due to the blinding light. \nThe frontmost figure walks towards you and touches your forehead.\nWith her touch, you mind seems to unlock and you discover the secrets of basic magic! \nSoon after she returns to her position, your daydream cuts out and you return to the present - changed.");
		player.spell[0] = "Mental Blast";
		player.spell[1] = "Augment Strength";
		player.spell[2] = "Mystic Barrier";
		player.gift= "Mystic Abilities";
	}
	public static void EnduranceMastery(Player player){
		System.out.println("The words begin to leave your mouth, and soon after you body feels as if it was being crushed. \nYour vision suddenly fades to scene of a titanic man holding up a immense sphere. \nThe titan looks at you with solemn eyes that depict years of hardship.\n\"Mortal who wishes the gift of Endurance, I alone hold the heavens and sky, and I will grant you the gift of great endurance.\nTake this gift, and use it to clear the Depths and purge it of evil!\"\nThe vision fades away and you are left with nothing more than what feels to be great endurance.");
		player.gift = "Endurance Mastery";
	}
	public static void EldersWisdom(Player player){
		System.out.println("Moments after you state your choice, the world around you dissolves and a wise-looking figure steps before you, a spear in one hand and an owl perched in the next. \nThe figure doesn't speak, but rather see looks upon you with all-knowing eyes. \nFor what feels like hours she stares upon you, and you simply stand unmoving. \nAfter a long, long time, she moves towards you, her eyes now showing a sort of respect to you. \nAfter she enters talking range with you she speaks. \nShe tells you of many, many things, and you, like a pupil, sit and listen. \nAfter a long time filled with countless stories, you return to the present, wiser than ever before.");
		player.gift = "Elders Wisdom";
	}
	public static void EarthTelekinesis(Player player){
		System.out.println("Right after you mention your choice, everything around you dissapears, leaving you with only the earth and land for miles. \nJoyful of the new found freedom you begin to roam and live off the land. \nAfter what feels like weeks alone with nothing but the earth, you feel like you have formed a silent bond with it. \nMany months pass and finally, you decide its time to resume your journey to the depths, understanding that you won't be alone, \nbut rather, you will have all of the Earth on your side. \nAfter this epiphany, the world returns to normal and you return to the present, as if no time had passed.");
		player.gift = "Earth Telekinesis";
	}
}
