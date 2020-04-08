package me.zacl.platform.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.zacl.platform.Platform;

/**
 * Entry point for desktop version of the game
 *
 * @author Zach CLark
 */
public class DesktopLauncher {

   /**
    * Start an instance of an LWJGL application with our game code
    * @param arg command-line arguments
    */
   public static void main (String[] arg) {
      LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

      // TODO: remove this!
      config.width = 1280;
      config.height = 720;
      config.resizable = false;

      new LwjglApplication(new Platform(), config);
   }
}
