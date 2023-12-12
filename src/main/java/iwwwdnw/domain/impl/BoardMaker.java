package iwwwdnw.domain.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BoardMaker {

	private List<FieldImpl> innerCircle = new ArrayList<>();
	private List<FieldImpl> outerCircle = new ArrayList<>();
	private List<FieldImpl> middleOuterCircle = new ArrayList<>();
	private List<FieldImpl> middleInnerCircle = new ArrayList<>();

	private List<FieldImpl> outerJoins = new ArrayList<>();
	private List<FieldImpl> innerJoins = new ArrayList<>();
	private List<FieldImpl> innerStartFields = new ArrayList<>();
	private List<FieldImpl> outerStartFields = new ArrayList<>();

	private int numberOfPlayers;
	private List<PlayerImpl> players;

	public BoardMaker(PlayerImpl[] players) {
		this.players = Arrays.asList(players);
		this.numberOfPlayers = players.length;
		this.mkBoard();
		this.assignStartFields();
	}

	private void assignStartFields() {
		Iterator<FieldImpl> innerIter = this.innerStartFields.iterator();
		Iterator<FieldImpl> outerIter = this.outerStartFields.iterator();

		for (PlayerImpl player : this.players) {
			FieldImpl innerField = innerIter.next();
			FieldImpl outerField = outerIter.next();
			player.setStartField(outerField, innerField);
		}
	}

	private void mkBoard() {
		this.mkInnerCircle();
		this.mkOuterCircle();
		this.mkJoin();
	}

	private void mkInnerCircle() {
		int fieldCount = 6 + (2 * (6 - this.numberOfPlayers));
		this.mkCircle(fieldCount, this.innerCircle, this.innerJoins, this.innerStartFields);
	}

	private void mkOuterCircle() {
		int fieldCount = 10 + (2 * (6 - this.numberOfPlayers));
		this.mkCircle(fieldCount, this.outerCircle, this.outerJoins, this.outerStartFields);
	}

	private void mkCircle(int numberOfFields, List<FieldImpl> allFields, List<FieldImpl> joinFields,
			List<FieldImpl> startFields) {
		FieldImpl field = new FieldImpl(null, true, true);
		allFields.add(field);
		joinFields.add(field);
		startFields.add(field);
		FieldImpl firstField = field;
		FieldImpl lastField = field;

		for (int f = 1; f < (numberOfFields * this.numberOfPlayers); f++) {
			boolean isStart = ((f % numberOfFields) == 0);
			boolean isJoin = ((f % (numberOfFields / 2)) == 0);
			field = new FieldImpl(lastField, isStart, isJoin);
			allFields.add(field);
			if (isStart)
				startFields.add(field);
			if (isJoin)
				joinFields.add(field);
			lastField = field;
		}
		lastField.setSucc(firstField);
		firstField.setPred(lastField);
	}

	private void mkJoin() {
		Iterator<FieldImpl> innerIter = this.innerJoins.iterator();
		Iterator<FieldImpl> outerIter = this.outerJoins.iterator();
		while (innerIter.hasNext()) {
			FieldImpl innerField = innerIter.next();
			FieldImpl outerField = outerIter.next();
			FieldImpl newOne = new FieldImpl(outerField, false, false);
			FieldImpl newTwo = new FieldImpl(newOne, false, false);
			outerField.setNeighbor(newOne);
			innerField.setNeighbor(newTwo);
			newTwo.setSucc(innerField);
			this.middleOuterCircle.add(newOne);
			this.middleInnerCircle.add(newTwo);
		}
	}

	public List<FieldImpl> getBoard() {
		List<FieldImpl> allFields = new ArrayList<>(this.innerCircle);
		allFields.addAll(this.middleInnerCircle);
		allFields.addAll(this.middleOuterCircle);
		allFields.addAll(this.outerCircle);
		int id = 1;
		for (FieldImpl field : allFields)
			field.setId(id++);
		return allFields;
	}

}
