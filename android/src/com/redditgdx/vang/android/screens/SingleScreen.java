package com.redditgdx.vang.android.screens;


import com.badlogic.gdx.Net;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import com.redditgdx.vang.android.Asset;

import net.dean.jraw.models.Submission;


public abstract class SingleScreen implements Net.HttpResponseListener{



    public static final Asset assets = new Asset();

    public Submission  submission;


    public static Table tablePointer;

    public SingleScreen(){

    }

    public SingleScreen(Submission sub, Table scrollPaneTable){

        //Initialize everything we need.
        submission = sub;


        tablePointer = scrollPaneTable;



        createView();






    }


    //function is called when this specific SingleScreen is viewed.
    //The table is reset, and populated by whatever is in this screen, text or link.
    public void onViewing(){

        //3 functions... seem to do the same thing?
        tablePointer.clear();
        tablePointer.clearChildren();
        tablePointer.reset();

        this.loadContent();
    }

    //called when this becomes current screen.
    public abstract void loadContent();


    //called during instantiation.
    public abstract void createView();



    public void dispose(){
    }



    @Override
    public void handleHttpResponse (Net.HttpResponse httpResponse) {
    }


    @Override
    public void failed (Throwable t) {
    }


    @Override
    public void cancelled () {

    }
}
