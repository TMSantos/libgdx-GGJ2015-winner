package ggj2015.game.resources;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Tiago Santos on 25/01/2015.
 */
public class HUDResources {

    public final TextureAtlas.AtlasRegion HUDScoreBox;
    public final TextureAtlas.AtlasRegion HUDWinScreen;
    public final TextureAtlas.AtlasRegion HUDLostScreen;

    public HUDResources(TextureAtlas junkPack) {
        HUDScoreBox = junkPack.findRegion("HUDScoreBox");
        HUDWinScreen = junkPack.findRegion("win");
        HUDLostScreen = junkPack.findRegion("lost");
    }
}
