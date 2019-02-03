package relics;

import com.badlogic.gdx.graphics.Texture;

import basemod.abstracts.CustomRelic;

public class AbstractRelicModRelic extends CustomRelic {
	
	public AbstractRelicModRelic(String ID, RelicTier tier, LandingSound landingSound) {
		super(ID, getRelicTexture(ID), tier, landingSound);
	}
	
	
	public static final Texture getTexture(String resource) {
		return new Texture("images/" + resource);
	}
	
	public static final Texture getRelicTexture(String relic) {
		return getTexture("relics/" + relic);
	}
	
}
