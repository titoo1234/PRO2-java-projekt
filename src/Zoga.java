import java.util.Random;


public class Zoga {
	private double	x;	
	private double	y;
	private int	polmer;
	private double hitrost;
	private double smerX;
	private double smerY;
	private Frame frame;
	private double koncna;
	Igralec igralec1;
	
	
	public Zoga(double x, double y,  int polmer, double hitrost,double smerX,double smerY,double koncna) {
		this.koncna = koncna/10;
		this.x = x;
		this.y = y;
		this.polmer = polmer;
		this.hitrost = hitrost/10;
		this.smerX = smerX;
		this.smerY = smerY;
	
	}
	public void ustaviZazeni() {
		if (this.getHitrost() != 0.0) {	
			this.setHitrost(0.0);
			}
			else {
//				System.out.print(zoga.getKoncna());
				this.setHitrost(this.getKoncna());	
			}
	}
	

	


	public double getKoncna() {
		return koncna;
	}





	public void setKoncna(int koncna) {
		this.koncna = koncna;
	}





	public Frame getFrame() {
		return frame;
	}





	public void setX(double x) {
		this.x = x;
	}





	public void setY(double y) {
		this.y = y;
	}





	public void setPolmer(int polmer) {
		this.polmer = polmer;
	}





	public void setHitrost(double hitrost) {
		this.hitrost = hitrost;
	}





	public void setSmerX(double smerX) {
		this.smerX = smerX;
	}





	public void setSmerY(double smerY) {
		this.smerY = smerY;
	}





	public void setFrame(Frame frame) {
		this.frame = frame;
	}





	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getPolmer() {
		return polmer;
	}

	public double getHitrost() {
		return hitrost;
	}

	public double getSmerX() {
		return smerX;
	}

	public double getSmerY() {
		return smerY;
	}
	
	public void update() {
//		èe ni nobenih ovir
		this.x = this.x + (double)this.hitrost * this.smerX;
		this.y = this.y + this.hitrost * this.smerY;
	}
	
	public void sprememba(Frame frame,Igralec igralec1,Igralec igralec2) {
//		èe pride do roba se more spremeniti smerX in smerY
		int sirina = frame.sir();
		int visina = frame.vis();
		if (this.x  > sirina - this.polmer - 15) {
			if (this.y > igralec1.getPolozaj()) {
			if (igralec1.getRelVelikost() > Math.abs(this.y - this.polmer -igralec1.getPolozaj()) ) {
				
				this.smerX = -this.getSmerX();
			}	
			}
		
			else {
			if (igralec1.getRelVelikost() > Math.abs(this.y -igralec1.getPolozaj()) ) {
				
				this.smerX = -this.getSmerX();
			}	
			}
		}
		if (this.x < 15 & igralec2.getRelVelikost() > Math.abs(this.y +this.polmer/2 -igralec2.getPolozaj())) {
			this.smerX = -this.getSmerX();
		}
		if (this.x < 0 | this.x > sirina - this.polmer) {
			this.ustaviZazeni();
			int stp1 = new Random().nextBoolean() ? -1 : 1;
			double st1 = stp1*(0.5 + 0.5*Math.random());
			int stp2 = new Random().nextBoolean() ? -1 : 1;
			double st2 = stp2*(Math.sqrt(1-st1*st1));
			this.smerX = st1;
			this.smerY = st2;
			this.setX(sirina/2);
			this.setY(visina/2);
			}
		
		if (this.y < 13 | this.y > visina-this.polmer-90) {
			this.smerY = -this.getSmerY();
	}
	}

}
