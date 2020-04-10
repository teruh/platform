package me.zacl.platform.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import me.zacl.platform.util.ConstantsContract;

/**
 * An entity that is controlled by the user.
 * 2020-04-09
 *
 * @author Zach Clark
 */
public class Player extends PhysicsEntity {

   private Body         body;
   private BodyDef      bodyDef;
   private FixtureDef   fixtureDef;
   private PolygonShape shape;

   private Texture                  texture;
   private TextureRegion[]          regions;
   private Animation<TextureRegion> standAnimation;
   private Animation<TextureRegion> moveAnimation;

   private boolean isFacingLeft;
   private boolean isJumping;

   private float   width;     // Entity's width in world units
   private float   height;    // Entity's height in world units

   private float stateTime = 0;

   /**
    * Set default class values
    *
    * @param x          x-position of the player in the world
    * @param y          y-position of the player in the world
    * @param box2DWorld Box2D simulation the entity lives in
    */
   public Player(float x, float y, World box2DWorld) {
      super(x, y, box2DWorld);

      isFacingLeft = false;

      texture = new Texture("player.png");
      regions = TextureRegion.split(texture, 16, 16)[0];

      standAnimation = new Animation(0, regions[0]);
      moveAnimation = new Animation(0, regions[0], regions[1], regions[2], regions[3]);
      moveAnimation.setPlayMode(Animation.PlayMode.LOOP);

      width = ConstantsContract.UNIT_SCALE * regions[0].getRegionWidth();
      height = ConstantsContract.UNIT_SCALE * regions[0].getRegionHeight();

      bodyDef = new BodyDef();
      bodyDef.position.set(x, y);
      bodyDef.type = BodyDef.BodyType.DynamicBody;
      body = box2DWorld.createBody(bodyDef);

      fixtureDef = new FixtureDef();
      shape = new PolygonShape();
      shape.setAsBox((width / 2), (height / 2));

      fixtureDef.shape = shape;
      body.createFixture(fixtureDef);

      setBody(body);
   }

   public void handleInput(float deltaTime) {
      // Jump
      if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && !isJumping) {
         body.setLinearVelocity(body.getLinearVelocity().x, ConstantsContract.JUMP_FORCE);
         isJumping = true;
      } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
         // Move right
         body.setLinearVelocity(ConstantsContract.MOVE_FORCE, body.getLinearVelocity().y);
         isFacingLeft = false;
      } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
         // Move left
         body.setLinearVelocity(-ConstantsContract.MOVE_FORCE, body.getLinearVelocity().y);
         isFacingLeft = true;
      } else {
         body.setLinearVelocity(0.0f, body.getLinearVelocity().y);
      }

      if(body.getLinearVelocity().y == 0.0f) {
         isJumping = false;
      }
   }

   @Override
   public void update(float deltaTime) {
      stateTime += deltaTime;
      setPosition(body.getPosition().x - width / 2, body.getPosition().y - height / 2);
      handleInput(deltaTime);
   }

   @Override
   public void render(SpriteBatch batch) {
      TextureRegion frame = null;

      if (body.getLinearVelocity().x == 0) {
         frame = standAnimation.getKeyFrame(0);
      } else {
         frame = moveAnimation.getKeyFrame(stateTime);
      }

      batch.begin();
      if (isFacingLeft) {
         batch.draw(frame, getPositionX() + width, getPositionY(), -width, height);
      } else {
         batch.draw(frame, getPositionX(), getPositionY(), width, height);
      }
      batch.end();
   }
}
