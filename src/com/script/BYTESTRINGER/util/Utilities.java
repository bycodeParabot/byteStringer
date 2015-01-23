package com.script.BYTESTRINGER.util;

import org.parabot.environment.scripts.framework.SleepCondition;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.Player;
import org.rev317.min.api.wrappers.SceneObject;
import org.rev317.min.api.wrappers.Tile;

import com.script.BYTESTRINGER.data.Data;

public class Utilities {
	final Player player = Players.getMyPlayer();

	public boolean needSpin() {
		if (Inventory.getCount(Data.flax) > 0 && Game.getPlane() == 1) {
			return true;
		}
		return false;
	}

	public boolean needBank() {
		if (Inventory.getCount(Data.flax) < 1
				&& Data.BANK_TILE.distanceTo() <= 5) {
			return true;
		}
		return false;
	}

	public SleepCondition condition = new SleepCondition() {

		@Override
		public boolean isValid() {
			return player.getAnimation() > 0;
		}

	};

	public boolean needWalk() {
		if (Inventory.getCount(Data.flax) < 1
				&& Data.BANK_TILE.distanceTo() > 5) {
			return true;
		}
		if (Inventory.getCount(Data.flax) > 0 && Game.getPlane() == 0) {
			return true;
		}
		return false;
	}

	public boolean isDoorOpen() {
		try {
			SceneObject[] door = SceneObjects.getSceneObjects();
			for (SceneObject playa : door) {
				if (playa != null) {
					if (playa.getId() == Data.door
							&& playa.getLocation().equals(Data.DOOR_TILE)) {
						return true;
					}
				}

			}
		} catch (Exception e) {
			 
		}
		return false;
	}

	public int getDoorHash() {
		try {
			SceneObject[] npc = SceneObjects.getAllSceneObjects();
			for (SceneObject playa : npc) {
				if (playa != null) {
					if (playa.getLocation().equals(Data.DOOR_TILE)
							&& playa.getId() == Data.door) {
						return playa.getHash();
					}
				}
			}

		} catch (Exception e) {
			 
		}

		return -1;
	}
	public int getDoorX() {
		try {
			SceneObject[] npc = SceneObjects.getAllSceneObjects();
			for (SceneObject playa : npc) {
				if (playa != null) {
					if (playa.getLocation().equals(Data.DOOR_TILE)
							&& playa.getId() == Data.door) {
						return playa.getLocalRegionX();
					}
				}
			}

		} catch (Exception e) {
			 
		}

		return -1;
	}
	public int getDoorY() {
		try {
			SceneObject[] npc = SceneObjects.getAllSceneObjects();
			for (SceneObject playa : npc) {
				if (playa != null) {
					if (playa.getLocation().equals(Data.DOOR_TILE)
							&& playa.getId() == Data.door) {
						return playa.getLocalRegionY();
					}
				}
			}

		} catch (Exception e) {
			 
		}

		return -1;
	}
	public int getDownLadderX() {
		try {
			SceneObject[] npc = SceneObjects.getSceneObjects();
			for (SceneObject playa : npc) {
				if (playa != null) {
					if (playa.getLocation().equals(Data.DOWN_LADDER)
							&& playa.getId() == Data.down) {
						return playa.getLocalRegionX();
					}
				}
			}

		} catch (Exception e) {
			 
		}

		return -1;
	}
	public int getDownLadderHash() {
		try {
			SceneObject[] npc = SceneObjects.getSceneObjects();
			for (SceneObject playa : npc) {
				if (playa != null) {
					if (playa.getLocation().equals(Data.DOWN_LADDER)
							&& playa.getId() == Data.down) {
						return playa.getHash();
					}
				}
			}

		} catch (Exception e) {
			 
		}

		return -1;
	}
	public int getDownLadderY() {
		try {
			SceneObject[] npc = SceneObjects.getSceneObjects();
			for (SceneObject playa : npc) {
				if (playa != null) {
					if (playa.getLocation().equals(Data.DOWN_LADDER)
							&& playa.getId() == Data.down) {
						return playa.getLocalRegionY();
					}
				}
			}

		} catch (Exception e) {
			 
		}

		return -1;
	}


}
