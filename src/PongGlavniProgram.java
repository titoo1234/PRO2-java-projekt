import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Random;

public class PongGlavniProgram {

	public static void main(String[] args) {
		Rezultat rezultat = new Rezultat();
		Panel2 panel2 = new Panel2(rezultat);
		int stp1 = new Random().nextBoolean() ? -1 : 1;
		double st1 = stp1*(0.5 + 0.5*Math.random());
		int stp2 = new Random().nextBoolean() ? -1 : 1;
		double st2 = stp2*(Math.sqrt(1-st1*st1));
//		Igralec igralec1 = new Igralec(1,2,50);
		Igralec igralec1 = new Igralec(1,30,100,10,false);
		Igralec igralec2 = new Igralec(1,20,100,10,false);
		Zoga zoga = new Zoga(200,200.20,20,50,st1,st2,50,rezultat, panel2);
		Frame okno = new Frame(zoga,igralec1,igralec2,rezultat, panel2);
		okno.setVisible(true);
		okno.setFocusable(true);
		int i = okno.getHeight();
		System.out.print(i);
//		int i = okno.BorderLayout.CENTER.HEIGHT;
		
		double desiredFPS = 50d;
		long sleep = (long) (GameTimer.ONE_SECOND / desiredFPS);
		GameTimer timer = new GameTimer();
		
		timer.start();
		try {
		    while(true){
		    	

		        // tick and print fps
		        timer.tick();
//		        System.out.println(timer.getFPS());

		        // input, update and draw (abstract methods of my engine class)
		        
		        igralec1.update(zoga);
		        igralec2.update(zoga);
		        zoga.update();
		        
		        zoga.sprememba(okno,igralec1,igralec2,rezultat);
		        okno.repaint();
//		        okno.panel2.repaint();
		        

		        // sleep
		        long wake = System.nanoTime() + sleep - timer.tock();
		        do {Thread.sleep(0);}
		        while (System.nanoTime() < wake);

		    }
		} catch (InterruptedException e) {
		    // oh someone paused the game
		}
		
	}

}
