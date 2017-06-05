package ggj2015.game.resources;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Tiago Santos on 24/01/2015.
 */
public class JunkPack {

    public final TextureAtlas.AtlasRegion glassJunk1;
    public final TextureAtlas.AtlasRegion glassJunk2;
    public final TextureAtlas.AtlasRegion glassJunk3;

    public final TextureAtlas.AtlasRegion paperJunk1;
    public final TextureAtlas.AtlasRegion paperJunk2;
    public final TextureAtlas.AtlasRegion paperJunk3;

    public final TextureAtlas.AtlasRegion plasticJunk1;
    public final TextureAtlas.AtlasRegion plasticJunk2;
    public final TextureAtlas.AtlasRegion plasticJunk3;

    public final TextureAtlas.AtlasRegion bioJunk1;
    public final TextureAtlas.AtlasRegion bioJunk2;
    public final TextureAtlas.AtlasRegion bioJunk3;

    public JunkPack(TextureAtlas junkPack) {
        glassJunk1 = junkPack.findRegion("glass_junk1");
        glassJunk2 = junkPack.findRegion("glass_junk2");
        glassJunk3 = junkPack.findRegion("glass_junk3");

        paperJunk1 = junkPack.findRegion("paper_junk1");
        paperJunk2 = junkPack.findRegion("paper_junk2");
        paperJunk3 = junkPack.findRegion("paper_junk3");

        plasticJunk1 = junkPack.findRegion("plastic_junk1");
        plasticJunk2 = junkPack.findRegion("plastic_junk2");
        plasticJunk3 = junkPack.findRegion("plastic_junk3");

        bioJunk1 = junkPack.findRegion("bio_junk1");
        bioJunk2 = junkPack.findRegion("bio_junk2");
        bioJunk3 = junkPack.findRegion("bio_junk3");
    }

}
