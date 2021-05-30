
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Panel extends JPanel implements KeyListener{
	Zoga zoga;
	Igralec igralec1;
	Igralec igralec2;
	JComboBox<Integer>	sizes;
	JTextField field;
	JTextField field2;
	Rezultat rezultat;
	Image slika;
	public List<Ikona> ikone;
	List<String> mozneikone = new ArrayList<String>();
	long zacetnicas = System.currentTimeMillis();
	public Panel2 panel2;
	
	
	public Panel(Zoga zoga,Igralec igralec1,Igralec igralec2,JComboBox<Integer>	sizes,Rezultat rezultat,Panel2 panel2) {
		super();
		this.ikone	= new ArrayList<Ikona>();
		this.panel2 = panel2;

		mozneikone.add("zajc36x36red.png");
		mozneikone.add("zajc36x36green.png");
		mozneikone.add("pol36x36red.png");
		mozneikone.add("pol36x36green.png");
		mozneikone.add("odbojgreen36x36.jpg");
		mozneikone.add("odbojred36x36.jpg");


		
		this.requestFocus(true);
	
        setBackground(Color.WHITE);

        this.zoga = zoga;
        this.igralec1 = igralec1;
        this.igralec2 = igralec2;

        this.setFocusable(true);
        this.rezultat = rezultat;
        field = new JTextField(8);
        
        field.setFont(field.getFont().deriveFont(50f));

        this.add(field);
        field2 = new JTextField(8);
      
        field2.setFont(field.getFont().deriveFont(50f));

        this.add(field2);
        this.requestFocus();
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        
        panel = this;
    
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	};
	
	@Override
	public void keyPressed(KeyEvent evt)
    {
		int key = evt.getKeyCode();

        if(key == KeyEvent.VK_UP)
        {
        	if (!(igralec1.isPc())){//ni računalnik
        	igralec1.setPolozaj(igralec1.getPolozaj() - igralec1.getHitrost());
        	repaint();
        	this.requestFocus(true);
        	}
        }
        	if(key == KeyEvent.VK_S)
              {
              	if (!(igralec2.isPc())){
              	igralec2.setPolozaj(Math.min(igralec2.getPolozaj() + igralec2.getHitrost(),panel.getHeight()));
              	this.requestFocus(true);
              	repaint();
              	}
	
        }
        	if(key == KeyEvent.VK_W)
              {
              	if (!(igralec2.isPc())){
              		
	              	igralec2.setPolozaj(igralec2.getPolozaj() - igralec2.getHitrost());
	              	repaint();
	              	this.requestFocus(true);
              	}
              	
              }
        	
        	if(key == KeyEvent.VK_DOWN)
              {
              	if (!(igralec1.isPc())){
              	igralec1.setPolozaj(Math.min(igralec1.getPolozaj() + igralec1.getHitrost(),panel.getHeight()));
              	repaint();
              	this.requestFocus(true);
              	}
              	
              }
        	
        	if(key == KeyEvent.VK_SPACE)
            {
            	zoga.ustaviZazeni();
            	if (panel.rezultat.getGol1() == 3 |panel.rezultat.getGol2() == 3) {
            		panel.rezultat.reset();
    		        panel.panel2.rez.setText("Igralec 1: " + panel.rezultat.getGol1()+"  Igralec 2: "+ panel.rezultat.getGol2());
            	}
            	this.requestFocus(true);
            }
            	
            

    };

    @Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	};
	
	
	
	
	
	Panel panel = this;
    @Override
    public void paint(Graphics g) {
    	super.paint(g); // klic metode nadrazreda

    	Graphics2D graphics = (Graphics2D)g; // pretvarjanje tipov
    	int visina1 = 320;
    	int sirina1 = 130;
    	int sirina2 = 730;
    	if (rezultat.getGol2() == 3) {
    		field.setVisible(true);
    		
			field.setLocation(sirina1, visina1);
    		field.setText("☻ ZMAGA ☻");
    		field2.setVisible(true);
    		
			field2.setLocation(sirina2,visina1);
    		field2.setText("😢 PORAZ 😭");
    	}

    		else if (rezultat.getGol1() == 3) {	
    			field.setVisible(true);
        		
    			field.setLocation(sirina1, visina1);
        		field.setText("😢 PORAZ 😭");
        		field2.setVisible(true);
        		
    			field2.setLocation(sirina2, visina1);
        		field2.setText("☻ ZMAGA ☻");
    			
    	}
    	else {
    		field.setVisible(false);
    		field2.setVisible(false);
    	}
    	for(int i = 0; i < ikone.size() ; i++) {
        	Ikona ikona = ikone.get(i);
        	double x = ikona.getX();
        	double y = ikona.getY();
        	
        	Image slika  = Toolkit.getDefaultToolkit().getImage(ikona.getKateraslika());
        	graphics.drawImage(slika,(int)x-20,(int) y-20,this);

    	}
    	//risanje žoge
    	double x = zoga.getX();
    	double y = zoga.getY();
    	double r = zoga.getPolmer();
        Color barva1 = Color.black;
        graphics.setColor(barva1);
        graphics.drawOval((int)x,(int) y, (int)r, (int)r); 
    	graphics.setColor(Color.BLACK);
    	graphics.setStroke(new BasicStroke(2.0f));
        graphics.fillOval((int)x,(int) y, (int)r, (int)r);
        Dimension dim  = this.getSize();
        //risanje igralcev
        int polozajX = (int) dim.getWidth();
        int polozajY = (int) dim.getHeight();
        int vel = igralec1.relVelikost;
        int sirina = 13;
        graphics.setColor(Color.GRAY);
        graphics.drawRect(polozajX-10, (int)igralec1.getPolozaj()- vel/2, 10, vel);
        graphics.fillRect(polozajX-10, (int)igralec1.getPolozaj()- vel/2, 10, vel);
        int vel2 = igralec2.relVelikost;
        graphics.drawRect(0, (int)igralec2.getPolozaj()- vel2/2, 10, vel);
        graphics.fillRect(0, (int)igralec2.getPolozaj()- vel2/2, 10, vel);
        
        graphics.setColor(Color.black);
        graphics.drawRect(0, 0, polozajX, sirina);
        graphics.fillRect(0, 0, polozajX, sirina);
        
        graphics.drawRect(0, polozajY-sirina, polozajX, sirina);
        graphics.fillRect(0, polozajY-sirina, polozajX, sirina);
        //Delanje novih ikon
        if (zoga.getHitrost() != 0){
		if (System.currentTimeMillis() - zacetnicas > 800) {
			
			double randomx =  (int)(800.0 * Math.random() + 200);
			double randomy =  (int)(600.0 * Math.random() + 25);

			String randomslika = mozneikone.get((int)(mozneikone.size() *	Math.random()));
			Ikona a = new Ikona(randomx, randomy, 10, 4, randomslika);
			panel.ikone.add(a);
				
			zacetnicas = System.currentTimeMillis();
			}
        }
        //preverimo ali je žoga prišla do katere izmed ikon
		for(int i = 0; i < ikone.size() ; i++) {
			double sredisce_zogaX = zoga.getX() + zoga.getPolmer()/2;
			double sredisce_zogaY = zoga.getY() + zoga.getPolmer()/2;
        	Ikona ikona = ikone.get(i);
        	double ikonax = ikona.getX();
        	double ikonay = ikona.getY();

        	double u = (sredisce_zogaX - ikonax) * (sredisce_zogaX - ikonax);
        	double v = (sredisce_zogaY - ikonay) * (sredisce_zogaY - ikonay);
        	double razdalja = Math.sqrt(u + v);
        	//Primerno spremeni latnosti igralne plošče ko pride do ikone
        	if (razdalja < zoga.getPolmer() + 25) {
        		if (ikona.getKateraslika() == "zajc36x36green.png") {
        			if (zoga.getSmerX() > 0) {
        				igralec2.setHitrost(igralec2.getHitrost() + 25);
        				
        			}
        			
        			else igralec1.setHitrost(igralec1.getHitrost() + 25);
        		}
        		if (ikona.getKateraslika() == "zajc36x36red.png") {
        			if (zoga.getSmerX() > 0) {
        				igralec1.setHitrost(igralec1.getHitrost() + 25);
        				
        			}
        			
        			else igralec2.setHitrost(igralec2.getHitrost() + 25);
        		}
        		
        		if (ikona.getKateraslika() == "pol36x36green.png") {
        			if (zoga.getSmerX() > 0) {
        				igralec1.setHitrost(igralec1.getHitrost() - 5);
        			}
        			else igralec2.setHitrost(igralec2.getHitrost() - 5);
        		}
        		
        		if (ikona.getKateraslika() == "pol36x36red.png") {
        			if (zoga.getSmerX() > 0) {
        				igralec2.setHitrost(igralec2.getHitrost() - 5);
        			}
        			else igralec1.setHitrost(igralec1.getHitrost() - 5);
        		}
        		if (ikona.getKateraslika() == "odbojgreen36x36.jpg") {
            		
        			double st1 = (0.5 + 0.5*Math.random());
        			int stp2 = new Random().nextBoolean() ? -1 : 1;
        			double st2 = stp2*(Math.sqrt(1-st1*st1));
        			zoga.setHitrost(zoga.getHitrost()+0.5);
        			
        			if (zoga.getSmerX() > 0) {
	        			zoga.setSmerY(st2);
	        			zoga.setSmerX(st1);
	        			
        			}
        			else {
        				zoga.setSmerY(st2);
	        			zoga.setSmerX(-st1);
        			}
        			
        		}
        			
        		if (ikona.getKateraslika() == "odbojred36x36.jpg") {
        		
        			double st1 = (0.5 + 0.5*Math.random());
        			int stp2 = new Random().nextBoolean() ? -1 : 1;
        			double st2 = stp2*(Math.sqrt(1-st1*st1));
        			zoga.setHitrost(zoga.getHitrost()+0.5);
        			
        			if (zoga.getSmerX() > 0) {
	        			zoga.setSmerY(st2);
	        			zoga.setSmerX(-st1);
        			}
        			else {
        				zoga.setSmerY(st2);
	        			zoga.setSmerX(st1);
        			}
        			
        			
        		}
        		//odstani ikono do katere pride
        		panel.ikone.remove(i);
        		
        		
        	}

        
        
        
    }
    

    }
}