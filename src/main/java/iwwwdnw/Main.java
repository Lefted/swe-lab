package iwwwdnw;

import iwwwdnw.domain.DomainFactory;
import iwwwdnw.gui.View;
import iwwwdnw.statemachine.StateMachineFactory;
import iwwwdnw.statemachine.port.State.S;
import iwwwdnw.statemachine.port.Subject;
import iwwwdnw.turn.TurnFactory;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello SWE");
		
		DomainFactory.FACTORY.domain().init(); 
		StateMachineFactory.FACTORY.stateMachine().setState(S.START_TURN);
		Subject subject = StateMachineFactory.FACTORY.subject();
		(new View(TurnFactory.FACTORY.turn(),subject)).startEventLoop();
		
	}

}
