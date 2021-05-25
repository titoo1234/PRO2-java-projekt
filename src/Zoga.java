import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JTextField;


public class Zoga {
	private double	x;	
	private double	y;
	private double	polmer;
	private double hitrost;
	private double smerX;
	private double smerY;
	private Frame frame;
	private double koncna;
	Rezultat rezultat;
	Igralec igralec1;
	Panel2 panel2;
	Panel panel;
	
	
	public Zoga(double x, double y,  double polmer, double hitrost,double smerX,double smerY,double koncna,Rezultat rezultat, Panel2 panel2) {
		this.koncna = koncna/10;
		this.x = x;
		this.y = y;
		this.polmer = polmer;
		this.hitrost = hitrost/10;
		this.smerX = smerX;
		this.smerY = smerY;
		this.panel2 = panel2;
		
		
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

	public double getPolmer() {
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
	
	public void sprememba(Frame frame,Igralec igralec1,Igralec igralec2,Rezultat rezultat) {
//		èe pride do roba se more spremeniti smerX in smerY
		int sirina = frame.sir();
		int visina = frame.vis();
		if (this.x  > sirina - this.polmer - 15) {
			if (this.y > igralec1.getPolozaj()) {
			if (igralec1.getRelVelikost()/2 > Math.abs(this.y - this.polmer -igralec1.getPolozaj()) ) {
				double razdalja = Math.abs(this.y - this.polmer/2 -igralec1.getPolozaj());
				double k = Math.abs((razdalja)/igralec1.getRelVelikost()/2);
				this.smerY =  2*k;
				this.smerX = -Math.sqrt(1-this.smerY*this.smerY);
				
			}	
			}
		
			else {
			if (igralec1.getRelVelikost()/2 > Math.abs(this.y -igralec1.getPolozaj()) ) {
				double razdalja = Math.abs(this.y + this.polmer/2 -igralec1.getPolozaj());
				double k = Math.abs((razdalja)/igralec1.getRelVelikost()/2);
				this.smerY = -2*k ;
				this.smerX = -Math.sqrt(1-this.smerY*this.smerY);
//				this.smerX = -Math.abs(this.getSmerX());
//				this.smerY = Math.sqrt(1-this.smerX*this.smerX);
			}	
			}
		}
		if (this.x < 15) {
			if (this.y > igralec2.getPolozaj()) {
			if(igralec2.getRelVelikost()/2 > Math.abs(this.y +this.polmer -igralec2.getPolozaj())) {
				double razdalja = Math.abs(this.y - this.polmer/2 -igralec2.getPolozaj());
				double k = Math.abs((razdalja)/igralec2.getRelVelikost()/2);
				this.smerY =  2*k;
				this.smerX = Math.sqrt(1-this.smerY*this.smerY);
				
				
				
//				this.smerX = Math.abs(this.getSmerX());
//				this.smerY = Math.sqrt(1-this.smerX*this.smerX);
			}
			}
			else {
				if (igralec2.getRelVelikost()/2 > Math.abs(this.y -igralec2.getPolozaj()) ) {
					double razdalja = Math.abs(this.y - this.polmer/2 -igralec2.getPolozaj());
					double k = Math.abs((razdalja)/igralec2.getRelVelikost()/2);
					this.smerY =  -2*k;
					this.smerX = Math.sqrt(1-this.smerY*this.smerY);
					
//					this.smerX = Math.abs(this.getSmerX());
//					this.smerY = Math.sqrt(1-this.smerX*this.smerX);
				
			}
		}
		}
		
		if (this.x < 0-this.polmer/2 | this.x > sirina - this.polmer) {
			if (this.x < 0-this.polmer/2) {
				rezultat.setGol1(rezultat.getGol1()+1);
//				System.out.print(rezultat.getGol1());
		        JTextField rez = new JTextField();
		        panel2.rez.setText("Igralec 1: " + rezultat.getGol2()+"  Igralec 2: "+ rezultat.getGol1());
//		        rez.setPreferredSize(new Dimension(140, 30));
//		        rez.setText("Igralec 1: " + rezultat.getGol1()+"  Igralec 2: "+ rezultat.getGol2());
		        
		        panel2.add(rez);
		        
			}
			else {
				rezultat.setGol2(rezultat.getGol2()+1);
		        panel2.rez.setText("Igralec 1: " + rezultat.getGol2()+"  Igralec 2: "+ rezultat.getGol1());
		        
//				System.out.print(rezultat.getGol2());
				
			}
			frame.panel.ikone = new ArrayList<Ikona>();
			this.ustaviZazeni();
			int stp1 = new Random().nextBoolean() ? -1 : 1;
			double st1 = stp1*(0.5 + 0.5*Math.random());
			int stp2 = new Random().nextBoolean() ? -1 : 1;
			double st2 = stp2*(Math.sqrt(1-st1*st1));
			this.smerX = st1;
			this.smerY = st2;
			this.setX(sirina/2);
			this.setY(350);
			String vel1 = frame.speeds1.getSelectedItem().toString();
			int s1 =   Integer.parseInt(vel1);
			igralec1.setHitrost(s1);
			String vel2 = frame.speeds2.getSelectedItem().toString();
			int s2 =   Integer.parseInt(vel2);
			igralec2.setHitrost(s2);
			
			
			}
		
		if (this.y < 13 | this.y > visina-this.polmer-140) {
			this.smerY = -this.getSmerY();
	}
	}

}
