package com.redditgdx.vang.android.mock;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.redditgdx.vang.android.Asset;
import com.redditgdx.vang.android.RedditMaster;
import com.redditgdx.vang.android.RedditPackage;
import com.redditgdx.vang.android.login.Login;
import com.redditgdx.vang.android.screens.PageView;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.Subreddit;

/**
 * Created by xeng on 10/31/15.
 */
public class MockScreen extends ScreenAdapter implements InputProcessor {


    private Table table;
    private ScrollPane scrollPane;
    Label label;

    private Stage stage;

    private Asset assets;


    RedditMaster user;

    RedditPackage pack;

    @Override
    public void show(){
        table = new Table();
        scrollPane = new ScrollPane(table);
        stage = new Stage();

        scrollPane.setScrollingDisabled(true, false);


        Table scrollPaneCover = new Table();
        scrollPaneCover.setFillParent(true);
        scrollPaneCover.add(scrollPane).fill().expand();

        stage.addActor(scrollPaneCover);

        InputMultiplexer m = new InputMultiplexer();

        m.addProcessor(this);
        m.addProcessor(this.stage);

        Gdx.input.setInputProcessor(m);

        assets = new Asset();

        addLabels();

        user = new RedditMaster();



        pack = user.getAllTheInfo("shortscarystories", "top", "day", 10);





    }

    public void addLabels(){

        TextField.TextFieldStyle txtstyle = new TextField.TextFieldStyle();

        txtstyle.font = assets.verdana;
        txtstyle.fontColor = Color.WHITE;
        String myText = "This is my text, there are many text but this one is mine1.\n";



        for(int x = 0; x < 100; x++){
            String newString = "This is my text, there are many text but this one is mine1. " + String.valueOf(x) + "\n";
            myText = myText.concat(newString);
        }


        Submission submission = pack.subredditList.get(0);
        System.out.println(submission.getSelftext());

        TextField textField = new TextField(submission.getSelftext(), txtstyle);
        textField.setFillParent(true);

        label = new Label(myText,new Label.LabelStyle(assets.verdana, Color.WHITE));

        label.setWrap(true);

        table.add(label).width(Gdx.graphics.getWidth()).top().row();


    }


    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.stage.act();


        this.stage.draw();
    }



    @Override
    public void dispose(){}



    private static final int width = Gdx.graphics.getWidth();
    int xx = 0;
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



        if ((xx - x) > (width/ 3)){

            System.out.println("WEWEWERWERWERWERWERWERWERWERWERWERWERWEWR");
            String newText = "WE scroolled right. we scrolled right."

                    + "WE scroolled right. we scrolled right."
                    + "WE scroolled right. we scrolled right."
                    + "WE scroolled right. we scrolled right."
                    + "WE scroolled right. we scrolled right."
                    + "WE scroolled right. we scrolled right."
                    + "WE scroolled right. we scrolled right."
                    + "WE scroolled right. we scrolled right.";
            label.setText(newText);
        }

        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointerc, int button){

        xx = x;
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
