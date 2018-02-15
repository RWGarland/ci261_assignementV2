package com.allsopg.game;

import com.allsopg.game.actor.AnimatedSprite;
import com.allsopg.game.actor.BonusSprite;
import com.allsopg.game.utility.Constants;
import com.allsopg.game.utility.UniversalResource;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter {
    private OrthographicCamera camera;
    private Viewport view;
    private SpriteBatch batch;
    private AnimatedSprite umberella;
    private BonusSprite jump, close;
    private float animationTime;
	@Override
	public void create () {
		camera = new OrthographicCamera();
		view = new FitViewport(800,600,camera);
		batch = new SpriteBatch();
		Texture small = new Texture(Gdx.files.internal("gfx/pixelSky.png"));
		Texture medium = new Texture(Gdx.files.internal("gfx/pixelSky.png")); // tried to add own image for background
        jump = new BonusSprite("gfx/Umbrella/UmJump_assets.atlas",medium, // added my sprite animation
                new Vector2(Constants.SCENE_WIDTH/2,Constants.SCENE_HEIGHT/2), Animation.PlayMode.LOOP); // idle animation
		close = new BonusSprite("gfx/UmDestroy/CloseUm_assets.atlas",medium,
				new Vector2(Constants.SCENE_WIDTH/2, Constants.SCENE_HEIGHT/2), Animation.PlayMode.LOOP); // activated animation

        jump.idleRoutine();
		close.activeRoutine();
	}
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        animationTime +=Gdx.graphics.getDeltaTime();
        UniversalResource.getInstance().tweenManager.update(animationTime);
        batch.begin();
        jump.update(animationTime);
        jump.draw(batch);
		close.update(animationTime);
		close.draw(batch);
		batch.end();
	}
	@Override
	public void dispose () {
		batch.dispose();
	}
}
