package depths;

public class CurrentEnemy extends EnemyEntity{
	public int Estr = 0, Emag = 0, Eluc = 0, Eacc = 0, Edef = 0, Espe = 0, EHP = 0, EMP = 0, EMaxHP = 0, EMaxMP = 0, Elvl = 0, EXPgiven = 0, Ggiven = 0;
	public String sound = "Error";
	public String[] Attacks = null;
	public String name = "ERROR";
	public String genderPronoun = "it";
	public boolean isBleeding = false;
	public boolean isPoisoned = false;
	public String basicAttackMessage = "";
	public String damageAdjective = "";
	public String deathCry = "";
	@Override
	public int basicAttack(Player player) {
		return ((int) ((double)Estr * ((Math.random() * 2 + 1)) - player.def));
	}
	
	public int claw (Player player){
		return ((int) ((double)Estr * ((Math.random() * 2 + 1))));
	}
	
	public int bloodsuck (Player player){
		return ((int) ((double)Estr * ((Math.random() * 2 + 1))));
	}
	
	public CurrentEnemy(int Estr, int Emag, int Eluc, int Edef, int Espe, int EHP, int EMP, int Elvl, int EXPgiven, int Ggiven, String Name, String[] attacks, String sound, String genderPronoun, String basicAttackMessage, String damageAdjective, String deathCry){
		this.Estr = Estr;
		this.Emag = Emag;
		this.Eluc = Eluc;
		this.Espe = Espe;
		this.EHP = EHP;
		this.EMP = EMP;
		this.EMaxHP = EHP;
		this.EMaxMP = EMP;
		this.Elvl = Elvl;
		this.EXPgiven = EXPgiven;
		this.Ggiven = Ggiven;
		this.name = Name;
		this.Attacks = attacks;
		this.sound = sound;
		this.genderPronoun = genderPronoun;
		this.basicAttackMessage = basicAttackMessage;
		this.damageAdjective = damageAdjective;
		this.deathCry = deathCry;
		
	}
	@Override
	public String randomAttack(){
		int RandomNum = (int) (Math.random() * Attacks.length);
		return Attacks[RandomNum];
	}
}