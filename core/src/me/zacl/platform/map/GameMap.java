package me.zacl.platform.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Handle the loading and rendering of a TiledMap
 * 2020-04-06
 *
 * @author Zach Clark
 */
public class GameMap {
   private TiledMap                   tiledMap;      // Reference to the tiled map
   private OrthogonalTiledMapRenderer mapRenderer;   // Handles rendering of tiles

   /**
    * Set default class attributes
    *
    * @param mapPath   LibGDX's directory path to the map
    * @param unitScale logical representation of the world (1x1 in code = unitScale tile pixels)
    */
   public GameMap(String mapPath, float unitScale) {
      tiledMap = new TmxMapLoader().load(mapPath);
      mapRenderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);
   }

   /**
    * Handle the rendering of the game's map
    * Does nothing on it's own -> must be called from a render method in screen
    *
    * @param camera camera the world will be visible from
    * @param batch  SpriteBatch that map will render to
    */
   public void render(OrthographicCamera camera, SpriteBatch batch) {
      mapRenderer.setView(camera);
      mapRenderer.render();

      batch.setProjectionMatrix(camera.combined);

      batch.begin();
      // TODO: render entities here
      batch.end();
   }

   /**
    * Clear memory allocated to the loaded Tiled map
    */
   public void dispose() {
      tiledMap.dispose();
   }
}
