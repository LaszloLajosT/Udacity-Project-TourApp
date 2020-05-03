package com.example.android.tour;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.core.content.ContextCompat;

public class GuideAdapter extends ArrayAdapter<GuideInformation> {
    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    private static final String LOG_TAG = GuideAdapter.class.getSimpleName();

    public GuideAdapter(Context context, ArrayList<GuideInformation> pguides,int colorResourceId) {
        super(context, 0, pguides);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_guide, parent, false);
        }

        GuideInformation current_guide = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.general_name_text_view);
        nameTextView.setText(current_guide.getmGeneralName());

        TextView telTextView = listItemView.findViewById(R.id.phone_text_view);
        telTextView.setText(current_guide.getmPhoneNumber());

        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(current_guide.getmLogoImageResourceId());

        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}



