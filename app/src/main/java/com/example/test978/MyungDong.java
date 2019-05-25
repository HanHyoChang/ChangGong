package com.example.test978;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MyungDong extends TabActivity {
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.myungdong);


                TabHost tabHost = getTabHost();

                TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("지역별");
                tabSpecSong.setContent(R.id.tabSong);
                tabHost.addTab(tabSpecSong);

                TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST")
                        .setIndicator("요령");
                tabSpecArtist.setContent(R.id.tabArtist);
                tabHost.addTab(tabSpecArtist);

                TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("신고");
                tabSpecAlbum.setContent(R.id.tabAlbum);
                tabHost.addTab(tabSpecAlbum);


                TabHost.TabSpec tabSpecAlbum1 = tabHost.newTabSpec("ALBUM").setIndicator("게임");
                tabSpecAlbum.setContent(R.id.tabAlbum);
                tabHost.addTab(tabSpecAlbum);

                tabHost.setCurrentTab(0);
        }
}
