package ggj2015.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import ggj2015.game.managers.ResourceManager;
import ggj2015.game.managers.ScreenManager;
import ggj2015.game.utils.Constants;

/**
 * Created by Tiago Santos on 25/01/2015.
 */
public class IntroScreenFirst extends AbstractGameScreen{

    private Stage mIntroScreenStage;
    private Image mImgMainMenuBackground;

    //SCREEN 1
    private Image mImgScreenImage1;
    private Image mImgScreenImage2;
    private Image mImgScreenImage3;
    private Image mTapToContinue;

    //SCREEN2
    private Image mScreen2World;
    private Image mScreen2Anim1;
    private Image mScreen2Anim2;
    private Image mScreen2Anim3;
    private Image mScreen2Anim4;
    private Image mScreen2Text1;
    private Image mScreen2Text2;

    //SCREEN 3
    private Image mScreen3Anim1;
    private Image mScreen3Anim2;
    private Image mScreen3Anim3;

    //SCREEN 4
    private Image mScreen4Anim1;
    private Image mScreen4Anim2;
    private Image mScreen4Anim3;

    //SCREEN 5
    private Image mScreen5Anim1;
    private Image mScreen5Anim2;
    private Image mScreen5Anim3;
    private Image mScreen5Anim4;

    //SCREEN 6
    private Image mScreen6Anim1;
    private Image mScreen6Anim2;
    private Image mScreen6Anim3;
    private Image mScreen6Anim4;
    private Image mScreen6Text;

    //SCREEN 7
    private Image mScreen7Anim1;
    private Image mScreen7Anim2;
    private Image mScreen7Anim3;

    //SCREEN 8
    private Image mScreen8Text;

    private CURRENT_SCREEN mCurrentScreen;
    private boolean mChangeScreen;

    public IntroScreenFirst(ScreenManager screenManager) {
        super(screenManager);
    }

    @Override
    public void show() {
        super.show();

        mCurrentScreen = CURRENT_SCREEN.ONE;
        mChangeScreen = false;

        mIntroScreenStage = new Stage(new ExtendViewport(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT));

        buildIntroScreen();
    }

    private void buildIntroScreen() {
        Texture backgroundTexture = new Texture("levelbackground.png");
        backgroundTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        mImgMainMenuBackground = new Image(backgroundTexture);
        mImgMainMenuBackground.setSize(Constants.VIEWPORT_WIDTH,Constants.VIEWPORT_HEIGHT);

        //SCREEN 1
        mImgScreenImage1 = new Image(ResourceManager.instance.introscreenFirst.introscreen1anim1);
        mImgScreenImage1.setSize(5.72f, 6.416f);
        mImgScreenImage1.setPosition(0f,3.5f);
        mImgScreenImage2 = new Image(ResourceManager.instance.introscreenFirst.introscreen1anim2);
        mImgScreenImage2.setSize(6.472f,9.388f);
        mImgScreenImage2.setPosition(8f,0.35f);
        mImgScreenImage3 = new Image(ResourceManager.instance.introscreenFirst.introscreen1anim3);
        mImgScreenImage3.setSize(5.37f,1.064f);
        mImgScreenImage3.setPosition(12f,0.3f);
        mTapToContinue = new Image(ResourceManager.instance.introscreenFirst.introscreen1tap);
        mTapToContinue.setSize(5.49f,0.315f);
        mTapToContinue.setPosition(12f,0.3f);

        mImgScreenImage2.setVisible(false);
        mImgScreenImage3.setVisible(false);

        //SCREEN 2
        mScreen2World = new Image(ResourceManager.instance.introscreenSecond.introscreen2planet);
        mScreen2World.setSize(3.129f,3.166f);
        mScreen2World.setPosition(7.5f, 3.5f);
        mScreen2Anim1 = new Image(ResourceManager.instance.introscreenSecond.screen2anim1);
        mScreen2Anim1.setSize(0.824f,1.287f);
        mScreen2Anim1.setPosition(8.75f,6.63f);
        mScreen2Anim2 = new Image(ResourceManager.instance.introscreenSecond.screen2anim2);
        mScreen2Anim2.setSize(3.3f,1.731f);
        mScreen2Anim2.setPosition(7.45f,6.2f);
        mScreen2Anim3 = new Image(ResourceManager.instance.introscreenSecond.screen2anim3);
        mScreen2Anim3.setSize(5.31f,3.31f);
        mScreen2Anim3.setPosition(6.5f, 4.65f);
        mScreen2Anim4 = new Image(ResourceManager.instance.introscreenSecond.screen2anim4);
        mScreen2Anim4.setSize(5.56f,5.342f);
        mScreen2Anim4.setPosition(6.35f,2.6f);
        mScreen2Text1 = new Image(ResourceManager.instance.introscreenSecond.screen2text1);
        mScreen2Text1.setSize(5.37f,1.03f);
        mScreen2Text1.setPosition(0.5f,8.5f);
        mScreen2Text2 = new Image(ResourceManager.instance.introscreenSecond.screen2text2);
        mScreen2Text2.setSize(5.37f,1.21f);
        mScreen2Text2.setPosition(12f,0.5f);

        //SCREEN 3
        mScreen3Anim1 = new Image(ResourceManager.instance.introscreenThird.introscreen3anim1);
        mScreen3Anim1.setSize(2.75f,3.94f);
        mScreen3Anim1.setPosition(7.5f, 3.5f);
        mScreen3Anim2 = new Image(ResourceManager.instance.introscreenThird.introscreen3anim2);
        mScreen3Anim2.setSize(0.75f,0.55f);
        mScreen3Anim2.setPosition(3f,7.6f);
        mScreen3Anim3 = new Image(ResourceManager.instance.introscreenThird.introscreen3anim3);
        mScreen3Anim3.setSize(0.259f,0.36f);
        mScreen3Anim3.setPosition(12.1f,9.15f);

        //SCREEN 4
        mScreen4Anim1 = new Image(ResourceManager.instance.introscreenFour.introscreen4anim1);
        mScreen4Anim1.setSize(4.96f,6.69f);
        mScreen4Anim1.setPosition(0.5f,3f);
        mScreen4Anim2 = new Image(ResourceManager.instance.introscreenFour.introscreen4anim2);
        mScreen4Anim2.setSize(2.51f,1.287f);
        mScreen4Anim2.setPosition(6.5f,4f);
        mScreen4Anim3 = new Image(ResourceManager.instance.introscreenFour.introscreen4anim3);
        mScreen4Anim3.setSize(4.85f,3.166f);
        mScreen4Anim3.setPosition(10f,3f);

        //SCREEN 5
        mScreen5Anim1 = new Image(ResourceManager.instance.introscreenFive.introscreen5anim1);
        mScreen5Anim1.setSize(6.31f,6.101f);
        mScreen5Anim1.setPosition(0.5f,3.35f);
        mScreen5Anim2 = new Image(ResourceManager.instance.introscreenFive.introscreen5anim2);
        mScreen5Anim2.setSize(3.407f,1.72f);
        mScreen5Anim2.setPosition(7.5f,3.7f);
        mScreen5Anim3 = new Image(ResourceManager.instance.introscreenFive.introscreen5anim3);
        mScreen5Anim3.setSize(0.66f,0.314f);
        mScreen5Anim3.setPosition(11.9f,4.1f);
        mScreen5Anim4 = new Image(ResourceManager.instance.introscreenFive.introscreen5anim4);
        mScreen5Anim4.setSize(3.46f,3.611f);
        mScreen5Anim4.setPosition(13.5f,0.4f);

        //Screen 6
        mScreen6Anim1 = new Image(ResourceManager.instance.introscreenSix.introscreen6anim1);
        mScreen6Anim1.setSize(14.56f, 9.46f);
        mScreen6Anim1.setPosition(2f,0f);
        mScreen6Anim2 = new Image(ResourceManager.instance.introscreenSix.introscreen6anim2);
        mScreen6Anim2.setSize(11.05f, 6.19f);
        mScreen6Anim2.setPosition(5.6f,0.98f);
        mScreen6Anim3 = new Image(ResourceManager.instance.introscreenSix.introscreen6anim3);
        mScreen6Anim3.setSize(11.15f, 7.42f);
        mScreen6Anim3.setPosition(0.9f,1.1f);
        mScreen6Anim4 = new Image(ResourceManager.instance.introscreenSix.introscreen6anim4);
        mScreen6Anim4.setSize(12.96f, 7.65f);
        mScreen6Anim4.setPosition(3.7f,1.11f);
        mScreen6Text = new Image(ResourceManager.instance.introscreenSix.introscreen6text);
        mScreen6Text.setSize(5.87f,1.95f);
        mScreen6Text.setPosition(0.6f,7.5f);

        //SCREEN 7
        mScreen7Anim1 = new Image(ResourceManager.instance.introscreenSeven.introscreen7anim1);
        mScreen7Anim1.setSize(5.87f, 1.44f);
        mScreen7Anim1.setPosition(0.5f,8f);
        mScreen7Anim2 = new Image(ResourceManager.instance.introscreenSeven.introscreen7anim2);
        mScreen7Anim2.setSize(5.87f, 6.58f);
        mScreen7Anim2.setPosition(0.5f,0.5f);
        mScreen7Anim3 = new Image(ResourceManager.instance.introscreenSeven.introscreen7anim3);
        mScreen7Anim3.setSize(7.305f,9.44f);
        mScreen7Anim3.setPosition(9f,0.5f);

        //SCREEN 8
        mScreen8Text = new Image(ResourceManager.instance.introscreenSeven.introscreen8text);
        mScreen8Text.setSize(17.78f,5.72f);
        mScreen8Text.setPosition(0f,3.5f);

        mIntroScreenStage.addActor(mImgMainMenuBackground);
        mIntroScreenStage.addActor(mImgScreenImage1);
        mIntroScreenStage.addActor(mImgScreenImage2);
        mIntroScreenStage.addActor(mImgScreenImage3);
        mIntroScreenStage.addActor(mTapToContinue);

        mIntroScreenStage.addActor(mScreen2World);
        mIntroScreenStage.addActor(mScreen2Anim1);
        mIntroScreenStage.addActor(mScreen2Anim2);
        mIntroScreenStage.addActor(mScreen2Anim3);
        mIntroScreenStage.addActor(mScreen2Anim4);
        mIntroScreenStage.addActor(mScreen2Text1);
        mIntroScreenStage.addActor(mScreen2Text2);

        mScreen2World.setVisible(false);
        mScreen2Anim1.setVisible(false);
        mScreen2Anim2.setVisible(false);
        mScreen2Anim3.setVisible(false);
        mScreen2Anim4.setVisible(false);
        mScreen2Text1.setVisible(false);
        mScreen2Text2.setVisible(false);

        mIntroScreenStage.addActor(mScreen3Anim1);
        mIntroScreenStage.addActor(mScreen3Anim2);
        mIntroScreenStage.addActor(mScreen3Anim3);

        mScreen3Anim1.setVisible(false);
        mScreen3Anim2.setVisible(false);
        mScreen3Anim3.setVisible(false);

        mIntroScreenStage.addActor(mScreen4Anim1);
        mIntroScreenStage.addActor(mScreen4Anim2);
        mIntroScreenStage.addActor(mScreen4Anim3);

        mScreen4Anim1.setVisible(false);
        mScreen4Anim2.setVisible(false);
        mScreen4Anim3.setVisible(false);

        mIntroScreenStage.addActor(mScreen5Anim1);
        mIntroScreenStage.addActor(mScreen5Anim2);
        mIntroScreenStage.addActor(mScreen5Anim3);
        mIntroScreenStage.addActor(mScreen5Anim4);

        mScreen5Anim1.setVisible(false);
        mScreen5Anim2.setVisible(false);
        mScreen5Anim3.setVisible(false);
        mScreen5Anim4.setVisible(false);

        mIntroScreenStage.addActor(mScreen6Anim1);
        mIntroScreenStage.addActor(mScreen6Anim2);
        mIntroScreenStage.addActor(mScreen6Anim3);
        mIntroScreenStage.addActor(mScreen6Anim4);
        mIntroScreenStage.addActor(mScreen6Text);

        mScreen6Anim1.setVisible(false);
        mScreen6Anim2.setVisible(false);
        mScreen6Anim3.setVisible(false);
        mScreen6Anim4.setVisible(false);
        mScreen6Text.setVisible(false);

        mIntroScreenStage.addActor(mScreen7Anim1);
        mIntroScreenStage.addActor(mScreen7Anim2);
        mIntroScreenStage.addActor(mScreen7Anim3);

        mScreen7Anim1.setVisible(false);
        mScreen7Anim2.setVisible(false);
        mScreen7Anim3.setVisible(false);

        mIntroScreenStage.addActor(mScreen8Text);
        mScreen8Text.setVisible(false);

        mIntroScreenStage.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                switch (mCurrentScreen) {
                    case ONE: handleScreenOne();
                        break;
                    case TWO: handleScreenTwo();
                        break;
                    case THREE: handleScreenThree();
                        break;
                    case FOUR: handleScreenFour();
                        break;
                    case FIVE: handleScreenFive();
                        break;
                    case SIX: handleScreenSix();
                        break;
                    case SEVEN: handleScreenSeven();
                        break;
                    case EIGTH: handleScreenEight();
                        break;
                }

            }
        });
    }

    private void handleScreenSix() {

        if(mScreen6Anim4.isVisible()){
            mCurrentScreen = CURRENT_SCREEN.SEVEN;
            hideScreen6();
            handleScreenSeven();
        } else if(mScreen6Anim3.isVisible()){
            mScreen6Anim4.setVisible(true);
        }else if(mScreen6Anim2.isVisible()){
            mScreen6Anim3.setVisible(true);
        }else  if(mScreen6Anim1.isVisible()){
            mScreen6Anim2.setVisible(true);
        }else if(mScreen6Text.isVisible()){
            mScreen6Anim1.setVisible(true);
        }else mScreen6Text.setVisible(true);

    }

    private void hideScreen6() {
        mScreen6Anim1.setVisible(false);
        mScreen6Anim2.setVisible(false);
        mScreen6Anim3.setVisible(false);
        mScreen6Anim4.setVisible(false);
        mScreen6Text.setVisible(false);
    }

    private void handleScreenSeven() {

        if(mScreen7Anim3.isVisible()) {
           mCurrentScreen = CURRENT_SCREEN.EIGTH;
            hideScreen7();
            handleScreenEight();

        }else if(mScreen7Anim2.isVisible()){
            mScreen7Anim3.setVisible(true);
        }else if(mScreen7Anim1.isVisible()) {
            mScreen7Anim2.setVisible(true);
        }else mScreen7Anim1.setVisible(true);
    }

    private void hideScreen7() {
        mScreen7Anim1.setVisible(false);
        mScreen7Anim2.setVisible(false);
        mScreen7Anim3.setVisible(false);
    }

    private void handleScreenEight() {
        if(mScreen8Text.isVisible()) mScreenManager.setScreen(new GameScreen(mScreenManager),null);
        else mScreen8Text.setVisible(true);
    }

    private void handleScreenFive() {

        if(mScreen5Anim4.isVisible()){
            mCurrentScreen = CURRENT_SCREEN.SIX;
            hideScreen5();
            handleScreenSix();
        }else if(mScreen5Anim3.isVisible()){
            mScreen5Anim4.setVisible(true);

        }else if(mScreen5Anim2.isVisible()){
            mScreen5Anim3.setVisible(true);
        }else if(mScreen5Anim1.isVisible()){
            mScreen5Anim2.setVisible(true);
        }else {
            mScreen5Anim1.setVisible(true);
        }
    }

    private void hideScreen5() {
        mScreen5Anim1.setVisible(false);
        mScreen5Anim2.setVisible(false);
        mScreen5Anim3.setVisible(false);
        mScreen5Anim4.setVisible(false);
    }

    private void handleScreenTwo() {
        if(mScreen2Text2.isVisible()){
            mCurrentScreen = CURRENT_SCREEN.THREE;
            hideScreen2();
            handleScreenThree();
        }else if(mScreen2Anim4.isVisible()){
            mScreen2Text2.setVisible(true);
        }else if(mScreen2Anim3.isVisible()){
            mScreen2Anim4.setVisible(true);
        }else if(mScreen2Anim2.isVisible()){
            mScreen2Anim3.setVisible(true);
        }else if(mScreen2Anim1.isVisible()){
            mScreen2Anim2.setVisible(true);
        }else if(mScreen2World.isVisible()){
            mScreen2Anim1.setVisible(true);
        }else{
            mScreen2World.setVisible(true);
            mScreen2Text1.setVisible(true);
        }
    }

    private void handleScreenThree() {
        if(mScreen3Anim3.isVisible()){
            mCurrentScreen = CURRENT_SCREEN.FOUR;
            hideScreen3();
            handleScreenFour();
        }else if(mScreen3Anim2.isVisible()){
            mScreen3Anim3.setVisible(true);
        }else if(mScreen3Anim1.isVisible()){
            mScreen3Anim2.setVisible(true);
        }else mScreen3Anim1.setVisible(true);

    }

    private void handleScreenFour() {

        if(mScreen4Anim3.isVisible()){
            mCurrentScreen = CURRENT_SCREEN.FIVE;
            hideScreen4();
            handleScreenFive();
        }else{

        if(mScreen4Anim2.isVisible()){
            mScreen4Anim3.setVisible(true);
        }

        if(mScreen4Anim1.isVisible()){
            mScreen4Anim2.setVisible(true);
        }else{
            hideScreen3();
            mScreen4Anim1.setVisible(true);
        }
     }
    }

    private void hideScreen4() {
        mScreen4Anim1.setVisible(false);
        mScreen4Anim2.setVisible(false);
        mScreen4Anim3.setVisible(false);
    }

    private void hideScreen3() {
        mScreen3Anim1.setVisible(false);
        mScreen3Anim2.setVisible(false);
        mScreen3Anim3.setVisible(false);

    }

    private void hideScreen2() {
        mScreen2World.setVisible(false);
        mScreen2Text1.setVisible(false);
        mScreen2Text2.setVisible(false);
        mScreen2Anim1.setVisible(false);
        mScreen2Anim2.setVisible(false);
        mScreen2Anim3.setVisible(false);
        mScreen2Anim4.setVisible(false);


    }

    private void handleScreenOne() {
        if(mChangeScreen){
            mChangeScreen = false;
            mCurrentScreen = CURRENT_SCREEN.TWO;
            hideScreen1();
            handleScreenTwo();
        }else {

            if (!mImgScreenImage2.isVisible()) {
                mImgScreenImage2.setVisible(true);
                mTapToContinue.setVisible(false);
            } else {
                mImgScreenImage3.setVisible(true);
                mChangeScreen = true;
            }
        }
    }

    private void hideScreen1() {
        mImgScreenImage1.setVisible(false);
        mImgScreenImage2.setVisible(false);
        mImgScreenImage3.setVisible(false);
        mTapToContinue.setVisible(false);
    }

    @Override
    public void render(float deltaTime) {
        super.render(deltaTime);

        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mIntroScreenStage.act(deltaTime);
        mIntroScreenStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        //super.resize(width, height);
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
        return mIntroScreenStage;
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    private enum CURRENT_SCREEN{
        ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGTH
    }
}


