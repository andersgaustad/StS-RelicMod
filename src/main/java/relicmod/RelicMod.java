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
import relics.AncientShield;
import relics.BlackLotus;
import relics.LightningRod;
import relics.MagicalSnailShell;
import relics.MidnightOil;
import relics.Powerstone;
import relics.SwordOfVigilance;
import relics.WantedPoster;

@SpireInitializer
public class RelicMod implements EditRelicsSubscriber, EditStringsSubscriber {
	
	public static final Logger logger = LogManager.getLogger(RelicMod.class.getName());
	
	private static final String language = "eng";
	
	public RelicMod() {
		logger.info("RelicMod was created.");
		BaseMod.subscribe(this);
	}
	
	
	public static void initialize() {
		new RelicMod();
	}
	

	@Override
	public void receiveEditRelics() {
		
		logger.info("Adding relics...");
		
		BaseMod.addRelic(new BlackLotus(), RelicType.SHARED);
		logger.info("BlackLotus was added to pool");
		
		BaseMod.addRelic(new WantedPoster(), RelicType.SHARED);
		logger.info("WantedPoster was added to pool");
		
		BaseMod.addRelic(new Powerstone(), RelicType.SHARED);
		logger.info("Powerstone was added to pool");
		
		BaseMod.addRelic(new LightningRod(), RelicType.SHARED);
		logger.info("LightningRod was added to pool");
		
		BaseMod.addRelic(new AncientShield(), RelicType.SHARED);
		logger.info("AncientShield was added to pool");
		
		BaseMod.addRelic(new MidnightOil(), RelicType.SHARED);
		logger.info("MidnightOil was added to pool");
		
		BaseMod.addRelic(new MagicalSnailShell(), RelicType.SHARED);
		logger.info("MagicalSnailShield was added to pool");
		
		BaseMod.addRelic(new SwordOfVigilance(), RelicType.SHARED);
		logger.info("SwordOfVigilance was added to pool");
		
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
