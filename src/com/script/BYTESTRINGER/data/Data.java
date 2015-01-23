package com.script.BYTESTRINGER.data;

import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Area;
import org.rev317.min.api.wrappers.Tile;

public class Data {

	public static int flax = 1780, bank = 2213, spinner = 2644, up = 1747,
			down = 1746, strung = 0, door = 1530;

	public static Tile BANK_TILE = new Tile(2725, 3492);

	public static Tile DOOR_TILE = new Tile(2716, 3472);

	public static Tile DOWN_LADDER = new Tile(2715, 3470);

	public static Area SPIN_ROOM = new Area(new Tile(2709, 3474, 1), new Tile(
			2709, 3469, 1), new Tile(2717, 3469, 1), new Tile(2717, 3474, 1));

	public static Tile myLoc = Players.getMyPlayer().getLocation();

}
