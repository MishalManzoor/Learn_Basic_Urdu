package com.mishal.learnbasicurdu;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

public class familyFragment extends Fragment {
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

        Adapter adapter = new Adapter(requireContext() , arrayList , R.color.fam);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {

            releaseResource();

            helperClass helperClass = arrayList.get(position);

            mediaPlayer = MediaPlayer.create(getActivity() , helperClass.getAudio());
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
        arrayList.add(new helperClass("father" , R.drawable.family_father ,"باپ"  ,
                R.raw.father));

        arrayList.add(new helperClass("mother" , R.drawable.family_mother ,"ماں"  ,
                R.raw.mother));

        arrayList.add(new helperClass("daughter", R.drawable.family_daughter ,"بیٹی"  ,
                R.raw.daughter));

        arrayList.add(new helperClass("brother" , R.drawable.family_son ,"بھائی"  ,
                R.raw.brother));

        arrayList.add(new helperClass("younger brother" , R.drawable.family_younger_brother ,"چھوٹا بھائی"  ,
                R.raw.younbro));

        arrayList.add(new helperClass("older sister" , R.drawable.family_older_brother ,"بڑی بہن"  ,
                R.raw.oldersis));

        arrayList.add(new helperClass("younger sister" , R.drawable.family_younger_sister , "چھوٹی بہن"  ,
                R.raw.younsis));

        arrayList.add(new helperClass("grandfather" , R.drawable.family_grandfather ,"دادا"  ,
                R.raw.grandfather));

        arrayList.add(new helperClass("grandmother" , R.drawable.family_grandmother ,"دادی"  ,
                R.raw.grandmother));
    }
}