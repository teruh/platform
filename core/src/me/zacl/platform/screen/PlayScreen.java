package me.zacl.platform.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import me.zacl.platform.entity.Player;
import me.zacl.platform.map.GameMap;
import com.badlogic.gdx.graphics.GL20;
import me.zacl.platform.map.PhysicsWorld;
import me.zacl.platform.util.ConstantsContract;

/**
 * Handles gameplay logic. Initializes the level, player, and related systems.
 * 2020-04-06
 *
 * @author Zach Clark
 */
public class PlayScreen implements Screen {

   private GameMap            map;          // The current "level" or map
   private Player             player;       // The player
   private OrthographicCamera camera;       // The main camera for the level (our eyes!)
   private SpriteBatch        spriteBatch;  // Describes/sends all sprites to the GPU at once
   private PhysicsWorld       physicsWorld; // The physics simulation for this screen

   /**
    * Set default values for the play screen
    */
   public PlayScreen() {
      spriteBatch = new SpriteBatch();

      camera = new OrthographicCamera();
      camera.setToOrtho(false, 20, 10); // How many tiles are visible (e.x. 20x10)
      camera.update();

      map = new GameMap("plat_dev.tmx", ConstantsContract.UNIT_SCALE);
      physicsWorld = new PhysicsWorld(map.getTiledMap());

      player = new Player(4, 4, physicsWorld.getBox2DWorld());

      physicsWorld.generateStaticBodiesFromRectangles("level_col");
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

      physicsWorld.update();

      player.update(Gdx.graphics.getDeltaTime());

      camera.position.x = player.getBody().getPosition().x;
      camera.update();

      map.render(camera, spriteBatch);

      player.render(spriteBatch);

      physicsWorld.render(camera.combined);
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
