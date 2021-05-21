
public class Igralec {
	int st;
	int hitrost;
	int relVelikost;
	int polozaj;
	boolean pc;
	Zoga zoga;
	

	
	public Igralec(int st,int hitrost,int relVelikost,int polozaj,boolean pc){
		this.pc = pc;
		this.polozaj = polozaj;
		this.st = st;
		this.hitrost = hitrost;
		this.relVelikost = relVelikost;
		
		
	}

	public int getSt() {
		return st;
	}







	public void setSt(int st) {
		this.st = st;
	}







	public int getHitrost() {
		return hitrost;
	}







	public void setHitrost(int hitrost) {
		this.hitrost = hitrost;
	}







	public int getRelVelikost() {
		return relVelikost;
	}







	public void setRelVelikost(int relVelikost) {
		this.relVelikost = relVelikost;
	}







	public int getPolozaj() {
		return polozaj;
	}







	public void setPolozaj(int polozaj) {
		this.polozaj = polozaj;
	}







	public boolean isPc() {
		return pc;
	}







	public void setPc(boolean pc) {
		this.pc = pc;
	}







	public Zoga getZoga() {
		return zoga;
	}



	public void setZoga(Zoga zoga) {
		this.zoga = zoga;
	}

	public  void update(Zoga zoga) {
		if (this.pc) {
		if (zoga.getY() +zoga.getPolmer()/2< this.polozaj) { //zoga je visje
			this.polozaj = this.polozaj - Math.min(this.hitrost/7,Math.abs((int)(this.polozaj+zoga.getY())));
		}
		else {
			this.polozaj = this.polozaj + Math.min(this.hitrost/7,Math.abs((int)(this.polozaj-zoga.getY())));
		}
		}
		
	}
	

	public void spremeniAuto() {
		if (this.pc) {
			this.pc = false;
		}
		else {
			this.pc = true;
		}
	}
	
	
/*
	
	public void upocasni() {
		long zacetnicas = System.currentTimeMillis();
		int zacetnahitrost = this.getHitrost();
		this.setHitrost(this.getHitrost() - 25);
		while(true) {
			if (System.currentTimeMillis() - zacetnicas > 5) {
				break;
			}
		this.setHitrost(zacetnahitrost);
		}
		
	}
	
	
	public void pospesi() {
		long zacetnicas = System.currentTimeMillis();
		int zacetnahitrost = this.getHitrost();
		this.setHitrost(this.getHitrost() + 25);
		while(true) {
			if (System.currentTimeMillis() - zacetnicas > 5) {
				break;
			}
		this.setHitrost(zacetnahitrost);
		}
		
	}
		
	
*/	
	
	
	

}
