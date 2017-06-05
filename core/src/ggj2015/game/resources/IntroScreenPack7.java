package ggj2015.game.resources;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Tiago Santos on 25/01/2015.
 */
public class IntroScreenPack7 {

    public final TextureAtlas.AtlasRegion introscreen7anim1;
    public final TextureAtlas.AtlasRegion introscreen7anim2;
    public final TextureAtlas.AtlasRegion introscreen7anim3;

    public final TextureAtlas.AtlasRegion introscreen8text;

    public IntroScreenPack7(TextureAtlas introscreen) {
        introscreen7anim1 = introscreen.findRegion("screen7anim1");
        introscreen7anim2 = introscreen.findRegion("screen7anim2");
        introscreen7anim3 = introscreen.findRegion("screen7anim3");
        introscreen8text = introscreen.findRegion("screen8text");

    }
}
