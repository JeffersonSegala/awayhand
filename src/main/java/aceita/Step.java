package aceita;

import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public enum Step {

	IN_QUEUE("Aguardando partida...") {
		@Override
		public Step doStep(Screen screen) {
			Match accept = screen.exists(ImagePatterns.acceptPattern);
			if (accept != null) {
				accept.click();
				return Step.MATCH_ACCEPTED;
			}
			return IN_QUEUE;
		}
	},
	MATCH_ACCEPTED("Partida aceita...") {
		@Override
		public Step doStep(Screen screen) {
			return Step.WAITING_BAN;
		}
	},
	WAITING_BAN("Aguardando fase de banimento...") {
		@Override
		public Step doStep(Screen screen) {
			if (screen.exists(ImagePatterns.banPattern) != null) {
				return Step.BAN_PHASE;
			}
			return Step.WAITING_BAN;
		}
	},
	BAN_PHASE("Banindo...") {
		@Override
		public Step doStep(Screen screen) {
			try {
				if (MainView.autobanFlag.isSelected()) {
					screen.type(ImagePatterns.banSearchPattern, MainView.banInput.getText());
					screen.click(ImagePatterns.banIconPattern);
					screen.click(ImagePatterns.banButtonPattern);
					return Step.WAITING_PICK;
				}
			} catch (Error | Exception e) {
				System.out.println("Erro banindo");
				e.printStackTrace();
			}
			return Step.BAN_PHASE;
		}
	},
	WAITING_PICK("Aguardando fase de pick...") {
		@Override
		public Step doStep(Screen screen) {
			if (screen.exists(ImagePatterns.pickPattern) != null) {
				return Step.PICK_PHASE;
			}
			return Step.WAITING_PICK;
		}
	},
	PICK_PHASE("Escolhendo...") {
		@Override
		public Step doStep(Screen screen) {
			try {
				if (MainView.autopickFlag.isSelected()) {
					System.out.println("Tentando pick");
					screen.type(ImagePatterns.pickSearchPattern, MainView.pickInput.getText());
					screen.click(ImagePatterns.pickIconPattern);
					screen.click(ImagePatterns.pickButtonPattern);
					return Step.WAITING_LOADING;
				}
			} catch (Error | Exception e) {
				System.out.println("Erro pickando");
				e.printStackTrace();
			}
			return Step.PICK_PHASE;
		}
	},
	WAITING_LOADING("Aguardando loadscreen...") {
		@Override
		public Step doStep(Screen screen) {
			if (screen.exists(ImagePatterns.loadingPattern) != null) {
				return Step.LOADING;
			}
			return Step.WAITING_LOADING;
		}
	},
	LOADING("Bom jogo! (fechando em 3s)") {
		@Override
		public Step doStep(Screen screen) {
			System.exit(0);
			return null;
		}
	};

	public abstract Step doStep(Screen screen);
	
	private String description;
	
	Step(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
