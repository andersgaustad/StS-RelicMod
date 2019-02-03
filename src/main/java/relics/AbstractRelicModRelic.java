package relics;

import com.badlogic.gdx.graphics.Texture;

import basemod.abstracts.CustomRelic;

public class AbstractRelicModRelic extends CustomRelic {
	
	private final static String IMAGEDIR = "relicmod_images";
	
	public AbstractRelicModRelic(String ID, RelicTier tier, LandingSound landingSound) {
		super(ID, getRelicTexture(ID), tier, landingSound);
	}
	
	
	public static final Texture getTexture(String resource) {
		return new Texture(IMAGEDIR + "/" + resource);
	}
	
	public static final Texture getRelicTexture(String relic) {
		return getTexture("relics/" + relic + ".png");
	}
	
	//private Texture t = new Texture(internalPath);
}
