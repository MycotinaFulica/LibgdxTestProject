package com.sample.learnlibgdx.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.sample.learnlibgdx.MyGdxGame;

public class DesktopLauncher {
	private static boolean rebuildAtlas = false;
	private static boolean drawDebugOutline = false;

	public static void main (String[] arg) {

		if (rebuildAtlas) {
			TexturePacker.Settings settings = new TexturePacker.Settings();
			settings.maxWidth = 1024;
			settings.maxHeight = 1024;
			settings.duplicatePadding = false;
			settings.debug = drawDebugOutline;
			TexturePacker.process(settings, "../../desktop/assets-raw/images","images","canyonbunny.pack");
			TexturePacker.process(settings, "../../desktop/assets-raw/images-ui","images","canyonbunny-ui.pack");
		}

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
