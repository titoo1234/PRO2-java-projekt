import java.awt.BorderLayout;
import java.awt.Dimension;

public class PongGlavniProgram {

	public static void main(String[] args) {
		Zoga zoga = new Zoga(16.2,45.2,15,6,6,6);
		System.out.println(zoga.getX());
		Frame okno = new Frame(zoga);
		
		
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
//		        System.out.print(zoga.getX());
		    }
		} catch (InterruptedException e) {
		    // oh someone paused the game
		}
		
		
		
	}

}
