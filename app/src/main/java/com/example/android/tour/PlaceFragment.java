package com.example.android.tour;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceFragment extends Fragment {

    //Key word when I pass position value
    public static final String KEY_POSITION = "position";
    public static ArrayList<GuideInformation> guides;

    public PlaceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guide_list, container, false);

        guides = new ArrayList<GuideInformation>();
        guides.add(new GuideInformation(R.drawable.hengistburyhead1,R.drawable.hengistburyhead2, getString(R.string.place_name1),getString(R.string.place_description1), getString(R.string.place_address1), getString(R.string.place_phone1),getString(R.string.place_open_times1)));
        guides.add(new GuideInformation(R.drawable.bournemouthpier1, R.drawable.bournemouthpier2, getString(R.string.Event_name2),getString(R.string.place_description2), getString(R.string.place_address2),getString(R.string.place_phone2),getString(R.string.place_open_times2)));

        GuideAdapter adapter = new GuideAdapter(getActivity(),guides,R.color.category_places);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Word} object at the given position the user clicked on
                GuideInformation guide = guides.get(position);

                Intent intent = new Intent(getContext(),GuideDetails.class);
                intent.putExtra(FoodFragment.KEY_POSITION, position);
                intent.putExtra(getString(R.string.activity_name),PlaceFragment.class.getSimpleName());
                Log.v("Test",PlaceFragment.class.getSimpleName());

                // MainActivity.class.getSimpleName()
                startActivity(intent);
            }
        });
        return rootView;
    }
}
