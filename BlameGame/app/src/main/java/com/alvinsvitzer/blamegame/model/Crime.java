package com.alvinsvitzer.blamegame.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Alvin on 12/27/15.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspect;


    public Crime(){
        this(UUID.randomUUID());
    }


    public Crime(UUID id){

        mId = id;
        mDate = new Date();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public UUID getId(){
        return mId;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getSuspect(){
        return mSuspect;
    }

    public void setSuspect(String suspect){
        mSuspect = suspect;
    }

}


