package me.zacl.platform.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.zacl.platform.map.GameMap;

/**
 * An entity that is controlled by the user.
 * 2020-04-08
 *
 * @author Zach Clark
 */
public class Player extends TexturedEntity {
   /**
    * Set default class values
    *
    * @param x   x-position of the player in the world
    * @param y   y-position of the player in the world
    * @param map game world the player lives in
    */
   public Player(float x, float y, GameMap map) {
      super(x, y, map, new Texture("player.png"));
   }

   @Override
   public void update(float deltaTime) {

   }

   @Override
   public void render(SpriteBatch batch) {
      batch.begin();
      batch.draw(getTexture(), getPositionX(), getPositionY(), getWidth(), getHeight());
      batch.end();
   }
}
