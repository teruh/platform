package me.zacl.platform.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import me.zacl.platform.Platform;

public class PlayScreen implements Screen {

   private Platform game;

   private Texture img;

   private OrthographicCamera camera;
   private Viewport           viewport;

   public PlayScreen(Platform game) {
      this.game = game;

      img = new Texture("badlogic.jpg");

      camera = new OrthographicCamera();
      viewport = new FitViewport(game.WORLD_WIDTH / 2, game.WORLD_HEIGHT / 2, camera);
      viewport.apply();
   }

   @Override
   public void show() {

   }

   @Override
   public void render(float delta) {
      Gdx.gl.glClearColor(0, 1, 1, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

      camera.update();
      game.batch.setProjectionMatrix(camera.combined);

      game.batch.begin();
      game.batch.draw(img, 0, 0);
      game.batch.end();
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
      img.dispose();
   }
}
