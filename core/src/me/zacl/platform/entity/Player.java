package me.zacl.platform.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import me.zacl.platform.map.GameMap;
import me.zacl.platform.util.ConstantsContract;

/**
 * An entity that is controlled by the user.
 * 2020-04-08
 *
 * @author Zach Clark
 */
public class Player extends TexturedEntity {

   private boolean isGrounded; // Is the player in the air (from jumping or otherwise)?

   private Vector2 velocity;   // Player's velocity

   /**
    * Set default class values
    *
    * @param x   x-position of the player in the world
    * @param y   y-position of the player in the world
    * @param map game world the player lives in
    */
   public Player(float x, float y, GameMap map) {
      super(x, y, map, new Texture("player.png"));
      velocity = new Vector2();
   }

   @Override
   public void update(float deltaTime) {
      // We only want to run once per frame!
      if (deltaTime == 0) {
         return;
      } else if (deltaTime > 0.1f) {
         deltaTime = 0.1f;
      }

      // Apply gravity
      velocity.add(0, ConstantsContract.GRAVITY);

      // Scale velocity so we know how far we need to move in this update
      velocity.scl(deltaTime);

      // Set the latest position
      addToPositionVector(velocity);

      // Unscale velocity
      velocity.scl(1 / deltaTime);
   }

   @Override
   public void render(SpriteBatch batch) {
      batch.begin();
      batch.draw(getTexture(), getPositionX(), getPositionY(), getWidth(), getHeight());
      batch.end();
   }
}
