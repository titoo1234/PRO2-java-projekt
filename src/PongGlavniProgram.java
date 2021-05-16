import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Random;

public class PongGlavniProgram {

	public static void main(String[] args) {
		int stp1 = new Random().nextBoolean() ? -1 : 1;
		double st1 = stp1*(0.5 + 0.5*Math.random());
		int stp2 = new Random().nextBoolean() ? -1 : 1;
		double st2 = stp2*(Math.sqrt(1-st1*st1));
//		System.out.print(st1);
//		System.out.print(st2);
		
		
//		System.out.println(vel1);

		

		Zoga zoga = new Zoga(200,200.20,20,60,st1,st2,60);
		System.out.println(zoga.getX());
		Frame okno = new Frame(zoga);
		okno.setVisible(true);
		
		
		
		
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
		        zoga.update();
		        zoga.sprememba(okno);
		        okno.repaint();

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
