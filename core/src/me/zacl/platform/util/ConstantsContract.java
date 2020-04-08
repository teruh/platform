package me.zacl.platform.util;

/**
 * Holds constant values that may be referenced through out the project
 *
 * @author Zach CLark
 */
public class ConstantsContract {

   /**
    * Class should not/cannot be initialized
    */
   private ConstantsContract() {
   }

   // All tiles are 16x16px
   public static final int TILE_SIZE = 16;

   // Used to scale map pixels to logical dimensions (1x1 in game logic = 16x16px)
   public static final float UNIT_SCALE = 1 / 16f;
}
