package com.redditgdx.vang.android.mock;

import android.graphics.drawable.Drawable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.squareup.okhttp.internal.http.HttpMethod;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by xeng on 10/31/15.
 */
public class MockLink extends ScreenAdapter implements Net.HttpResponseListener {



    Stage stage;
    Texture texture;
    Image image;
    public MockLink(){}

    @Override
    public void show(){
        stage = new Stage();

        String url = "http://i.imgur.com/vMWwHuw.jpg";


        Drawable drawable = LoadImageFromWebOperations(url);


    }

    @Override
    public void render(float delta){
        stage.act();
        stage.draw();
    }


    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public void handleHttpResponse (Net.HttpResponse httpResponse) {

       /* final int statusCode = httpResponse.getStatus().getStatusCode();

        if (statusCode != 200) {
            Gdx.app.log("NetAPITest", "An error ocurred since statusCode is not OK");
            System.out.println(httpResponse);
            System.out.println("COde: " + String.valueOf(statusCode));
        }

        else{
            final byte[] rawImageBytes = httpResponse.getResult();
            Gdx.app.postRunnable(new Runnable() {
                public void run () {
                    Pixmap pixmap = new Pixmap(rawImageBytes, 0, rawImageBytes.length);
                    texture = new Texture(pixmap);

                    image = new Image(texture);
                    image.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

                    stage.addActor(image);
                }
            });

        }*/
    }


    @Override
    public void failed (Throwable t) {
        t.printStackTrace();
    }


    @Override
    public void cancelled () {

    }


}
