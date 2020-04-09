package me.zacl.platform.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import me.zacl.platform.map.GameMap;

/**
 * Represents an entity that has an X, Y position in the game world
 * 2020-04-08
 *
 * @author Zach Clark
 */
public abstract class Entity {

   private Vector2 position; // X, Y position of the entity in the world

   /**
    * Set default class values
    * @param x x-position of the entity in the world
    * @param y y-position of the entity in the world
    */
   public Entity(float x, float y) {
      this.position = new Vector2();
      position.x = x;
      position.y = y;
   }

   /**
    * Handle entity game logic
    * @param deltaTime engine delta time
    */
   public abstract void update(float deltaTime);

   /**
    * Render entity in the world
    */
   public abstract void render(SpriteBatch batch);

   /**
    * Get the x-position of the entity
    * @return entity's x-position
    */
   public float getPositionX() {
      return position.x;
   }

   /**
    * Get the y-position of the entity
    * @return entity's y-position
    */
   public float getPositionY() {
      return position.y;
   }

   /**
    * Set the position of the entity
    * @param x x-position of the entity in the world
    * @param y y-position of the entity in the world
    */
   public void setPosition(float x, float y) {
      position.x = x;
      position.y = y;
   }

   /**
    * Set the x-position of the entity
    * @param x x-position of the entity
    */
   public void setPositionX(float x) {
      position.x = x;
   }

   /**
    * Set the y-position of the entity
    * @param y y-position of the entity
    */
   public void setPositionY(float y) {
      position.y = y;
   }

   /**
    * Add the given vector to the position vector
    * Allows "movement" by taking existing values and performing addition on them
    * @param vector vector to add to position vector
    */
   public void addToPositionVector(Vector2 vector) {
      position.add(vector);
   }

   /**
    * Add the given components to the position vector
    * Allows "movement" by taking existing values and performing addition on them
    * @param x x-value to add to position vector
    * @param y y-value to add to position vector
    */
   public void addToPositionVector(float x, float y) {
      position.add(x, y);
   }
}
