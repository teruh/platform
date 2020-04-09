package me.zacl.platform.entity;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Represents an entity that has a texture representation in the game world.
 * 2020-04-08
 *
 * @author Zach Clark
 */
public abstract class PhysicsEntity extends Entity {

   /**
    * Physics variables
    */
   private World box2DWorld;
   private Body    body;

   /**
    * Set default class values
    *
    * @param x   x-position of the entity in the world
    * @param y   y-position of the entity in the world
    * @param box2DWorld Box2D simulation the entity lives in
    */
   public PhysicsEntity(float x, float y, World box2DWorld) {
      super(x, y);

      this.box2DWorld = box2DWorld;
   }

   public World getBox2DWorld() {
      return box2DWorld;
   }

   public Body getBody() {
      return body;
   }

   public void setBody(Body body) {
      this.body = body;
   }
}
