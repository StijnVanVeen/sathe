package com.example.stijn.sath.dataAccess;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.stijn.sath.domain.Film;
import com.example.stijn.sath.domain.Hall;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by kelly on 28-3-2018.
 */

public class CinemaFilmAPI extends AsyncTask<String, Void, String> {
    private OnFilmAvailable listener = null;

    public CinemaFilmAPI(OnFilmAvailable listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        InputStream inputStream = null;
        int responsCode = -1;

        String personUrl = strings[0];
        String response = "";

        try {
            URL url = new URL(personUrl);
            URLConnection urlConnection = url.openConnection();

            if (!(urlConnection instanceof HttpURLConnection)) {
                return null;
            }

            HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
            httpConnection.setAllowUserInteraction(false);
            httpConnection.setInstanceFollowRedirects(true);
            httpConnection.setRequestMethod("GET");

            // Run the request via the HTTP connection on the URL
            httpConnection.connect();
            responsCode = httpConnection.getResponseCode();

            if (responsCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpConnection.getInputStream();
                response = getStringFromInputStream(inputStream);
            } else {
            }
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
        return response;
    }

    private static String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(String response){
        if(response == null || response == "") {
            return;
        }

        JSONObject jsonObject;
        try {
            // Top level json object
            jsonObject = new JSONObject(response);

            // Gets all photos and starts looping
            JSONArray results = jsonObject.getJSONArray("results");
            for(int idx = 0; idx < results.length(); idx++) {

                //get individual photo
                JSONObject result = results.getJSONObject(idx);

                //Get the image url
                String title = result.getString("original_title");

                //Get the imageID
                int filmID = result.getInt("id");

                String description = result.getString("overview");
                String imageURL = "http://image.tmdb.org/t/p/w185";
                imageURL += result.getString("poster_path");


                // Create new MarsRoverImage object
                Film film = new Film(filmID,title,"genre","--",description, 16, new Hall(2), null, imageURL);
                Log.i("FILM", imageURL);

                // call back with new MarsRoverImage data
                listener.onFilmAvailable(film);
            }
        } catch( JSONException ex) {
        }
    }

    public interface OnFilmAvailable{
        void onFilmAvailable(Film film);
    }
}
