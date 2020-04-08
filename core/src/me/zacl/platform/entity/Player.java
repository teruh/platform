package me.zacl.platform.entity;

import me.zacl.platform.map.GameMap;

/**
 * An entity that is controlled by the user.
 * 2020-04-08
 *
 * @author Zach Clark
 */
public class Player extends Entity {

   /**
    * Set default class values
    *
    * @param x   x-position of the entity in the world
    * @param y   y-position of the entity in the world
    * @param map game world the entity lives in
    */
   public Player(float x, float y, GameMap map) {
      super(x, y, map);
   }

   @Override
   public void update(float deltaTime) {

   }

   @Override
   public void render() {

   }
}
