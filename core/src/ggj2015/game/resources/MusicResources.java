package ggj2015.game.resources;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Tiago Santos on 24/01/2015.
 */
public class MusicResources {

    public final Music menuTheme;
    public final Music levelTheme;

    public final Sound starThrashButton;
    public final Sound starThrashEndFail;
    public final Sound starThrashEndSuccess;
    public final Sound starThrashFail;
    public final Sound starMonsterGlass;
    public final Sound starMonsterBio;
    public final Sound starMonsterPaper;
    public final Sound starMonsterPlastic;
    public final Sound starMonsterMovement;
    public final Sound starMonsterPoints;


    public MusicResources (AssetManager am) {
        menuTheme = am.get("music/Star_trash_menu.mp3", Music.class);
        levelTheme = am.get("music/Star_trash_game.mp3", Music.class);

        starThrashButton = am.get("music/Star_trash_button.mp3",Sound.class);
        starThrashEndFail = am.get("music/Star_trash_end_fail.mp3",Sound.class);
        starThrashEndSuccess = am.get("music/Star_trash_end_succes.mp3",Sound.class);
        starThrashFail = am.get("music/Star_trash_fail.mp3",Sound.class);
        starMonsterGlass = am.get("music/Star_trash_monster_glass.mp3",Sound.class);
        starMonsterBio = am.get("music/Star_trash_monster_bio.mp3",Sound.class);
        starMonsterPaper = am.get("music/Star_trash_monster_paper.mp3",Sound.class);
        starMonsterPlastic = am.get("music/Star_trash_monster_plastic.mp3",Sound.class);
        starMonsterMovement = am.get("music/Star_trash_movement.mp3",Sound.class);
        starMonsterPoints = am.get("music/Star_trash_points.mp3",Sound.class);


    }

    public void dispose(){
        menuTheme.dispose();
        levelTheme.dispose();

        starThrashButton.dispose();
        starThrashEndFail.dispose();
        starThrashEndSuccess.dispose();
        starThrashFail.dispose();
        starMonsterGlass.dispose();
        starMonsterBio.dispose();
        starMonsterPaper.dispose();
        starMonsterPlastic.dispose();
        starMonsterMovement.dispose();
        starMonsterPoints.dispose();
    }
}
