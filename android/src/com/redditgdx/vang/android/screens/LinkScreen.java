package com.redditgdx.vang.android.screens;

import android.graphics.drawable.Drawable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;


import net.dean.jraw.models.Submission;

import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LinkScreen extends SingleScreen {



    String hashCode;
    Texture textureFromWeb;
    Image imageFromWeb;
    String url;
    public LinkScreen(){

    }


    public LinkScreen(Submission sub, Table scrollPaneTable){
        super(sub, scrollPaneTable);





    }



    @Override
    public void createView(){
        fetchImagefromWeb();


    }

    public void fetchImagefromWeb(){
        String httpMethod = Net.HttpMethods.GET;
        String requestContent = null;

        url = submission.getUrl();


        Net.HttpRequest httpRequest = new Net.HttpRequest(httpMethod);
        httpRequest.setUrl(url);
        httpRequest.setContent(requestContent);
        Gdx.net.sendHttpRequest(httpRequest, this);
    }

    @Override
    public void loadContent(){


        Label temp = new Label("LINK POST HERE", new Label.LabelStyle(assets.verdana, Color.WHITE));





        tablePointer.add(imageFromWeb).width(Gdx.graphics.getWidth()).height(Gdx.graphics.getHeight());
    }


    @Override
    public void handleHttpResponse (Net.HttpResponse httpResponse) {


        final int statusCode = httpResponse.getStatus().getStatusCode();
        // We are not in main thread right now so we need to post to main thread for ui updates

        if (statusCode != 200) {
            Gdx.app.log("NetAPITest", "An error ocurred since statusCode is not OK");
        }

        else{
            try{
                final byte[] rawImageBytes = httpResponse.getResult();
                Gdx.app.postRunnable(new Runnable() {
                    public void run () {
                        Pixmap pixmap = new Pixmap(rawImageBytes, 0, rawImageBytes.length);
                        textureFromWeb = new Texture(pixmap);
                        imageFromWeb = new Image(textureFromWeb);
                        System.out.println(url);
                    }
                });
            }catch(Exception e){
                e.printStackTrace();
            }

        }


    }


    @Override
    public void failed(Throwable t){
        t.printStackTrace();
    }


}
