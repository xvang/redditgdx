package com.redditgdx.vang.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 *
 */
public class Asset {



    public BitmapFont verdana;

    public Asset(){
        verdana = new BitmapFont(Gdx.files.internal("fonts/poorrichardwhite.fnt"));
    }





    public void dispose(){
        verdana.dispose();
    }
}
