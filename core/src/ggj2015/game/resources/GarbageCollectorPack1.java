package ggj2015.game.resources;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Tiago Santos on 24/01/2015.
 */
public class GarbageCollectorPack1 {

    public final TextureAtlas.AtlasRegion glassCollector1;
    public final TextureAtlas.AtlasRegion paperCollector1;

    public final Animation glassCollectorAnimation;
    public final Animation paperCollectorAnimation;

    public GarbageCollectorPack1(TextureAtlas garbageCollectorPack1){
        glassCollector1 = garbageCollectorPack1.findRegion("glass_collector1");
        paperCollector1 = garbageCollectorPack1.findRegion("paper_collector1");

        Array<TextureAtlas.AtlasRegion> glassCollectorRegions = null;

        glassCollectorRegions = new Array<TextureAtlas.AtlasRegion>();
        glassCollectorRegions.add(garbageCollectorPack1.findRegion("glass_collector1"));
        glassCollectorRegions.add(garbageCollectorPack1.findRegion("glass_collector2"));
        glassCollectorRegions.add(garbageCollectorPack1.findRegion("glass_collector3"));
        glassCollectorRegions.add(garbageCollectorPack1.findRegion("glass_collector4"));
        glassCollectorAnimation = new Animation(0.1f, glassCollectorRegions);

        Array<TextureAtlas.AtlasRegion> paperCollectorRegions = null;

        paperCollectorRegions = new Array<TextureAtlas.AtlasRegion>();
        paperCollectorRegions.add(garbageCollectorPack1.findRegion("paper_collector1"));
        paperCollectorRegions.add(garbageCollectorPack1.findRegion("paper_collector2"));
        paperCollectorRegions.add(garbageCollectorPack1.findRegion("paper_collector3"));
        paperCollectorRegions.add(garbageCollectorPack1.findRegion("paper_collector4"));
        paperCollectorAnimation = new Animation(0.1f, paperCollectorRegions);

    }
}
