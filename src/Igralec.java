import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Igralec {
	int st;
	int hitrost;
	int relVelikost;
	double polozaj;
	boolean pc;
	Zoga zoga;
	private Map<Integer,Boolean> keyMap;

	
	public Igralec(int st,int hitrost,int relVelikost,double polozaj,boolean pc){
		this.pc = pc;
		this.polozaj = polozaj;
		this.st = st;
		this.hitrost = hitrost;
		this.relVelikost = relVelikost;
		keyMap = new HashMap<Integer,Boolean>();
		
		keyMap.put(KeyEvent.VK_UP,false);
		keyMap.put(KeyEvent.VK_DOWN,false);
		keyMap.put(KeyEvent.VK_W,false);
		keyMap.put(KeyEvent.VK_S,false);
		keyMap.put(KeyEvent.VK_SPACE,false);
		
		
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
		if (hitrost > this.hitrost) {
		int max = Math.min(hitrost, 50);
		this.hitrost = max;
		}
		else {int min = Math.max(hitrost, 1);
		this.hitrost = min;
			
		}
	}







	public int getRelVelikost() {
		return relVelikost;
	}







	public void setRelVelikost(int relVelikost) {
		this.relVelikost = relVelikost;
	}







	public double getPolozaj() {
		return polozaj;
	}







	public void setPolozaj(double d) {
		if (d < this.getPolozaj()) {
			this.polozaj = Math.max(d,0);
		}
		else this.polozaj = d;
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
		if (zoga.getY() +zoga.getPolmer()/2 == this.polozaj) {
			
		}
		else if (zoga.getY() +zoga.getPolmer()/2 < this.polozaj) { //zoga je visje
			
			this.polozaj = this.polozaj - Math.min(this.hitrost/7,Math.abs((double)(this.polozaj-zoga.getY())));
		}
		else {
			this.polozaj = this.polozaj + Math.min(this.hitrost/7,Math.abs((double)(this.polozaj-zoga.getY())));
		}
		}
		else {
			
	        
			if(keyMap.get(KeyEvent.VK_UP))
				this.setPolozaj(this.getPolozaj() - this.getHitrost());
			if(keyMap.get(KeyEvent.VK_DOWN))
				this.setPolozaj(this.getPolozaj() - this.getHitrost());
			if(keyMap.get(KeyEvent.VK_S))
				this.setPolozaj(this.getPolozaj() - this.getHitrost());
			if(keyMap.get(KeyEvent.VK_W))
				this.setPolozaj(this.getPolozaj() - this.getHitrost());
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
	
	

	//narobe
//	public void upocasni() {
//		long zacetnicas = System.currentTimeMillis();
//		this.setHitrost(this.getHitrost() - 150);
//		while(true) {
//			if (System.currentTimeMillis() - zacetnicas > 5000) {
//				this.setHitrost(this.getHitrost() + 150);
//				break;
//			}
//		}
//		
//	}
//	
//	
//	public void pospesi() {
//		long zacetnicas = System.currentTimeMillis();
//		this.setHitrost(this.getHitrost() + 150);
//		while(true) {
//			if (System.currentTimeMillis() - zacetnicas > 5000) {
//				break;
//			}
//		this.setHitrost(this.getHitrost() - 150);
//		}
//		
//	}
//		
	

	
	

}
