package com.example.androidmefragment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.androidmefragment.R;
import com.example.androidmefragment.data.AndroidImageAssets;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (savedInstanceState == null ){
        // The Head Fragment Create Manager '
        HeadPartFragment headFragment = new HeadPartFragment();

        // Set the List of image id's for the head fragment and set the position to the second image in the list
        headFragment.setmImageIds(AndroidImageAssets.getHeads());
            int headIndex = getIntent().getIntExtra("headIndex", 0);
            headFragment.setmListIndex(headIndex);
        //Use a FragmentManager and Transaction to add the fragment to the Screen
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.head_container, headFragment)
                .commit();


        HeadPartFragment bodyFragment = new HeadPartFragment();

        // Set the List of image id's for the head fragment and set the position to the second image in the list
        bodyFragment.setmImageIds(AndroidImageAssets.getBodies());
        //Use a FragmentManager and Transaction to add the fragment to the Screen
        fragmentManager.beginTransaction()
                .add(R.id.body_container, bodyFragment)
                .commit();

        HeadPartFragment legsFragment = new HeadPartFragment();

        // Set the List of image id's for the head fragment and set the position to the second image in the list
        legsFragment.setmImageIds(AndroidImageAssets.getLegs());
        //Use a FragmentManager and Transaction to add the fragment to the Screen
        fragmentManager.beginTransaction()
                .add(R.id.leg_container, legsFragment)
                .commit();

        }
    }
}
