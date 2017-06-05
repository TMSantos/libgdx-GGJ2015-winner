package ggj2015.game.resources;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Tiago Santos on 25/01/2015.
 */
public class IntroScreenPack1 {

    public final TextureAtlas.AtlasRegion introscreen1anim1;
    public final TextureAtlas.AtlasRegion introscreen1anim2;
    public final TextureAtlas.AtlasRegion introscreen1anim3;

    public final TextureAtlas.AtlasRegion introscreen1tap;

    public IntroScreenPack1(TextureAtlas introscreen) {
        introscreen1anim1 = introscreen.findRegion("screen1anim1");
        introscreen1anim2 = introscreen.findRegion("screen1anim2");
        introscreen1anim3 = introscreen.findRegion("screen1anim3");
        introscreen1tap = introscreen.findRegion("screen1Tap");
    }
}
