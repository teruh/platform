package me.zacl.platform.entity;

import com.badlogic.gdx.graphics.Texture;
import me.zacl.platform.map.GameMap;
import me.zacl.platform.util.ConstantsContract;

/**
 * Represents an entity that has a texture representation in the game world.
 * 2020-04-08
 *
 * @author Zach Clark
 */
public abstract class TexturedEntity extends Entity {

   private Texture texture;   // Texture that represents this entity
   private float   width;     // Entity's width in world units
   private float   height;    // Entity's height in world units

   /**
    * Set default class values
    *
    * @param x   x-position of the entity in the world
    * @param y   y-position of the entity in the world
    * @param map game world the entity lives in
    */
   public TexturedEntity(float x, float y, GameMap map, Texture texture) {
      super(x, y, map);
      this.texture = texture;

      // Scale the width and height of the entity into world units
      width = ConstantsContract.UNIT_SCALE * texture.getWidth();
      height = ConstantsContract.UNIT_SCALE * texture.getHeight();
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
}
