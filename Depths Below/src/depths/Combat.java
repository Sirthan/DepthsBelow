package depths;

import java.util.Scanner;

public class Combat {
	public static void fightMenu(Player player, CurrentEnemy enemy){
		boolean comKey = true;
		while(comKey){
			if(enemy.EHP <= 0){
				break;
			}
			if(player.gift.equals("Elders Wisdom")||player.bugTest){
				System.out.println(player.name + " -- (HP - " + player.MaxHP + " / " + player.HP + ")(MP - " + player.MaxMP + " / " + player.MP + ")(Shield - " +player.shield +")     v.s.     (MP - " + enemy.EMaxMP + " / " + enemy.EMP + " )(HP - "+ enemy.EMaxHP+ " / " + enemy.EHP + ") -- " + enemy.name);

			} else {
				System.out.println(player.name + " -- (HP - " + player.MaxHP + " / " + player.HP + ")(MP - " + player.MaxMP + " / " + player.MP + ")(Shield - " +player.shield +")     v.s.     (MP - ? / ? )(HP - ? / ?) -- " + enemy.name);
			}
			System.out.println("What do you want to do?");
			System.out.println(">Attack");
			if(player.gift.equalsIgnoreCase("Combat Aptitude"))System.out.println(">Advanced Combat");
			if(player.gift.equalsIgnoreCase("Earth Telekinesis"))System.out.println(">Telekinesis");
			System.out.println(">Magic");
			if(!(player.activeItem.equals("")))System.out.println(">Active Item");
			System.out.println(">Stats");
			Scanner sc = new Scanner(System.in);
			String userChoice = sc.nextLine();

			/*Start of Attack if*/

			if(userChoice.equalsIgnoreCase("Attack")||userChoice.equalsIgnoreCase("Attac")||userChoice.equalsIgnoreCase("Atta")||userChoice.equalsIgnoreCase("Att")||userChoice.equalsIgnoreCase("At")||userChoice.equalsIgnoreCase("A")){
				RandomAttackMessage(enemy, player);
				int damage = (int) ((double)player.str * ((Math.random() * 2 + 1)) - enemy.Edef);
				enemy.EHP -= damage;
				System.out.print("The attack hits the " + enemy.name + " and appears to cause ");
				damageMessage(damage, enemy.EMaxHP, player);
				TurnSwap(player, enemy);

				/*Start of Adv. Combat if*/

			} else if((userChoice.equalsIgnoreCase("Advanced Combat")||userChoice.equalsIgnoreCase("ACombat")||userChoice.equalsIgnoreCase("A Combat")||userChoice.equalsIgnoreCase("Advanced C")||userChoice.equalsIgnoreCase("AdvancedC")||userChoice.equalsIgnoreCase("AC")||userChoice.equalsIgnoreCase("AdvancedCombat")||userChoice.equalsIgnoreCase("AdvCombat")||userChoice.equalsIgnoreCase("Adv C")||userChoice.equalsIgnoreCase("A Com")||userChoice.equalsIgnoreCase("ACom")) && player.gift.equalsIgnoreCase("Combat Aptitude")){
				boolean AdvComkey = true;
				while(AdvComkey){
					AdvComkey = false;
					AdvancedAttackMenu(player);
					System.out.println("Which maneuver will you use?");
					String AdvInput = sc.nextLine();

					/*Start of Pircing Attack if*/

					if(AdvInput.equalsIgnoreCase("PA")||AdvInput.equalsIgnoreCase("Piercing Attack")||AdvInput.equalsIgnoreCase("P A")||AdvInput.equalsIgnoreCase("PAttack")||AdvInput.equalsIgnoreCase("PiercingA")||AdvInput.equalsIgnoreCase("Piercing A")||AdvInput.equalsIgnoreCase("P Attack")){
						if(player.gift.equalsIgnoreCase("Combat Aptitude")){
							if(player.MP >= 2){
								player.MP -= 2;
								RandomAttackMessage(enemy, player);
								int damage = (int) ((double)player.str * ((Math.random() * 2 + 1)));
								enemy.EHP -= damage;
								System.out.print("The attack hits the " + enemy.name + " and appears to cause ");
								damageMessage(damage, enemy.EMaxHP, player);
								TurnSwap(player, enemy);
							} else {
								System.out.println("Not enough MP");
							}
						} else {
							System.out.println("Not a choice \n(If you want to return, type exit)");
							AdvComkey = true;
						}

						/*Start of Heavy Slice if*/

					} else if(AdvInput.equalsIgnoreCase("Heavy Slice")||AdvInput.equalsIgnoreCase("HS")||AdvInput.equalsIgnoreCase("HeavySlice")||AdvInput.equalsIgnoreCase("H S")||AdvInput.equalsIgnoreCase("HSlice")||AdvInput.equalsIgnoreCase("HeavyS")||AdvInput.equalsIgnoreCase("H Slice")||AdvInput.equalsIgnoreCase("Heavy S")){
						if(player.gift.equalsIgnoreCase("Combat Aptitude") && player.lvl >= 2){
							if(player.MP >= 3){
								player.MP -= 2;
								RandomAttackMessage(enemy, player);
								int damage = (int) ((double)player.str * ((Math.random() * 3 + 1)));
								enemy.EHP -= damage;
								System.out.print("The attack hits the " + enemy.name + " and appears to cause ");
								damageMessage(damage, enemy.EMaxHP, player);
								TurnSwap(player, enemy);
							} else {
								System.out.println("Not enough MP!");
								AdvComkey = true;
							}
						} else {
							System.out.println("Not a choice \n(If you want to return, type exit)");
							AdvComkey = true;
						}

						/*Start of Deep Cuts If*/

					} else if(AdvInput.equalsIgnoreCase("Deep Cuts")||AdvInput.equalsIgnoreCase("DeepCuts")||AdvInput.equalsIgnoreCase("D Cuts")||AdvInput.equalsIgnoreCase("DCuts")||AdvInput.equalsIgnoreCase("Deep C")||AdvInput.equalsIgnoreCase("DeepC")||AdvInput.equalsIgnoreCase("D C")||AdvInput.equalsIgnoreCase("DC")){
						if(player.gift.equalsIgnoreCase("Combat Aptitude") && player.lvl >= 3){
							if(player.MP >= 3){
								player.MP -= 3;
								RandomAttackMessage(enemy, player);
								int damage = (int) ((double)player.str * ((Math.random() + 1)));
								enemy.EHP -= damage;
								System.out.print("The attack hits the " + enemy.name + " and appears to cause ");
								damageMessage(damage, enemy.EMaxHP, player);
								System.out.println("The "  + enemy.name + " begins to bleed!");
								TurnSwap(player, enemy);
							} else {
								System.out.println("Not enough MP!");
							}
						} else {
							System.out.println("Not a choice \n(If you want to return, type exit)");
							AdvComkey = true;
						}

						/*Start of exit if*/

					} else if (AdvInput.equalsIgnoreCase("exit")||AdvInput.equalsIgnoreCase("exi")||AdvInput.equalsIgnoreCase("ex")|| AdvInput.equalsIgnoreCase("e")){

						/*Start of else*/

					} else {
						System.out.println("Not a choice \n(If you want to return, type exit)");
						AdvComkey = true;
					}
				}

				/*Start of Magic if*/ 

			} else if (userChoice.equalsIgnoreCase("Magic")||userChoice.equalsIgnoreCase("Magi")||userChoice.equalsIgnoreCase("Mag")||userChoice.equalsIgnoreCase("Ma")||userChoice.equalsIgnoreCase("M")){
				boolean magKey = true;
				while(magKey){
					magKey = false;
					player.printSpells();
					if(player.checkSpell()){
						System.out.println("Which spell will you cast?");
					} else {
						break;
					}
					String magChoice = sc.nextLine();

					/*Start of Mental Blast if*/

					if((magChoice.equalsIgnoreCase("Mental Blast")||magChoice.equalsIgnoreCase("MentalBlast")||magChoice.equalsIgnoreCase("MBlast")||magChoice.equalsIgnoreCase("M Blast")||magChoice.equalsIgnoreCase("MentalB")||magChoice.equalsIgnoreCase("Mental B")||magChoice.equalsIgnoreCase("Me B")||magChoice.equalsIgnoreCase("MeB"))&& GameMechanics.checkArray("Mental Blast", player.spell)){
						if(player.MP >= 1){
							player.MP -= 1;
							Magic.MentalBlastMessage(player, enemy);
							int damage = (int) ((player.mag) * (Math.random() * 2 + 1) + ((double) (player.acc / 2) + ((double)player.luc / 2)));
							enemy.EHP -= damage;
							System.out.print("The spell lands on the " + enemy.name + " and singes him for ");
							damageMessage(damage, enemy.EMaxHP, player);
							TurnSwap(player, enemy);
						} else {
							System.out.println("Not Enough MP!!!!");
						}

						/*Start of Augment Strength if*/

					} else if((magChoice.equalsIgnoreCase("Augment Strength")||magChoice.equalsIgnoreCase("AugmentStrength")||magChoice.equalsIgnoreCase("AStrength")||magChoice.equalsIgnoreCase("A Strength")||magChoice.equalsIgnoreCase("Augment S")||magChoice.equalsIgnoreCase("AugmentS")||magChoice.equalsIgnoreCase("A S")||magChoice.equalsIgnoreCase("AS")||magChoice.equalsIgnoreCase("Aug S")||magChoice.equalsIgnoreCase("AugS")||magChoice.equalsIgnoreCase("Aug Str")||magChoice.equalsIgnoreCase("AugStr")) && GameMechanics.checkArray("Augment Strength", player.spell)){
						if(player.MP >= 4){
							player.MP -= 4;
							player.str -= player.AugStr;
							player.AugStr += (int) ((double)(player.mag / 2) * (Math.random() * 2 + 1));
							player.str += player.AugStr;
							Magic.AugmentStengthMessage(player, enemy);
							System.out.println("(Your strength is currently being augmented by " + player.AugStr + " points.)");
							TurnSwap(player, enemy);

						} else {
							System.out.println("Not Enough MP!!!!");
						}

						/*Start of Mystic Barrier if*/

					} else if((magChoice.equalsIgnoreCase("Mystic Barrier")||magChoice.equalsIgnoreCase("MysticBarrier")||magChoice.equalsIgnoreCase("MBarrier")||magChoice.equalsIgnoreCase("M Barrier")||magChoice.equalsIgnoreCase("Mystic B")||magChoice.equalsIgnoreCase("MysticB")||magChoice.equalsIgnoreCase("Mystic Barrier")||magChoice.equalsIgnoreCase("MyB")||magChoice.equalsIgnoreCase("My B")||magChoice.equalsIgnoreCase("Mystic")||magChoice.equalsIgnoreCase("Barrier")||magChoice.equalsIgnoreCase("Bar")||magChoice.equalsIgnoreCase("Mys Bar")) && GameMechanics.checkArray("Mystic Barrier", player.spell)){
						if(player.MP >= 6){
							player.MP -= 6;
							player.shield += (int) ((double)(player.mag / 2) * (Math.random() * 2 + 1));
							Magic.MysticBarrierMessage(player, enemy);
							TurnSwap(player, enemy);
						} else {
							System.out.println("Not Enough MP!!!!");
						}

					} else if (magChoice.equalsIgnoreCase("exit")||magChoice.equalsIgnoreCase("exi")||magChoice.equalsIgnoreCase("ex")||magChoice.equalsIgnoreCase("e")) {


					}  else {
						System.out.println("That is not a proper command! Please enter a actual command!(If you want to exit this menu, type exit)");
						magKey = true;
					}

				}

				/*Start of Active Item if*/

			} else if ((userChoice.equalsIgnoreCase("Active Item")||userChoice.equalsIgnoreCase("ActiveItem")||userChoice.equalsIgnoreCase("AItem")||userChoice.equalsIgnoreCase("A Item")||userChoice.equalsIgnoreCase("Active I")||userChoice.equalsIgnoreCase("ActiveI")||userChoice.equalsIgnoreCase("AI")||userChoice.equalsIgnoreCase("A I")||userChoice.equalsIgnoreCase("Item")||userChoice.equalsIgnoreCase("Ite")||userChoice.equalsIgnoreCase("It")||userChoice.equalsIgnoreCase("I")) && (!(player.activeItem.equals("")))){
				System.out.println("Currently Unimplemented, To be added at a future date...");
				TurnSwap(player, enemy);

				/*Start of Telekinesis if*/

			} else if((userChoice.equalsIgnoreCase("Telekinesis")||userChoice.equalsIgnoreCase("Telekinesi")||userChoice.equalsIgnoreCase("Telekines")||userChoice.equalsIgnoreCase("Telekine")||userChoice.equalsIgnoreCase("Telekin")||userChoice.equalsIgnoreCase("Teleki")||userChoice.equalsIgnoreCase("Telek")||userChoice.equalsIgnoreCase("Tele")||userChoice.equalsIgnoreCase("Tel")||userChoice.equalsIgnoreCase("Te")||userChoice.equalsIgnoreCase("T")) && player.gift.equals("Earth Telekinesis") ){
				TelekinesisMessage(player);
				int damage = RandomTelekinesis(player, enemy);
				if(damage == -1){
					System.out.println("The plant hits the " + enemy.name + " and poisons him!!");
				} else if(damage == -2){
					player.shield = (int) ((double) ((player.luc + player.acc)/2)/(Math.random() * 3 + 1));
				} else {
					System.out.print("The rock smashes into the " + enemy.name + " and deals ");
					damageMessage(damage, enemy.EMaxHP, player);
					enemy.EHP -= damage;
				}
				TurnSwap(player,enemy);


				/*Start of Stats if */

			} else if (userChoice.equalsIgnoreCase("stats")||userChoice.equalsIgnoreCase("stat")||userChoice.equalsIgnoreCase("sta")||userChoice.equalsIgnoreCase("st")||userChoice.equalsIgnoreCase("s")){
				player.statSheet();
				EStatSheet(enemy);
			} else {
				System.out.println("That is not an actual command, please enter an actual command!!!");
			}
		}
	}

	public static void damageMessage(int damage, int EHP, Player player){
		if(!(player.gift.equals("Elders Wisdom")||player.bugTest)){
			double damagePercent = (((double)damage) / ((double) EHP));
			if(damagePercent < .05){
				System.out.println("an almost nonexistant ammount of damage.");
			} else if(damagePercent < .10){
				System.out.println("a miniscule ammount of damage. ");
			} else if (damagePercent < .15){
				System.out.println("a slight ammount of damage. ");
			} else if (damagePercent < .20){
				System.out.println("a light ammount of damage. ");
			} else if (damagePercent < .25){
				System.out.println("a moderate ammount of damage. ");
			} else if (damagePercent < .35){
				System.out.println("a signifigant ammount of damage. ");
			} else if (damagePercent < .50){
				System.out.println("a large ammount of damage. ");
			} else if (damagePercent < .75){
				System.out.println("a heavy ammount of damage. ");
			} else if (damagePercent < .90){
				System.out.println("a fatal ammount of damage. ");
			} else if (damagePercent > .91){
				System.out.println("a lethal ammount of damage. ");
			} else {
				System.out.println("a low ammount of damage. ");
			}
		} else {
			System.out.println("exactly " + damage + " points of damage.");
		}
	}

	public static void EStatSheet(CurrentEnemy enemy){
		System.out.println("\t"+ enemy.name +  "'s Stats");
		System.out.println("--------------------------");
		System.out.println("Strength - " + enemy.Estr + "\tMagic Power - " + enemy.Emag);
		System.out.println("Luck - " + enemy.Eluc + "    \tAccuaracy - " + enemy.Eacc);
		System.out.println("Defense - " + enemy.Edef + " \tSpeed - " + enemy.Espe);
		System.out.println("Health - " + enemy.EHP + "   \tMystic Energy - " + enemy.EMP);
	}

	public static void RandomAttackMessage(CurrentEnemy enemy, Player player){
		int randomNum = (int)(Math.random() * 4 + 1);
		switch (randomNum){
		case 1:
			System.out.println("Hands raised above your head, you charge ferociously towards the " + enemy.name + "!!");
			break;
		case 2:
			System.out.println("Almost reluctantly, you speed into the " + enemy.name +"!");
			break;
		case 3:
			System.out.println("You take a moment to prepare, then smash into the " + enemy.name + "!");
			break;
		case 4:
			System.out.println("Slowly, you walk to the " + enemy.name + ", pausing only a moment before showering " + enemy.genderPronoun + " in punches.");
			break;
		default:
			System.out.println("ERROR - Combat, RandomAttackMessage()");

		}
	}
	public static void AdvancedAttackMenu(Player player){
		switch(player.lvl){
		case 1:
			System.out.println("Piercing Attack (2MP).");
			break;
		case 2:
			System.out.println("Piercing Attack (2MP), Heavy Slice (3MP).");
			break;
		case 3:
			System.out.println("Piercing Attack (2MP), Heavy Slice (3MP), Deep Cuts (3MP).");
			break;
		case 4:
			System.out.println("Piercing Attack (2MP), Heavy Slice (3MP), Deep Cuts (3MP). ");
			break;
		case 5:
			System.out.println("Piercing Attack (2MP), Heavy Slice (3MP), Deep Cuts (3MP). ");
			break;
		default:
			System.out.println("Piercing Attack (2MP), Heavy Slice (3MP), Deep Cuts (3MP). ");
			break;
		}
	}

	public static void TurnSwap(Player player, CurrentEnemy enemy){
		System.out.println("\n");
		if(enemy.isBleeding){
			enemy.EHP -= (int) ((double) player.str / 2.0);
			System.out.println("The " + enemy.name + " is losing a lot of blood due to his cut!");
		}
		if(enemy.isPoisoned){
			enemy.EHP -= (int) ((double) player.luc / (Math.random() * 2 + 1));
			System.out.println("The " + enemy.name + " is obviously being affected by " + enemy.genderPronoun + " poisoning!");
		}
		if(enemy.EHP > 0){
			System.out.println("The " + enemy.name + "'s eyes dart around squemishly.");
			String attack = enemy.randomAttack();
			GameMechanics.pause(2000);
			if(attack.equals("basic")){
				System.out.println(enemy.basicAttackMessage);
				int damage = enemy.basicAttack(player);
				if(damage < 1)damage = 1;
				if(player.shield > 0){
					player.shield -= damage;
					if(player.shield < 0) player.shield = 0;
					if(player.gift.equals("Endurance Mastery")){
						System.out.println("Your shield absorbs the " + (damage / 2) + " points of damage.");
					} else {
						System.out.println("Your shield absorbs the " + damage + " points of damage.");
					}
					if(GameMechanics.checkArray("Reflect Stone", player.items)){
						System.out.print("The barrier seems to return some of the damage, injuring the " + enemy.name + " for ");
						damageMessage(damage, enemy.EMaxHP, player);
						enemy.EHP -= damage;
						if(enemy.EHP <= 0) enemy.EHP = 1; 
						}
				} else {
					player.takeDamage(damage);
					if(player.gift.equals("Endurance Mastery")){
						System.out.println("You are " + enemy.damageAdjective + " for " + (damage / 2) + " points of damage!!!!");
					} else {
						System.out.println("You are " + enemy.damageAdjective + " for " + damage + " points of damage!!!!");
					}
				}
			} else if(attack.equalsIgnoreCase("claw")){
				System.out.println("The " + enemy.name + " tears into you with " + enemy.genderPronoun + " massive claws!!");
				int damage = enemy.claw(player);
				if(damage < 1)damage = 1;
				if(player.shield > 0){
					player.shield -= damage;
					if(player.shield < 0) player.shield = 0;
					if(player.gift.equals("Endurance Mastery")){
						System.out.println("Your shield absorbs the " + (damage / 2) + " points of damage.");
					} else {
						System.out.println("Your shield absorbs the " + damage + " points of damage.");
					}
					if(GameMechanics.checkArray("Reflect Stone", player.items)){
					System.out.print("The barrier seems to return some of the damage, injuring the " + enemy.name + " for ");
					damageMessage(damage, enemy.EMaxHP, player);
					enemy.EHP -= damage;
					if(enemy.EHP <= 0) enemy.EHP = 1; 
					}
				} else {
					player.takeDamage(damage);
					if(player.gift.equals("Endurance Mastery")){
						System.out.println("You are scratched for " + (damage / 2) + " points of damage!!!!");
					} else {
						System.out.println("You are scratched for " + damage + " points of damage!!!!");
					}
				}
			} else if (attack.equals("bloodsuck")){
				System.out.println("The " + enemy.name + " attempts bites into your arm!!");
				int damage = enemy.bloodsuck(player);
				if(damage < 1)damage = 1;
				if(player.shield > 0){
					player.shield -= damage;
					if(player.shield < 0) player.shield = 0;
					if(player.gift.equals("Endurance Mastery")){
						System.out.println("Your shield absorbs the " + (damage / 2) + " points of damage.");
					} else {
						System.out.println("Your shield absorbs the " + damage + " points of damage.");
					}
					System.out.println("The " + enemy.name + " couldn't drink any blood!");
					if(GameMechanics.checkArray("Reflect Stone", player.items)){
						System.out.print("The barrier seems to return some of the damage, injuring the " + enemy.name + " for ");
						damageMessage(damage, enemy.EMaxHP, player);
						enemy.EHP -= damage;
						if(enemy.EHP <= 0) enemy.EHP = 1; 
						}
				} else {
					player.takeDamage(damage);
					System.out.println("The " + enemy.name + " begins to drink your blood!!");
					if(player.gift.equals("Endurance Mastery")){
						System.out.println("Your drained for " + (damage / 2) + " points of damage!!");
					} else {
						System.out.println("Your drained for " + damage + " points of damage!!");
					}
					enemy.EHP += damage;
					if(enemy.EHP > enemy.EMaxHP){
						enemy.EHP = enemy.EMaxHP;
					}
				}	
			}

			if(player.HP <= 0){
				if(GameMechanics.checkArray("Fancy Cupcake", player.items)){
					System.out.println("You fall to the ground, hurt and injured, unsure if you could keep going... ");
					GameMechanics.pause(500);
					System.out.println("But then, you remember the Fancy Cupcake you aquired earlier, and decide to eat it as a last ditch effort!");
					System.out.println("Suddenly, you feel invigorated and inspired to continue the fight!!");
					player.HP = (player.MaxHP / 4);
					int fancyIndex = GameMechanics.indexArray("Fancy Cupcake", player.items);
					player.items[fancyIndex] = "Fancy Cup cakeWrapper";
					
				} else {
				DeathMessage(player);
				System.out.println("Game Over...");
				System.out.println("Here are your final stats");
				player.statSheet();
				System.out.println("You cleared " + (player.floorsCleared - 1) + " floors and cleared " + player.roomsCleared + " rooms.");
				System.out.println("Lastly, you were defeated by a " + enemy.name);
				System.exit(0);
				}
			}
		} else {
			player.str -= player.AugStr;
			player.AugStr = 0;
			System.out.println(enemy.deathCry);
			GameMechanics.pause(1000);
			VictoryMessage(enemy);
			GameMechanics.pause(1000);
			System.out.println("You loot " + enemy.Ggiven + " Gold off the enemy and feel as if you gained about " + enemy.EXPgiven + " experience!");
			player.EXP += enemy.EXPgiven;
			player.G += enemy.Ggiven;
			if(player.EXP >= player.TNL){
				GameMechanics.pause(1000);
				GameMechanics.levelupText();
				System.out.println("");
				GameMechanics.pause(2000);
				player.lvlUp();
				System.out.println("");
			}
		}
	}

	public static void VictoryMessage(CurrentEnemy enemy){
		int randomNum = (int)(Math.random() * 6 + 1);
		switch (randomNum){
		case 1:
			System.out.println("Overcome with the joy of defeating the " + enemy.name + " you begin to jump up and down with joy!!");
			break;
		case 2:
			System.out.println("Grinning, almost uncontrollably, you feel renewed with excitement over the death of the " + enemy.name + ".");
			break;
		case 3:
			System.out.println("Tired from the fight, you take a moment of repspite before continueing onward...");
			break;
		case 4:
			System.out.println("You let out a quick sigh of relief, then you get back to the adventure at hand.");
			break;
		case 5:
			System.out.println("You take in a deep breath, and slowly exhale in attempt to calm yourself from the battle.");
			break;
		case 6:
			System.out.println("You nod you head in a cocky way and grin, pleased you won the difficult fight.");
			break;
		default:
			System.out.println("ERROR - Combat, VictoryMessage()");
		}
	}

	public static void DeathMessage(Player player ){
		int randomNum = (int)(Math.random() * 4 + 1);
		switch (randomNum){
		case 1:
			System.out.println("Under too much stress and pain, your body crumbles to the ground, unable to continue functioning... \nThe last thought you ever think of is how your family will react to the news...");
			break;
		case 2:
			System.out.println("Teary-eyed and bloodied, you collapse onto the ground, unable to continue fighting...\nYour last thought is of home, and, in a moment serene peace, you remember your wonderful life before being selected to brave the Depths...");
			break;
		case 3:
			System.out.println("You scream out as you fall on the hard ground knowing the depths has claimed another victim...\nYour life flashes before your eyes and, for the first time since entering the Depths, you smile...");
			break;
		case 4:
			System.out.println("Slowly, you fall on the ground - feeling as if every bone within you were broken...\nTears fall from you face at the thought of how close you were to conquering the Depths...");
			break;
		default:
			System.out.println("ERROR - Combat, DeathMessage()");
		}	
	}
	public static void TelekinesisMessage(Player player){
		int randomNum = (int)(Math.random() * 4 + 1);
		switch (randomNum){
		case 1:
			System.out.println("You begin to hone in on the environment around you to look for items to throw...");
			GameMechanics.pause(2000);
			break;
		case 2:
			System.out.println("You begin to calm down and focus on the earth around you...");
			GameMechanics.pause(2000);
			break;
		case 3:
			System.out.println("You start to empty your mind and prepare to throw an object telekinetically...");
			GameMechanics.pause(2000);
			break;
		case 4:
			System.out.println("You kneel down and attempt to become one with the earth.");
			GameMechanics.pause(2000);
			break;
		default:
			System.out.println("ERROR - Combat, TelekinesisMessage()");
		}
	}

	public static int RandomTelekinesis(Player player, CurrentEnemy enemy){
		int randomNum = (int)(Math.random() * 10 + 1);
		if(randomNum <= 6){
			System.out.println("After a couple moments of focus, you are able to find and throw a relatively large rock.");
			return ((int) (((((double)player.luc / 6.0) + ((double) player.acc / 2.0) + ((double) player.spe / 3.0)) * (Math.random() * 3 + 2)) - enemy.Edef));
		} else if (randomNum == 7){
			System.out.println("Deciding that you need protrection, you stack a large number of rocks into a shield infront of you.");
			return (-2);
		} else if (randomNum == 8){
			System.out.println("With an amazing stroke of luck, you are able to find a massive rock, and you immediately throw it at the " + enemy.name + "!!");
			return ((int) (((((double)player.luc / 6.0) + ((double) player.acc / 2.0) + ((double) player.spe / 3.0)) * (Math.random() * 4 + 3)) - enemy.Edef));
		} else if (randomNum == 9){
			System.out.println("You, unfortunantly, are unable to find anything other than a medium sized rock to throw.\nUnhappily, you toss the tiny rock toward the " + enemy.name + "...");
			return ((int) ((((double)player.luc / 6.0) + ((double) player.acc / 2.0) + ((double) player.spe / 3.0)) - enemy.Edef));
		} else if(randomNum == 10){
			System.out.println("Deciding to mix it up a little, you throw a poisonous plant in hopes of poisoning the " + enemy.name + "!");
			enemy.isPoisoned = true;
			return (-1);
		} else {
			return ((int) (((((double)player.luc / 6.0) + ((double) player.acc / 2.0) + ((double) player.spe / 3.0)) * (Math.random() * 2 + 1)) - enemy.Edef));
		}
	}
}