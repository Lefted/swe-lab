package iwwwdnw;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import iwwwdnw.domain.DomainFactory;
import iwwwdnw.domain.port.Domain;
import iwwwdnw.domain.port.Field;
import iwwwdnw.domain.port.Game;
import iwwwdnw.domain.port.Player;

class InitTest {

	@Test
	void test() {
		Domain domain = DomainFactory.FACTORY.domain();
		domain.init();
		Game game = domain.getGame();

		List<Player> players = game.allPlayers();
		Assertions.assertEquals(3, players.size());
		Set<Field> fields = game.getBoard();
		Assertions.assertTrue(fields.size() > 0);
		for (Field field : fields) {
			Assertions.assertNotNull(field.succ());
			Assertions.assertNotNull(field.pred());
			
			if (field.isJoinField())
				Assertions.assertNotNull(field.neighbor());
			else
				Assertions.assertNull(field.neighbor());
			
			if (field.isStartField())
				Assertions.assertTrue(field.isJoinField());
		}

	}

}
