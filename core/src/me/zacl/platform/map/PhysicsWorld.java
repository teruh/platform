package me.zacl.platform.map;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import me.zacl.platform.util.ConstantsContract;

/**
 * Encapsulates all Box2D physics code for a tiled map
 * 2020-04-08
 *
 * @author Zach Clark
 */
public class PhysicsWorld {

   private TiledMap tiledMap;                 // The game world this class will handle physics for
   private World    box2DWorld;               // The Box2D physics world
   private Box2DDebugRenderer debugRenderer;  // Used to draw Box2D debugging info

   private BodyDef      bodyDef;       // Body definition for a generated body
   private PolygonShape polygonShape;  // Shape for a generated body
   private FixtureDef   fixtureDef;    // Fixture definition for a generated body
   private Fixture      fixture;
   private Body         body;

   public PhysicsWorld(TiledMap tiledMap) {
      this.tiledMap = tiledMap;

      box2DWorld = new World(new Vector2(0, ConstantsContract.GRAVITY), true);
      debugRenderer = new Box2DDebugRenderer();
   }

   /**
    * Generate solid surface collisions in the Box2D world from rectangles in a Tiled object layer
    *
    * @param layerName the layer the collision objects are on as a string
    */
   public void generateStaticBodiesFromRectangles(String layerName) {
      MapObjects objects = tiledMap.getLayers().get(layerName).getObjects();

      for (MapObject object : objects) {
         Rectangle rectangle = ((RectangleMapObject) object).getRectangle();

         bodyDef = new BodyDef();
         bodyDef.type = BodyDef.BodyType.StaticBody;
         body = box2DWorld.createBody(bodyDef);

         fixture = body.createFixture(generatePolygonShapeFromRectangle(rectangle), 0);

         body.setTransform(getRectangleCenter(rectangle), 0);
      }
   }

   public PolygonShape generatePolygonShapeFromRectangle(Rectangle rectangle) {
      polygonShape = new PolygonShape();
      polygonShape.setAsBox(((rectangle.width / 2) / ConstantsContract.TILE_SIZE),
                            ((rectangle.height / 2) / ConstantsContract.TILE_SIZE));
      return polygonShape;
   }

   public Vector2 getRectangleCenter(Rectangle rectangle) {
      Vector2 center = new Vector2();

      if (rectangle == null) {
         return null;
      }

      rectangle.getCenter(center);
      return center.scl(ConstantsContract.UNIT_SCALE);
   }

   public void render(Matrix4 cameraViewMatrix) {
      debugRenderer.render(this.box2DWorld, cameraViewMatrix);
   }

   public void update() {
      box2DWorld.step(ConstantsContract.TIME_STEP, 6, 2);
   }

   public World getBox2DWorld() {
      return box2DWorld;
   }
}
