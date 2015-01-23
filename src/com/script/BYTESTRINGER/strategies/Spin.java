package com.script.BYTESTRINGER.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

import com.script.BYTESTRINGER.core.Main;
import com.script.BYTESTRINGER.data.Data;

public class Spin implements Strategy {
	public SceneObject[] spinner;
	Main s;

	public Spin(Main s) {
		this.s = s;
	}

	@Override
	public boolean activate() {
		if (s.getUtil().needSpin()) {
			return true;
		}
		return false;

	}

	@Override
	public void execute() {

		spinner = SceneObjects.getNearest(Data.spinner);
		if (s.getUtil().needSpin()) {
			if (spinner != null && spinner.length > 0) {
				if (Game.getOpenBackDialogId() != 8880
						&& Players.getMyPlayer().getAnimation() == -1) {
					spinner[0].interact(1);
					Time.sleep(3000);

				}
				if (Game.getOpenBackDialogId() == 8880) {
					Menu.sendAction(315, 1779, 16, 8890);
					Time.sleep(1500);
					Keyboard.getInstance().sendKeys("28");
					Time.sleep(2000);

				}

				while (Players.getMyPlayer().getAnimation() != -1) {
					Time.sleep(2000);
				}

			}
		}
	}

}
