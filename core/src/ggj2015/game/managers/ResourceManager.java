package ggj2015.game.managers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import ggj2015.game.resources.*;
import ggj2015.game.utils.Constants;

/**
 * Created by Tiago Santos on 23/01/2015.
 */
public class ResourceManager implements Disposable{

    public static final ResourceManager instance = new ResourceManager();

    private AssetManager mAssetManager;

    public GarbageCollectorPack1 garbageCollectorPack1;
    public GarbageCollectorPack2 garbageCollectorPack2;
    public JunkPack junkPack;
    public HUDResources hudResources;
    public MusicResources musicResources;
    public FontResources font;

    public IntroScreenPack1 introscreenFirst;
    public IntroScreenPack2 introscreenSecond;
    public IntroScreenPack3 introscreenThird;
    public IntroScreenPack4 introscreenFour;
    public IntroScreenPack5 introscreenFive;
    public IntroScreenPack6 introscreenSix;
    public IntroScreenPack7 introscreenSeven;

    public ResourceManager() {}

    public void initResourceManager(AssetManager assetManager){
        mAssetManager = assetManager;

        mAssetManager.load(Constants.GARBAGE_COLLECTOR_PACK_1, TextureAtlas.class);
        mAssetManager.load(Constants.GARBAGE_COLLECTOR_PACK_2, TextureAtlas.class);
        mAssetManager.load(Constants.JUNK_PACK, TextureAtlas.class);
        mAssetManager.load(Constants.HUD_PACK,TextureAtlas.class);

        mAssetManager.load(Constants.INTRO_SCREEN_FIRST,TextureAtlas.class);
        mAssetManager.load(Constants.INTRO_SCREEN_SECOND,TextureAtlas.class);
        mAssetManager.load(Constants.INTRO_SCREEN_THIRD,TextureAtlas.class);
        mAssetManager.load(Constants.INTRO_SCREEN_FOUR,TextureAtlas.class);
        mAssetManager.load(Constants.INTRO_SCREEN_FIVE,TextureAtlas.class);
        mAssetManager.load(Constants.INTRO_SCREEN_SIX,TextureAtlas.class);
        mAssetManager.load(Constants.INTRO_SCREEN_SEVEN,TextureAtlas.class);

        mAssetManager.load(Constants.MAIN_MENU_MUSIC, Music.class);
        mAssetManager.load(Constants.LEVEL_MUSIC, Music.class);
        mAssetManager.load(Constants.STAR_THRASH_BUTTON, Sound.class);
        mAssetManager.load(Constants.STAR_THRASH_END_FAIL, Sound.class);
        mAssetManager.load(Constants.STAR_THRASH_END_SUCCESS, Sound.class);
        mAssetManager.load(Constants.STAR_THRASH_FAIL, Sound.class);
        mAssetManager.load(Constants.STAR_THRASH_MONSTER_GLASS, Sound.class);
        mAssetManager.load(Constants.STAR_THRASH_MONSTER_BIO, Sound.class);
        mAssetManager.load(Constants.STAR_THRASH_MONSTER_PAPER, Sound.class);
        mAssetManager.load(Constants.STAR_THRASH_MONSTER_PLASTIC, Sound.class);
        mAssetManager.load(Constants.STAR_THRASH_MOVEMENT, Sound.class);
        mAssetManager.load(Constants.STAR_THRASH_POINTS, Sound.class);
        mAssetManager.finishLoading();

        TextureAtlas garbageCollectorPack1Atlas = assetManager.get(Constants.GARBAGE_COLLECTOR_PACK_1);
        TextureAtlas garbageCollectorPack2Atlas = assetManager.get(Constants.GARBAGE_COLLECTOR_PACK_2);
        TextureAtlas junkAtlas = assetManager.get(Constants.JUNK_PACK);
        TextureAtlas hudAtlas = assetManager.get(Constants.HUD_PACK);

        TextureAtlas introScreenPack1Atlas = assetManager.get(Constants.INTRO_SCREEN_FIRST);
        TextureAtlas secondScreenPack2Atlas = assetManager.get(Constants.INTRO_SCREEN_SECOND);
        TextureAtlas thirdScreenPackAtlas = assetManager.get(Constants.INTRO_SCREEN_THIRD);
        TextureAtlas fourScreenPackAtlas = assetManager.get(Constants.INTRO_SCREEN_FOUR);
        TextureAtlas fiveScreenPackAtlas = assetManager.get(Constants.INTRO_SCREEN_FIVE);
        TextureAtlas sixScreenPackAtlas = assetManager.get(Constants.INTRO_SCREEN_SIX);
        TextureAtlas sevenScreenPackAtlas = assetManager.get(Constants.INTRO_SCREEN_SEVEN);

        for (Texture t : garbageCollectorPack1Atlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        for (Texture t : garbageCollectorPack2Atlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        for (Texture t : junkAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        for (Texture t : hudAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        for (Texture t : introScreenPack1Atlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        for (Texture t : secondScreenPack2Atlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        for (Texture t : thirdScreenPackAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        for (Texture t : fourScreenPackAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        for (Texture t : fiveScreenPackAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        for (Texture t : sixScreenPackAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        for (Texture t : sevenScreenPackAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        garbageCollectorPack1 = new GarbageCollectorPack1(garbageCollectorPack1Atlas);
        garbageCollectorPack2 = new GarbageCollectorPack2(garbageCollectorPack2Atlas);
        junkPack = new JunkPack(junkAtlas);
        hudResources = new HUDResources(hudAtlas);

        introscreenFirst = new IntroScreenPack1(introScreenPack1Atlas);
        introscreenSecond = new IntroScreenPack2(secondScreenPack2Atlas);
        introscreenThird = new IntroScreenPack3(thirdScreenPackAtlas);
        introscreenFour = new IntroScreenPack4(fourScreenPackAtlas);
        introscreenFive = new IntroScreenPack5(fiveScreenPackAtlas);
        introscreenSix = new IntroScreenPack6(sixScreenPackAtlas);
        introscreenSeven = new IntroScreenPack7(sevenScreenPackAtlas);

        musicResources = new MusicResources(mAssetManager);
        font = new FontResources();
    }

    public AssetManager getAssetManager() {
        return mAssetManager;
    }

    @Override
    public void dispose() {
        musicResources.dispose();
    }
}

