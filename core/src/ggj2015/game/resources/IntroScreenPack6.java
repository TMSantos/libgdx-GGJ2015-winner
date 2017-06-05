package ggj2015.game.resources;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Tiago Santos on 25/01/2015.
 */
public class IntroScreenPack6 {

    public final TextureAtlas.AtlasRegion introscreen6anim1;
    public final TextureAtlas.AtlasRegion introscreen6anim2;
    public final TextureAtlas.AtlasRegion introscreen6anim3;
    public final TextureAtlas.AtlasRegion introscreen6anim4;

    public final TextureAtlas.AtlasRegion introscreen6text;

    public IntroScreenPack6(TextureAtlas introscreen) {
        introscreen6anim1 = introscreen.findRegion("screen6anim1");
        introscreen6anim2 = introscreen.findRegion("screen6anim2");
        introscreen6anim3 = introscreen.findRegion("screen6anim3");
        introscreen6anim4 = introscreen.findRegion("screen6anim4");
        introscreen6text = introscreen.findRegion("screen6text");

    }
}
