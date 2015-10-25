package com.redditgdx.vang.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redditgdx.vang.main.screens.PageView;

import net.dean.jraw.http.SubmissionRequest;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.Subreddit;
import net.dean.jraw.paginators.Sorting;
import net.dean.jraw.paginators.SubredditPaginator;
import net.dean.jraw.paginators.TimePeriod;

public class RedditGDX extends Game {


	public SpriteBatch batch;
	Texture img;


	public RedditMaster user;
	@Override
	public void create () {

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

        user = new RedditMaster();


		SubredditPaginator sp = new SubredditPaginator(user.r);

		sp.setLimit(100);
        sp.setSorting(Sorting.TOP);
        sp.setTimePeriod(TimePeriod.DAY);

        sp.setSubreddit("pics");

        sp.next(true);
        Listing<Submission> list = sp.getCurrentListing();

        System.out.println(list.get(0).getAuthor());

        PageView page = new PageView(user.getAllTheInfo("pics"), batch);

        this.setScreen(page);


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
}
