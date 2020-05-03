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

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    //Key word when I pass position value
    public static final String KEY_POSITION = "position";
    public static ArrayList<GuideInformation> guides;

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guide_list, container, false);

        guides = new ArrayList<GuideInformation>();
        guides.add(new GuideInformation(R.drawable.bayrun1,R.drawable.bayrun2, getString(R.string.event_name1),getString(R.string.event_description1), getString(R.string.event_address1), getString(R.string.event_phone1),getString(R.string.event_open_times1)));

        GuideAdapter adapter = new GuideAdapter(getActivity(),guides,R.color.category_events);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Word} object at the given position the user clicked on
                GuideInformation guide = guides.get(position);

                Intent intent = new Intent(getContext(),GuideDetails.class);
                intent.putExtra(FoodFragment.KEY_POSITION, position);
                intent.putExtra(getString(R.string.activity_name),EventsFragment.class.getSimpleName());

                startActivity(intent);
            }
        });
        return rootView;
    }
}
