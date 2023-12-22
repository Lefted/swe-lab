package iwwwdnw.domain.port;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Game {
	
	List<Player> allPlayers();
	
	Set<Field> getBoard();
	
	void aufNeuePositionenBewegen(Map<Figure, Field> neuePositionen);
}
