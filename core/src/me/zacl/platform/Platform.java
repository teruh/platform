package me.zacl.platform;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.zacl.platform.screen.PlayScreen;

public class Platform extends Game {
   public final int WORLD_WIDTH = 800;
   public final int WORLD_HEIGHT = 320;

   public SpriteBatch batch;

   @Override
   public void create () {
      batch = new SpriteBatch();
      setScreen(new PlayScreen(this));
   }

   @Override
   public void render () {
      super.render();
   }

   @Override
   public void dispose () {
      batch.dispose();
      super.dispose();
   }
}
