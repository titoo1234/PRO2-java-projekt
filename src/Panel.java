import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel {
	Zoga zoga;
	public Panel(Zoga zoga) {
		super();
        setBackground(Color.WHITE);
        this.zoga = zoga;
	}
    @Override
    public void paint(Graphics g) {
    	super.paint(g); // klic metode nadrazreda

    	Graphics2D graphics = (Graphics2D)g; // pretvarjanje tipov
    	int indent = 32, size = 96; // pomožne spremenljivke
    	double x = zoga.getX();
    	double y = zoga.getY();
    	int r = zoga.getPolmer();
    	graphics.setColor(Color.BLACK);
    	graphics.setStroke(new BasicStroke(2.0f));
        graphics.fillOval((int)x,(int) y, r, r);
        Color barva1 = Color.black;
        graphics.setColor(barva1);
        graphics.drawOval((int)x,(int) y, r, r);
        
    }

}