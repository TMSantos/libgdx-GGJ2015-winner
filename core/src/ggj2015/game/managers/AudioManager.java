package ggj2015.game.managers;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Tiago Santos on 23/01/2015.
 */
public class AudioManager {

    public static final AudioManager instance = new AudioManager();

    private Music playingMusic;

    private AudioManager () {
    }

    public void play (Sound sound) {
        play(sound, 1);
    }

    public void play (Sound sound, float volume) {
        play(sound, volume, 1);
    }

    public void play (Sound sound, float volume, float pitch) {
        play(sound, volume, pitch, 0);
    }

    public void play (Sound sound, float volume, float pitch, float pan) {
       // if (!GamePreferences.instance.sound) return;
       // sound.play(GamePreferences.instance.volSound * volume, pitch, pan);
        sound.play(1f,pitch,pan);
    }

    public void play (Music music) {
        playingMusic = music;
        music.setLooping(true);
        music.setVolume(0.5f);
        music.play();

       /* if (GamePreferences.instance.music) {
            music.setLooping(true);
            music.setVolume(GamePreferences.instance.volMusic);
            music.play();
        }*/
    }

    public void stopMusic () {
        if (playingMusic != null) playingMusic.stop();
    }

    public Music getPlayingMusic () {
        return playingMusic;
    }


    public void onSettingsUpdated () {
        if (playingMusic == null) return;

      //  playingMusic.setVolume(GamePreferences.instance.volMusic);

       /* if (GamePreferences.instance.music) {
            if (!playingMusic.isPlaying()) playingMusic.play();
        }
        else {
            playingMusic.pause();
        }*/

    }
}
