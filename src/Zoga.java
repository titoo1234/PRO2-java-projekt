
public class Zoga {
	private double	x;	
	private double	y;
	private int	polmer;
	private double hitrost;
	private int smerX;
	private int smerY;
	private Frame frame;
	private double koncna;
	
	
	public Zoga(double x, double y,  int polmer, double hitrost,int smerX,int smerY,double koncna) {
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





	public void setSmerX(int smerX) {
		this.smerX = smerX;
	}





	public void setSmerY(int smerY) {
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

	public int getSmerX() {
		return smerX;
	}

	public int getSmerY() {
		return smerY;
	}
	
	public void update() {
//		èe ni nobenih ovir
		this.x = this.x + this.hitrost * this.smerX;
		this.y = this.y + this.hitrost * this.smerY;
	}
	
	public void sprememba(Frame frame) {
//		èe pride do roba se more spremeniti smerX in smerY
		int sirina = frame.sir();
		int visina = frame.vis();
		if (this.x < 0 | this.x > sirina - 2*this.polmer) {
			this.smerX = -this.getSmerX();
		}
		if (this.y < 0 | this.y > visina-70) {
			this.smerY = -this.getSmerY();
	}
	}

}
