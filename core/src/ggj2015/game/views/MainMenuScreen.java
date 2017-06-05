package ggj2015.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import ggj2015.game.managers.AudioManager;
import ggj2015.game.managers.ResourceManager;
import ggj2015.game.managers.ScreenManager;
import ggj2015.game.utils.Constants;
import ggj2015.game.utils.screentransitions.ScreenTransition;
import ggj2015.game.utils.screentransitions.ScreenTransitionFade;

/**
 * Created by Tiago Santos on 24/01/2015.
 */
public class MainMenuScreen extends AbstractGameScreen{

    private Stage mMainMenuStage;
    private Skin mMainMenuSkin;

    private Image mImgMainMenuBackground;
    private Button mPlayButton;
    private Button mCreditsButton;
    private Button mExitButton;

    public MainMenuScreen(ScreenManager screenManager) {
        super(screenManager);
    }

    @Override
    public void show() {
        super.show();

        Gdx.input.setCatchBackKey(true);

        mMainMenuStage = new Stage(new ExtendViewport(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT));
        buildMainMenu();

        AudioManager.instance.play(ResourceManager.instance.musicResources.menuTheme);
    }

    private void buildMainMenu() {
        mMainMenuSkin = new Skin(Gdx.files.internal(Constants.MAIN_MENU_SKIN),
                new TextureAtlas(Constants.MAIN_MENU_ATLAS));

        Texture backgroundTexture = new Texture("mainmenu/background.png");
        backgroundTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        mImgMainMenuBackground = new Image(backgroundTexture);
        mImgMainMenuBackground.setSize(Constants.VIEWPORT_WIDTH,Constants.VIEWPORT_HEIGHT);
        mPlayButton = new Button(mMainMenuSkin,"Play");
        mPlayButton.setSize(4.06f,1.49f);
        mCreditsButton = new Button(mMainMenuSkin,"Credits");
        mCreditsButton.setSize(4.06f,1.49f);
        mExitButton = new Button(mMainMenuSkin,"Exit");
        mExitButton.setSize(1.611f,1.49f);

        mPlayButton.setPosition(5f,0.1f);
        mCreditsButton.setPosition(9.3f,0.1f);
        mExitButton.setPosition(16f,0.1f);

        mMainMenuStage.addActor(mImgMainMenuBackground);
        mMainMenuStage.addActor(mPlayButton);
        mMainMenuStage.addActor(mCreditsButton);
        mMainMenuStage.addActor(mExitButton);

        mPlayButton.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                //ScreenTransition transition = ScreenTransitionFade.init(0.15f);
                mScreenManager.setScreen(new IntroScreenFirst(mScreenManager),null);
            }
        });

        mCreditsButton.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                mScreenManager.setScreen(new CreditsScreen(mScreenManager),null);
            }
        });

        mExitButton.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mMainMenuStage.act(deltaTime);
        mMainMenuStage.draw();

    }

    @Override
    public void resize(int width, int height) {
        //mMainMenuStage.getViewport().update(width,height);
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public InputProcessor getInputProcessor() {
        return mMainMenuStage;
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
        mMainMenuStage.dispose();
    }
}
