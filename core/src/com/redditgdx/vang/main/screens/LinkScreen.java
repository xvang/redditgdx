package com.redditgdx.vang.main.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;


import com.github.imgur.api.image.ImageRequest;
import com.github.imgur.api.image.ImageResponse;
import com.redditgdx.vang.main.Asset;

import net.dean.jraw.models.Submission;

import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;



public class LinkScreen extends SingleScreen {


    ImageResponse response;


    String hashCode;

    public LinkScreen(){

    }


    public LinkScreen(Submission sub, Table scrollPaneTable){
        super(sub, scrollPaneTable);

        //'hashCode' is defined in this function.
        getHashFromURL(sub.getUrl());




        
    }

    /*public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }*/

    public void getHashFromURL(String url){

        hashCode = url;

        url = url.replace("https://i.imgur.com/", "");
        url = url.replace("http://imgur.com/", "");
        url = url.replace("http://i.imgur.com/", "");
        url = url.replace(".png", "");
        url = url.replace(".jpg", "");

        url = url.replace(".jpeg", "");
        url = url.replace("", "");

        if(url.contains("?")){
            int position = url.indexOf("?");

            url = url.substring(0, position);

        }


        //If we get to here, then that means they are equal.
        //url did not change.
        if (hashCode.equals(url)) {
            String errorMessage = "URL WAS NOT PARSED: " + url;

            Logger.getAnonymousLogger().log(Level.SEVERE, errorMessage);
        }
        else{
            hashCode = url;
        }


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
