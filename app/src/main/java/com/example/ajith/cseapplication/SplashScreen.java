package com.example.ajith.cseapplication;

import android.content.Intent;
import android.view.WindowManager;
import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashScreen extends AwesomeSplash {
    @Override
    public void initSplash(ConfigSplash configSplash) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        configSplash.setBackgroundColor(R.color.purple);
        configSplash.setAnimCircularRevealDuration(2000);
        configSplash.setRevealFlagY(Flags.REVEAL_TOP);
        configSplash.setLogoSplash(R.drawable.CSEDEPTLOGO);
        configSplash.setAnimLogoSplashDuration(2000);
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn);
        configSplash.setTitleTextSize(0);
    }
    @Override
    public void animationsFinished() {
        Intent i= new Intent(SplashScreen.this, HomeActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
