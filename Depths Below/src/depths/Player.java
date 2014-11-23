package depths;

public class Player {
	public String name = null; // 4 and 5 are set in NewGame.NewChar()
	public int str = 0, mag = 0, luc = 0, acc = 0, def = 0, spe = 0, HP = 0, MP = 0, lvl = 1, EXP = 0, G = 10;
	public String[] items = new String[1]; //6, 7, and 8 are all filled in as the game continues on, This holds all the passive Items for the player
	public String activeItem = null;//This holds the name of the player's held Active Item
	public String charm = null; //This holds the name of the player's passive charm. 
	public String gift = null; //This is the gift they choose at the start of the game
	
	public Player(String name, int str, int mag, int luc, int acc, int def, int spe, int HP, int MP){ //Hooray for massive method to set the values of everything. Used in line 29 of NewGame.
		this.name = name;
		this.str = str;
		this.mag = mag;
		this.luc = luc;
		this.acc = acc;
		this.def = def;
		this.spe = spe;
		this.HP = HP;
		this.MP = MP;
	}
	
	public void statSheet(){
		System.out.println("\tStats");
		System.out.println("--------------------------");
		System.out.println("Strength - " + str + "\tMagic Power - " + mag);
		System.out.println("Luck - " + luc + "    \tAccuaracy - " + acc);
		System.out.println("Defense - " + def + " \tSpeed - " + spe);
		System.out.println("Health - " + HP + "   \tMystic Energy - " + MP);
		System.out.println("Current items - ");
		for(int i = 0; i < items.length; i++){
			if(items[i] == null){
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
		if(activeItem == null){
			System.out.println("You currently do not have an active item!");
		} else {
			System.out.println(activeItem);
		}
		System.out.print("Charm - ");
		if(charm == null){
			System.out.println("You currently do not have a charm!");
		} else {
			System.out.println(charm);
		}
	}
	
}
