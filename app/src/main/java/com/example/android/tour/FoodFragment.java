package com.example.android.tour;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;

public class FoodFragment   extends  Fragment {

        //Key word when I pass position value
        public static final String KEY_POSITION = "position";
        public static ArrayList<GuideInformation> guides;
        public static ArrayList<GuideInformation> music;

        public FoodFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.guide_list, container, false);

            guides = new ArrayList<GuideInformation>();
            guides.add(new GuideInformation(R.drawable.bournemouthpizza1,R.drawable.bournemouthpizza2, getString(R.string.food_name1),getString(R.string.food_description1), getString(R.string.food_address1), getString(R.string.food_phone1),getString(R.string.food_open_times1)));
            guides.add(new GuideInformation(R.drawable.sevenbone1, R.drawable.sevenbone2, getString(R.string.food_name2),getString(R.string.food_description2), getString(R.string.food_address2),getString(R.string.food_phone2),getString(R.string.food_open_times2)));
            guides.add(new GuideInformation(R.drawable.stable1,R.drawable.stable2, getString(R.string.food_name3),getString(R.string.food_description3), getString(R.string.food_address3),getString(R.string.food_phone3),getString(R.string.food_open_times3)));

            GuideAdapter adapter = new GuideAdapter(getActivity(),guides,R.color.category_food);
            ListView listView = rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    // Get the {@link Word} object at the given position the user clicked on
                    GuideInformation guide = guides.get(position);

                    Intent intent = new Intent(getContext(),GuideDetails.class);
                    intent.putExtra(FoodFragment.KEY_POSITION, position);
                    intent.putExtra(getString(R.string.activity_name),FoodFragment.class.getSimpleName());
                    startActivity(intent);
                }
            });
            return rootView;
        }
}