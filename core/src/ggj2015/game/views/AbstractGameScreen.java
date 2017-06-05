package ggj2015.game.views;


import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import ggj2015.game.managers.ResourceManager;
import ggj2015.game.managers.ScreenManager;

/**
 * Created by Tiago Santos on 23/01/2015.
 */
public abstract class AbstractGameScreen implements Screen {

    public ScreenManager mScreenManager;

    public AbstractGameScreen(ScreenManager screenManager){
        mScreenManager = screenManager;
    }

    public void render(float deltaTime) {}

    public void resize(int width, int height) {}

    public void show() {}

    public void hide() {}

    public void pause() {}

    public abstract InputProcessor getInputProcessor ();

    public void resume () {
        // ResourceManager.instance.initResourceManager();
    }

    public void dispose () {
        //ResourceManager.instance.dispose();
    }
}
