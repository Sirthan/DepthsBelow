package depths;
//This class will hold player values and functions that directly interact with these values, like statsheets.
public class Player {
	public String name = ""; // 4 and 5 are set in NewGame.NewChar()
	public int str = 0, mag = 0, luc = 0, acc = 0, def = 0, spe = 0, HP = 0, MP = 0, MaxHP = 0, MaxMP = 0, lvl = 1, EXP = 0, G = 10, roomsCleared = -1, floorsCleared = 1, shield = 0, TNL = 10;
	public String[] items = {"","",""}; //Lines 6, 7, and 8 are all filled in as the game continues on, This holds all the passive Items for the player
	public String activeItem = "";//This holds the name of the player's held Active Item
	public String charm = ""; //This holds the name of the player's passive charm. 
	public String gift = ""; //This is the gift they choose at the start of the game
	public String[] spell = {"","",""}; //Simple Spell array for holding spells, Filled in as game goes on.
	public int AugStr = 0; //This will hold how much strength is augmented by, so it may be reversed at the end of the battle.
	public boolean bugTest = false;
	
	public Player(String name, int str, int mag, int luc, int acc, int def, int spe, int HP, int MP){ //Hooray for massive constructor to set the values of everything. Used in line 29 of NewGame.
		this.name = name;
		this.str = str;
		this.mag = mag;
		this.luc = luc;
		this.acc = acc;
		this.def = def;
		this.spe = spe;
		this.HP = HP;
		this.MP = MP;
		this.MaxHP = HP;
		this.MaxMP = MP;
	}
	
	public void statSheet(){ //A more in-depth statSheet, different than the one used in the Character creation(NewGame)
		System.out.println("   Stats -- " + name + " Level " + lvl );
		System.out.println("----------------------------");
		System.out.println("Strength - " + str + "\tMagic Power - " + mag);
		System.out.println("Luck - " + luc + "    \tAccuaracy - " + acc);
		System.out.println("Defense - " + def + " \tSpeed - " + spe);
		System.out.println("Health - " + MaxHP + "   \tMystic Energy - " + MaxMP);
		System.out.print("Gift - ");
		if(gift == ""){
			System.out.println("You don't have a blessing currently");
		} else {
			System.out.println("You currently have the blessing of " + gift);
		}
		System.out.print("Current items - ");
		for(int i = 0; i < items.length; i++){
			if(items[i].equals("")){
				if(i == 0){
					System.out.println("You currently have no items!");
				} else {
					break;
				}
			} else {
				System.out.println(items[i]);
			}
		}
		System.out.print("Active Item - ");
		if(activeItem == ""){
			System.out.println("You currently do not have an active item!");
		} else {
			System.out.println(activeItem);
		}
		System.out.print("Charm - ");
		if(charm == ""){
			System.out.println("You currently do not have a charm!");
		} else {
			System.out.println(charm);
		}
	}
	
	public void printSpells(){
		for(int i = 0; i < spell.length; i++){
			if(spell[i].equalsIgnoreCase("Mental Blast")){
				System.out.print("Mental Blast (1MP) ");
			} else if(spell[i].equalsIgnoreCase("Augment Strength")){
				System.out.print("Augment Strngth (4MP) ");
			} else if(spell[i].equalsIgnoreCase("Mystic Barrier")){
				System.out.print("Mystic Barrier (6MP) ");
			} else if(spell[i].equals("")){
				if(i == 0){
					System.out.println("You have no knowledge of any spells!");
				}
				break;
			}
			if((i+1) != spell.length){
				System.out.print(",");
			}
		}
	}
	public boolean checkSpell(){
		if(spell[0] == ""){
			return false;
		} else {
			return true;
		}
	}
	public void takeDamage(int damage){
		if(gift.equals("Endurance Mastery")){
			HP -= (int) ((double) damage / 2.0);
		} else {
			HP -= damage;
		}
	}
	
	public void lvlUp(){
		System.out.println("     Stat Growths     ");
		System.out.println("----------------------");
		StatGrowth("Strength");
		StatGrowth("Magic Power");
		StatGrowth("Luck");
		StatGrowth("Accuracy");
		StatGrowth("Defense");
		StatGrowth("Speed");
		StatGrowth("Health");
		StatGrowth("Mystic Energy");
		lvl++;
		EXP %= TNL;
		TNL += ((lvl * 5) - luc);
		HP = MaxHP;
		MP = MaxMP;
	}
	
	public void StatGrowth(String stat){
		int statG = ((int) ((Math.random() * 2 + 1) + ((double) luc / 30.0)));
		if(stat.equals("Strength")){
			System.out.println(stat +" +" + statG);
			str += statG;
		} else if (stat.equals("Magic Power")){
			System.out.println(stat +" +" + statG);
			mag += statG;
		} else if(stat.equals("Luck")){
			System.out.println(stat +" +" + statG);
			luc += statG;
		} else if(stat.equals("Accuracy")){
			System.out.println(stat +" +" + statG);
			acc += statG;
		} else if(stat.equals("Defense")){
			System.out.println(stat +" +" + statG);
			def += statG;
		} else if(stat.equals("Speed")){
			System.out.println(stat +" +" + statG);
			spe += statG;
		} else if(stat.equals("Health")){
			System.out.println(stat +" +" + (statG * 5));
			MaxHP += (statG * 5);
		} else if(stat.equals("Mystic Energy")){
			System.out.println(stat +" +" + (5 * statG));
			MaxMP += (statG * 5);
		}
	}
	
	public void swapStats(){
		String randomstat = randomStat();
		String randomstat2 = randomStat();
		int tmp = statGetter(randomstat);
		statSetter(randomstat , statGetter(randomstat2));
		statSetter(randomstat2 , tmp);
	}
	public String randomStat(){
		int randomNum = (int) (Math.random() * 8 + 1);
		switch(randomNum){
		case 1:
			return "str";
		case 2:
			return "mag";
		case 3:
			return "luc";
		case 4:
			return "acc";
		case 5:
			return "def";
		case 6:
			return "spe";
		case 7:
			return "MaxHP";
		case 8:
			return "MaxMP";
		default:
			return "spe";
		}
		
	}
	public int statGetter(String stat){
		if(stat.equalsIgnoreCase("str"))return str;
		else if(stat.equalsIgnoreCase("mag"))return mag;
		else if(stat.equalsIgnoreCase("luc"))return luc;
		else if(stat.equalsIgnoreCase("acc"))return acc;
		else if(stat.equalsIgnoreCase("def"))return def;
		else if(stat.equalsIgnoreCase("spe"))return spe;
		else if(stat.equalsIgnoreCase("MaxHP"))return (MaxHP / 5);
		else if(stat.equalsIgnoreCase("MaxMP"))return (MaxMP / 5);
		else return spe;
	}
	public void statSetter(String stat, int set){
		if(stat.equalsIgnoreCase("str"))str=set;
		else if(stat.equalsIgnoreCase("mag"))mag=set;
		else if(stat.equalsIgnoreCase("luc"))luc=set;
		else if(stat.equalsIgnoreCase("acc"))acc=set;
		else if(stat.equalsIgnoreCase("def"))def=set;
		else if(stat.equalsIgnoreCase("spe"))spe=set;
		else if(stat.equalsIgnoreCase("MaxHP")) MaxHP = ((set * 5) + 5);
		else if(stat.equalsIgnoreCase("MaxMP"))MaxMP = (set * 5);
	}
}