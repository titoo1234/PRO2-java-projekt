import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Panel extends JPanel {
	Zoga zoga;
	Igralec igralec1;
	Igralec igralec2;
	public Panel(Zoga zoga,Igralec igralec1,Igralec igralec2) {
		super();
		
        setBackground(Color.WHITE);
        Dimension dim  = this.getSize();
        int polozajY = (int) dim.getHeight()/2;
        igralec1.setPolozaj(polozajY/2);
        igralec2.setPolozaj(polozajY/2);
        this.zoga = zoga;
        this.igralec1 = igralec1;
        this.igralec2 = igralec2;

	}
    @Override
    public void paint(Graphics g) {
    	super.paint(g); // klic metode nadrazreda

    	Graphics2D graphics = (Graphics2D)g; // pretvarjanje tipov
    	int indent = 32, size = 96; // pomožne spremenljivke
    	double x = zoga.getX();
    	double y = zoga.getY();
    	int r = zoga.getPolmer();
        Color barva1 = Color.black;
        graphics.setColor(barva1);
        graphics.drawOval((int)x,(int) y, r, r);    	
    	graphics.setColor(Color.BLACK);
    	graphics.setStroke(new BasicStroke(2.0f));
        graphics.fillOval((int)x,(int) y, r, r);
        Dimension dim  = this.getSize();
        
        int polozajX = (int) dim.getWidth();
        int polozajY = (int) dim.getHeight();
        int vel = igralec1.relVelikost;
        
        graphics.drawRect(polozajX-10, igralec1.getPolozaj()- vel/2, 10, vel);
        graphics.fillRect(polozajX-10, igralec1.getPolozaj()- vel/2, 10, vel);
        
        graphics.drawRect(0, igralec2.getPolozaj()- vel/2, 10, vel);
        graphics.fillRect(0, igralec2.getPolozaj()- vel/2, 10, vel);
        
        
    }


}