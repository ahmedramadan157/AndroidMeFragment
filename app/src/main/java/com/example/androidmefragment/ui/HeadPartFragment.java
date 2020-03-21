package com.example.androidmefragment.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.androidmefragment.R;

import java.util.ArrayList;
import java.util.List;

public class HeadPartFragment extends Fragment {

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    private static final String TAG = "BodyPartFragment";
    private List<Integer> mImageIds;
    private int mListIndex;

    public HeadPartFragment() {
    }

    /**
     * Inflates athe Fragment Layout and sets any image resources
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // load the Saved state
        if (savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex= savedInstanceState.getInt(LIST_INDEX);
        }

        View view = inflater.inflate(R.layout.fragment_head_parts , container ,false);
        // get a reference to Images
        final ImageView imageView = view.findViewById(R.id.frag_head_part_ids);

        if (mImageIds != null)
        {
            // Set the image resource to display
            imageView.setImageResource(mImageIds.get(mListIndex));
            //Set a click Listener on the image View
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Increment position as long as the index remain <= the Size of the image ids list
                    if (mListIndex < mImageIds.size()-1){
                        mListIndex++;

                    } else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        }else {

            Log.v(TAG ,"This Fragment has a null list of image ids ");
        }

        //Return  View
        return view;
    }

    /**
     *  Setter Methods for keeping track of the list images this fragment can display ;
     */
    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putIntegerArrayList(IMAGE_ID_LIST , (ArrayList<Integer>) mImageIds);
        outState.putInt(LIST_INDEX , mListIndex);

    }
}