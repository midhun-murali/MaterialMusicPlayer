package com.materialman.materialmusicplayer.playback;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.materialman.materialmusicplayer.playback.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements MusicListFragment.OnMusicListFragmentInteractionListener, AlbumItemFragment.OnAlbumListFragmentInteractionListener, SocialMediaListDialogFragment.Listener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                fragment = new MusicListFragment();
                loadFragment(fragment);
                return true;
            } else if (id == R.id.navigation_dashboard) {
                //fragment = new SocialMediaListDialogFragment();
                //loadFragment(fragment);
                //TODO bottom sheet dialog
                /*View view = getLayoutInflater().inflate(R.layout.fragment_social_media_list_dialog, null);

                BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this);
                dialog.setContentView(view);
                dialog.show();*/

                //TODO bottom sheet dialog fragment
                SocialMediaListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
                return true;
            } else if (id == R.id.navigation_notifications) {
                fragment = new AlbumItemFragment();
                loadFragment(fragment);
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new MusicListFragment());
        //mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.rootFrameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onAlbumListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onItemClicked(int position) {

    }

}
