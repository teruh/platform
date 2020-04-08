package me.zacl.platform.entity;

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
   private GameMap map;      // Game world the entity lives in

   /**
    * Set default class values
    * @param x x-position of the entity in the world
    * @param y y-position of the entity in the world
    * @param map game world the entity lives in
    */
   public Entity(float x, float y, GameMap map) {
      this.position = new Vector2();
      position.x = x;
      position.y = y;
      this.map = map;
   }

   /**
    * Handle entity game logic
    * @param deltaTime engine delta time
    */
   public abstract void update(float deltaTime);

   /**
    * Render entity in the world
    */
   public abstract void render();

   /**
    * Get the position of the entity
    * @return entity's position as a vector
    */
   public Vector2 getPosition() {
      return position;
   }

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
    * Change the map the entity belongs to
    * @param map world the entity exists in
    */
   public void setMap(GameMap map) {
      this.map = map;
   }
}
