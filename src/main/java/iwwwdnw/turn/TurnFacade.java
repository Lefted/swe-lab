package iwwwdnw.turn;

import java.util.Map;

import iwwwdnw.domain.DomainFactory;
import iwwwdnw.domain.port.Field;
import iwwwdnw.domain.port.Figure;
import iwwwdnw.statemachine.StateMachineFactory;
import iwwwdnw.statemachine.port.State.S;
import iwwwdnw.statemachine.port.StateMachine;
import iwwwdnw.turn.impl.TurnImpl;
import iwwwdnw.turn.port.ITurn;

public class TurnFacade implements TurnFactory, ITurn {

	private TurnImpl turn;
	private StateMachine stateMachine;
	
	@Override
	public ITurn turn() {
		if (this.turn == null) {
			this.stateMachine = StateMachineFactory.FACTORY.stateMachine();
			this.turn = new TurnImpl(stateMachine, DomainFactory.FACTORY.domain());
		}
		return this;
	}

	@Override
	public synchronized void sysop() {
		if (this.stateMachine.getState().isSubStateOf( S.MAKE_A_TURN /* choose right state*/ ))
			this.turn.sysop();
	}

	@Override
	public void wurfeln() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void augensummeVerteilen(Map<Figure, Field> neuePositionen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startfeldAuswaehlen(Field startfeld) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
