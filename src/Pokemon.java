
public class Pokemon {
	int pokedex;
	int atkMin;
	int atkMax;
	int atkMaxWithLollipop = 0;
	int numberLollipop = 0;
	String ability = " ", name = " ";
	public Pokemon(int pokedex,String name, int atk, String ability, int lollipop){
		this.name = name;
		this.pokedex = pokedex;
		this.atkMin = atk;
		this.atkMax = this.atkMin + 20;
		this.numberLollipop = lollipop;
		this.ability = ability;
		if(lollipop != 0){
			atkMaxWithLollipop = atkMax + (lollipop*2);
		}
		else{
			atkMaxWithLollipop = this.atkMax;
		}
	}
	
	public int getPokedex() {
		return pokedex;
	}
	public void setPokedex(int pokedex) {
		this.pokedex = pokedex;
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	public int getAtkMin() {
		return atkMin;
	}
	public void setAtkMin(int atkMin) {
		this.atkMin = atkMin;
	}
	public int getAtkMax() {
		return atkMax;
	}
	public void setAtkMax(int atkMax) {
		this.atkMax = atkMax;
	}
	public int getAtkMaxWithLollipop() {
		return atkMaxWithLollipop;
	}
	public void setAtkMaxWithLollipop(int atkMaxWithLollipop) {
		this.atkMaxWithLollipop = atkMaxWithLollipop;
	}
	public int getNumberLollipop() {
		return numberLollipop;
	}
	public void setNumberLollipop(int numberLollipop) {
		this.numberLollipop = numberLollipop;
	}
	@Override
	public String toString() {
		return "Pokemon [pokedex=" + pokedex + ", atkMin=" + atkMin + ", atkMax=" + atkMax + ", atkMaxWithLollipop="
				+ atkMaxWithLollipop + ", numberLollipop=" + numberLollipop + ", ability=" + ability + ", name=" + name
				+ "]";
	}/*
	@Override
	public String toString() {
		return  ""+atkMin;
	}
	public int CompareTo(Pokemon pokemon){
		if(this.pokedex == pokemon.getPokedex()){
			return 0;
		}else if(this.pokedex < pokemon.getPokedex()){
			return -1;
		}else{
			return 1;
		}
	}*/
}
