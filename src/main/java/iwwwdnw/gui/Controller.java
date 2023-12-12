package iwwwdnw.gui;

import iwwwdnw.statemachine.port.Observer;
import iwwwdnw.statemachine.port.State;
import iwwwdnw.statemachine.port.Subject;
import iwwwdnw.turn.port.ITurn;

public class Controller implements Observer {

	private View myView;
	private Subject subject;
	private ITurn myModel;

	public Controller(View view, ITurn model, Subject subject) {
		this.myView = view;
		this.myModel = model;
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update(State currentState) {
		/* maybe there is something to do */
	}

	public void doit() {
		this.myView.show("need input!" );
		int x = 1; /* read input */
		switch (x) {
		case 1  :
			this.myModel.sysop();
			break;
		case -1  :
			this.myView.stop();
			break;
		default:
			;
		}

		// TODO Auto-generated method stub

	}

}
