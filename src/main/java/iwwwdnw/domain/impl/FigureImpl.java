package iwwwdnw.domain.impl;

import iwwwdnw.domain.port.Field;
import iwwwdnw.domain.port.Figure;

public class FigureImpl  implements Figure{

	private FieldImpl field;
	private PlayerImpl player;
	
	public FigureImpl(PlayerImpl player) {
		this.player = player;
	}

	@Override
	public Field getField() {
		return this.field;
	}

	@Override
	public String getColor() {
		return this.player.getColor();
	}

}
