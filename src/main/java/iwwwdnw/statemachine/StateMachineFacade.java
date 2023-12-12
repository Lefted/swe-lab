package iwwwdnw.statemachine;

import iwwwdnw.statemachine.impl.StateMachineImpl;
import iwwwdnw.statemachine.port.Observer;
import iwwwdnw.statemachine.port.State;
import iwwwdnw.statemachine.port.StateMachine;
import iwwwdnw.statemachine.port.Subject;

public class StateMachineFacade implements StateMachineFactory, StateMachine, Subject{
	
	private StateMachineImpl stateMachine;

	
	@Override
	public synchronized StateMachine stateMachine() {
		if (this.stateMachine == null)
			this.stateMachine = new StateMachineImpl();
		return this;
	}

	@Override
	public synchronized Subject subject() {
		if (this.stateMachine == null)
			this.stateMachine = new StateMachineImpl();
		return this;
	}
	
	
	
	@Override
	public synchronized void attach(Observer obs) {
		this.stateMachine.attach(obs);
		
	}

	@Override
	public synchronized void detach(Observer obs) {
		this.stateMachine.detach(obs);
	}

	@Override
	public synchronized State getState() {
		return this.stateMachine.getState();
	}

	@Override
	public synchronized boolean setState(State state) {
		return this.stateMachine.setState(state);
	}



	

	
	
	

}
