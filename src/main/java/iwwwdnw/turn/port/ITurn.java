package iwwwdnw.turn.port;

import java.util.Map;

import iwwwdnw.domain.port.Field;
import iwwwdnw.domain.port.Figure;

public interface ITurn {
	
	void sysop();
	
	void wurfeln();

	void augensummeVerteilen(Map<Figure, Field> neuePositionen);
	
	void startfeldAuswaehlen(Field startfeld);
}
