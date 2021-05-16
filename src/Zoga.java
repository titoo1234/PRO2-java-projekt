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
//		�e ni nobenih ovir
		this.x = this.x + (double)this.hitrost * this.smerX;
		this.y = this.y + this.hitrost * this.smerY;
	}
	
	public void sprememba(Frame frame) {
//		�e pride do roba se more spremeniti smerX in smerY
		int sirina = frame.sir();
		int visina = frame.vis();
		if (this.x < 0 | this.x > sirina - this.polmer) {
			
			this.ustaviZazeni();
			int stp1 = new Random().nextBoolean() ? -1 : 1;
			double st1 = stp1*(0.5 + 0.5*Math.random());
			int stp2 = new Random().nextBoolean() ? -1 : 1;
			double st2 = stp2*(Math.sqrt(1-st1*st1));
			this.smerX = st1;
			this.smerY = st2;
			this.setX(200);
			this.setY(200);
		}
		if (this.y < 0 | this.y > visina-this.polmer-70) {
			this.smerY = -this.getSmerY();
	}
	}

}
