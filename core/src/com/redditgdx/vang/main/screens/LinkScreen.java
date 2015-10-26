package com.redditgdx.vang.main.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.redditgdx.vang.main.Asset;

import net.dean.jraw.models.Submission;

/**
 * Created by xeng on 10/25/15.
 */
public class LinkScreen extends SingleScreen {


    public LinkScreen(){

    }


    public LinkScreen(Submission sub, Table scrollPaneTable){
        super(sub, scrollPaneTable);
    }


    @Override
    public void createView(){

    }

    @Override
    public void loadContent(){
        System.out.println("LINK");
        Label temp = new Label("LINK POST HERE", new Label.LabelStyle(assets.verdana, Color.WHITE));

        tablePointer.add(temp);
    }


}
