package me.zacl.platform.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.zacl.platform.map.GameMap;
import com.badlogic.gdx.graphics.GL20;

/**
 * Handles game play logic. Initializes the level, player, and related systems.
 * 2020-04-06
 *
 * @author Zach Clark
 */
public class PlayScreen implements Screen {
   // Used to scale map pixels to logical dimensions (1x1 in game logic = 16x16 pixels)
   private final float UNIT_SCALE = 1 / 16f;

   private GameMap            map;         // The current "level" or map
   private OrthographicCamera camera;      // The main camera for the level (our eyes!)
   private SpriteBatch        spriteBatch; // Describes/sends all sprites to the GPU at once

   /**
    * Set default values for the play screen
    */
   public PlayScreen() {
      spriteBatch = new SpriteBatch();

      camera = new OrthographicCamera();
      camera.setToOrtho(false, 20, 10); // How many tiles are visible (e.x. 20x10)
      camera.update();

      map = new GameMap("plat_dev.tmx", UNIT_SCALE);
   }

   @Override
   public void show() {

   }

   /**
    * Called each frame. Render the level, everything in it, as well as the UI.
    *
    * @param deltaTime engine delta-time
    */
   @Override
   public void render(float deltaTime) {
      // Clear color is an awful red so it's obvious when something is wrong here
      Gdx.gl.glClearColor(1, 0, 0, 1);
      Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

      camera.update();
      map.render(camera, spriteBatch);
   }

   @Override
   public void resize(int width, int height) {

   }

   @Override
   public void pause() {

   }

   @Override
   public void resume() {

   }

   @Override
   public void hide() {

   }

   @Override
   public void dispose() {
      spriteBatch.dispose();
      map.dispose();
   }
}
