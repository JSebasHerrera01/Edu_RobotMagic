package com.example.robotmagic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class CardLectureEvalueAdapter extends FragmentStateAdapter {
    private List<CardLectureEvalueItem> CardLectureEvalueItem;

    public CardLectureEvalueAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<CardLectureEvalueItem> CardLectureEvalueItem) {
        super(fragmentManager, lifecycle);
        this.CardLectureEvalueItem = CardLectureEvalueItem;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("title", CardLectureEvalueItem.get(position).getTitle());
        bundle.putString("answer1", CardLectureEvalueItem.get(position).getanswer1());
        bundle.putString("answer2", CardLectureEvalueItem.get(position).getAnswer2());
        bundle.putString("answer3", CardLectureEvalueItem.get(position).getanswer3());
        bundle.putString("imageName", CardLectureEvalueItem.get(position).getImageName());

        if (position == getItemCount() - 1) {
            bundle.putBoolean("isLastPage", true);
        }

        CardNumberEvalueFragment cardNumberEvalueFragment = new CardNumberEvalueFragment();
        ModulesFragment modulesFragment = new ModulesFragment();
        cardNumberEvalueFragment.setArguments(bundle);
        modulesFragment.setArguments(bundle);
        return cardNumberEvalueFragment;
    }



    @Override
    public int getItemCount() {
        return CardLectureEvalueItem.size();
    }
}
