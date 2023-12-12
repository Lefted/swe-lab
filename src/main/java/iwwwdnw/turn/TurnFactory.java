package iwwwdnw.turn;

import iwwwdnw.turn.port.ITurn;

public interface TurnFactory {
	
	TurnFactory FACTORY = new TurnFacade();
	ITurn turn();

}
