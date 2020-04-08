package me.zacl.platform.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.zacl.platform.Platform;

public class DesktopLauncher {
   public static void main (String[] arg) {
      LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
      config.width = 1280;
      config.height = 720;
      config.resizable = false;
      new LwjglApplication(new Platform(), config);
   }
}
