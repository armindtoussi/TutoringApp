package com.example.armint.testtutor;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by Brandon on 2016-11-29.
 */

public class DBConnection {
    private static final Person currentPerson = new Person();
    protected static JsonArray userArray = new JsonArray();
    private static final String urlStart = "https://api.mlab.com/api/1/databases/tutor_app/collections/Person";
    private static final String apikey   = "?apiKey=sCHR89HcWrM7wtVktlCMCToFlXsIjgRn";

    public DBConnection() { }

    public JsonArray getUsers() {
        return userArray;
    }

    public String[] getNames() {
        ArrayList<String> names = new ArrayList<String>();
        JsonObject obj;
        //Log.d("Testing getNames", "getNames() called");
        for (JsonElement e : userArray) {
            obj = e.getAsJsonObject();
            //Log.d("Testing getNames", obj.get("name").getAsString());
            names.add(obj.get("name").getAsString());
            //Log.d("Teting getNames", "" + names.size());
        }
        String[] returnNames = new String[names.size()];
        return names.toArray(returnNames);
    }

    public String[] getDescription() {
        ArrayList<String> description = new ArrayList<String>();
        JsonObject obj;
        for (JsonElement e : userArray) {
            obj = e.getAsJsonObject();
            description.add(obj.get("description").getAsString());
        }
        String[] returnDescriptions = new String[description.size()];
        return description.toArray(returnDescriptions);
    }

    public String[][] getTutorInfo(final Context context) {
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> descriptions = new ArrayList<String>();
        try {
            String query = "&q={\"" + "goodcourse" + "\":\"" + currentPerson.getBadCourse() + "\"}";
            JsonArray arr = Ion.with(context).load("GET", urlStart + apikey + query)
                    .asJsonArray().get();
            for (JsonElement ele : arr) {
                names.add(ele.getAsJsonObject().get("name").getAsString());
                descriptions.add(ele.getAsJsonObject().get("description").getAsString());
            }
        } catch (IndexOutOfBoundsException ex){
            Log.d("getTutorNames", "No matches.");
        } catch (Exception ex) {
            Log.d("getTutorNames", "Query failed.");
        }
        String[][] returnInfo = new String[2][descriptions.size()];
        names.toArray(returnInfo[0]);
        descriptions.toArray(returnInfo[1]);
        return returnInfo;
    }

    public String[][] getTutoreeInfo(final Context context) {
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> descriptions = new ArrayList<String>();
        Log.d("getTutoreeInfo", "" + currentPerson.getGoodCourse());
        try {
            String query = "&q={\"" + "badcourse" + "\":\"" + currentPerson.getGoodCourse() + "\"}";
            JsonArray arr = Ion.with(context).load("GET", urlStart + apikey + query)
                    .asJsonArray().get();
            Log.d("getTutoreeInfo", "" + arr.size());
            for (JsonElement ele : arr) {
                names.add(ele.getAsJsonObject().get("name").getAsString());
                descriptions.add(ele.getAsJsonObject().get("description").getAsString());
            }
        } catch (IndexOutOfBoundsException ex){
            Log.d("getTutorNames", "No matches.");
        } catch (Exception ex) {
            Log.d("getTutorNames", "Query failed.");
        }
        String[][] returnInfo = new String[2][descriptions.size()];
        names.toArray(returnInfo[0]);
        descriptions.toArray(returnInfo[1]);
        return returnInfo;
    }

    public boolean loginCheck(final Context context, final String username, final String password) {
        try {
            String query = "&q{\"" + "username" + "\":\"" + username + "\"}";
            JsonObject obj = Ion.with(context).load("GET", urlStart + apikey + query)
                    .asJsonArray().get().get(0).getAsJsonObject();
            if (obj.get("password").getAsString().equals(password)) {
                currentPerson.setPerson(obj);
                //Log.d("loginCheck, a/setPerson", currentPerson.getName());
                return true;
            } else {
                return false;
            }
        } catch (IndexOutOfBoundsException ex){
            Log.d("loginCheck", "User not found.");
            return false;
        } catch (Exception ex){
            Log.d("loginCheck", "Query failed.");
            return false;
        }
    }

    public void jsonRequest(final Context context) {
        if (userArray != null) {
            userArray = new JsonArray();
            Ion.with(context).
                    load("https://api.mlab.com/api/1/databases/tutor_app/collections/Person?apiKey=sCHR89HcWrM7wtVktlCMCToFlXsIjgRn").
                    asJsonArray().
                    setCallback(
                            new FutureCallback<JsonArray>() {
                                @Override
                                public void onCompleted(final Exception ex,
                                                        final JsonArray array) {
                                    if (ex != null) {
                                        Log.d("Error: ", ex.getMessage());
                                    } else {
                                        userArray = array;
                                        Log.d("Testing jsonRequest", "" + userArray.size());
                                        for (final JsonElement element : array) {
                                            final JsonObject json;
                                            final JsonElement nameElement;
                                            final String name;

                                            json = element.getAsJsonObject();
                                            nameElement = json.get("name");

                                            name = nameElement.getAsString();
                                            Log.d("X",
                                                    ">>>>>>>>>>>>>>>>>" + name + " -> " + nameElement);
                                        }
                                    }
                                }
                            });
        }
    }

}