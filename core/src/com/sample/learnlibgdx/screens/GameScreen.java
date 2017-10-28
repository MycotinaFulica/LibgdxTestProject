package com.sample.learnlibgdx.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.sample.learnlibgdx.game.WorldController;
import com.sample.learnlibgdx.game.WorldRenderer;
import com.sample.learnlibgdx.util.GamePreferences;

public class GameScreen extends AbstractGameScreen {
    private static final String TAG = GameScreen.class.getName();
    private WorldController worldController;
    private WorldRenderer worldRenderer;
    private boolean paused;

    public static boolean toSwitch;

    public GameScreen (Game game) {
        super(game);
    }
    @Override
    public void render (float deltaTime) {
        // Do not update game world when paused.
        if (!paused) {
            // Update game world by the time that has passed
            // since last rendered frame.
            worldController.update(deltaTime);
        }
        // Sets the clear screen color to: Cornflower Blue
        Gdx.gl.glClearColor(0x64 / 255.0f, 0x95 / 255.0f,0xed / 255.0f, 0xff / 255.0f);
        // Clears the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Render game world to screen
        worldRenderer.render();

        if(toSwitch) {
            game.setScreen(new MenuScreen(game));
        }
    }
    @Override
    public void resize (int width, int height) {
        worldRenderer.resize(width, height);
    }
    @Override
    public void show () {
        toSwitch = false;
        GamePreferences.instance.load();
        Gdx.app.log(TAG, "Showing Game Screen Uh Oh");
        worldController = new WorldController(game);
        Gdx.app.log(TAG, "Showing Game Screen Uh Oh2");
        worldRenderer = new WorldRenderer(worldController);
        Gdx.app.log(TAG, "Showing Game Screen Uh Oh3");
        Gdx.input.setCatchBackKey(true);
    }
    @Override
    public void hide () {
        worldRenderer.dispose();
        Gdx.input.setCatchBackKey(false);
    }
    @Override
    public void pause () {
        paused = true;
    }
    @Override
    public void resume () {
        super.resume();
        // Only called on Android!
        paused = false;
    }
}