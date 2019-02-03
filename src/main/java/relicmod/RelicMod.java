package relicmod;

import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.localization.RelicStrings;

import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import relics.BlackLotus;

@SpireInitializer
public class RelicMod implements EditRelicsSubscriber, EditStringsSubscriber {
	
	public static final Logger logger = LogManager.getLogger(RelicMod.class.getName());
	
	private static String language = "eng";
	
	public RelicMod() {
		logger.info("RelicMod was created.");
		BaseMod.subscribe(this);
	}
	
	
	public static void initialize() {
		new RelicMod();
	}
	

	@Override
	public void receiveEditRelics() {
		// image loading works?
		logger.info("Trying to load image...");
		new Texture("relicmod_images/relics/BlackLotus.png");
		logger.info("Image was loaded");
		
		logger.info("Adding relics...");
		
		BaseMod.addRelic(new BlackLotus(), RelicType.SHARED);
		
		logger.info("Relics added!");
	}

	@Override
	public void receiveEditStrings() {
		final String pathToRelicStrings = "localization/" + RelicMod.language + "/RelicString.json";
		String relicStrings = Gdx.files.internal(pathToRelicStrings).readString(String.valueOf(StandardCharsets.UTF_8));
		
		logger.info("Loading relic strings...");
		
		BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
		
		logger.info("Relic string was succesfully loaded!");
	}
	
		
}
