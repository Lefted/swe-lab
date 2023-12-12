package iwwwdnw.domain.port;

import java.util.Set;

public interface Player {
	
	String getName();
	
	int getYearOfBirth();
	
	String getColor();
	
	Set<Figure> allFigures();
	
	Field[] startFields();
	

}
