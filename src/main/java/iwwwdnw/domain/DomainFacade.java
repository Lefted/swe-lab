package iwwwdnw.domain;

import iwwwdnw.domain.impl.DomainImpl;
import iwwwdnw.domain.port.Domain;
import iwwwdnw.domain.port.Game;

public class DomainFacade implements DomainFactory, Domain{

	
	private DomainImpl domain = new DomainImpl();
	
	
	@Override
	public synchronized Domain domain() {
		if (this.domain == null)
				this.domain = new DomainImpl();
			return this;
		}

	@Override
	public synchronized void init() {
		this.domain.init();
	}


	@Override
	public synchronized Game getGame() {
		return this.domain.getGame();
	}


}
