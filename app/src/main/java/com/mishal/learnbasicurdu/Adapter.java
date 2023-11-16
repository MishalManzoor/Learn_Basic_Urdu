package com.mishal.learnbasicurdu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<helperClass> {

    private final int colorActivity;
    public Adapter(@NonNull Context context, ArrayList<helperClass> arrayList , int mColorActivity) {
        super(context, 0 , arrayList);

        colorActivity = mColorActivity;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;

        if (listView == null) {

            listView = LayoutInflater.from(getContext())
                    .inflate(R.layout.design, parent, false);
        }

        helperClass currentNUmberPosition = getItem(position);

        TextView default_T = listView.findViewById(R.id.default_text);
        default_T.setText(currentNUmberPosition.getGetEnglishTranslation());

        TextView urdu = listView.findViewById(R.id.urdu);
        urdu.setText(currentNUmberPosition.getGetUrduTranslation());

        ImageView imageView = listView.findViewById(R.id.images);

        if (currentNUmberPosition.hasImage()) {

            imageView.setImageResource(currentNUmberPosition.getImages());

            imageView.setVisibility(View.VISIBLE);
        } else {

            imageView.setVisibility(View.GONE);
        }


        View textColor = listView.findViewById(R.id.linearLayout);
        int color = ContextCompat.getColor(getContext() , colorActivity);
        textColor.setBackgroundColor(color);

        View textColor1 = listView.findViewById(R.id.linearLayout3);
        int color1 = ContextCompat.getColor(getContext() , colorActivity);
        textColor1.setBackgroundColor(color1);

        return listView;
    }
}
