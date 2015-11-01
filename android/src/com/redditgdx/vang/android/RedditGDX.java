package com.redditgdx.vang.android;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redditgdx.vang.android.mock.MockLink;
import com.redditgdx.vang.android.mock.MockScreen;
import com.redditgdx.vang.android.screens.PageView;


public class RedditGDX extends Game {


	public SpriteBatch batch;
	Texture img;



	public RedditMaster user;
	@Override
	public void create () {

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

        user = new RedditMaster();



        RedditPackage pack = user.getAllTheInfo("pics", "top", "day", 10);

        PageView page = new PageView(pack);

        this.setScreen(page);

        //this.setScreen(new MockScreen());


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}


	@Override
    public void dispose(){
        batch.dispose();

    }


}
