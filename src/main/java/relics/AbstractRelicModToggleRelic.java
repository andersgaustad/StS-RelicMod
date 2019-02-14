package relics;

public class AbstractRelicModToggleRelic extends AbstractRelicModRelic {
	
	protected boolean active = true;

	public AbstractRelicModToggleRelic(String ID, RelicTier relictier, LandingSound landingsound) {
		super(ID, relictier, landingsound);
	}
	
	protected void activate() {
		setActive(true);
	}
	
	protected void deactivate() {
		setActive(false);
	}
	
	protected void setActive(boolean activate) {
		// XOR; Same as: this.active!=activate
		if (this.active ^ activate) {
			this.active = activate;
			
			this.img = AbstractRelicModRelic.getRelicTexture(this.relicId, activate);
		}
	}
	
}
