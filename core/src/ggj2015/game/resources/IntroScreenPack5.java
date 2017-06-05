package ggj2015.game.resources;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Tiago Santos on 25/01/2015.
 */
public class IntroScreenPack5 {

    public final TextureAtlas.AtlasRegion introscreen5anim1;
    public final TextureAtlas.AtlasRegion introscreen5anim2;
    public final TextureAtlas.AtlasRegion introscreen5anim3;
    public final TextureAtlas.AtlasRegion introscreen5anim4;

    public IntroScreenPack5(TextureAtlas introscreen) {
        introscreen5anim1 = introscreen.findRegion("screen5anim1");
        introscreen5anim2 = introscreen.findRegion("screen5anim2");
        introscreen5anim3 = introscreen.findRegion("screen5anim3");
        introscreen5anim4 = introscreen.findRegion("screen5anim4");

    }
}
