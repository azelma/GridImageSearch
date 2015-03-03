package com.example.valerie.gridimagesearch.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by valerie on 3/2/15.
 */
public class ImageResult {
    public String fullUrl;
    public String thumbUrl;
    public String title;
    public int width;
    public int height;

    public ImageResult(JSONObject json){
        try{
            this.fullUrl = json.getString("url");
            this.thumbUrl = json.getString("tbUrl");
            this.title = json.getString("title");
            this.height = json.getInt("height");
            this.width = json.getInt("width");
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<ImageResult> fromJSONArray (JSONArray array){
        ArrayList<ImageResult> results = new ArrayList<ImageResult>();
        for(int i = 0; i < array.length(); i++){
            try {
                results.add(new ImageResult(array.getJSONObject(i)));
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
        return results;
    }
}
