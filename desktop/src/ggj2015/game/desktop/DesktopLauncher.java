package ggj2015.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ggj2015.game.ggj2015;

/**
 * Created by Tiago Santos on 24/01/2015.
 */
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 720;
        config.width = 1280;
		new LwjglApplication(new ggj2015(), config);
	}
}
