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
import relics.AngelFigurine;
import relics.AssassinsTools;
import relics.BlackLotus;
import relics.BrokenChains;
import relics.CampingSupplies;
import relics.CoiledSword;
import relics.Coupon;
import relics.ForgottenJournal;
import relics.HeartOfSteel;
import relics.Hearthstone;
import relics.LightningRod;
import relics.MagicalSnailShell;
import relics.MidnightOil;
import relics.MysteryBox;
import relics.OrbOptimizer;
import relics.ParryingDagger;
import relics.Powerstone;
import relics.ScholarsParchment;
import relics.ScholarsQuill;
import relics.SigiledHammer;
import relics.StuffedToySnake;
import relics.SwordOfVigilance;
import relics.TrebuchetToy;
import relics.WantedPoster;
import relics.WarlordsTankard;

@SpireInitializer
public class RelicMod implements EditRelicsSubscriber, EditStringsSubscriber {
	
	public static final Logger LOGGER = LogManager.getLogger(RelicMod.class.getName());
	
	private static final String LANGUAGE = "eng";
	
	public RelicMod() {
		LOGGER.info("RelicMod was created.");
		BaseMod.subscribe(this);
	}
	
	
	public static void initialize() {
		new RelicMod();
	}
	

	@Override
	public void receiveEditRelics() {
		
		LOGGER.info("Adding relics...");
		
		BaseMod.addRelic(new BlackLotus(), RelicType.SHARED);
		LOGGER.info("BlackLotus was added to pool");
		
		BaseMod.addRelic(new WantedPoster(), RelicType.SHARED);
		LOGGER.info("WantedPoster was added to pool");
		
		BaseMod.addRelic(new Powerstone(), RelicType.SHARED);
		LOGGER.info("Powerstone was added to pool");
		
		BaseMod.addRelic(new LightningRod(), RelicType.SHARED);
		LOGGER.info("LightningRod was added to pool");
		
		BaseMod.addRelic(new AncientShield(), RelicType.SHARED);
		LOGGER.info("AncientShield was added to pool");
		
		BaseMod.addRelic(new MidnightOil(), RelicType.SHARED);
		LOGGER.info("MidnightOil was added to pool");
		
		BaseMod.addRelic(new MagicalSnailShell(), RelicType.SHARED);
		LOGGER.info("MagicalSnailShell was added to pool");
		
		BaseMod.addRelic(new SwordOfVigilance(), RelicType.SHARED);
		LOGGER.info("SwordOfVigilance was added to pool");
		
		BaseMod.addRelic(new Hearthstone(), RelicType.SHARED);
		LOGGER.info("Hearthstone was added to pool");
		
		BaseMod.addRelic(new BrokenChains(), RelicType.RED);
		LOGGER.info("BrokenChains was added to pool");
		
		BaseMod.addRelic(new WarlordsTankard(), RelicType.SHARED);
		LOGGER.info("WarlordsTankard was added to pool");
		
		BaseMod.addRelic(new CoiledSword(), RelicType.SHARED);
		LOGGER.info("CoiledSword was added to pool");
		
		BaseMod.addRelic(new ScholarsQuill(), RelicType.SHARED);
		LOGGER.info("ScholarsQuill was added to pool");
		
		BaseMod.addRelic(new ScholarsParchment(), RelicType.SHARED);
		LOGGER.info("ScholarsParchment was added to pool");
		
		BaseMod.addRelic(new AngelFigurine(), RelicType.SHARED);
		LOGGER.info("AngelFigurine was added to pool");
		
		BaseMod.addRelic(new ParryingDagger(), RelicType.GREEN);
		LOGGER.info("ParryingDagger was added to pool");
		
		BaseMod.addRelic(new TrebuchetToy(), RelicType.SHARED);
		LOGGER.info("TrebuchetToy was added to pool");
		
		BaseMod.addRelic(new CampingSupplies(), RelicType.SHARED);
		LOGGER.info("CampingSupplies was added to pool");
		
		BaseMod.addRelic(new Coupon(), RelicType.SHARED);
		LOGGER.info("Coupon was added to pool");
		
		BaseMod.addRelic(new MysteryBox(), RelicType.SHARED);
		LOGGER.info("MysteryBox was added to pool");
		
		BaseMod.addRelic(new StuffedToySnake(), RelicType.SHARED);
		LOGGER.info("StuffedToySnake was added to pool");
		
		BaseMod.addRelic(new ForgottenJournal(), RelicType.SHARED);
		LOGGER.info("ForgottenJournal was added to pool");
		
		BaseMod.addRelic(new HeartOfSteel(), RelicType.SHARED);
		LOGGER.info("HeartOfSteel was added to pool");
		
		BaseMod.addRelic(new SigiledHammer(), RelicType.SHARED);
		LOGGER.info("SigiledHammer was added to pool");
		
		BaseMod.addRelic(new AssassinsTools(), RelicType.GREEN);
		LOGGER.info("AssassinsTools was added to pool");
		
		BaseMod.addRelic(new OrbOptimizer(), RelicType.BLUE);
		LOGGER.info("OrbOptimizer was added to pool");
		
		BaseMod.addRelic(new relics.Compiler(), RelicType.BLUE);
		LOGGER.info("Compiler was added to pool");
		
		LOGGER.info("Relics added!");
	}

	@Override
	public void receiveEditStrings() {
		final String pathToRelicStrings = "localization/" + RelicMod.LANGUAGE + "/RelicString.json";
		String relicStrings = Gdx.files.internal(pathToRelicStrings).readString(String.valueOf(StandardCharsets.UTF_8));
		
		LOGGER.info("Loading relic strings...");
		
		BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
		
		LOGGER.info("Relic string was succesfully loaded!");
	}
	
		
}
