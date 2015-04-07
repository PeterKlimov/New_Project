package com.example.pk.new_project;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseObject;


/**
 * Created by Vladi on 4/7/2015.
 */
public class MyApp extends Application {
    public ParseObject parseObject;

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "RIiC6MB5Ho3hus1zPN8Tk54RBGZ7DKn8ZXFiWJGd", "MdaKoX0WPcLOrG9XDdTuoxcPoZHMuyO8zREUMLO1");

    }
}

