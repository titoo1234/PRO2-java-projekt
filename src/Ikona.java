import java.awt.Rectangle;
import java.util.List;

public class Ikona{
	double x;
	double y;
	double stranica;
	int pomen;
	String kateraslika;
	
	
	public Ikona(double x, double y,double stranica,int pomen, String slika) {
		this.x = x;
		this.y = y;
		this.stranica = stranica;
		this.pomen = pomen;
		this.kateraslika = slika;
		
	}

	
	public String getKateraslika() {
		return kateraslika;
	}


	public void setKateraslika(String slika) {
		this.kateraslika = slika;
	}

	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public double getStranica() {
		return stranica;
	}


	public void setStranica(double stranica) {
		this.stranica = stranica;
	}


	public int getPomen() {
		return pomen;
	}


	public void setPomen(int pomen) {
		this.pomen = pomen;
	}
	

	
}
