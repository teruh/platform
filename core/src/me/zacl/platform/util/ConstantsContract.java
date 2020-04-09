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
   public static final float TILE_SIZE = 16f;

   // Used to scale map pixels to logical dimensions (1x1 in game logic = tile size px)
   public static final float UNIT_SCALE = 1f / TILE_SIZE;

   // Player constants
   public static final int FRAME_COLS = 8;
   public static final int FRAME_ROWS = 4;
   public static final float JUMP_FORCE = 4f;
   public static final float MOVE_FORCE = 0.1f;

   // Physics constants
   public static final float GRAVITY = -10;
   public static final float TIME_STEP = 1 / 60f;
}
