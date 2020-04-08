package me.zacl.platform.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import me.zacl.platform.util.ConstantsContract;

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

   /**
    * Get the tile at a world coordinate.
    *
    * @param layer  map layer to search
    * @param column tile's column
    * @param row    tile's row
    * @return tile at the specified world coordinate
    */
   public Tile getTileTypeByCoordinate(int layer, int column, int row) {
      TiledMapTile tile;
      TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) tiledMap.getLayers().get(layer))
          .getCell(column, row);

      // Make sure cell actually exists before doing anything to prevent npx
      if (cell != null) {
         tile = cell.getTile();

         // Make sure tile actually exists before doing anything to prevent npx
         if (tile != null) {
            int id = tile.getId();
            return Tile.getTileTypeByID(id);
         }
      }

      return null;
   }

   /**
    * Get the tile at a certain pixel location.
    * Simply calls getTileTypeByCoordinate by converting x/y pixels to the world coordinates.
    *
    * @param layer map layer to search
    * @param x     x-pixel
    * @param y     y-pixel
    * @return tile at the specified pixel location
    */
   public Tile getTileTypeByLocation(int layer, float x, float y) {
      return this.getTileTypeByCoordinate(layer, (int) (x / ConstantsContract.TILE_SIZE),
                                          (int) (y / ConstantsContract.TILE_SIZE));
   }
}
