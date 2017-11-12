package com.sample.learnlibgdx.screens.transitions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;

//still a bit confused why we need to flip the texture vertically here
//should experiment a bit with fbo myself, perhaps checking if we're not using the drawing function to the screen, it might behave normally?
//but I wonder how to simulate that.
//current possible explanation : the result of the drawing already mapped to windows coordinate system which is 0,0 at top left corner, making the pixels on fbo vertically flipped?
public class ScreenTransitionFade implements ScreenTransition
{
    private static final ScreenTransitionFade instance = new ScreenTransitionFade();
    private float duration;

    public static ScreenTransitionFade init (float duration) {
        instance.duration = duration;
        return instance;
    }

    @Override
    public float getDuration() {
        return duration;
    }

    @Override
    public void render(SpriteBatch batch, Texture currScreen, Texture nextScreen, float alpha)
    {
        float w = currScreen.getWidth();
        float h = currScreen.getHeight();
        alpha = Interpolation.fade.apply(alpha);
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setColor(1, 1, 1, 1);
        batch.draw(currScreen, 0, 0, 0, 0, w, h, 1, 1, 0, 0, 0,
                currScreen.getWidth(), currScreen.getHeight(),
                false, true);
        batch.setColor(1, 1, 1, alpha);
        batch.draw(nextScreen, 0, 0, 0, 0, w, h, 1, 1, 0, 0, 0,
                nextScreen.getWidth(), nextScreen.getHeight(),
                false, true);
        batch.end();
    }
}
