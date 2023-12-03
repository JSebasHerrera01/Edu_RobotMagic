package com.example.robotmagic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class CardLectureAdapter extends FragmentStateAdapter {

    private List<CardLectureItem> cardLectureItems;

    public CardLectureAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<CardLectureItem> cardLectureItems) {
        super(fragmentManager, lifecycle);
        this.cardLectureItems = cardLectureItems;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("videoName", cardLectureItems.get(position).getVideoName());

        if (position == getItemCount() - 1) {
            bundle.putBoolean("isLastPage", true);
        }

        CardLectureFragment CardLectureFragment = new CardLectureFragment();
        ModulesFragment modulesFragment = new ModulesFragment();
        CardLectureFragment.setArguments(bundle);
        modulesFragment.setArguments(bundle);

        return CardLectureFragment;
    }

    @Override
    public int getItemCount() {
        return cardLectureItems.size();
    }
}
