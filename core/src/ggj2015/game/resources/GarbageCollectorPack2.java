package ggj2015.game.resources;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Tiago Santos on 24/01/2015.
 */
public class GarbageCollectorPack2 {

    public final TextureAtlas.AtlasRegion bioCollector1;
    public final TextureAtlas.AtlasRegion plasticCollector1;

    public final Animation bioCollectorAnimation;
    public final Animation plasticCollectorAnimation;

    public GarbageCollectorPack2(TextureAtlas garbageCollectorPack1){
        bioCollector1 = garbageCollectorPack1.findRegion("bio_collector1");
        plasticCollector1 = garbageCollectorPack1.findRegion("plastic_collector1");

        Array<TextureAtlas.AtlasRegion> bioCollectorRegions = null;

        bioCollectorRegions = new Array<TextureAtlas.AtlasRegion>();
        bioCollectorRegions.add(garbageCollectorPack1.findRegion("bio_collector1"));
        bioCollectorRegions.add(garbageCollectorPack1.findRegion("bio_collector2"));
        bioCollectorRegions.add(garbageCollectorPack1.findRegion("bio_collector3"));
        bioCollectorRegions.add(garbageCollectorPack1.findRegion("bio_collector4"));
        bioCollectorRegions.add(garbageCollectorPack1.findRegion("bio_collector5"));
        bioCollectorRegions.add(garbageCollectorPack1.findRegion("bio_collector6"));
        bioCollectorAnimation = new Animation(0.1f, bioCollectorRegions);

        Array<TextureAtlas.AtlasRegion> plasticCollectorRegions = null;

        plasticCollectorRegions = new Array<TextureAtlas.AtlasRegion>();
        plasticCollectorRegions.add(garbageCollectorPack1.findRegion("plastic_collector1"));
        plasticCollectorRegions.add(garbageCollectorPack1.findRegion("plastic_collector2"));
        plasticCollectorRegions.add(garbageCollectorPack1.findRegion("plastic_collector3"));
        plasticCollectorAnimation = new Animation(0.1f, plasticCollectorRegions);

    }
}
