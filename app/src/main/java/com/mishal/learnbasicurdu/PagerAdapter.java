package com.mishal.learnbasicurdu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter  extends FragmentStateAdapter {

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 0) {
            return new numberFragment();
        }

        else if (position == 1){

            return new familyFragment();
        }

        else if (position == 2){

            return new colorFragment();
        }

        else {

            return new phrasesFragment();
        }
    }

    @Override
    public int getItemCount() {

        return 4;
    }
}
