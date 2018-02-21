import java.awt.Graphics;
import java.awt.Point;


public class ItemModifier {
	String description;
	Point range;
	int requiredILVL;
	int roll;
	String affixType;
	String affixName = "";
	String baseItem;
	public ItemModifier(){
		
		//item is an amulet
		if(baseItem=="amulet"){
			if(affixType=="prefix"){
				roll = DivineOrb.randomNumber(1, 100016);
				//added physical dmg
				if(roll<=1181&&roll>0&&requiredILVL>=5){
					affixName = "Glinting";
				}
				else if(roll<=2362&&roll>1181&&requiredILVL>=13){
					affixName = "Burnished";
				}
				else if(roll<=3543&&roll>2362&&requiredILVL>=19){
					affixName = "Polished";
				}
				else if(roll<=4724&&roll>3542&&requiredILVL>=28){
					affixName = "Honed";
				}
				else if(roll<=5905&&roll>4724&&requiredILVL>=35){
					affixName = "Gleaming";
				}
				else if(roll<=7086&&roll>5905&&requiredILVL>=44){
					affixName = "Annealed";
				}
				else if(roll<=8267&&roll>7086&&requiredILVL>=52){
					affixName = "Razor Sharp";
				}
				else if(roll<=9448&&roll>8267&&requiredILVL>=64){
					affixName = "Tempered";
				}
				else if(roll<=10629&&roll>9448&&requiredILVL>=76){
					affixName = "Flaring";
				}
				
				//Increased Energy Shield
				else if(roll<=11810&&roll>10629&&requiredILVL>=3){
					affixName = "Shining";
				}
				else if(roll<=12991&&roll>11810&&requiredILVL>=11){
					affixName = "Glimmering";
				}
				else if(roll<=14172&&roll>12991&&requiredILVL>=17){
					affixName = "Glittering";
				}
				else if(roll<=15353&&roll>14172&&requiredILVL>=23){
					affixName = "Glowing";
				}
				else if(roll<=16534&&roll>15353&&requiredILVL>=29){
					affixName = "Radiating";
				}
				else if(roll<=17715&&roll>16534&&requiredILVL>=35){
					affixName = "Pulsing";
				}
				else if(roll<=18896&&roll>17715&&requiredILVL>=42){
					affixName = "Seething";
				}
				else if(roll<=20077&&roll>18896&&requiredILVL>=50){
					affixName = "Blazing";
				}
				else if(roll<=21258&&roll>20077&&requiredILVL>=59){
					affixName = "Scintillating";
				}
				else if(roll<=22439&&roll>21258&&requiredILVL>=68){
					affixName = "Incandescent";
				}
				else if(roll<=23620&&roll>22439&&requiredILVL>=74){
					affixName = "Resplendent";
				}
				
				//Percent increased energy shield
				else if(roll<=24801&&roll>23620&&requiredILVL>=3){
					affixName = "Protective";
				}
				else if(roll<=25982&&roll>24801&&requiredILVL>=18){
					affixName = "Strong-Willed";
				}
				else if(roll<=27163&&roll>25982&&requiredILVL>=30){
					affixName = "Resolute";
				}
				else if(roll<=28344&&roll>27163&&requiredILVL>=42){
					affixName = "Fearless";
				}
				else if(roll<=29525&&roll>28344&&requiredILVL>=56){
					affixName = "Dauntless";
				}
				else if(roll<=30706&&roll>29525&&requiredILVL>=70){
					affixName = "Indomitable";
				}
				else if(roll<=31887&&roll>30706&&requiredILVL>=77){
					affixName = "Unassailable";
				}
				
				//Percent increased evasion rating
				else if(roll<=33068&&roll>31887&&requiredILVL>=2){
					affixName = "Agile";
				}
				else if(roll<=34249&&roll>33068&&requiredILVL>=19){
					affixName = "Dancer's";
				}
				else if(roll<=35430&&roll>34249&&requiredILVL>=30){
					affixName = "Acrobat's";
				}
				else if(roll<=36611&&roll>35430&&requiredILVL>=42){
					affixName = "Fleet";
				}
				else if(roll<=37792&&roll>36611&&requiredILVL>=56){
					affixName = "Blurred";
				}
				else if(roll<=38973&&roll>37792&&requiredILVL>=70){
					affixName = "Phased";
				}
				else if(roll<=40154&&roll>38973&&requiredILVL>=77){
					affixName = "Vaporous";
				}
				
				//Increased Life
				else if(roll<=41135&&roll>40154&&requiredILVL>=1){
					affixName = "Healthy";
				}
				else if(roll<=42516&&roll>41135&&requiredILVL>=11){
					affixName = "Sanguine";
				}
				else if(roll<=43697&&roll>42516&&requiredILVL>=18){
					affixName = "Stalwart";
				}
				else if(roll<=44878&&roll>43697&&requiredILVL>=24){
					affixName = "Stout";
				}
				else if(roll<=46059&&roll>44878&&requiredILVL>=30){
					affixName = "Robust";
				}
				else if(roll<=47240&&roll>46059&&requiredILVL>=36){
					affixName = "Rotund";
				}
				else if(roll<=48421&&roll>47240&&requiredILVL>=44){
					affixName = "Virile";
				}
				
				//Increased Mana
				else if(roll<=49602&&roll>48421&&requiredILVL>=1){
					affixName = "Beryl";
				}
				else if(roll<=50783&&roll>49602&&requiredILVL>=11){
					affixName = "Cobalt";
				}
				else if(roll<=51964&&roll>50783&&requiredILVL>=17){
					affixName = "Azure";
				}
				else if(roll<=53145&&roll>51964&&requiredILVL>=23){
					affixName = "Sapphire";
				}
				else if(roll<=54326&&roll>53145&&requiredILVL>=29){
					affixName = "Cerulean";
				}
				else if(roll<=55507&&roll>54326&&requiredILVL>=35){
					affixName = "Aqua";
				}
				else if(roll<=56688&&roll>55507&&requiredILVL>=42){
					affixName = "Opanescent";
				}
				else if(roll<=57869&&roll>56688&&requiredILVL>=51){
					affixName = "Gentian";
				}
				else if(roll<=59050&&roll>57869&&requiredILVL>=60){
					affixName = "Chalybeous";
				}
				else if(roll<=60231&&roll>59050&&requiredILVL>=69){
					affixName = "Mazerine";
				}
				else if(roll<=61412&&roll>60231&&requiredILVL>=75){
					affixName = "Blue";
				}
				
				//Percent increased Armour
				else if(roll<=62593&&roll>61412&&requiredILVL>=2){
					affixName = "Reinforced";
				}
				else if(roll<=63774&&roll>62593&&requiredILVL>=18){
					affixName = "Layered";
				}
				else if(roll<=64955&&roll>63774&&requiredILVL>=30){
					affixName = "Lobstered";
				}
				else if(roll<=66136&&roll>64995&&requiredILVL>42){
					affixName = "Buttressed";
				}
				else if(roll<=67317&&roll>66136&&requiredILVL>=56){
					affixName = "Thickened";
				}
				else if(roll<=68498&&roll>67317&&requiredILVL>=70){
					affixName = "Solid";
				}
				else if(roll<=69679&&roll>68498&&requiredILVL>=77){
					affixName = "Impregnable";
				}
				
				//increased rarity of items found
				else if(roll<=70860&&roll>69679&&requiredILVL>=20){
					affixName = "Magpie's";
				}
				else if(roll<=72041&&roll>70860&&requiredILVL>=39){
					affixName = "Pirates";
				}
				else if(roll<=73222&&roll>72041&&requiredILVL>=62){
					affixName = "Dragon's";
				}
				
				//Life Leech
				else if(roll<=74403&&roll>73222&&requiredILVL>=9){
					affixName = "Remora's";
				}
				else if(roll<=74993&&roll>74403&&requiredILVL>=25){
					affixName = "Lamprey's";
				}
				else if(roll<=75288&&roll>74993&&requiredILVL>=72){
					affixName = "Vampire's";
				}
				
				//Mana Leech
				else if(roll<=76469&&roll>75288&&requiredILVL>=9){
					affixName = "Thirsty";
				}
				else if(roll<=77650&&roll>76469&&requiredILVL>=74){
					affixName = "Parched";
				}
				
				//Percent Increased Spell damage
				else if(roll<=78831&&roll>77650&&requiredILVL>=5){
					affixName = "Chanter's";
				}
				else if(roll<=80012&&roll>78831&&requiredILVL>=20){
					affixName = "Mage's";
				}
				else if(roll<=81193&&roll>80012&&requiredILVL>=38){
					affixName = "Sorcerer's";
				}
				else if(roll<=82374&&roll>81193&&requiredILVL>=56){
					affixName = "Thaumaturgist's";
				}
				else if(roll<=83555&&roll>82374&&requiredILVL>=76){
					affixName = "Wizard's";
				}
				
				//Added cold Damage
				else if(roll<=84145&&roll>83555&&requiredILVL>=2){
					affixName = "Frosted";
				}
				else if(roll<=84735&&roll>84145&&requiredILVL>=13){
					affixName = "Chilled";
				}
				else if(roll<=85325&&roll>84735&&requiredILVL>=21){
					affixName = "Icy";
				}
				else if(roll<=85915&&roll>85325&&requiredILVL>=29){
					affixName = "Frigid";
				}
				else if(roll<=86505&&roll>85915&&requiredILVL>=36){
					affixName = "Freezing";
				}
				else if(roll<=87095&&roll>86505&&requiredILVL>=45){
					affixName = "Frozen";
				}
				else if(roll<=87685&&roll>87095&&requiredILVL>=53){
					affixName = "Glaciated";
				}
				else if(roll<=88275&&roll>87685&&requiredILVL>=65){
					affixName = "Polar";
				}
				else if(roll<=88570&&roll>88275&&requiredILVL>=77){
					affixName = "Entombing";
				}
				
				//Added Fire damage
				else if(roll<=89160&&roll>88570&&requiredILVL>=1){
					affixName = "Heated";
				}
				else if(roll<=89750&&roll>89160&&requiredILVL>=12){
					affixName = "Smoldering";
				}
				else if(roll<=90340&&roll>89750&&requiredILVL>=20){
					affixName = "Smoking";
				}
				else if(roll<=90930&&roll>90340&&requiredILVL>=28){
					affixName = "Burning";
				}
				else if(roll<=91520&&roll>90930&&requiredILVL>=35){
					affixName = "Flaming";
				}
				else if(roll<=92110&&roll>91520&&requiredILVL>=44){
					affixName = "Scorching";
				}
				else if(roll<=92700&&roll>92110&&requiredILVL>=52){
					affixName = "Incinerating";
				}
				else if(roll<=93290&&roll>92700&&requiredILVL>=64){
					affixName = "Blasting";
				}
				else if(roll<=93585&&roll>93290&&requiredILVL>=76){
					affixName = "Cremating";
				}
				
				//Added lightning damage
				else if(roll<=94175&&roll>93585&&requiredILVL>=3){
					affixName = "Humming";
				}
				else if(roll<=94765&&roll>94175&&requiredILVL>=13){
					affixName = "Buzzing";
				}
				else if(roll<=95355&&roll>94765&&requiredILVL>=22){
					affixName = "Snapping";
				}
				else if(roll<=95945&&roll>95355&requiredILVL>=28){
					affixName = "Crackling";
				}
				else if(roll<=96535&&roll>95945&&requiredILVL>=35){
					affixName = "Sparking";
				}
				else if(roll<=97125&&roll>96535&&requiredILVL>=44){
					affixName = "Arcing";
				}
				else if(roll<=97715&&roll>97125&&requiredILVL>=52){
					affixName = "Shocking";
				}
				else if(roll<=98305&&roll>97715&&requiredILVL>=64){
					affixName = "Discharging";
				}
				else if(roll<=98600&&roll>98305&&requiredILVL>=76){
					affixName = "Electrocuting";
				}
				
				//Weapon elemental damage
				else if(roll<=98954&&roll>98600&&requiredILVL>=4){
					affixName = "Catalysing";
				}
				else if(roll<=99308&&roll>98954&&requiredILVL>=15){
					affixName = "Infusing";
				}
				else if(roll<=99662&&roll>99308&&requiredILVL>=30){
					affixName = "Empowering";
				}
				else if(roll<=100016&&roll>99662&&requiredILVL>=75){
					affixName = "Unleashed";
				}
			}
			else if(affixType=="Suffix"){
				roll = DivineOrb.randomNumber(1, 100016);
				
			}
		}
	}
	public void Draw(Graphics g){
		g.drawString(roll+description, 143,480);
	}
}
