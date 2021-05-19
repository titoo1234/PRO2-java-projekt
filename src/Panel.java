import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Panel extends JPanel implements KeyListener{
	Zoga zoga;
	Igralec igralec1;
	Igralec igralec2;
	JComboBox<Integer>	sizes;
	public Panel(Zoga zoga,Igralec igralec1,Igralec igralec2,JComboBox<Integer>	sizes) {
		super();
		
        setBackground(Color.WHITE);
        Dimension dim  = this.getSize();
        int polozajY = (int) dim.getHeight()/2;

        this.zoga = zoga;
//        zoga.setX(this.getWidth()/2);
//        zoga.setY(this.getHeight()/2);
        this.igralec1 = igralec1;
        this.igralec2 = igralec2;
        igralec1.setPolozaj(polozajY/2);
        igralec2.setPolozaj(polozajY/2);
        this.setFocusable(true);

addMouseListener(new MouseListener() {
	
    		
    		@Override
    		public void mouseReleased(MouseEvent e) {
    			// TODO Auto-generated method stub	
    		}
    		@Override	
    		public void mousePressed(MouseEvent e) {
    			
//    			String vel1 = sizes.getSelectedItem().toString();
//    			int velikost =   Integer.parseInt(vel1);
//    			zoga.setPolmer(velikost);
//    			
//    			zoga.ustaviZazeni();
    			
    			
    		}
    		
    		@Override
    		public void mouseExited(MouseEvent e) {
    			// TODO Auto-generated method stub	
    		}
    		@Override
    		public void mouseEntered(MouseEvent e) {
    			// TODO Auto-generated method stub	
    		}
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			// TODO Auto-generated method stub
    			
    		}
        
    	});

		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			

			
    
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	};

	@Override
	public void keyPressed(KeyEvent evt)
    {System.out.print("asd");
        if(evt.getKeyCode() == KeyEvent.VK_UP)
        {System.out.print("asd");
//        	String vel1 = sizes.getSelectedItem().toString();
//			int velikost =   Integer.parseInt(vel1);
//			zoga.setPolmer(velikost);
//        	zoga.ustaviZazeni();
        	if (!(igralec1.isPc())){//ni raèunalnik
        	igralec1.setPolozaj(igralec1.getPolozaj() - igralec1.getHitrost());
        	System.out.print("asd");
        	repaint();
        	}
        }
        	if(evt.getKeyCode() == KeyEvent.VK_S)
              {
              	if (!(igralec2.isPc())){
              	igralec2.setPolozaj(igralec2.getPolozaj() + igralec2.getHitrost());
              	
              	repaint();
              	}
	
        }
        	if(evt.getKeyCode() == KeyEvent.VK_W)
              {
              	if (!(igralec2.isPc())){
              	igralec2.setPolozaj(igralec2.getPolozaj() - igralec2.getHitrost());
              	repaint();
              	}
              	
              }
        	
        	if(evt.getKeyCode() == KeyEvent.VK_DOWN)
              {
              	if (!(igralec1.isPc())){
              	igralec1.setPolozaj(igralec1.getPolozaj() + igralec1.getHitrost());
              	repaint();
              	}
              	
              }

    };

    @Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	};
	
	
	
	
	
	
    @Override
    public void paint(Graphics g) {
    	super.paint(g); // klic metode nadrazreda

    	Graphics2D graphics = (Graphics2D)g; // pretvarjanje tipov
    	
    	double x = zoga.getX();
    	double y = zoga.getY();
    	int r = zoga.getPolmer();
        Color barva1 = Color.black;
        graphics.setColor(barva1);
        graphics.drawOval((int)x,(int) y, r, r); 
//        graphics.drawOval(100,100, 100, 100); 
//        graphics.drawOval(0,0, 100, 100); 
    	graphics.setColor(Color.BLACK);
    	graphics.setStroke(new BasicStroke(2.0f));
        graphics.fillOval((int)x,(int) y, r, r);
        Dimension dim  = this.getSize();
        
        int polozajX = (int) dim.getWidth();
        int polozajY = (int) dim.getHeight();
        int vel = igralec1.relVelikost;
        //risanje robov
        int sirina = 13;
      //risanje igralcev
        graphics.setColor(Color.GRAY);
        graphics.drawRect(polozajX-10, igralec1.getPolozaj()- vel/2, 10, vel);
        graphics.fillRect(polozajX-10, igralec1.getPolozaj()- vel/2, 10, vel);
        int vel2 = igralec2.relVelikost;
        graphics.drawRect(0, igralec2.getPolozaj()- vel2/2, 10, vel);
        graphics.fillRect(0, igralec2.getPolozaj()- vel2/2, 10, vel);
        
        graphics.setColor(Color.black);
        graphics.drawRect(0, 0, polozajX, sirina);
        graphics.fillRect(0, 0, polozajX, sirina);
        
        graphics.drawRect(0, polozajY-sirina, polozajX, sirina);
        graphics.fillRect(0, polozajY-sirina, polozajX, sirina);
      
        
        
    }


}