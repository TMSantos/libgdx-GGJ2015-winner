package ggj2015.game.models;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import ggj2015.game.managers.ResourceManager;

/**
 * Created by Tiago Santos on 24/01/2015.
 */
public class JunkCollector extends GameObject{

    private TextureRegion mStandTexture;
    private Animation mEatJunk;

    public static final String JUNK_COLLECTOR_OBJECT = "JUNK_COLLECTOR_OBJECT";

    private boolean mMoveInSquare;
    private float mSpeed;

    private String mEdgeCorner;

    private OBJECT_TYPE mJunkCollectorType;

    private boolean mAnimate;

    public JunkCollector(World world,OBJECT_TYPE junkCollectorType) {
        body = createBody(world);
        //body.setTransform(position,0*MathUtils.degreesToRadians);

        mJunkCollectorType = junkCollectorType;

        switch (mJunkCollectorType){

            case PAPER: mStandTexture = ResourceManager.instance.garbageCollectorPack1.paperCollector1;
                        mEatJunk = ResourceManager.instance.garbageCollectorPack1.paperCollectorAnimation;
                        break;
            case GLASS: mStandTexture = ResourceManager.instance.garbageCollectorPack1.glassCollector1;
                        mEatJunk = ResourceManager.instance.garbageCollectorPack1.glassCollectorAnimation;
                        break;
            case PLASTIC: mStandTexture = ResourceManager.instance.garbageCollectorPack2.plasticCollector1;
                          mEatJunk = ResourceManager.instance.garbageCollectorPack2.plasticCollectorAnimation;
                          break;
            case BIO:   mStandTexture = ResourceManager.instance.garbageCollectorPack2.bioCollector1;
                        mEatJunk = ResourceManager.instance.garbageCollectorPack2.bioCollectorAnimation;
                        break;
        }

        position.x =  body.getPosition().x - origin.x;
        position.y =  body.getPosition().y - origin.y;
        dimension.x =  4.83f;
        dimension.y = 2.64f;
        origin.x = dimension.x / 4;
        origin.y = dimension.y / 4;
    }

    @Override
    public void update(float deltaTime) {
        position.x =  body.getPosition().x;
        position.y =  body.getPosition().y;

        if(mMoveInSquare) moveinsquare();

        if(mAnimate){
            stateTime += deltaTime;
            if(animation == null)setAnimation(mEatJunk);
        }
        else{
            if(animation != null) setAnimation(null);
        }

        if(stateTime > 0.5f){
            stateTime = 0;
            mAnimate = false;
            setAnimation(null);
        }
    }

    private void moveinsquare() {
        //PURE MESSSSSSSSSSS, THE HAMMER IS HEREE,MOVE AWAY!!!!!!!!!!!
        //please dont blame me, I am the only programmer,no sleep and no time for better implementation, soo lets share the love :D
        if(mEdgeCorner.equals("1")){
            if(rotation != 180f){
                dimension.x =  4.83f;
                dimension.y = 2.64f;
                origin.x = dimension.x / 4;
                origin.y = dimension.y / 4;
                body.setTransform(-7.6f,3.7f,0);
            }
            rotation = 180f;
            moveX(new Vector2(1f, 0f));
        }else if(mEdgeCorner.equals("2")){
            if(rotation != 90f){
                dimension.x = 4.83f;
                dimension.y = 2.64f;
                origin.x = dimension.x / 2.5f;
                origin.y = -dimension.y / 4.5f;
                body.setTransform(7.6f,3.7f,0);
            }
            rotation = 90f;
            moveX(new Vector2(0f, -1f));
        }else if(mEdgeCorner.equals("3")){
            if(rotation != 180f){
                dimension.x =  -4.83f;
                dimension.y = -2.64f;
                origin.x = dimension.x / 4;
                origin.y = dimension.y / 4;
                body.setTransform(7.6f,-3.7f,0);
            }
            rotation = 180f;
            moveX(new Vector2(-1f, 0f));
        }else if(mEdgeCorner.equals("4")){
            if(rotation != 90f){
                dimension.x =  -4.83f;
                dimension.y = -2.64f;
                origin.x = dimension.x / 2.5f;
                origin.y = -(dimension.y / 4.5f);
                body.setTransform(-7.6f,-3.7f,0);
            }
            rotation = 90f;
            moveX(new Vector2(0f, 1f));
        }

    }

    public void init(){
        //PURE MESSSSSSSSSSS, THE HAMMER IS HEREEEEE,MOVE AWAY!!!!!!!!!!!
        //please dont blame me, I am the only programmer,no sleep and no time for better implementation, soo lets share the love :D
        if(mEdgeCorner.equals("1")){
            if(rotation != 180f){
                dimension.x =  4.83f;
                dimension.y = 2.64f;
                origin.x = dimension.x / 4;
                origin.y = dimension.y / 4;
                body.setTransform(0f,3.7f,0);
            }
            rotation = 180f;
        }else if(mEdgeCorner.equals("2")){
            if(rotation != 90f){
                dimension.x = 4.83f;
                dimension.y = 2.64f;
                origin.x = dimension.x / 2.5f;
                origin.y = -dimension.y / 4.5f;
                body.setTransform(7.6f,0f,0);
            }
            rotation = 90f;
        }else if(mEdgeCorner.equals("3")){
            if(rotation != 180f){
                dimension.x =  -4.83f;
                dimension.y = -2.64f;
                origin.x = dimension.x / 4;
                origin.y = dimension.y / 4;
                body.setTransform(0f,-3.7f,0);
            }
            rotation = 180f;
        }else if(mEdgeCorner.equals("4")){
            if(rotation != 90f){
                dimension.x =  -4.83f;
                dimension.y = -2.64f;
                origin.x = dimension.x / 2.5f;
                origin.y = -(dimension.y / 4.5f);
                body.setTransform(-7.6f,0f,0);
            }
            rotation = 90f;
        }


    }

    public void moveX(Vector2 direction){
        body.setLinearVelocity((direction.scl(mSpeed)));

    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg = null;

        if(animation != null){
            reg = animation.getKeyFrame(stateTime,true);
        }else{
            reg = mStandTexture;
        }

        batch.draw(reg.getTexture(),
                position.x,
                position.y,
                origin.x,
                origin.y,
                dimension.x,
                dimension.y,
                scale.x,
                scale.y,
                rotation,
                reg.getRegionX(),
                reg.getRegionY(),
                reg.getRegionWidth(),
                reg.getRegionHeight(),
                false,
                false);


    }

    @Override
    public Body createBody(World world) {
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.KinematicBody;

        Body body = world.createBody(def);

        PolygonShape junkCollectorShape = new PolygonShape();
        junkCollectorShape.setAsBox(0.5f,0.5f);

       /* PolygonShape collectorJunkDetector = new PolygonShape();
        collectorJunkDetector.setAsBox(1f, 0.1f, new Vector2(-1f,-1f),0);
        FixtureDef catLeftClawFixture = new FixtureDef();
        catLeftClawFixture.isSensor = true;
        catLeftClawFixture.shape = collectorJunkDetector;
        body.createFixture(catLeftClawFixture);
        collectorJunkDetector.dispose();*/

        FixtureDef junkCollectorFixture = new FixtureDef();
        junkCollectorFixture.isSensor = true;
        junkCollectorFixture.shape = junkCollectorShape;

        body.createFixture(junkCollectorFixture);

        junkCollectorShape.dispose();

        body.getFixtureList().get(0).setUserData(JUNK_COLLECTOR_OBJECT);
        body.setUserData(this);

        return body;
    }


    public float getSpeed() {
        return mSpeed;
    }

    public void setSpeed(float speed) {
        mSpeed = speed;
    }

    public boolean isMoveInSquare() {
        return mMoveInSquare;
    }

    public void setMoveInSquare(boolean moveInSquare) {
        mMoveInSquare = moveInSquare;
    }

    public String getEdgeCorner() {
        return mEdgeCorner;
    }

    public void setEdgeCorner(String edgeCorner) {
        mEdgeCorner = edgeCorner;
    }

    public OBJECT_TYPE getJunkCollectorType() {
        return mJunkCollectorType;
    }

    public void setJunkCollectorType(OBJECT_TYPE junkCollectorType) {
        mJunkCollectorType = junkCollectorType;
    }

    public boolean isAnimate() {
        return mAnimate;
    }

    public void setAnimate(boolean animate) {
        mAnimate = animate;
    }

}
