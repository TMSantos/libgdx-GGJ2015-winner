package ggj2015.game.utils.screentransitions;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Tiago Santos on 23/01/2015.
 */
public interface ScreenTransition {

    public float getDuration ();

    public abstract void render (SpriteBatch batch, Texture currScreen, Texture nextScreen, float alpha);

}
