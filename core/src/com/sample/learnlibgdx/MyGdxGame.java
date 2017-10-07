package com.sample.learnlibgdx;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sample.learnlibgdx.game.Assets;
import com.sample.learnlibgdx.game.WorldController;
import com.sample.learnlibgdx.game.WorldRenderer;
import com.sample.learnlibgdx.screens.MenuScreen;


public class MyGdxGame extends Game {
	private static final String TAG = MyGdxGame.class.getName();

	@Override
	public void create () {
		// Set Libgdx log level
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		// Load assets
		Assets.instance.init(new AssetManager());
		// Start game at menu screen
		setScreen(new MenuScreen(this));
	}

	/*SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;
	Sprite sprite;
	private float rot;

	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(1, h/w);
		camera.translate(0,0);

		batch = new SpriteBatch();
		img = new Texture("images/canyonbunny.pack.png");
		img.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

		TextureRegion region = new TextureRegion(img, 0, 0, 256, 256);
		sprite = new Sprite(img);
		sprite.setSize(1f, h/w); //0.9f *sprite.getHeight() / sprite.getWidth()
		sprite.setOrigin(0f,0);
		sprite.translate(-0.5f, -h/w/2);
		//sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
		//sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);
		//sprite.setPosition(-0.5f,(-h/w)/2);
	}

	@Override
	public void render () {
		camera.update();
		Gdx.gl.glClearColor(1f, 0.5f,0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		final float degreesPerSecond = 100.0f;
		//rot = (rot + Gdx.graphics.getDeltaTime() * degreesPerSecond) % 360;
		//sprite.setRotation(rot);
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}*/

}
