
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
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
//	List<Integer> ig1_hitrosti = new ArrayList<Integer>();
//	List<Double> ig1_cas = new ArrayList<Double>();
	
	private Map<Integer,Boolean> keyMap;
	
	
	public Panel(Zoga zoga,Igralec igralec1,Igralec igralec2,JComboBox<Integer>	sizes,Rezultat rezultat) {
		super();
		this.ikone	= new ArrayList<Ikona>();
//		this.ikone = ikone;


//		mozneikone.add("odboj36x36.png");
		mozneikone.add("zajc36x36red.png");
		mozneikone.add("zajc36x36green.png");
		mozneikone.add("pol36x36red.png");
		mozneikone.add("pol36x36green.png");
//		mozneikone.add("odbojblue36x36.jpg");
		mozneikone.add("odbojgreen36x36.jpg");
		mozneikone.add("odbojred36x36.jpg");
		
		
		
		
			keyMap = new HashMap<Integer,Boolean>();
			
			keyMap.put(KeyEvent.VK_UP,false);
			keyMap.put(KeyEvent.VK_DOWN,false);
			keyMap.put(KeyEvent.VK_LEFT,false);
			keyMap.put(KeyEvent.VK_RIGHT,false);
			keyMap.put(KeyEvent.VK_SPACE,false);

		
		


		
		
//		Ikona ikona = new Ikona(x1,y1,10,4, slika);
	//	panel.ikone.add(ikona);
//		Ikona a = new Ikona(600, 400, 10, 4, "zajc36x36.png");
	//	this.ikone.add(a);
		
		this.requestFocus(true);
	
        setBackground(Color.WHITE);
        Dimension dim  = this.getSize();
        int polozajY = (int) dim.getHeight()/2;

        this.zoga = zoga;
//        zoga.setX(this.getWidth()/2);
//        zoga.setY(this.getHeight()/2);
        this.igralec1 = igralec1;
        this.igralec2 = igralec2;

        this.setFocusable(true);
        this.rezultat = rezultat;
        field = new JTextField(8);
//        field.setBounds(500, 5, 280, 50); // to get height, set large font
        
        field.setFont(field.getFont().deriveFont(50f));
//        field.setVisible(false);
        this.add(field);
        field2 = new JTextField(8);
//      field.setBounds(500, 5, 280, 50); // to get height, set large font
      
        field2.setFont(field.getFont().deriveFont(50f));
//      field.setVisible(false);
        this.add(field2);
        this.requestFocus();
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        
//        ImageIcon slika = new ImageIcon("Zajeta2.png");
        panel = this;
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
    			
//    			zoga.ustaviZazeni();
//    			double x =  e.getX();
//    			double y =  e.getY();
//    			String slika = mozneikone.get((int)(2.0 *	Math.random()));
//    			
//    			
//    			
//    			Ikona ikona = new Ikona(x,y,10,4, slika);
//    			panel.ikone.add(ikona);
//    			
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
    {
        if(evt.getKeyCode() == KeyEvent.VK_UP)
        {
//        	String vel1 = sizes.getSelectedItem().toString();
//			int velikost =   Integer.parseInt(vel1);
//			zoga.setPolmer(velikost);
//        	zoga.ustaviZazeni();
        	if (!(igralec1.isPc())){//ni računalnik
        	igralec1.setPolozaj(igralec1.getPolozaj() - igralec1.getHitrost());
//        	System.out.print("asd");
        	repaint();
        	this.requestFocus(true);
        	}
        }
        	if(evt.getKeyCode() == KeyEvent.VK_S)
              {
              	if (!(igralec2.isPc())){
              	igralec2.setPolozaj(Math.min(igralec2.getPolozaj() + igralec2.getHitrost(),panel.getHeight()));
              	this.requestFocus(true);
              	repaint();
              	}
	
        }
        	if(evt.getKeyCode() == KeyEvent.VK_W)
              {
              	if (!(igralec2.isPc())){
              		
	              	igralec2.setPolozaj(igralec2.getPolozaj() - igralec2.getHitrost());
	              	repaint();
	              	this.requestFocus(true);
              	}
              	
              }
        	
        	if(evt.getKeyCode() == KeyEvent.VK_DOWN)
              {
              	if (!(igralec1.isPc())){
              	igralec1.setPolozaj(Math.min(igralec1.getPolozaj() + igralec1.getHitrost(),panel.getHeight()));
              	repaint();
              	this.requestFocus(true);
              	}
              	
              }
        	
        	if(evt.getKeyCode() == KeyEvent.VK_SPACE)
            {
            	zoga.ustaviZazeni();
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
//    		setBackground(shadow);
//    		((Graphics2D) g).setComposite(AlphaComposite.SrcOver.derive(0.2f));
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
        	
//        	int vel = (int) ikona.getStranica(); 

//        	graphics.fillOval((int)x,(int) y,vel, vel);
        	
        	//tukaj morma najdit prave slike....
        	// ko pritisnema reset morma zbrisat use ikone... tud ko se zaleti v kakaega
        	Image slika  = Toolkit.getDefaultToolkit().getImage(ikona.getKateraslika());
        	graphics.drawImage(slika,(int)x-20,(int) y-20,this);

    	}
    		
    	double x = zoga.getX();
    	double y = zoga.getY();
    	double r = zoga.getPolmer();
        Color barva1 = Color.black;
        graphics.setColor(barva1);
        graphics.drawOval((int)x,(int) y, (int)r, (int)r); 
//        graphics.drawOval(100,100, 100, 100); 
//        graphics.drawOval(0,0, 100, 100); 
    	graphics.setColor(Color.BLACK);
    	graphics.setStroke(new BasicStroke(2.0f));
        graphics.fillOval((int)x,(int) y, (int)r, (int)r);
        Dimension dim  = this.getSize();
        
        int polozajX = (int) dim.getWidth();
        int polozajY = (int) dim.getHeight();
        int vel = igralec1.relVelikost;
        //risanje robov
        int sirina = 13;
      //risanje igralcev
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
        
        if (zoga.getHitrost() != 0){
		if (System.currentTimeMillis() - zacetnicas > 300) {
			
			double randomx =  (int)(800.0 * Math.random() + 200);
			double randomy =  (int)(600.0 * Math.random() + 25);

			String randomslika = mozneikone.get((int)(mozneikone.size() *	Math.random()));
			Ikona a = new Ikona(randomx, randomy, 10, 4, randomslika);
			panel.ikone.add(a);
				
			zacetnicas = System.currentTimeMillis();
			}
        }

		for(int i = 0; i < ikone.size() ; i++) {
			double sredisce_zogaX = zoga.getX() + zoga.getPolmer()/2;
			double sredisce_zogaY = zoga.getY() + zoga.getPolmer()/2;
        	Ikona ikona = ikone.get(i);
        	double ikonax = ikona.getX();
        	double ikonay = ikona.getY();
//        	System.out.println(i);
//        	System.out.println(ikonax);
//        	System.out.println(sredisce_zogaX);
        	//double razdalja = (sredisce_zogaX - ikonax)(sredisce_zogaX - ikonax) + (sredisce_zogaY - ikonay)(sredisce_zogaY - ikonay);
        	
//        	if (Math.sqrt((sredisce_zogaX - ikonax) + (sredisce_zogaY - ikonay)) < zoga.getPolmer() + 25) {
//        		break;
//        	}

        	double u = (sredisce_zogaX - ikonax) * (sredisce_zogaX - ikonax);
        	double v = (sredisce_zogaY - ikonay) * (sredisce_zogaY - ikonay);
        	double razdalja = Math.sqrt(u + v);
        	
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
//        			this.smerX = st1;
//        			this.smerY = st2;
//        			double st1 = (0.5 + 0.5*Math.random();
//        			zoga.setSmerY(st1); // lahk nardima vec moznih odbojev, tut za x smer alpa random kaj
        			
        			
        		}
        		
        		panel.ikone.remove(i);
        		
        		
        	}

        
        
        
    }
    

    }
}