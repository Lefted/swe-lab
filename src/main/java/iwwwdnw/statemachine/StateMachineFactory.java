package iwwwdnw.statemachine;

import iwwwdnw.statemachine.port.StateMachine;
import iwwwdnw.statemachine.port.Subject;

public interface StateMachineFactory {
	
	StateMachineFactory FACTORY = new StateMachineFacade();
	
	StateMachine stateMachine();

	Subject subject();


}
