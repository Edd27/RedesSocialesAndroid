package com.edev.redessocialesandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    CallbackManager callbackManager;
    private static final String EMAIL = "email";
    LoginButton loginButton;
    Button btnShareLink;
    ShareDialog shareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShareLink = (Button)findViewById(R.id.btnShareLink);

        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);

        btnShareLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareLinkContent content = new ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("https://developers.facebook.com"))
                        .setShareHashtag(new ShareHashtag.Builder()
                                .setHashtag("#ConnectTheWorld")
                                .build())
                        .build();

                if (ShareDialog.canShow(ShareLinkContent.class)) {
                    shareDialog.show(content);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}