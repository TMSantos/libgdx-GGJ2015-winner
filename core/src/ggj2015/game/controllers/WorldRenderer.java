package ggj2015.game.controllers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.Disposable;
import ggj2015.game.managers.ResourceManager;
import ggj2015.game.utils.Constants;

/**
 * Created by Tiago Santos on 23/01/2015.
 */
public class WorldRenderer implements Disposable {

    private OrthographicCamera mCamera;
    public OrthographicCamera mCameraGUI;

    private SpriteBatch mBatch;
    private Level mLevel;

    //private BitmapFont mGameScore;

    private Box2DDebugRenderer b2debugRenderer;

    private float mGUIpointX;
    private float mGUIpointY;

    public WorldRenderer (Level level) {
        mBatch = new SpriteBatch();

        mLevel = level;
        mCamera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        mCamera.position.set(0, 0, 0);
        mCamera.zoom = 1f;
        mCamera.update();

        mCameraGUI = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
        mCameraGUI.position.set(Constants.VIEWPORT_GUI_WIDTH/2,  Constants.VIEWPORT_GUI_HEIGHT/2, 0);
        mCameraGUI.setToOrtho(true);
        mCameraGUI.update();

        //mGameScore = ResourceManager.instance.font.defaultNormal;

        mGUIpointX = mCameraGUI.viewportWidth-(mCameraGUI.viewportWidth/3.5f);
        mGUIpointY = mCameraGUI.viewportHeight - (mCameraGUI.viewportHeight-20);
        b2debugRenderer = new Box2DDebugRenderer();
    }

    public void render(){
        renderLevel(mBatch);
        //renderGUI(mBatch);
       // b2debugRenderer.render(mLevel.getWorld(), mCamera.combined);
    }

    private void renderLevel(SpriteBatch batch) {
        batch.setProjectionMatrix(mCamera.combined);
        batch.begin();
        mLevel.render(batch);
        batch.end();
    }

    private void renderGUI(SpriteBatch batch) {
        batch.setProjectionMatrix(mCameraGUI.combined);
        batch.begin();
        //renderGuiFpsCounter(batch);
        batch.end();
    }
    public OrthographicCamera getCamera() {
        return mCamera;
    }

    @Override
    public void dispose() {
        mBatch.dispose();
    }

    /*private void renderGuiFpsCounter (SpriteBatch batch) {
        if(mLevel.isGameOver()){
            if(mLevel.getCurrentScore() >= mLevel.getGoalScore()) {
                mGameScore.draw(batch, "You completed this level", mCameraGUI.viewportWidth / 3.5f, mCameraGUI.viewportHeight / 2);
                mGameScore.draw(batch, "Tap on screen for the next.", mCameraGUI.viewportWidth / 3.5f, mCameraGUI.viewportHeight / 2 + 50);
            }else{
                mGameScore.draw(batch, "You lost, what do we do now?", mCameraGUI.viewportWidth / 4f, mCameraGUI.viewportHeight / 2);
                mGameScore.draw(batch, "There is no more hope.", mCameraGUI.viewportWidth / 4f, mCameraGUI.viewportHeight / 2+50);
                mGameScore.draw(batch, "Your cat is going to die because of you..", mCameraGUI.viewportWidth / 4f, mCameraGUI.viewportHeight / 2+100);
            }
        }else {
            mGameScore.draw(batch, "Goal: " + mLevel.getGoalScore(), mGUIpointX, mGUIpointY);
            mGameScore.setColor(1, 1, 1, 1);
            mGameScore.draw(batch, "Score: " + mLevel.getCurrentScore(), mGUIpointX, mGUIpointY + 50);
        }

    }*/

    public SpriteBatch getmBatch() {
        return mBatch;
    }

    public void setmBatch(SpriteBatch mBatch) {
        this.mBatch = mBatch;
    }


}
