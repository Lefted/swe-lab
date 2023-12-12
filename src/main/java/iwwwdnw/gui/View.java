package iwwwdnw.gui;

import iwwwdnw.statemachine.port.Observer;
import iwwwdnw.statemachine.port.State;
import iwwwdnw.statemachine.port.Subject;
import iwwwdnw.turn.port.ITurn;

public class View implements Observer {

	private State currentState;
	private Controller controller;
	private Subject subject;
	private ITurn model;
	private boolean running = true;

	public View(ITurn turn, Subject subject) {
		this.model = turn;
		this.subject = subject;
		this.subject.attach(this);
		this.controller = new Controller(this, this.model, this.subject);
	}

	public void startEventLoop() {
		while (running) {
			this.display();
			this.controller.doit();
		}
	}

	void display() {
		/* Display the situation as shown in your mock-up. */
		System.out.println(String.format("Sate %s%nStituation is...", this.currentState.toString()));
	}

	void show(String instruction) {
		/* Display the instructions given by the controller. */
		System.out.println(String.format("Do: %s", instruction));
	}

	void stop() {
		this.running = false;
	}

	@Override
	public void update(State newState) {
		this.currentState = newState;
	}

}
