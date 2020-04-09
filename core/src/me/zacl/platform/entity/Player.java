package me.zacl.platform.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * An entity that is controlled by the user.
 * 2020-04-08
 *
 * @author Zach Clark
 */
public class Player extends PhysicsEntity {

   private Body body;
   private BodyDef bodyDef;
   private FixtureDef fixtureDef;
   private PolygonShape shape;

   /**
    * Set default class values
    *
    * @param x   x-position of the player in the world
    * @param y   y-position of the player in the world
    * @param box2DWorld Box2D simulation the entity lives in
    */
   public Player(float x, float y, World box2DWorld) {
      super(x, y, box2DWorld);

      bodyDef = new BodyDef();
      bodyDef.position.set(x, y);
      bodyDef.type = BodyDef.BodyType.DynamicBody;
      body = box2DWorld.createBody(bodyDef);

      fixtureDef = new FixtureDef();
      shape = new PolygonShape();
      shape.setAsBox(0.5f, 1f);

      fixtureDef.shape = shape;
      body.createFixture(fixtureDef);

      setBody(body);
   }

   public void handleInput(float deltaTime) {
      // Jump
      if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
         body.applyLinearImpulse(new Vector2(0, 4f), body.getWorldCenter(), true);
      }

      // Move right
      if(Gdx.input.isKeyPressed(Input.Keys.D)) {
         body.applyLinearImpulse(new Vector2(0.1f, 0), body.getWorldCenter(), true);
      }

      // Move left
      if(Gdx.input.isKeyPressed(Input.Keys.A)) {
         body.applyLinearImpulse(new Vector2(-0.1f, 0), body.getWorldCenter(), true);
      }
   }

   @Override
   public void update(float deltaTime) {
      handleInput(deltaTime);
   }

   @Override
   public void render(SpriteBatch batch) {
      batch.begin();

      batch.end();
   }
}
