package iwwwdnw.statemachine.port;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface State {

	boolean isSubStateOf(State state);

	boolean isSuperStateOf(State state);

	public enum S implements State {

		INIT_GAME, //

		START_TURN, //

		MAKE_A_TURN(START_TURN), //

		WUERFELN(MAKE_A_TURN), //

		STARTFELD_AUSWAEHLEN(MAKE_A_TURN), //
		
		AUGENSUMME_VERTEILEN(MAKE_A_TURN), //
		
		WISSENSDUELL(MAKE_A_TURN),

		AWARD_CEREMMONY;

		private List<State> subStates;

		public static final S INITIAL_STATE = INIT_GAME;

		private S(State... subS) {
			this.subStates = new ArrayList<>(Arrays.asList(subS));
		}

		@Override
		public boolean isSuperStateOf(State s) {
			boolean result = (s == null) || (this == s); // self contained
			for (State state : this.subStates) // or
				result |= state.isSuperStateOf(s); // contained in a substate!
			return result;
		}

		@Override
		public boolean isSubStateOf(State state) {
			return (state != null) && state.isSuperStateOf(this);
		}
	}

}