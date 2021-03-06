package com.redditgdx.vang.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.redditgdx.vang.main.Asset;
import com.redditgdx.vang.main.RedditPackage;

import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.Subreddit;

import java.util.LinkedList;


/**
 *
 */
public class PageView extends ScreenAdapter implements Runnable, InputProcessor{




    private LinkedList<SingleScreen> singleScreens;
    private SingleScreen currentScreen;

    public RedditPackage localPack;


    public Table scrollPaneTable;
    ScrollPane scrollpane;
    Stage stage;


    InputMultiplexer multi;


    //td_x is the x-coordinate of where user touched down.
    //in touchedUp() there is the x-coordinate of where user touched up
    //if td_x - touched_up > screen_width/3, then we "scroll" to next submission.
    private int td_X;


    public PageView(){
    }

    //Within the 'pack' object is a subreddit object.
    //It should already be loaded with a lazy(?) subreddit object.
    public PageView(RedditPackage pack){



        stage = new Stage();

        scrollPaneTable = new Table();
        scrollpane = new ScrollPane(scrollPaneTable);

        localPack = pack;
        singleScreens = new LinkedList<SingleScreen>();

        initScreens();

        currentScreen = singleScreens.getFirst();
        currentScreen.onViewing();


        //setting up the stage.
        stage.addActor(scrollpane);




        //setting up multiple inputs.
        multi = new InputMultiplexer();
        multi.addProcessor(this);
        multi.addProcessor(stage);
        Gdx.input.setInputProcessor(multi);

    }





    @Override
    public void render(float delta){

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        stage.draw();

    }



    //Here we initialize the screens.
    public void initScreens(){

        Listing<Submission> submissionPointer = localPack.subredditList;

        int length = submissionPointer.size();

        for(int x = 0; x < length; x++){

            System.out.println(submissionPointer.get(x).getUrl());

            if(submissionPointer.get(x).isSelfPost()){

                singleScreens.add(new TextScreen(submissionPointer.get(x), scrollPaneTable));
            }
            else if (submissionPointer.get(x).getUrl().contains("imgur.com")){
                singleScreens.add(new LinkScreen(submissionPointer.get(x), scrollPaneTable));
            }

        }

    }



    public void changeToNextView(){

        int currentPosition = singleScreens.indexOf(currentScreen);

        if (currentPosition < singleScreens.size() - 1) {
            currentScreen = singleScreens.get(currentPosition + 1);

            currentScreen.onViewing();
        }


    }


    @Override
    public void dispose(){


        int size = singleScreens.size();

        for(int x = 0; x < size; x++){
            singleScreens.get(x).dispose();
        }
    }


    @Override
    public void run(){

    }




    private static final int width = Gdx.graphics.getWidth();
    @Override
    public boolean mouseMoved(int x, int y){
        return false;
    }

    @Override
    public boolean scrolled(int x){
        return false;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button){


        if (td_X - x > (width / 3)){
            changeToNextView();
        }

        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointerc, int button){

        td_X = x;
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
