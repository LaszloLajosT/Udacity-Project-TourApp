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
public class DrinkFragment extends Fragment {

    public static final String KEY_POSITION ="position";
    public static ArrayList<GuideInformation> guides;
   // public String KEY_POSITION = getString(R.string.key_position);

    public DrinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.guide_list, container, false);

        guides = new ArrayList<GuideInformation>();
        guides.add(new GuideInformation(R.drawable.revolution1,R.drawable.revolution2, getString(R.string.drink_name1),getString(R.string.drink_description1), getString(R.string.drink_address1), getString(R.string.drink_phone1),getString(R.string.drink_open_times1)));
        guides.add(new GuideInformation(R.drawable.sixtymillionpostcards1, R.drawable.sixtymillionpostcards2, getString(R.string.drink_name2),getString(R.string.drink_description2), getString(R.string.drink_address2),getString(R.string.drink_phone2),getString(R.string.drink_open_times2)));

        GuideAdapter adapter = new GuideAdapter(getActivity(),guides,R.color.category_drink);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Word} object at the given position the user clicked on
                GuideInformation guide = guides.get(position);

                Intent intent = new Intent(getContext(),GuideDetails.class);
                intent.putExtra(FoodFragment.KEY_POSITION, position);
                intent.putExtra(getString(R.string.activity_name),DrinkFragment.class.getSimpleName());

                startActivity(intent);
            }
        });
        return rootView;
    }
}
