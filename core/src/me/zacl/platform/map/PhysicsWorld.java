package me.zacl.platform.map;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Encapsulates all Box2D physics code for a tiled map
 * 2020-04-08
 *
 * @author Zach Clark
 */
public class PhysicsWorld {
   private World box2DWorld;   // The Box2D physics world

   private BodyDef      bodyDef;
   private PolygonShape polygonShape;
   private FixtureDef   fixtureDef;
   private Body         body;

   public PhysicsWorld() {
      box2DWorld = new World(new Vector2(0, 0), true);

      bodyDef = new BodyDef();
      polygonShape = new PolygonShape();
      fixtureDef = new FixtureDef();
   }

   /**
    * Generate solid surface collisions in the Box2D world
    * @param layerName the layer the collision objects are on as a string
    * @return true if collisions generated successfully
    */
   public boolean generateMapCollisions(String layerName) {
      return false;
   }
}
