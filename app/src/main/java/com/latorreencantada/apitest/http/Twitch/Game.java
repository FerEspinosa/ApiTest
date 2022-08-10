
package com.latorreencantada.apitest.http.Twitch;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Game {



    public Game(){

    }

    public Game(String name, String url){
        this.name = name;
        this.boxArtUrl = url;
    }
/*
    public Game(String name, String url){
        this.setBoxArtUrl(url);
        this.setName(name);
    }
*/
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("box_art_url")
    @Expose
    private String boxArtUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoxArtUrl() {
        return boxArtUrl;
    }

    public void setBoxArtUrl(String boxArtUrl) {
        this.boxArtUrl = boxArtUrl;
    }

}