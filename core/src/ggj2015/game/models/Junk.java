package ggj2015.game.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import ggj2015.game.managers.ResourceManager;

import java.util.Random;

/**
 * Created by Tiago Santos on 23/01/2015.
 */
public class Junk extends GameObject{

    public static final String JUNK_OBJECT = "JUNK_OBJECT";

    private OBJECT_TYPE mJunkType;

    private float mDestroyTimer;

    private float mTimeAlive;

    private TextureRegion mTexture;

    public Junk(World world,Vector2 pos,OBJECT_TYPE objectType,float destroyTimer) {
        body = createBody(world);
        body.setTransform(pos,0);
        body.setAngularVelocity(50f);

        mJunkType = objectType;
        mDestroyTimer = destroyTimer;
        mTimeAlive = 0;

        position.x =  body.getPosition().x - origin.x;
        position.y =  body.getPosition().y - origin.y;
        dimension.x =  1.88f;
        dimension.y = 2.06f;
        origin.x = dimension.x / 2;
        origin.y = dimension.y / 2;
        rotation = body.getAngle();

        Random random = new Random();
        float randomX =  random.nextFloat() * 2 - 1;

        float randomY = random.nextFloat() * 2 - 1;

        body.applyLinearImpulse(new Vector2(randomX, randomY), body.getLocalCenter(), true);

        int texture = random.nextInt(3 - 1 + 1) + 1;

        switch (objectType) {
            case PAPER: generateRandomPaper(texture);
                break;
            case GLASS: generateRandomGlass(texture);
                break;
            case PLASTIC: generateRandomPlastic(texture);
                break;
            case BIO: genrateRandomBio(texture);
                break;
        }

    }

    private void genrateRandomBio(int texture) {
        if(texture == 1) mTexture = ResourceManager.instance.junkPack.bioJunk1;
        if(texture == 2) mTexture = ResourceManager.instance.junkPack.bioJunk2;
        if(texture == 3) mTexture = ResourceManager.instance.junkPack.bioJunk3;
    }

    private void generateRandomPlastic(int texture) {
        if(texture == 1) mTexture = ResourceManager.instance.junkPack.plasticJunk1;
        if(texture == 2) mTexture = ResourceManager.instance.junkPack.plasticJunk2;
        if(texture == 3) mTexture = ResourceManager.instance.junkPack.plasticJunk3;
    }

    private void generateRandomGlass(int texture) {
        if(texture == 1) mTexture = ResourceManager.instance.junkPack.glassJunk1;
        if(texture == 2) mTexture = ResourceManager.instance.junkPack.glassJunk2;
        if(texture == 3) mTexture = ResourceManager.instance.junkPack.glassJunk3;
    }

    private void generateRandomPaper(int texture) {
        if(texture == 1) mTexture = ResourceManager.instance.junkPack.paperJunk1;
        if(texture == 2) mTexture = ResourceManager.instance.junkPack.paperJunk2;
        if(texture == 3) mTexture = ResourceManager.instance.junkPack.paperJunk3;
    }

    @Override
    public void update(float deltaTime) {
        mTimeAlive+=deltaTime;
        position.x =  body.getPosition().x - origin.x;
        position.y =  body.getPosition().y - origin.y;
        rotation = body.getAngle();

        if(mTimeAlive > mDestroyTimer){
            setShouldDestroy(true);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(mTexture.getTexture(),
                position.x,
                position.y,
                origin.x,
                origin.y,
                dimension.x,
                dimension.y,
                scale.x,
                scale.y,
                rotation,
                mTexture.getRegionX(),
                mTexture.getRegionY(),
                mTexture.getRegionWidth(),
                mTexture.getRegionHeight(),
                false,
                false);
    }

    @Override
    public Body createBody(World world) {
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;

        Body body = world.createBody(def);

        CircleShape sugarFoodShape = new CircleShape();
        sugarFoodShape.setRadius(0.5f);

        FixtureDef sugarFoodFixture = new FixtureDef();
        sugarFoodFixture.isSensor = true;
        sugarFoodFixture.shape = sugarFoodShape;

        body.createFixture(sugarFoodFixture);

        sugarFoodShape.dispose();

        body.getFixtureList().get(0).setUserData(JUNK_OBJECT);
        body.setUserData(this);

        return body;
    }

    public OBJECT_TYPE getJunkType() {
        return mJunkType;
    }

    public void setJunkType(OBJECT_TYPE junkType) {
        mJunkType = junkType;
    }

    public void setShouldDestroy(boolean shouldDestroy) {
        if(shouldDestroy){
            //body.setUserData("destroy");
            body.getFixtureList().get(0).setUserData("destroy");
        }
    }


}
