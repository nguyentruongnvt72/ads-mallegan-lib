package com.malleganadslibrary;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import com.mallegan.ads.util.AppOpenManager;
import com.mallegan.ads.util.AdsApplication;
import com.mallegan.ads.util.AppsFlyer;

import java.util.List;

public class MyApplication extends AdsApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        AppOpenManager.getInstance().disableAppResumeWithActivity(Splash.class);
        initRemoteConfig();
        AppsFlyer.getInstance().initAppFlyer(this, "", true);

    }

    @Override
    public boolean enableAdsResume() {
        return true;
    }

    @Override
    public List<String> getListTestDeviceId() {
        return null;
    }

    @Override
    public String getResumeAdId() {
        return "ca-app-pub-3940256099942544/3419835294";
    }

    @Override
    public Boolean buildDebug() {
        return true;
    }


    public static void initRemoteConfig() {
        FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(5)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.setDefaultsAsync(R.xml.remote_config_defaults);
        mFirebaseRemoteConfig.fetchAndActivate();
    }


}
