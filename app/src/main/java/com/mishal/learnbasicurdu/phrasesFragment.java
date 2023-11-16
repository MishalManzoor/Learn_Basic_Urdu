package com.mishal.learnbasicurdu;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class phrasesFragment extends Fragment {

    ListView listView;

    private MediaPlayer mediaPlayer;

    public void releaseResource(){

        if (mediaPlayer != null){

            mediaPlayer.release();

            mediaPlayer = null;
        }
    }

    MediaPlayer.OnCompletionListener onCompletionListener = mp -> releaseResource();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.listview, container, false);


        listView = root.findViewById(R.id.list_item);


        final ArrayList<helperClass> arrayList = new ArrayList<>();

        addInList(arrayList);

        Adapter adapter = new Adapter(requireContext() , arrayList , R.color.phr);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {

            releaseResource();

            helperClass helperClass = arrayList.get(position);

            mediaPlayer = MediaPlayer.create(getActivity(), helperClass.getAudio());
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(onCompletionListener);
        });

        return root;
    }

    @Override
    public void onStop() {
        super.onStop();

        releaseResource();
    }

    private void addInList(ArrayList<helperClass> arrayList){
        arrayList.add(new helperClass("Where are you going?" , "آپ کہاں جا رہا ہے؟"
                , R.raw.wheregoing));

        arrayList.add(new helperClass("What is your name?" ,  "آپ کا نام کیا ہے؟"
                , R.raw.whatname ));

        arrayList.add(new helperClass("My name is..." , "میرا نام ہے..."
                , R.raw.myis));

        arrayList.add(new helperClass("How are you feeling?" , "آپ کیسا محسوس کر رہے ہیں؟"
                , R.raw.howfeeling));

        arrayList.add(new helperClass("I’m feeling good." , "میں اچھا محسوس کر رہا ہوں"
                , R.raw.igood));

        arrayList.add(new helperClass("Are you coming?" , "کیا آپ آ رہے ہیں؟"
                , R.raw.arecomming));

        arrayList.add(new helperClass("Yes, I’m coming." ,"جی ہاں میں آ رہا ہوں"
                , R.raw.yescoming));

        arrayList.add(new helperClass("I’m coming." , "میں آ رہا ہوں"
                , R.raw.icoming));

        arrayList.add(new helperClass("Let’s go." , "چلو"
                , R.raw.letsgo));
    }
}