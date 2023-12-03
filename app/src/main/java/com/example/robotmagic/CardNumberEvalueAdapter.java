package com.example.robotmagic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class CardNumberEvalueAdapter extends FragmentStateAdapter {

    private List<CardNumberEvalueItem> cardNumberEvalueItems;

    public CardNumberEvalueAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<CardNumberEvalueItem> cardNumberEvalueItems) {
        super(fragmentManager, lifecycle);
        this.cardNumberEvalueItems = cardNumberEvalueItems;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("title", cardNumberEvalueItems.get(position).getTitle());
        bundle.putString("answer1", cardNumberEvalueItems.get(position).getanswer1());
        bundle.putString("answer2", cardNumberEvalueItems.get(position).getAnswer2());
        bundle.putString("answer3", cardNumberEvalueItems.get(position).getanswer3());
        bundle.putString("imageName", cardNumberEvalueItems.get(position).getImageName());

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
        return cardNumberEvalueItems.size();
    }
}
