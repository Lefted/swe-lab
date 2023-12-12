package iwwwdnw.domain.port;

public interface Domain {
	
	/* 
	 * Initialize a game. Choose some players and arrange some figures on the board.
	 * Create a random situation.
	 */
	void init();
	
	Game getGame();

}
