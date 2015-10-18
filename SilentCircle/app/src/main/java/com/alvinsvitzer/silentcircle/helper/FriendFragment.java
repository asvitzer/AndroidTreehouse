package com.alvinsvitzer.silentcircle.helper;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alvinsvitzer.silentcircle.R;

/**
 * Created by Alvin on 10/11/15.
 */
public class FriendFragment extends ListFragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static FriendFragment newInstance(int sectionNumber) {
        FriendFragment fragment = new FriendFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_friend, container, false);
        return rootView;
    }


}