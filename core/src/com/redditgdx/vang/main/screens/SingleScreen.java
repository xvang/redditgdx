package com.redditgdx.vang.main.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.github.imgur.ImgUr;
import com.github.imgur.api.image.ImageRequest;
import com.github.imgur.api.image.ImageResponse;

import java.io.IOException;

/**
 * Created by xeng on 10/24/15.
 */
public class SingleScreen {


    //Imgur id
    //5fc1f2a679ddb71

    private static final ImgUr imgur = new ImgUr("5fc1f2a679ddb71");

    public SingleScreen(){
       /* ImageResponse imgurResponse;

        try{
            imgurResponse = imgur.call(new ImageRequest(""));
        } catch(IOException e){
            System.out.println(e.getMessage());
        }*/
    }

    public void render(){

    }


    public void dispose(){

    }
}
