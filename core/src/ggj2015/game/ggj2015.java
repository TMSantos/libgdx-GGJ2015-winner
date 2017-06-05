package ggj2015.game;

import com.badlogic.gdx.assets.AssetManager;
import ggj2015.game.managers.ResourceManager;
import ggj2015.game.managers.ScreenManager;
import ggj2015.game.views.GameScreen;
import ggj2015.game.views.IntroScreenFirst;
import ggj2015.game.views.MainMenuScreen;

/**
 * Created by Tiago Santos on 24/01/2015.
 */
public class ggj2015 extends ScreenManager{
    @Override
    public void create() {

        ResourceManager.instance.initResourceManager(new AssetManager());

        setScreen(new MainMenuScreen(this),null);
        //setScreen(new GameScreen(this),null);
        //setScreen(new IntroScreenFirst(this),null);
    }
}
