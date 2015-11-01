package com.redditgdx.vang.android.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import net.dean.jraw.models.Submission;

/**
 * Created by xeng on 10/25/15.
 */
public class TextScreen extends SingleScreen {

    private Label username, textForTable;

    public TextScreen(){

    }


    public TextScreen(Submission sub, Table scrollPaneTable){
        super(sub, scrollPaneTable);


    }


    @Override
    public void createView(){
        username = new Label(submission.getAuthor(), new Label.LabelStyle(assets.verdana, Color.WHITE));


        System.out.println(submission.getSelftext());
        textForTable = new Label("", new Label.LabelStyle(assets.verdana, Color.WHITE));

        String text = String.valueOf(submission.getSelftext());

        text = text.replace("\n\n", "\n");

        textForTable.setText(text + "\n-----------\n");

        username.setWrap(true);
        textForTable.setWrap(true);

    }


    @Override
    public void loadContent(){

        //Label temp = new Label("TEXT POST HERE", new Label.LabelStyle(assets.verdana, Color.WHITE));
        tablePointer.add(username).width(Gdx.graphics.getWidth() - 20).center().row();
        tablePointer.add(textForTable).width(Gdx.graphics.getWidth() - 20).center().row();
        tablePointer.setBackground(new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal("green.png")))));
    }



}
