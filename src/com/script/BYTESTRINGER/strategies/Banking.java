package com.script.BYTESTRINGER.strategies;

import java.util.ArrayList;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Bank;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.Item;
import org.rev317.min.api.wrappers.SceneObject;

import com.script.BYTESTRINGER.core.Main;
import com.script.BYTESTRINGER.data.Data;

public class Banking implements Strategy {
	public SceneObject[] bank;
	Main s;

	public Banking(Main s) {
		this.s = s;
	}

	@Override
	public boolean activate() {
		if (s.getUtil().needBank()) {
			return true;
		}
		return false;

	}

	@Override
	public void execute() {
		bank = SceneObjects.getNearest(Data.bank);

		if (Game.getOpenInterfaceId() != 5292) {
			if (bank != null && bank.length > 0) {
				bank[0].interact(1);
				Time.sleep(3500);
			}
		}

		if (Game.getOpenInterfaceId() == 5292) { // If bank is open
			Time.sleep(500);
			depositAllExcept(1);
			Time.sleep(1500);
			Bank.withdraw(Data.flax, 28, 1200);
			Time.sleep(1200);
			Bank.close();
			Time.sleep(1000);

		}
	}

	public static void depositAllExcept(int... itemIDs) {
		final ArrayList<Integer> dontDeposit = new ArrayList<Integer>();
		if (Inventory.getCount(false) <= 2) {
			return;
		} else {
			for (int i : itemIDs) {
				dontDeposit.add(i);
			}
		}
		for (Item inventoryItem : Inventory.getItems()) {
			if (!dontDeposit.contains(inventoryItem.getId())) {
				Menu.sendAction(431, inventoryItem.getId() - 1,
						inventoryItem.getSlot(), 5064, 2213, 3);
				Time.sleep(80);
			}
		}
	}
}
