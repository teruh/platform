package me.zacl.platform.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.zacl.platform.map.GameMap;

public class PlayScreen implements Screen {

   private GameMap map; // The current "level" or map
   private OrthographicCamera camera;
   private SpriteBatch spriteBatch;

   public PlayScreen(SpriteBatch spriteBatch) {
      this.spriteBatch = spriteBatch;

      camera = new OrthographicCamera();
      camera.update();

      map = new GameMap("plat_dev.tmx");
   }

   @Override
   public void show() {

   }

   @Override
   public void render(float delta) {
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
      map.dispose();
   }
}
