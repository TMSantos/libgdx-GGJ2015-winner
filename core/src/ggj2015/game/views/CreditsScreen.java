package ggj2015.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import ggj2015.game.managers.ScreenManager;
import ggj2015.game.utils.Constants;

/**
 * Created by Tiago Santos on 25/01/2015.
 */
public class CreditsScreen extends AbstractGameScreen {

    private Stage mCreditsStage;
    private Image mCreditsImage;

    public CreditsScreen(ScreenManager screenManager) {
        super(screenManager);

        Gdx.input.setCatchBackKey(true);

        mCreditsStage = new Stage(new FitViewport(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT));
    }

    @Override
    public void show() {
        super.show();

        Texture backgroundTexture = new Texture("credits.png");
        backgroundTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        mCreditsImage = new Image(backgroundTexture);
        mCreditsImage.setSize(Constants.VIEWPORT_WIDTH,Constants.VIEWPORT_HEIGHT);

        mCreditsStage.addActor(mCreditsImage);

        mCreditsStage.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                mScreenManager.setScreen(new MainMenuScreen(mScreenManager),null);
            }
        });

    }


    @Override
    public void render(float deltaTime) {
        super.render(deltaTime);

        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mCreditsStage.act(deltaTime);
        mCreditsStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
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
        return mCreditsStage;
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();

        mCreditsStage.dispose();
    }
}
