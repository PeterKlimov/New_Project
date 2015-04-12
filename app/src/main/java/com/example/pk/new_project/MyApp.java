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

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "CC2ErpRS5JtCfbjIlHzuBnNPMvmJf443wWrjnowx", "WPh75hpXRvjqCUCJ0xpDTKtiyRBMoZVo2cgJUUv3");

        super.onCreate();


    }
}

