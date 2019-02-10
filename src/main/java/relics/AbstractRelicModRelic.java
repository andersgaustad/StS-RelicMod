package relics;

import com.badlogic.gdx.graphics.Texture;

import basemod.abstracts.CustomRelic;

public class AbstractRelicModRelic extends CustomRelic {
	
	private final static String IMAGEDIR = "relicmod_images";
	
	private final static String USEDUPAPPEND = "_INACTIVE";
	
	public AbstractRelicModRelic(String ID, RelicTier tier, LandingSound landingSound) {
		super(ID, getRelicTexture(ID), tier, landingSound);
	}
	
	public static final Texture getRelicTexture(String relic, boolean relicIsActive) {
		String activeTag = "";
		
		if (!relicIsActive) {
			activeTag = USEDUPAPPEND;
		}
		
		return getTexture("relics/" + relic + activeTag + ".png");	
	}
	
	public static final Texture getRelicTexture(String relic) {
		return getRelicTexture(relic, true);
	}
	
	
	
	public static final Texture getTexture(String resource) {
		return new Texture(IMAGEDIR + "/" + resource);
	}
	
}
