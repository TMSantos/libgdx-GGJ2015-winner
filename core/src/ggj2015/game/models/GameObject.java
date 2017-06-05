package ggj2015.game.models;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Tiago Santos on 23/01/2015.
 */
public abstract class GameObject {

    protected Body body;
    protected Vector2 position;
    protected Vector2 dimension;
    protected Vector2 origin;
    protected Vector2 scale;
    protected float rotation;
    protected boolean shouldRender;
    public Animation animation;
    public float stateTime;

    public void setAnimation (Animation animation) {
        this.animation = animation;
        stateTime = 0;
    }

    public GameObject () {
        position = new Vector2();
        dimension = new Vector2();
        origin = new Vector2();
        scale = new Vector2(1, 1);
        shouldRender = true;
    }

    public Body getBody(){
        return body;
    }

    public void update(float deltaTime){

    };

    public abstract void render(SpriteBatch batch);

    public abstract Body createBody(World world);

    public enum OBJECT_TYPE{
        PAPER,GLASS,PLASTIC,BIO
    }
}
