package iwwwdnw.domain.port;

public interface Figure {
	
	/* 
	 * The field the figure is placed on. If the figure is at home, "null" is returned.
	 */
	Field getField();
	
	String getColor();
	
	void aufStartfeldBewegen(Field startfeld);
}
