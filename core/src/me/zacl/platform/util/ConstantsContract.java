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

   // Used to scale map pixels to logical dimensions (1x1 in game logic = 16x16 pixels)
   public static final float UNIT_SCALE = 1 / 16f;
}
