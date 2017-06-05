package ggj2015.game.resources;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Tiago Santos on 25/01/2015.
 */
public class IntroScreenPack4 {

    public final TextureAtlas.AtlasRegion introscreen4anim1;
    public final TextureAtlas.AtlasRegion introscreen4anim2;
    public final TextureAtlas.AtlasRegion introscreen4anim3;

    public IntroScreenPack4(TextureAtlas introscreen) {
        introscreen4anim1 = introscreen.findRegion("screen4anim1");
        introscreen4anim2 = introscreen.findRegion("screen4anim2");
        introscreen4anim3 = introscreen.findRegion("screen4anim3");

    }
}
