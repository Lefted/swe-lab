package iwwwdnw.domain;

import iwwwdnw.domain.port.Domain;

public interface DomainFactory {

	DomainFactory FACTORY = new DomainFacade();
	
	Domain domain();
}
