package com.mishal.learnbasicurdu;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class numberFragment extends Fragment {

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

        Adapter adapter = new Adapter(requireContext() , arrayList , R.color.num);
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

    @Override
    public void onStop() {
        super.onStop();

        ReleaseResource();
    }

    private void addInList(ArrayList<helperClass> arrayList){
        arrayList.add(new helperClass("one" , R.drawable.number_one  ,"ایک" ,
                R.raw.one));

        arrayList.add(new helperClass("two" , R.drawable.number_two , "دو"  ,
                R.raw.two));

        arrayList.add(new helperClass("three" , R.drawable.number_three ,"تین"  ,
                R.raw.three));

        arrayList.add(new helperClass("four" , R.drawable.number_four ,  "چار"   ,
                R.raw.four));

        arrayList.add(new helperClass("five" , R.drawable.number_five , "پانچ"  ,
                R.raw.five));

        arrayList.add(new helperClass("six" , R.drawable.number_six , "چھ"  ,
                R.raw.six));

        arrayList.add(new helperClass("seven" , R.drawable.number_seven , "ساتھ"  ,
                R.raw.seven));

        arrayList.add(new helperClass("eight" , R.drawable.number_eight ,"آٹھ" ,
                R.raw.eight));

        arrayList.add(new helperClass("nine" , R.drawable.number_nine , "نو"  ,
                R.raw.nine));

        arrayList.add(new helperClass("ten" , R.drawable.number_ten , "دس"  ,
                R.raw.ten));
    }
}