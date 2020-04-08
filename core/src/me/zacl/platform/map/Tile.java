package me.zacl.platform.map;

import java.util.HashMap;

/**
 * Represent a tile in the game world.
 * 2020-04-08
 *
 * @author Zach Clark
 */
public enum Tile {

   /**
    * Tile types
    */
   AIR(0, "Air", false),
   SKY(1, "Sky", false),
   BRICKS(2, "Brick", true);

   private int     id;          // Tile's unique identifier
   private String  name;        // Tile's name for debugging/logging
   private boolean isSolid;     // Will things collide with this tile?

   private static HashMap<Integer, Tile> tileMap; // Hold the tile type tied to it's id

   /**
    * Set default tile values
    *
    * @param id      tile's unique identifier
    * @param name    tile's name
    * @param isSolid if things will collide with the tile in the world
    */
   Tile(int id, String name, boolean isSolid) {
      this.id = id;
      this.isSolid = isSolid;
   }

   /**
    * Get the tile's unique id number
    *
    * @return tile's unique identifier
    */
   public int getId() {
      return id;
   }

   /**
    * Get the tile's name
    *
    * @return tile's name
    */
   public String getName() {
      return name;
   }

   /**
    * Whether or not things should collide with this tile
    *
    * @return true if things should collide with this tile
    */
   public boolean isSolid() {
      return isSolid;
   }

   static {
      tileMap = new HashMap<>();

      for (Tile tile : Tile.values()) {
         tileMap.put(tile.getId(), tile);
      }
   }

   /**
    * Find the type of tile connected to a certain id
    *
    * @param id tile's id
    * @return the type of tile tied to this id
    */
   public static Tile getTileTypeByID(int id) {
      return tileMap.get(id);
   }
}
