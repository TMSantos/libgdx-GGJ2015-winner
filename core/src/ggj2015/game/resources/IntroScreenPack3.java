package ggj2015.game.resources;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Tiago Santos on 25/01/2015.
 */
public class IntroScreenPack3 {

    public final TextureAtlas.AtlasRegion introscreen3anim1;
    public final TextureAtlas.AtlasRegion introscreen3anim2;
    public final TextureAtlas.AtlasRegion introscreen3anim3;

    public IntroScreenPack3(TextureAtlas introscreen) {
        introscreen3anim1 = introscreen.findRegion("screen3anim1");
        introscreen3anim2 = introscreen.findRegion("screen3anim2");
        introscreen3anim3 = introscreen.findRegion("screen3anim3");

    }
}
