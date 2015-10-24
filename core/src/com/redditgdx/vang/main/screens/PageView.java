package com.redditgdx.vang.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redditgdx.vang.main.RedditPackage;

import net.dean.jraw.models.Subreddit;

import java.util.LinkedList;


/**
 *
 */
public class PageView extends ScreenAdapter implements Runnable, InputProcessor{



    private SpriteBatch localBatch;
    private Subreddit localSubreddit;

    private LinkedList<SingleScreen> singleScreens;


    public PageView(){
    }

    //Within the 'pack' object is a subreddit object.
    //It should already be loaded with a lazy(?) subreddit object.
    public PageView(RedditPackage pack, SpriteBatch batch){

        localBatch = batch;
        localSubreddit = pack.subreddit;

        singleScreens = new LinkedList<SingleScreen>();

        
        Gdx.input.setInputProcessor(this);

    }





    @Override
    public void render(float delta){

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        localBatch.begin();

        singleScreens.getFirst().render();

        localBatch.end();
    }


    public void init(){

    }






    @Override
    public void dispose(){


    }


    @Override
    public void run(){

    }



    @Override
    public boolean mouseMoved(int x, int y){
        return false;
    }

    @Override
    public boolean scrolled(int x){
        return false;
    }

    @Override
    public boolean touchUp(int a, int b, int c, int d){
        return false;
    }

    @Override
    public boolean touchDown(int a, int b, int c, int d){
        return false;
    }

    @Override
    public boolean touchDragged(int x ,int y, int z){
        return false;
    }

    @Override
    public boolean keyUp(int x){
        return false;
    }

    @Override
    public boolean keyDown(int x){
        return false;
    }

    @Override
    public boolean keyTyped(char x){
        return false;
    }
}
