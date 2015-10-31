package com.redditgdx.vang.android.screens;


import com.badlogic.gdx.scenes.scene2d.ui.Table;

import com.redditgdx.vang.android.Asset;

import net.dean.jraw.models.Submission;


public abstract class SingleScreen {



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


    //Creating the labels that will go in the table in the scrollpane in pageview.java
    //tablePointer is a pointer to that table.
    public void createTextView(){



    }
    public void createLinkView(){

    }


    //function is called when this specific SingleScreen is viewed.
    //The table is reset, and populated by whatever is in this screen, text or link.
    public void onViewing(){

        //3 functions... seem to do the same thing?
        tablePointer.clear();
        tablePointer.clearChildren();
        tablePointer.reset();

        loadContent();
    }


    public abstract void loadContent();

    public abstract void createView();



    public void dispose(){
    }
}
