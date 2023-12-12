package iwwwdnw.domain.impl;

import java.util.HashSet;
import java.util.Set;

import iwwwdnw.domain.port.Field;
import iwwwdnw.domain.port.Figure;

public class FieldImpl implements Field {

	private boolean isSartField;
	private boolean isJoinField;
	private int id;
	
	private FieldImpl successor;
	private FieldImpl predecessor;
	private FieldImpl neighbor;
	
	private Set<FigureImpl> figuresOnField = new HashSet<>();
	
	public FieldImpl(FieldImpl lastField, boolean isStartField, boolean isJoinField) {
		this.isSartField = isStartField;
		this.isJoinField = isJoinField;
		this.predecessor = lastField;
		if (lastField != null)
			lastField.successor = this;
	}

	@Override
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean isStartField() {
		return this.isSartField;
	}

	@Override
	public boolean isJoinField() {
		return this.isJoinField;
	}

	@Override
	public Field succ() {
		return this.successor;
	}

	@Override
	public Field pred() {
		return this.predecessor;
	}

	@Override
	public Field neighbor() {
		return this.neighbor;
	}

	@Override
	public Set<Figure> allFigures() {
		return new HashSet<>(this.figuresOnField);
	}

	public void setSucc(FieldImpl field) {
		this.successor = field;
	}

	public void setPred(FieldImpl field) {
		this.predecessor = field;
	}

	public void setNeighbor(FieldImpl field) {
		this.neighbor = field;
	}

}
