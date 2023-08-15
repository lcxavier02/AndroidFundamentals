package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragments.DragDropFragment;
import com.example.myapplication.fragments.TextsFragment;
import com.example.myapplication.fragments.ToggleFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DragDropFragment();
            case 1:
                return new TextsFragment();
            case 2:
                return new ToggleFragment();
            default:
                return new DragDropFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
