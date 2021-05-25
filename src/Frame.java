import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Frame extends JFrame{

	Zoga zoga;
	Panel panel;
	JPanel panel2;
	JComboBox<Integer>	sizes;
	JComboBox<Integer>	speeds1;
	JComboBox<Integer>	speeds2;
	Igralec igralec1;
	Igralec igralec2;
	public Rezultat rezultat;
    public Frame(Zoga zoga,Igralec igralec1,Igralec igralec2,Rezultat rezultat, Panel2 panel2) {
    	
        super();
//        setFocusable(true);
        this.panel2 =  new JPanel();
        this.igralec1 = igralec1;
        this.zoga = zoga;
        this.setTitle("Pong");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.rezultat = rezultat;
        

//        this.setPreferredSize(new Dimension(600, 450));
//        Panel    console    = new Panel();
//        add(console,    BorderLayout.CENTER);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setLocation(200, 50);
        this.setResizable(false);
        
        Panel panel = new Panel(zoga,igralec1,igralec2,sizes,rezultat);
        this.panel = panel;
        panel.requestFocus(true);
        
        
        JPanel panel1 = new JPanel();
        
        panel1.add(new JLabel("Hitrost:"));
    	JComboBox<Integer>	speeds1	= new JComboBox<Integer>(new Integer[] {16, 32, 64  });
    	this.speeds1 = speeds1;
    	String vel1 = speeds1.getSelectedItem().toString();
		int s1 =   Integer.parseInt(vel1);
		igralec2.setHitrost(s1);
    	speeds1.addActionListener (new ActionListener () {
    	    public void actionPerformed(ActionEvent e) {
    	    	String vel1 = speeds1.getSelectedItem().toString();
    			int s1 =   Integer.parseInt(vel1);
    			igralec2.setHitrost(s1);
    			panel.requestFocus(true);
    	        
    	    }
    	});
    	panel1.add(speeds1);
        
        
        panel1.add(new JLabel("Velikost žoge:"));
    	JComboBox<Integer>	sizes	= new JComboBox<Integer>(new Integer[] {16,24, 32  });
    	sizes.addActionListener (new ActionListener () {
    	    public void actionPerformed(ActionEvent e) {
    	    	String vel1 = sizes.getSelectedItem().toString();
    			int velikost =   Integer.parseInt(vel1);
    			zoga.setPolmer(velikost);
    			panel.requestFocus(true);
    	    }
    	});
    	panel1.add(sizes);
    	if (igralec2.isPc()) {
    	JCheckBox check1 = new JCheckBox("Igralec1", true);
    	check1.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	igralec2.spremeniAuto();
    	        panel1.repaint();
    	        panel.requestFocus(true);
    	    }
    	});
    	panel1.add(check1);
    	}
    	else {
    	JCheckBox check1 = new JCheckBox("Igralec1", false);
    	check1.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	igralec2.spremeniAuto();
    	        panel1.repaint();
    	        panel.requestFocus(true);
    	    }
    	    
    	});
    	panel1.add(check1);
    	}
    	
    	if (igralec1.isPc()) {
        	JCheckBox check2 = new JCheckBox("Igralec2", true);
        	check2.addActionListener(new ActionListener() {
        	    @Override
        	    public void actionPerformed(ActionEvent e) {
        	    	igralec1.spremeniAuto();
        	        panel1.repaint();
        	        panel.requestFocus(true);
        	    }
        	});
        	panel1.add(check2);
        	}
        	else {
        	JCheckBox check2 = new JCheckBox("Igralec2", false);
        	check2.addActionListener(new ActionListener() {
        	    @Override
        	    public void actionPerformed(ActionEvent e) {
        	    	igralec1.spremeniAuto();
        	        panel1.repaint();
        	        panel.requestFocus(true);
        	    }
        	    
        	});
        	panel1.add(check2);
        	}

    	
    	
    	Color customColor = new Color(200,255,200);
        panel1.setBackground(customColor);
        ImageIcon slika = new ImageIcon("Zajeta2.png");
        
    	JButton button = new JButton(slika);
    	button.setFont(button.getFont().deriveFont(10.0f));
    	button.setPreferredSize(new Dimension(50, 40));
    	
    	
    	button.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	zoga.ustaviZazeni();
    	    	button.setToolTipText("start");
    	    	panel.requestFocus(true);
    	    	if (rezultat.getGol1() == 3 |rezultat.getGol2() == 3) {
    	    		rezultat.reset();
    		        panel2.rez.setText("Igralec 1: " + rezultat.getGol1()+"  Igralec 2: "+ rezultat.getGol2());

    	    		panel.requestFocus(true);
    	    	}
    	    	
    	    	
//    	        repaint();
    	    }
    	});
    	panel1.add(button);
    	
		int sirina = this.sir();
		int visina = this.vis();
    	
    	JButton button2 = new JButton("Reset");
    	button2.setPreferredSize(new Dimension(80, 25));
    	
    	button2.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	if (zoga.getHitrost() != 0) {
    	    		zoga.ustaviZazeni();
    	    	}
    	    	int stp1 = new Random().nextBoolean() ? -1 : 1;
    			double st1 = stp1*(0.5 + 0.5*Math.random());
    			int stp2 = new Random().nextBoolean() ? -1 : 1;
    			double st2 = stp2*(Math.sqrt(1-st1*st1));
    			zoga.setSmerX(st1);
    			zoga.setSmerY(st2);
    			zoga.setX(sirina/2);
    			zoga.setY(350);
    			rezultat.setGol1(0);
    			rezultat.setGol2(0);
    			panel2.rez.setText("Igralec 1: " + rezultat.getGol2()+"  Igralec 2: "+ rezultat.getGol1());
    	    	button2.setToolTipText("reset");
    	    	panel.requestFocus(true);
    	    	
    	    	panel.ikone.clear(); // hitrosti se more nastavit nazaj
    	    	
    	    	
//    	        repaint();
    	    }
    	});
    	panel1.add(button2);
    	
    	
    	JSlider slider = new JSlider(0, 10, 1);
    	slider.addChangeListener(new ChangeListener() {
    		
    		@Override
    	    public void stateChanged(ChangeEvent e) {
    			JSlider source = (JSlider)e.getSource();
    			if (!source.getValueIsAdjusting()) {
    	              int hitrost = (int)source.getValue();
    	              if (zoga.getHitrost() == 0) {
    	            	  zoga.setKoncna(hitrost);
    	            	  //zoga.setHitrost(hitrost); //ta del lahko zakomentirama
    	            	  panel.requestFocus(true);
    	              }
    	              else{
    	            	  zoga.setKoncna(hitrost);
        	              zoga.setHitrost(hitrost);
        	              panel.requestFocus(true);
    	            	  
    	              }
    	              
    	              
    	              
    			}
//    	        panel1.repaint();
    	        
    	    }
    	});
    	panel1.add(slider);
    	
    	panel1.add(new JLabel("Hitrost:"));
    	JComboBox<Integer>	speeds2	= new JComboBox<Integer>(new Integer[] {16, 32, 64  });
    	this.speeds2 = speeds2;
    	String vel2 = speeds2.getSelectedItem().toString();
		int s2 =   Integer.parseInt(vel2);
		igralec1.setHitrost(s2);
    	speeds2.addActionListener (new ActionListener () {
    	    public void actionPerformed(ActionEvent e) {
    	    	String vel1 = speeds2.getSelectedItem().toString();
    			int s2 =   Integer.parseInt(vel1);
    			igralec1.setHitrost(s2);
    			panel.requestFocus(true);
    	        
    	    }
    	});
    	panel1.add(speeds2);
    	
        
    	
    	
//    	while (true) {
//    	    // ...
//    	    try {
//    	        Thread.sleep(slider.getValue());
//    	    } catch (InterruptedException e) {
//    	        e.printStackTrace();
//    	    }
//    	}
        
        add (panel1, BorderLayout.NORTH);
//        JPanel panel2 = new JPanel();
//        JTextField rez = new JTextField();
//        rez.setPreferredSize(new Dimension(140, 30));
//        rez.setText("Igralec 1: " + rezultat.getGol1()+"  Igralec 2: "+ rezultat.getGol2());
//        panel2.repaint();
//        panel2.add(rez);
//        
//        
//        
//        panel2.setBackground(customColor);
        
        add (panel2, BorderLayout.SOUTH);
        
        
        zoga.ustaviZazeni();
        String vel3 = sizes.getSelectedItem().toString();
		int velikost =   Integer.parseInt(vel3);
		zoga.setPolmer(velikost);
		
	
		
		
		
		
        
//        Dimension dim = panel.getSize();
//        double visina1 = dim.getHeight();
        
        
//        panel.addMouseListener(new MouseListener() {
//    		
//    		@Override
//    		public void mouseReleased(MouseEvent e) {
//    			// TODO Auto-generated method stub	
//    		}
//    		@Override	
//    		public void mousePressed(MouseEvent e) {			
//    			String vel1 = sizes.getSelectedItem().toString();
//    			int velikost =   Integer.parseInt(vel1);
//    			zoga.setPolmer(velikost);
//    			
//    			zoga.ustaviZazeni();
//    			
//    			
//    		}
//    		
//    		@Override
//    		public void mouseExited(MouseEvent e) {
//    			// TODO Auto-generated method stub	
//    		}
//    		@Override
//    		public void mouseEntered(MouseEvent e) {
//    			// TODO Auto-generated method stub	
//    		}
//    		@Override
//    		public void mouseClicked(MouseEvent e) {
//    			// TODO Auto-generated method stub
//    			
//    		}
//        
//    	});

//		panel.addKeyListener(new KeyAdapter() 
//		        {
//			public void keyPressed(KeyEvent evt)
//          {panel.requestFocus(true);
//              if(evt.getKeyCode() == KeyEvent.VK_UP)
//              {
////              	String vel1 = sizes.getSelectedItem().toString();
////      			int velikost =   Integer.parseInt(vel1);
////      			zoga.setPolmer(velikost);
////              	zoga.ustaviZazeni();
//              	if (!(igralec1.isPc())){//ni računalnik
//              	igralec1.setPolozaj(igralec1.getPolozaj() - igralec1.getHitrost());
//              	panel1.repaint();
//              	panel.requestFocus(true);
//              	}
//              	
//              	
//              }
//          }
//      });
//      addKeyListener(new KeyAdapter() 
//      {
//          public void keyPressed(KeyEvent evt)
//          
//          {
//              if(evt.getKeyCode() == KeyEvent.VK_DOWN)
//              {
//              	if (!(igralec1.isPc())){
//              	igralec1.setPolozaj(igralec1.getPolozaj() + igralec1.getHitrost());
//              	panel1.repaint();
//              	panel.requestFocus(true);
//              	}
//              	
//              }
//          }
//      });
//      addKeyListener(new KeyAdapter() 
//      {
//          public void keyPressed(KeyEvent evt)
//          {
//              if(evt.getKeyCode() == KeyEvent.VK_W)
//              {
//              	if (!(igralec2.isPc())){
//              	igralec2.setPolozaj(igralec2.getPolozaj() - igralec2.getHitrost());
//              	panel1.repaint();
//              	}
//              	
//              }
//          }
//      });
//      addKeyListener(new KeyAdapter() 
//      {
//          public void keyPressed(KeyEvent evt)
//          {
//              if(evt.getKeyCode() == KeyEvent.VK_S)
//              {
//              	if (!(igralec2.isPc())){
//              	igralec2.setPolozaj(igralec2.getPolozaj() + igralec2.getHitrost());
//              	
//              	panel1.repaint();
//              	}
//              	
//              }
//          }
//      });
		
        add (panel, BorderLayout.CENTER);
        panel.requestFocus(true);
      
    }
    public int vis() {
    	int a = this.getSize().height;
//    	System.out.println(a);
    return a;
    }
    public int sir() {
    	int b = this.getSize().width;
//    	System.out.println(b);
        return b;
    }

    @Override
    public void repaint() {
    	// TODO Auto-generated method stub

    	super.repaint();
    	
        
    }

}
