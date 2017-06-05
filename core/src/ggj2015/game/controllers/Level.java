package ggj2015.game.controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import ggj2015.game.managers.AudioManager;
import ggj2015.game.managers.ResourceManager;
import ggj2015.game.models.GameObject;
import ggj2015.game.models.Junk;
import ggj2015.game.models.JunkCollector;
import ggj2015.game.models.ObjectFactory;

/**
 * Created by Tiago Santos on 23/01/2015.
 */
public class Level {

    private static final String WALL_BODY = "WALL_BODY";

    private static final String WORLD_EDGE = "WORLD_EDGE";
    private static final String WORLD_EDGE_1 = "1";
    private static final String WORLD_EDGE_2 = "2";
    private static final String WORLD_EDGE_3 = "3";
    private static final String WORLD_EDGE_4 = "4";

    private World mWorld;

    private ObjectFactory mObjectFactory;

    private Array<JunkCollector> mJunkCollectorsList;
    private Array<Body> mBodyList;
    private Array<Junk> mJunkList;

    private Body mHitBody = null;
    private Body mGroundBody = null;

    private float mTimer;

    private int mLevelNumber;

    //Level properties
    private int mCurrentScore;
    private int mGoalScore;
    private float mGeneratorTimer;
    private int mNumberOfJunkPieces;
    private int mMaxNumberOfJunkPieces;

    private boolean mIsGameOver;

    public Level(int levelNumber) {
        mWorld = new World(new Vector2(0f,0f),true);
        mObjectFactory = new ObjectFactory();
        mBodyList = new Array<Body>();
        mJunkList = new Array<Junk>();
        mJunkCollectorsList = new Array<JunkCollector>();
        init(levelNumber);

    }

    public void init(int levelNumber){
        mLevelNumber = levelNumber;
        generateLevel();

        BodyDef bodyDef = new BodyDef();
        mGroundBody = mWorld.createBody(bodyDef);
        createPhysicsWorld();
        createCollisionListener();
        mIsGameOver = false;
    }

    private void generateLevel() {
        if(mLevelNumber == 1) generateLevel1();
        if(mLevelNumber == 2) generateLevel2();
        if(mLevelNumber == 3) generateLevel3();
        if(mLevelNumber == 4) generateLevel4();
        if(mLevelNumber == 5) generateLevel5();
        if(mLevelNumber == 6) generateAsianLevel();
    }

    private void createPhysicsWorld() {
        createWorldEdge(new Vector2(-8.4f,4.5f),WORLD_EDGE_1);
        createWorldEdge(new Vector2(8.4f,4.5f),WORLD_EDGE_2);
        createWorldEdge(new Vector2(8.4f, -4.5f), WORLD_EDGE_3);
        createWorldEdge(new Vector2(-8.4f,-4.5f),WORLD_EDGE_4);
    }

    private void createWorldEdge(Vector2 position, String userdata) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        CircleShape worldEdge = new CircleShape();
        worldEdge.setRadius(0.5f);

        FixtureDef worldEdgeFixture = new FixtureDef();
        worldEdgeFixture.isSensor = true;
        worldEdgeFixture.shape = worldEdge;

        Body ball = mWorld.createBody(bodyDef);
        ball.createFixture(worldEdgeFixture);

        ball.getFixtureList().get(0).setUserData(WORLD_EDGE);
        ball.setUserData(userdata);

        worldEdge.dispose();

        ball.setTransform(position,0);
    }

    public void update(float deltaTime) {
        //if(mIsGameOver) return;
        mTimer += deltaTime;
        mWorld.step(deltaTime, 8, 3);

        for(JunkCollector collector : mJunkCollectorsList){
            collector.update(deltaTime);
        }

        for(Junk junk : mJunkList){
            junk.update(deltaTime);
        }

        mWorld.getBodies(mBodyList);

        for(Body body : mBodyList) {
            if (body.getFixtureList() != null && body.getFixtureList().size > 0 && body.getFixtureList().get(0).getUserData().equals("destroy")) {
                //fast solution to prevent Box2D crash. (Bodies are still being destroyed, but not here, they are destroyed after we destroy first mouseJoint)
                body.setTransform(-100, -100, 0);
                mJunkList.removeValue((Junk) body.getUserData(),true);

            }
        }

        if(mTimer > mGeneratorTimer && mNumberOfJunkPieces <= mMaxNumberOfJunkPieces){
            mNumberOfJunkPieces++;
            mTimer = 0;
            Junk junk = mObjectFactory.getJunk(mWorld,5f,mLevelNumber);
            mJunkList.add(junk);
        }

        if(mNumberOfJunkPieces > mMaxNumberOfJunkPieces){
            if(mJunkList.size == 0) mIsGameOver = true;
        }

    }

    public void render(SpriteBatch batch) {

        for(Junk junk: mJunkList){
            junk.render(batch);
        }

        for(JunkCollector collector : mJunkCollectorsList){
            collector.render(batch);
        }
    }

    private void createWall(Vector2 startPoint,Vector2 endPoint){
        BodyDef mWallBodyDef = new BodyDef();
        mWallBodyDef.type = BodyDef.BodyType.StaticBody;
        Body mWallBody = mWorld.createBody(mWallBodyDef);

        EdgeShape mWallShape = new EdgeShape();
        mWallShape.set(startPoint,endPoint);

        FixtureDef mWallFixture = new FixtureDef();
        mWallFixture.shape = mWallShape;
        mWallFixture.density = 0f;
        mWallFixture.friction = 0f;
        mWallBody.createFixture(mWallFixture);
        mWallBody.getFixtureList().get(0).setUserData(WALL_BODY);
        mWallShape.dispose();
    }

    public void reset(int level) {
        mCurrentScore = 0;
        mNumberOfJunkPieces = 0;
        mWorld.getBodies(mBodyList);

        for(Body body : mBodyList) {
            mWorld.destroyBody(body);
        }

        mBodyList.clear();
        mJunkList.clear();
        mJunkCollectorsList.clear();
        init(level);
    }

    public World getWorld() {
        return mWorld;
    }

    public void setWorld(World world) {
        mWorld = world;
    }

    public Body getHitBody() {
        return mHitBody;
    }

    public void setHitBody(Body hitBody) {
        mHitBody = hitBody;
    }

    public Body getGroundBody() {
        return mGroundBody;
    }

    private void createCollisionListener() {
        mWorld.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();

                if(fixtureA == null || fixtureB == null || fixtureA.getUserData() == null || fixtureB.getUserData() == null) return;

                if(fixtureA.getUserData().equals(Junk.JUNK_OBJECT) && fixtureB.getUserData().equals(JunkCollector.JUNK_COLLECTOR_OBJECT)){
                    Junk junk = (Junk) fixtureA.getBody().getUserData();
                    junk.setShouldDestroy(true);

                    JunkCollector collector = (JunkCollector) fixtureB.getBody().getUserData();

                    if(junk.getJunkType().equals(collector.getJunkCollectorType())){
                        switch (collector.getJunkCollectorType()) {
                            case PAPER: ResourceManager.instance.musicResources.starMonsterPaper.play();
                                break;
                            case GLASS: ResourceManager.instance.musicResources.starMonsterGlass.play();
                                break;
                            case PLASTIC: ResourceManager.instance.musicResources.starMonsterPlastic.play();
                                break;
                            case BIO: ResourceManager.instance.musicResources.starMonsterBio.play();
                                break;
                        }
                        mCurrentScore+=100;
                        collector.setAnimate(true);
                    }else{
                        ResourceManager.instance.musicResources.starThrashFail.play();
                    }

                }

                if(fixtureB.getUserData().equals(Junk.JUNK_OBJECT) && fixtureA.getUserData().equals(JunkCollector.JUNK_COLLECTOR_OBJECT)){
                    Junk junk = (Junk) fixtureB.getBody().getUserData();
                    junk.setShouldDestroy(true);

                    JunkCollector collector = (JunkCollector) fixtureA.getBody().getUserData();

                    if(junk.getJunkType().equals(collector.getJunkCollectorType())){
                        switch (collector.getJunkCollectorType()) {
                            case PAPER: ResourceManager.instance.musicResources.starMonsterPaper.play();
                                break;
                            case GLASS: ResourceManager.instance.musicResources.starMonsterGlass.play();
                                break;
                            case PLASTIC: ResourceManager.instance.musicResources.starMonsterPlastic.play();
                                break;
                            case BIO: ResourceManager.instance.musicResources.starMonsterBio.play();
                                break;
                        }
                        mCurrentScore+=100;
                        collector.setAnimate(true);
                    }else{
                        ResourceManager.instance.musicResources.starThrashFail.play();
                    }
                }

                if(fixtureA.getUserData().equals(JunkCollector.JUNK_COLLECTOR_OBJECT) && fixtureB.getUserData().equals(WORLD_EDGE)){
                    JunkCollector collector = (JunkCollector) fixtureA.getBody().getUserData();
                    collector.setEdgeCorner(fixtureB.getBody().getUserData().toString());
                }

                if(fixtureB.getUserData().equals(JunkCollector.JUNK_COLLECTOR_OBJECT) && fixtureA.getUserData().equals(WORLD_EDGE)){
                    JunkCollector collector = (JunkCollector) fixtureB.getBody().getUserData();
                    collector.setEdgeCorner(fixtureA.getBody().getUserData().toString());
                }
            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });
    }


    private void generateLevel1(){
        JunkCollector mJunkCollector = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.PLASTIC);
        mJunkCollector.setMoveInSquare(false);
        mJunkCollector.setEdgeCorner("2");
        mJunkCollector.init();

        JunkCollector mJunkCollector2 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.BIO);
        mJunkCollector2.setMoveInSquare(false);
        mJunkCollector2.setEdgeCorner("4");
        mJunkCollector2.init();

        mJunkCollectorsList.add(mJunkCollector);
        mJunkCollectorsList.add(mJunkCollector2);

        mGeneratorTimer = 2f;
        mGoalScore = 1000;
        mMaxNumberOfJunkPieces = 20;
    }

    private void generateLevel2(){
        JunkCollector mJunkCollector = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.PLASTIC);
        mJunkCollector.setMoveInSquare(false);
        mJunkCollector.setEdgeCorner("1");
        mJunkCollector.init();

        JunkCollector mJunkCollector2 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.BIO);
        mJunkCollector2.setMoveInSquare(false);
        mJunkCollector2.setEdgeCorner("2");
        mJunkCollector2.init();

        JunkCollector mJunkCollector3 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.GLASS);
        mJunkCollector3.setMoveInSquare(false);
        mJunkCollector3.setEdgeCorner("3");
        mJunkCollector3.init();

        mJunkCollectorsList.add(mJunkCollector);
        mJunkCollectorsList.add(mJunkCollector2);
        mJunkCollectorsList.add(mJunkCollector3);

        mGeneratorTimer = 2f;
        mGoalScore = 1500;
        mMaxNumberOfJunkPieces = 20;
    }

    private void generateLevel3(){
        JunkCollector mJunkCollector = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.PLASTIC);
        mJunkCollector.setMoveInSquare(false);
        mJunkCollector.setEdgeCorner("1");
        mJunkCollector.init();

        JunkCollector mJunkCollector2 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.BIO);
        mJunkCollector2.setMoveInSquare(false);
        mJunkCollector2.setEdgeCorner("2");
        mJunkCollector2.init();

        JunkCollector mJunkCollector3 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.GLASS);
        mJunkCollector3.setMoveInSquare(false);
        mJunkCollector3.setEdgeCorner("3");
        mJunkCollector3.init();

        JunkCollector mJunkCollector4 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.PAPER);
        mJunkCollector4.setMoveInSquare(false);
        mJunkCollector4.setEdgeCorner("4");
        mJunkCollector4.init();

        mJunkCollectorsList.add(mJunkCollector);
        mJunkCollectorsList.add(mJunkCollector2);
        mJunkCollectorsList.add(mJunkCollector3);
        mJunkCollectorsList.add(mJunkCollector4);

        mGeneratorTimer = 1f;
        mGoalScore = 2000;
        mMaxNumberOfJunkPieces = 35;
    }

    private void generateLevel4(){
        JunkCollector mJunkCollector = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.PLASTIC);
        mJunkCollector.setMoveInSquare(true);
        mJunkCollector.setEdgeCorner("1");
        mJunkCollector.setSpeed(2f);

        JunkCollector mJunkCollector2 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.BIO);
        mJunkCollector2.setMoveInSquare(true);
        mJunkCollector2.setEdgeCorner("2");
        mJunkCollector2.setSpeed(2f);

        JunkCollector mJunkCollector3 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.GLASS);
        mJunkCollector3.setMoveInSquare(true);
        mJunkCollector3.setEdgeCorner("3");
        mJunkCollector3.setSpeed(2f);

        mJunkCollectorsList.add(mJunkCollector);
        mJunkCollectorsList.add(mJunkCollector2);
        mJunkCollectorsList.add(mJunkCollector3);

        mGeneratorTimer = 1f;
        mGoalScore = 2500;
        mMaxNumberOfJunkPieces = 40;
    }

    private void generateLevel5(){
        JunkCollector mJunkCollector = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.PLASTIC);
        mJunkCollector.setMoveInSquare(true);
        mJunkCollector.setEdgeCorner("1");
        mJunkCollector.setSpeed(2f);

        JunkCollector mJunkCollector2 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.BIO);
        mJunkCollector2.setMoveInSquare(true);
        mJunkCollector2.setEdgeCorner("2");
        mJunkCollector2.setSpeed(2f);

        JunkCollector mJunkCollector3 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.GLASS);
        mJunkCollector3.setMoveInSquare(true);
        mJunkCollector3.setEdgeCorner("3");
        mJunkCollector3.setSpeed(2f);

        JunkCollector mJunkCollector4 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.PAPER);
        mJunkCollector4.setMoveInSquare(true);
        mJunkCollector4.setEdgeCorner("4");
        mJunkCollector4.setSpeed(2f);

        mJunkCollectorsList.add(mJunkCollector);
        mJunkCollectorsList.add(mJunkCollector2);
        mJunkCollectorsList.add(mJunkCollector3);
        mJunkCollectorsList.add(mJunkCollector4);

        mGeneratorTimer = 1f;
        mGoalScore = 3000;
        mMaxNumberOfJunkPieces = 35;

    }

    private void generateAsianLevel(){
        mJunkCollectorsList = new Array<JunkCollector>();
        JunkCollector mJunkCollector = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.PLASTIC);
        mJunkCollector.setMoveInSquare(true);
        mJunkCollector.setEdgeCorner("1");
        mJunkCollector.setSpeed(10f);

        JunkCollector mJunkCollector2 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.BIO);
        mJunkCollector2.setMoveInSquare(true);
        mJunkCollector2.setEdgeCorner("2");
        mJunkCollector2.setSpeed(10f);

        JunkCollector mJunkCollector3 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.GLASS);
        mJunkCollector3.setMoveInSquare(true);
        mJunkCollector3.setEdgeCorner("3");
        mJunkCollector3.setSpeed(10f);

        JunkCollector mJunkCollector4 = mObjectFactory.getJunkCollector(mWorld,GameObject.OBJECT_TYPE.PAPER);
        mJunkCollector4.setMoveInSquare(true);
        mJunkCollector4.setEdgeCorner("4");
        mJunkCollector4.setSpeed(10f);

        mJunkCollectorsList.add(mJunkCollector);
        mJunkCollectorsList.add(mJunkCollector2);
        mJunkCollectorsList.add(mJunkCollector3);
        mJunkCollectorsList.add(mJunkCollector4);

        mGeneratorTimer = 2f;
        mGoalScore = 10000;

    }

    public boolean isGameOver() {
        return mIsGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        mIsGameOver = isGameOver;
    }

    public int getGoalScore() {
        return mGoalScore;
    }

    public void setGoalScore(int goalScore) {
        mGoalScore = goalScore;
    }

    public int getCurrentScore() {
        return mCurrentScore;
    }

    public void setCurrentScore(int currentScore) {
        mCurrentScore = currentScore;
    }

    public int getLevelNumber() {
        return mLevelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        mLevelNumber = levelNumber;
    }

}

