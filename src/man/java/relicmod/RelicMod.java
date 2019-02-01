package relicmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

import basemod.BaseMod;
import basemod.interfaces.EditRelicsSubscriber;

@SpireInitializer
public class RelicMod implements EditRelicsSubscriber {

	public static final Logger logger = LogManager.getLogger(RelicMod.class.getName());
	
	public RelicMod() {
		logger.info("RelicMod was created.");
		BaseMod.subscribe(this);
	}
	
	public void initialize() {
		new RelicMod();
	}

	@Override
	public void receiveEditRelics() {
		// TODO Auto-generated method stub
		
	}
	
}
