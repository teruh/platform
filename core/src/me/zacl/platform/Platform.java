package me.zacl.platform;

import com.badlogic.gdx.Game;
import me.zacl.platform.screen.PlayScreen;

/**
 * This class starts the game and ultimately handles graphics rendering
 * 2020-04-06
 *
 * @author Zach Clark
 */
public class Platform extends Game {
   /**
    * Set the proper game screen and give it references needed to handle rendering/updating
    */
   @Override
   public void create() {
      setScreen(new PlayScreen());
   }

   /**
    * Main game rendering - scenes generally handle this individually
    */
   @Override
   public void render() {
      super.render();
   }

   /**
    * Handle the closing of the game
    */
   @Override
   public void dispose() {
      super.dispose();
   }
}
