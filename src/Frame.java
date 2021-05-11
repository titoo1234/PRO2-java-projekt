import java.awt.BorderLayout;
import java.awt.Dimension;

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
        Panel panel = new Panel(zoga);
        this.panel = panel;
        add (panel, BorderLayout.CENTER);
        JPanel panel1 = new JPanel();
        add (panel1, BorderLayout.NORTH);
        JPanel panel2 = new JPanel();
        add (panel2, BorderLayout.SOUTH);
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
