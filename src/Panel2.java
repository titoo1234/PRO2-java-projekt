import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel2 extends JPanel {
	
	Rezultat rezultat;
	Color customColor = new Color(200,255,200);
	
	public Panel2(Rezultat rezultat) {
		
        JTextField rez = new JTextField();
        rez.setPreferredSize(new Dimension(140, 30));
        rez.setText("Igralec 1: " + rezultat.getGol1()+"  Igralec 2: "+ rezultat.getGol2());
        
        this.add(rez);
        
        
        this.setBackground(customColor);
		
	}
	
    @Override
    public void paint(Graphics g) {
    	super.paint(g);
    	
    }

}
