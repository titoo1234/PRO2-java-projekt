import javax.swing.JPanel;

public class Rezultat {
	int gol1;
	int gol2;
	JPanel panel2;
	public Rezultat() {
		this.gol1 = 0;
		this.gol2 = 0;
		
		
	}

	public int getGol1() {
		return gol1;
	}



	public void setGol1(int gol1) {
		this.gol1 = gol1;

	}



	public int getGol2() {
		return gol2;
	}



	public void setGol2(int gol2) {
		this.gol2 = gol2;

	}



	public void reset() {
		this.gol1 = 0;
		this.gol2 = 0;
 }
}
