package ggj2015.game.resources;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Tiago Santos on 25/01/2015.
 */
public class IntroScreenPack2 {

    public final TextureAtlas.AtlasRegion introscreen2planet;
    public final TextureAtlas.AtlasRegion screen2anim1;
    public final TextureAtlas.AtlasRegion screen2anim2;
    public final TextureAtlas.AtlasRegion screen2anim3;
    public final TextureAtlas.AtlasRegion screen2anim4;
    public final TextureAtlas.AtlasRegion screen2text1;
    public final TextureAtlas.AtlasRegion screen2text2;

    public IntroScreenPack2(TextureAtlas introscreen) {
        introscreen2planet = introscreen.findRegion("screen2world");
        screen2anim1 = introscreen.findRegion("screen2anim1");
        screen2anim2 = introscreen.findRegion("screen2anim2");
        screen2anim3 = introscreen.findRegion("screen2anim3");
        screen2anim4 = introscreen.findRegion("screen2anim4");
        screen2text1 = introscreen.findRegion("screen2text1");
        screen2text2 = introscreen.findRegion("screen2text2");

    }
}
