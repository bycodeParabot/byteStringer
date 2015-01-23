package com.script.BYTESTRINGER.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

import com.script.BYTESTRINGER.core.Main;
import com.script.BYTESTRINGER.data.Data;

public class Walk implements Strategy {
	public SceneObject[] down;
	public SceneObject[] up;
	Main s;

	public Walk(Main s) {
		this.s = s;
	}

	@Override
	public boolean activate() {
		if (s.getUtil().needWalk()) {
			return true;
		}
		return false;

	}

	@Override
	public void execute() {

		up = SceneObjects.getNearest(Data.up);
		down = SceneObjects.getNearest(Data.up);
		if (Inventory.getCount(Data.flax) < 1) {
			if (Game.getPlane() == 1) {
				// cheap-hax for down latter//
				Menu.sendAction(502, s.getUtil().getDownLadderHash(), s
						.getUtil().getDownLadderX(), s.getUtil()
						.getDownLadderY());
				Time.sleep(2000);

			} else {

				if (s.getUtil().isDoorOpen() == true) {

					Menu.sendAction(502, s.getUtil().getDoorHash(), s.getUtil()
							.getDoorX(), s.getUtil().getDoorY()); // ewww,
					// but
					// it's
					// a
					// door.
					Time.sleep(3000);

				}
				if (s.getUtil().isDoorOpen() == false) {
					Data.BANK_TILE.walkTo();
					while (Data.BANK_TILE.distanceTo() >= 5) { // yes it's
																// sloppy, but
																// conditonal
																// sleeping
																// isn't working
						Time.sleep(1000);
					}
				}
			}
		}

		if (Inventory.getCount(Data.flax) > 0 && Game.getPlane() == 0) {
			if (Data.DOOR_TILE.distanceTo() > 3) {
				Data.DOOR_TILE.walkTo();
				while (Data.DOOR_TILE.distanceTo() > 3) { // yes it's sloppy,
															// but conditonal
															// sleeping isn't
															// working
					Time.sleep(1000);
				}
			} else {
				if (s.getUtil().isDoorOpen() == true) {

					Menu.sendAction(502, s.getUtil().getDoorHash(), s.getUtil()
							.getDoorX(), s.getUtil().getDoorY()); // ewww,
					// but
					// it's
					// a
					// door.
					Time.sleep(3000);
			
				}
				if (s.getUtil().isDoorOpen() == false) {

					up[0].interact(0);
					Time.sleep(2000);
				}
			}

		}

	}

}
