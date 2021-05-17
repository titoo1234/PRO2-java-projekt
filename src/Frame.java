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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Frame extends JFrame{

	Zoga zoga;
	Panel panel;
	JComboBox<Integer>	sizes;
	Igralec igralec1;
	Igralec igralec2;
    public Frame(Zoga zoga,Igralec igralec1,Igralec igralec2) {
        super();
        this.igralec1 = igralec1;
        this.zoga = zoga;
        this.setTitle("Pong");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);

//        this.setPreferredSize(new Dimension(600, 450));
//        Panel    console    = new Panel();
//        add(console,    BorderLayout.CENTER);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setLocation(20, 20);
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Velikost:"));
    	JComboBox<Integer>	sizes	= new JComboBox<Integer>(new Integer[] { 10,16, 32, 64  });
    	sizes.addActionListener (new ActionListener () {
    	    public void actionPerformed(ActionEvent e) {
    	    	String vel1 = sizes.getSelectedItem().toString();
    			int velikost =   Integer.parseInt(vel1);
    			zoga.setPolmer(velikost);
    	        
    	    }
    	});
    	panel1.add(sizes);
    	JCheckBox check1 = new JCheckBox("Igralec1", true);
    	check1.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	igralec1.spremeniAuto();
    	        panel1.repaint();
    	    }
    	});
    	panel1.add(check1);
    	JCheckBox check2 = new JCheckBox("Igralec2", true);
    	check2.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	igralec2.spremeniAuto();
    	        panel1.repaint();
    	    }
    	});
    	panel1.add(check2);
    	
    	
    	Color customColor = new Color(200,255,200);
        panel1.setBackground(customColor);
    	JButton button = new JButton("Pause/Start");
    	button.setPreferredSize(new Dimension(80, 15));
    	
    	button.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	zoga.ustaviZazeni();
    	    	button.setToolTipText("start");
    	    	
    	    	
//    	        repaint();
    	    }
    	});
    	panel1.add(button);
    	JSlider slider = new JSlider(0, 10, 1);
    	slider.addChangeListener(new ChangeListener() {
    		
    		@Override
    	    public void stateChanged(ChangeEvent e) {
    			JSlider source = (JSlider)e.getSource();
    			if (!source.getValueIsAdjusting()) {
    	              int hitrost = (int)source.getValue();
    	              if (zoga.getHitrost() == 0) {
    	            	  zoga.setKoncna(hitrost);
    	            	  zoga.setHitrost(hitrost); //ta del lahko zakomentirama
    	              }
    	              else{
    	            	  zoga.setKoncna(hitrost);
        	              zoga.setHitrost(hitrost);
    	            	  
    	              }
    	              
    	              
    			}
//    	        panel1.repaint();
    	        
    	    }
    	});
    	panel1.add(slider);
    	
    	
//    	while (true) {
//    	    // ...
//    	    try {
//    	        Thread.sleep(slider.getValue());
//    	    } catch (InterruptedException e) {
//    	        e.printStackTrace();
//    	    }
//    	}
        
        add (panel1, BorderLayout.NORTH);
        JPanel panel2 = new JPanel();
        panel2.setBackground(customColor);
        add (panel2, BorderLayout.SOUTH);
        
        zoga.ustaviZazeni();
        String vel1 = sizes.getSelectedItem().toString();
		int velikost =   Integer.parseInt(vel1);
		zoga.setPolmer(velikost);
		
		
		
		
		
		
        Panel panel = new Panel(zoga,igralec1,igralec2);
        Dimension dim = panel.getSize();
        double visina = dim.getHeight();
        
        panel.addMouseListener(new MouseListener() {
    		
    		@Override
    		public void mouseReleased(MouseEvent e) {
    			// TODO Auto-generated method stub	
    		}
    		@Override	
    		public void mousePressed(MouseEvent e) {			
    			String vel1 = sizes.getSelectedItem().toString();
    			int velikost =   Integer.parseInt(vel1);
    			zoga.setPolmer(velikost);
    			
    			zoga.ustaviZazeni();
    			
    			
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
        addKeyListener(new KeyAdapter() 
        {
            public void keyPressed(KeyEvent evt)
            {
                if(evt.getKeyCode() == KeyEvent.VK_UP)
                {
//                	String vel1 = sizes.getSelectedItem().toString();
//        			int velikost =   Integer.parseInt(vel1);
//        			zoga.setPolmer(velikost);
//                	zoga.ustaviZazeni();
                	if (!(igralec1.isPc())){//ni raèunalnik
                	igralec1.setPolozaj(igralec1.getPolozaj() - igralec1.getHitrost());
                	panel1.repaint();
                	}
                	
                	
                }
            }
        });
        addKeyListener(new KeyAdapter() 
        {
            public void keyPressed(KeyEvent evt)
            {
                if(evt.getKeyCode() == KeyEvent.VK_DOWN)
                {
                	if (!(igralec1.isPc())){
                	igralec1.setPolozaj(igralec1.getPolozaj() + igralec1.getHitrost());
                	panel1.repaint();
                	}
                	
                }
            }
        });
//        
        add (panel, BorderLayout.CENTER);
        
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
