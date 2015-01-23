package com.script.BYTESTRINGER.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;

import com.script.BYTESTRINGER.data.Data;
import com.script.BYTESTRINGER.strategies.Banking;
import com.script.BYTESTRINGER.strategies.Spin;
import com.script.BYTESTRINGER.strategies.Walk;
import com.script.BYTESTRINGER.ui.GUI;
import com.script.BYTESTRINGER.util.Utilities;

@ScriptManifest(author = "ByteCoder", category = Category.OTHER, description = "Strings Bowstring", name = "byteSpinner", servers = { "2006scape" }, version = 1.0)
public class Main extends Script implements Paintable, MessageListener {

	public long startTime;
	public static GUI g = new GUI();
	public static boolean guiWait = true;

	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	private Utilities utilities = new Utilities();

	public Utilities getUtil() {
		return utilities;
	}

	public boolean onExecute() {

		startTime = System.currentTimeMillis();
		g.setVisible(true);
		while (guiWait) {
			Time.sleep(500);
		}

		strategies.add(new Spin(this));
		strategies.add(new Walk(this));
		strategies.add(new Banking(this));
		provide(strategies);
		return true;
	}

	@Override
	public void onFinish() {
		System.out.println("I ran: " + runTime(startTime));
	}

    private final Color color1 = new Color(0, 0, 255);

	private final Font font1 = new Font("Arial Rounded MT Bold", 1, 14);

	public void paint(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
		g.setFont(font1);
		g.setColor(color1);
		g.drawString("RunTime: " + runTime(startTime), 6, 41);
		g.drawString("Flax Strung: " + Data.strung, 6, 64);
	}

	public static String runTime(long i) {

		DecimalFormat nf = new DecimalFormat("00");
		long millis = System.currentTimeMillis() - i;
		long hours = millis / (1000 * 60 * 60);
		millis -= hours * (1000 * 60 * 60);
		long minutes = millis / (1000 * 60);
		millis -= minutes * (1000 * 60);
		long seconds = millis / 1000;

		return nf.format(hours) + ":" + nf.format(minutes) + ":"
				+ nf.format(seconds);
	}

	@Override
	public void messageReceived(MessageEvent m) {
		if(m.getMessage().toLowerCase().contains("make the flax into") && m.getType() == 0) {
			Data.strung++;
		}
	}
}