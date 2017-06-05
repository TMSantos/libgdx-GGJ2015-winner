package ggj2015.game.models;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Random;

/**
 * Created by Tiago Santos Santos on 24/01/2015.
 * GGJ2015
 */
public class ObjectFactory {

    public JunkCollector getJunkCollector(World world,GameObject.OBJECT_TYPE objectType) {
        return new JunkCollector(world,objectType);
    }

    public Junk getJunk(World mWorld,float destroyTime,int levelnumber) {
        Random random = new Random();

        int possibleGeneratedTypes = 0;

        if(levelnumber == 1) possibleGeneratedTypes = 2;
        if(levelnumber == 2) possibleGeneratedTypes = 3;
        if(levelnumber == 3) possibleGeneratedTypes = 4;
        if(levelnumber == 4) possibleGeneratedTypes = 3;
        if(levelnumber > 4) possibleGeneratedTypes = 4;

        int randomType = (int)(Math.random() * possibleGeneratedTypes + 1);

        float randomX =  random.nextFloat() * 12 - 6;
        float randomY = random.nextFloat() * 7 - 3;


        if(randomType == 1 ) return new Junk(mWorld,new Vector2(randomX,randomY), GameObject.OBJECT_TYPE.PLASTIC,destroyTime);
        if(randomType == 2 ) return new Junk(mWorld,new Vector2(randomX,randomY), GameObject.OBJECT_TYPE.BIO,destroyTime);
        if(randomType == 3 ) return new Junk(mWorld,new Vector2(randomX,randomY), GameObject.OBJECT_TYPE.GLASS,destroyTime);
        if(randomType == 4 ) return new Junk(mWorld,new Vector2(randomX,randomY), GameObject.OBJECT_TYPE.PAPER,destroyTime);

        return null;
    }
}
