package com.mishal.learnbasicurdu;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class colorFragment extends Fragment {

    ListView listView;

    private MediaPlayer mediaPlayer;

    public void ReleaseResource(){

        if (mediaPlayer != null){

            mediaPlayer.release();


            mediaPlayer = null;
        }
    }

    MediaPlayer.OnCompletionListener onCompletionListener = mp -> ReleaseResource();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.listview, container, false);

        listView = root.findViewById(R.id.list_item);

        final ArrayList<helperClass> arrayList = new ArrayList<>();

        addInList(arrayList);

        Adapter adapter = new Adapter(requireContext() , arrayList , R.color.col);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {

            ReleaseResource();

            helperClass helperClass = arrayList.get(position);

            mediaPlayer = MediaPlayer.create(getActivity() , helperClass.getAudio());
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(onCompletionListener);
        });
        return root;
    }

    public void addInList(ArrayList<helperClass> arrayList){
        arrayList.add(new helperClass("red" , R.drawable.color_red ,"سرخ"  ,
                R.raw.red));

        arrayList.add(new helperClass("gray" , R.drawable.color_gray ,"سرمئی"  ,
                R.raw.gray));

        arrayList.add(new helperClass("black" ,
                R.drawable.color_black ,"سیاہ"  ,
                R.raw.black));

        arrayList.add(new helperClass("white" ,
                R.drawable.color_white ,"سفيد"  ,
                R.raw.white));

        arrayList.add(new helperClass("dusty yellow" ,
                R.drawable.color_dusty_yellow ,"دھول بھرا پیلا"  ,
                R.raw.dusty));


        arrayList.add(new helperClass("brown" ,
                R.drawable.color_brown ,"بھورا"  ,
                R.raw.brown));

        arrayList.add(new helperClass("mustard yellow" ,
                R.drawable.color_mustard_yellow ,"سرسوں کا پیلا"  ,
                R.raw.mustard));

        arrayList.add(new helperClass("green" ,
                R.drawable.color_green ,"سبز"  ,
                R.raw.green));
    }
}