package me.zacl.platform.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import me.zacl.platform.util.ConstantsContract;

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

   private Texture texture;   // Texture that represents this entity
   private float   width;     // Entity's width in world units
   private float   height;    // Entity's height in world units

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

//      // Scale the width and height of the entity into world units
//      width = ConstantsContract.UNIT_SCALE * texture.getWidth();
//      height = ConstantsContract.UNIT_SCALE * texture.getHeight();
   }

   /**
    * Get the texture that represents this entity
    * @return texture that represents this entity
    */
   public Texture getTexture() {
      return texture;
   }

   /**
    * Set the texture that represents this entity
    * @param texture texture that represents this entity
    */
   public void setTexture(Texture texture) {
      this.texture = texture;
   }

   /**
    * Entity's width in world units
    * @return entity's width in world units
    */
   public float getWidth() {
      return width;
   }

   /**
    * Set the width of the entity in world units
    * @param width entity's width in world units
    */
   public void setWidth(float width) {
      this.width = width;
   }

   /**
    * Entity's height in world units
    * @return entity's height in world units
    */
   public float getHeight() {
      return height;
   }

   /**
    * Set the height of the entity in world units
    * @param height entity's height in world units
    */
   public void setHeight(float height) {
      this.height = height;
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
