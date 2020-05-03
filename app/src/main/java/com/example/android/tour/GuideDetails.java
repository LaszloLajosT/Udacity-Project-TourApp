package com.example.android.tour;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GuideDetails extends AppCompatActivity {

    int currentGuide;
    GuideInformation recentGuideInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_details);

        Intent intent = this.getIntent();

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String strdata = intent.getExtras().getString(getString(R.string.activity_name));
            if(strdata.equals(getString(R.string.food_fragment))) {
                currentGuide = extras.getInt(FoodFragment.KEY_POSITION);
                recentGuideInfo = FoodFragment.guides.get(currentGuide);
            }
            else if(strdata.equals(getString(R.string.drink_fragment))) {
                currentGuide = extras.getInt(DrinkFragment.KEY_POSITION);
                recentGuideInfo = DrinkFragment.guides.get(currentGuide);
            }
            else if(strdata.equals(getString(R.string.place_fragment))) {
                currentGuide = extras.getInt(PlaceFragment.KEY_POSITION);
                recentGuideInfo = PlaceFragment.guides.get(currentGuide);
            }
            else if(strdata.equals(getString(R.string.event_fragment))) {
                currentGuide = extras.getInt(EventsFragment.KEY_POSITION);
                recentGuideInfo = EventsFragment.guides.get(currentGuide);
            }

            TextView nameTextView = findViewById(R.id.general_name_text_view);
            nameTextView.setText(recentGuideInfo.getmGeneralName());

            ImageView imageView = findViewById(R.id.guide_image);
            imageView.setImageResource(recentGuideInfo.getmImageResourceId());

            TextView artistTextView = findViewById(R.id.description_text_view);
            artistTextView.setText(recentGuideInfo.getmDescription());

            TextView keyInfoTextView = findViewById(R.id.key_information_text_view);
            keyInfoTextView.setText(R.string.key_information);

            TextView addressTextView = findViewById(R.id.address_text_view);
            addressTextView.setText(recentGuideInfo.getmAddress());

            TextView contactTextView = findViewById(R.id.contact_text_view);
            contactTextView.setText(recentGuideInfo.getmPhoneNumber());

            TextView openingHoursTextView = findViewById(R.id.open_times_text_view);
            openingHoursTextView.setText(recentGuideInfo.getmOpenTimes());
        }
    }
}