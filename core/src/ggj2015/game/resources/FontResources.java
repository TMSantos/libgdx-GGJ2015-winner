package ggj2015.game.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import ggj2015.game.utils.Constants;

/**
 * Created by Tiago Santos on 24/01/2015.
 */
public class FontResources {

    public BitmapFont defaultUltraSmall;
    public BitmapFont defaultSmall;
    public BitmapFont defaultNormal;
    public BitmapFont defaultBig;

    public FontResources(){
        defaultUltraSmall = new BitmapFont(Gdx.files.internal(Constants.FONT_PATH), true);
        defaultSmall = new BitmapFont(Gdx.files.internal(Constants.FONT_PATH), true);
        defaultNormal = new BitmapFont(Gdx.files.internal(Constants.FONT_PATH), true);
        defaultBig = new BitmapFont(Gdx.files.internal(Constants.FONT_PATH), true);

        defaultUltraSmall.setScale(0.333f);
        defaultSmall.setScale(0.667f);
        defaultNormal.setScale(1.0f);
        defaultBig.setScale(1.25f);

        defaultSmall.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        defaultNormal.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        defaultBig.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public void dispose(){
        defaultSmall.dispose();
        defaultNormal.dispose();
        defaultBig.dispose();
    }

}
