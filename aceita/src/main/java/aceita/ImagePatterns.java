package aceita;

import java.io.IOException;

import javax.imageio.ImageIO;

import org.sikuli.script.Pattern;

public class ImagePatterns {

	public static Pattern queuePattern = getPattern("queue.png", 0.8f);
	public static Pattern acceptPattern = getPattern("acceptButton.png", 0.8f);
	
	public static Pattern banPattern = getPattern("ban.png", 0.8f);
	public static Pattern banSearchPattern = getPattern("banSearch.png", 0.7f);
	public static Pattern banIconPattern = getPattern("banIcon2.png", 0.3f);
	public static Pattern banButtonPattern = getPattern("banButton.png", 0.7f);

	public static Pattern pickPattern = getPattern("pick2.png", 0.8f);
	public static Pattern pickSearchPattern = getPattern("pickSearch.png", 0.7f);
	public static Pattern pickIconPattern = getPattern("pickIcon2.png", 0.3f);
	public static Pattern pickButtonPattern = getPattern("pickButton.png", 0.7f);
	
	public static Pattern loadingPattern = getPattern("loadingBar0.png", 0.7f);
	
	private static Pattern getPattern(String imageName, Float f) {
		boolean productionMode = true;
		try {
			Pattern p = new Pattern(ImageIO.read(ImagePatterns.class.getClassLoader().getResourceAsStream(productionMode ? "resources/" + imageName : imageName)));
			p.similar(f);
			return p;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
}
