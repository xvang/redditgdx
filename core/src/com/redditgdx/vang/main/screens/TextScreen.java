package com.redditgdx.vang.main.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.redditgdx.vang.main.Asset;

import net.dean.jraw.models.Submission;

/**
 * Created by xeng on 10/25/15.
 */
public class TextScreen extends SingleScreen {


    public TextScreen(){

    }


    public TextScreen(Submission sub, Table scrollPaneTable){
        super(sub, scrollPaneTable);


    }


    @Override
    public void createView(){
        Label username = new Label(submission.getAuthor(), new Label.LabelStyle(assets.verdana, Color.WHITE));

        Label textForTable = new Label("", new Label.LabelStyle(assets.verdana, Color.WHITE));
        textForTable.setText(submission.getSelftext());
    }


    @Override
    public void loadContent(){
        System.out.println("TEXT");
        Label temp = new Label("TEXT POST HERE", new Label.LabelStyle(assets.verdana, Color.WHITE));

        tablePointer.add(temp);
    }
}
