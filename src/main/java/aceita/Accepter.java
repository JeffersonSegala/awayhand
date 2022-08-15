package aceita;

import org.sikuli.script.Screen;

public class Accepter implements Runnable {

	private static Step STEP = Step.IN_QUEUE;
	
	public void run() {
		while (true) {
			Screen screen = new Screen();
			
			checkQueue(screen);
			
			STEP = STEP.doStep(screen);
			
			MainView.stepDescription.setText(STEP.getDescription());
			
			sleep(3000);
		}
	}
	
	private void checkQueue(Screen screen) {
		if (screen.exists(ImagePatterns.queuePattern) != null) {
			STEP = Step.IN_QUEUE;
		}
	}
	
	public void sleep(long mills) {
		try {
		    Thread.sleep(mills);
		} catch (InterruptedException e){
		    Thread.currentThread().interrupt();
		    System.out.println("Thread was interrupted, Failed to complete operation");
		}
	}
	
}
