import java.awt.Rectangle;
import java.util.List;

public class Ikona{
	double x;
	double y;
	double stranica;
	int pomen;
	
	
	public Ikona(double x, double y,double stranica,int pomen) {
		this.x = x;
		this.y = y;
		this.stranica = stranica;
		this.pomen = pomen; // �e 1-> hitrost zoge; 2-> ovira 3-> upo�asni tekmovalca
//		(naredi v igralcu metodo upo�asni ki dela za 5 s...)
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
