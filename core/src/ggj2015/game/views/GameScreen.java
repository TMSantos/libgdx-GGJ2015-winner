package ggj2015.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import com.badlogic.gdx.physics.box2d.joints.MouseJoint;
import com.badlogic.gdx.physics.box2d.joints.MouseJointDef;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxBuild;
import com.badlogic.gdx.utils.viewport.FitViewport;
import ggj2015.game.controllers.Level;
import ggj2015.game.controllers.WorldRenderer;
import ggj2015.game.managers.AudioManager;
import ggj2015.game.managers.ResourceManager;
import ggj2015.game.managers.ScreenManager;
import ggj2015.game.models.Junk;
import ggj2015.game.utils.Constants;

/**
 * Created by Tiago Santos on 23/01/2015.
 */
public class GameScreen extends AbstractGameScreen implements InputProcessor{

    private float screenWidth;
    private float screenHeight;

    private OrthographicCamera mGameCamera;

    private Stage mGameScreenStage;

    private Image mLevelBackground;
    private Image mHUDScoreBox;

    private Image mWinScreen;
    private Image mLostScreen;

    private float mWinScreenVirtualWidth = 7.6f;
    private float mWinScreenVirtualHeight = 3.56f;

    private float mLostScreenVirtualWidth = 7.26f;
    private float mLostScreenVirtualHeight = 4.36f;


    private float mHUDScoreBoxVirtualWidth = 4.2f;
    private float mHUDScoreBoxVirtualHeight = 1.288f;

    private Level mLevel;
    private WorldRenderer mWorldRenderer;

    protected MouseJoint mouseJoint = null;

    private boolean mGameOverHandled;

    private BitmapFont mGameScore;

    public GameScreen(ScreenManager screenManager) {
        super(screenManager);
    }

    Vector3 testPoint = new Vector3();
    QueryCallback callback = new QueryCallback() {
        @Override
        public boolean reportFixture (Fixture fixture) {
                if(fixture.getUserData() != null && !fixture.getUserData().equals(Junk.JUNK_OBJECT)){
                    return true;
                }else if (fixture.testPoint(testPoint.x, testPoint.y)) {
                    mLevel.setHitBody(fixture.getBody());
                    mLevel.getHitBody().setAngularVelocity(0);
                    return false;
                } else  return true;
        }
    };

    @Override
    public void show() {
        super.show();

        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();

        mGameOverHandled = false;

        mGameScreenStage = new Stage(new FitViewport(Constants.VIEWPORT_GUI_WIDTH,Constants.VIEWPORT_GUI_HEIGHT));
        mGameCamera = (OrthographicCamera) mGameScreenStage.getCamera();

        Texture backgroundTexture = new Texture(Constants.LEVEL_BACKGROUND);
        backgroundTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        mLevelBackground = new Image(backgroundTexture);

        /*Texture hudTexture = new Texture(Constants.HUD_SCORE_BOX);
        hudTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);*/

        mHUDScoreBox  = new Image(ResourceManager.instance.hudResources.HUDScoreBox);
        mHUDScoreBox.setSize((mHUDScoreBoxVirtualWidth*screenHeight)/Constants.VIEWPORT_HEIGHT,
                             (mHUDScoreBoxVirtualHeight*screenHeight)/Constants.VIEWPORT_HEIGHT);
        mHUDScoreBox.setPosition(50,(8.5f*screenHeight/Constants.VIEWPORT_HEIGHT));

        mWinScreen = new Image(ResourceManager.instance.hudResources.HUDWinScreen);
        mWinScreen.setSize((mWinScreenVirtualWidth*screenHeight)/Constants.VIEWPORT_HEIGHT,
                           (mWinScreenVirtualHeight*screenHeight)/Constants.VIEWPORT_HEIGHT);
        mWinScreen.setPosition((screenWidth/4),(screenHeight/3));
        mWinScreen.setVisible(false);

        mLostScreen = new Image(ResourceManager.instance.hudResources.HUDLostScreen);
        mLostScreen.setSize((mLostScreenVirtualWidth*screenHeight)/Constants.VIEWPORT_HEIGHT,
                (mLostScreenVirtualHeight*screenHeight)/Constants.VIEWPORT_HEIGHT);
        mLostScreen.setPosition((screenWidth/4),(screenHeight/4));
        mLostScreen.setVisible(false);

        mGameScreenStage.addActor(mLevelBackground);
        mGameScreenStage.addActor(mHUDScoreBox);
        mGameScreenStage.addActor(mWinScreen);
        mGameScreenStage.addActor(mLostScreen);

        mLevel = new Level(1);
        mWorldRenderer = new WorldRenderer(mLevel);

        if(screenHeight < 550) mGameScore = ResourceManager.instance.font.defaultUltraSmall;
        if(screenHeight >= 550 && screenHeight < 850) mGameScore = ResourceManager.instance.font.defaultSmall;
        if(screenHeight >= 850) mGameScore = ResourceManager.instance.font.defaultNormal;

        AudioManager.instance.stopMusic();
        AudioManager.instance.play(ResourceManager.instance.musicResources.levelTheme);

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render(float deltaTime) {
        super.render(deltaTime);

        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mGameCamera.setToOrtho(false);

        mGameScreenStage.act(deltaTime);
        mGameScreenStage.draw();

        mWorldRenderer.render();
        renderGuiFpsCounter(mWorldRenderer.getmBatch());

        if(mLevel.isGameOver()){
            if(mLevel.getCurrentScore() >= mLevel.getGoalScore()){
                mWinScreen.setVisible(true);
            }else{
                mLostScreen.setVisible(true);
            }
        }

        mLevel.update(deltaTime);
    }

    private void nextLevel(int level) {
        mLevel.reset(level);
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
        return this;
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(mLevel.isGameOver()){
            if(mLevel.getCurrentScore() >= mLevel.getGoalScore()){
                if(mLevel.getLevelNumber() == 6) mScreenManager.setScreen(new MainMenuScreen(mScreenManager),null);
                else{
                    nextLevel(mLevel.getLevelNumber()+1);
                    mWinScreen.setVisible(false);
                }

            }else{
                nextLevel(mLevel.getLevelNumber());
                mLostScreen.setVisible(false);
            }
        }else {
            mWorldRenderer.getCamera().unproject(testPoint.set(screenX, screenY, 0));
            mLevel.getWorld().QueryAABB(callback, testPoint.x - 0.1f, testPoint.y - 0.1f, testPoint.x + 0.1f, testPoint.y + 0.1f);

            if (mLevel.getHitBody() != null) {
                ResourceManager.instance.musicResources.starMonsterMovement.play();
                MouseJointDef def = new MouseJointDef();
                def.bodyA = mLevel.getGroundBody();
                def.bodyB = mLevel.getHitBody();
                def.collideConnected = true;
                def.target.set(testPoint.x, testPoint.y);
                def.maxForce = 1000.0f;// * mLevel.getHitBody().getMass();

                mouseJoint = (MouseJoint) mLevel.getWorld().createJoint(def);
                mLevel.getHitBody().setAwake(true);
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(mouseJoint == null) return false;
        mLevel.getWorld().destroyJoint(mouseJoint);
        mLevel.setHitBody(null);
        mouseJoint = null;
       // mDestroyJoint = true;
        Array<Body> mBodyList = new Array<Body>();
        mLevel.getWorld().getBodies(mBodyList);

        for(Body body : mBodyList){
            if(body.getUserData() != null && body.getUserData().equals("destroy")){
                mLevel.getWorld().destroyBody(body);
            }
        }

        return true;

    }

    Vector2 target = new Vector2();

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (mouseJoint != null) {
            mWorldRenderer.getCamera().unproject(testPoint.set(screenX, screenY, 0));
            mouseJoint.setTarget(target.set(testPoint.x, testPoint.y));
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private void renderGuiFpsCounter (SpriteBatch batch) {
        mGameCamera.setToOrtho(true);
        batch.setProjectionMatrix(mGameCamera.combined);
        batch.begin();

        mGameScore.draw(batch, "Goal: " + mLevel.getGoalScore(), (1.574f* screenHeight)/Constants.VIEWPORT_HEIGHT,
                                                                 (0.46f* screenHeight)/Constants.VIEWPORT_HEIGHT);
        mGameScore.setColor(1, 1, 1, 1);
        mGameScore.draw(batch, "Score: " + mLevel.getCurrentScore(), (1.574f * screenHeight) / Constants.VIEWPORT_HEIGHT,
                (0.926f * screenHeight) / Constants.VIEWPORT_HEIGHT);

        batch.end();

    }

}
