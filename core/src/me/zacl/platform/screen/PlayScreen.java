package me.zacl.platform.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import me.zacl.platform.Platform;

public class PlayScreen implements Screen {

   private Platform game;

   private OrthographicCamera camera;

   private TmxMapLoader mapLoader;
   private TiledMap tiledMap;
   private OrthogonalTiledMapRenderer mapRenderer;

   private float unitScale = 1 / 16f;

   public PlayScreen(Platform game) {
      this.game = game;

      mapLoader = new TmxMapLoader();
      tiledMap = mapLoader.load("plat_dev.tmx");
      mapRenderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);

      camera = new OrthographicCamera();
      camera.setToOrtho(false, 20, 10);
      camera.update();
   }

   @Override
   public void show() {

   }

   public void update(float dt) {
      camera.update();
      mapRenderer.setView(camera);
   }

   @Override
   public void render(float delta) {
      update(delta);

      Gdx.gl.glClearColor(1, 0, 0, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

      mapRenderer.render();

      camera.update();
      game.batch.setProjectionMatrix(camera.combined);
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
   }
}
