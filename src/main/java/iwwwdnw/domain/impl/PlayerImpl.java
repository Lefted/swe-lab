package iwwwdnw.domain.impl;

import java.util.HashSet;
import java.util.Set;

import iwwwdnw.domain.port.Field;
import iwwwdnw.domain.port.Figure;
import iwwwdnw.domain.port.Player;

public class PlayerImpl implements Player{
	
	private String name;
	private int yearOfBirth;
	private String color;
	private Set<FigureImpl> myFigures = new HashSet<>();
	private FieldImpl[] startField;

	public PlayerImpl(String name, int year, String color) {
		this.name = name;
		this.yearOfBirth = year;
		this.color = color;
		for (int i = 0; i < 5; i++)
			this.myFigures.add(new FigureImpl(this));
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getYearOfBirth() {
		return this.yearOfBirth;
	}

	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public Set<Figure> allFigures() {
		return new HashSet<>(this.myFigures);
	}

	@Override
	public Field[] startFields() {		
		return new Field[] {this.startField[0],this.startField[1]};
	}

	public void setStartField(FieldImpl outerField, FieldImpl innerField) {
		this.startField = new FieldImpl[] {outerField,innerField};
	}

}
