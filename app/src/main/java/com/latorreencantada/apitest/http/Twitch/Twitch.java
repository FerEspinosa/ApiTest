
package com.latorreencantada.apitest.http.Twitch;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Twitch {

    @SerializedName("data")
    @Expose
    private List<Game> games = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
