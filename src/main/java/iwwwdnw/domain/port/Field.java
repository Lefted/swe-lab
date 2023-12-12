package iwwwdnw.domain.port;

import java.util.Set;

public interface Field {
	
	/* Each field has a unique id. */
	
	int getId();
	
	boolean isStartField();
	boolean isJoinField();
	
	/* 
	 * Each field has a unique successor and a unique predecessor. 
	 * Start and join fields also have a unique neighbor.
	 */
	Field succ();
	Field pred();
	Field neighbor();
	
	/*
	 * Maybe there is a situation where several figures are standing on one field. 
	 */
	Set<Figure> allFigures();

}
