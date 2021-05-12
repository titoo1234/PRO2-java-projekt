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
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
	Zoga zoga;
	Panel panel;
    public Frame(Zoga zoga) {
        super();
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
        panel1.setBackground(Color.red);
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
        
        add (panel1, BorderLayout.NORTH);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.red);
        add (panel2, BorderLayout.SOUTH);
        
        
        
        Panel panel = new Panel(zoga);
        panel.addMouseListener(new MouseListener() {
    		
    		@Override
    		public void mouseReleased(MouseEvent e) {
    			// TODO Auto-generated method stub	
    		}
    		@Override	
    		public void mousePressed(MouseEvent e) {			
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
                if(evt.getKeyCode() == KeyEvent.VK_SPACE)
                {
                	zoga.ustaviZazeni();
                }
            }
        });
        
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

}
