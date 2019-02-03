package relicmod;

import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.badlogic.gdx.Gdx;
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
	
	
	public void initialize() {
		new RelicMod();
	}

	@Override
	public void receiveEditRelics() {
		BaseMod.addRelic(new BlackLotus(), RelicType.SHARED);
		
	}

	@Override
	public void receiveEditStrings() {
		final String pathToRelicStrings = "localization/" + RelicMod.language + "/RelicString.json";
		String relicStrings = Gdx.files.internal(pathToRelicStrings).readString(String.valueOf(StandardCharsets.UTF_8));
		
		BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
	}
		
}
