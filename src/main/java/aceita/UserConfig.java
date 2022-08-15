package aceita;

import java.util.prefs.Preferences;

public class UserConfig {
	
	public static final String BAN_INPUT_KEY = "banInput";
	public static final String PICK_INPUT_KEY = "pickInput";
	public static final String AUTO_BAN_KEY = "autoBanFlag";
	public static final String AUTO_PICK_KEY = "autoPickFlag";
	
	private static Preferences prefs = Preferences.userNodeForPackage(aceita.UserConfig.class);
	
	
	public static void loadConfig() {
		MainView.banInput.setText(prefs.get(BAN_INPUT_KEY, ""));
		MainView.autobanFlag.setSelected(new Boolean(prefs.get(AUTO_BAN_KEY, "False")));
		MainView.pickInput.setText(prefs.get(PICK_INPUT_KEY, ""));
		MainView.autopickFlag.setSelected(new Boolean(prefs.get(AUTO_PICK_KEY, "False")));
	}
	
	public static void saveConfig(String key, String value) {
		prefs.put(key, value);
	}
	
}
