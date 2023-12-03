package com.example.robotmagic;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;



public class CardColorEvalueAdapter extends FragmentStateAdapter {

    private List<CardColorEvalueItem> cardColorEvalueItems;

    public CardColorEvalueAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<CardColorEvalueItem> cardColorEvalueItems) {
        super(fragmentManager, lifecycle);
        this.cardColorEvalueItems = cardColorEvalueItems;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("title", cardColorEvalueItems.get(position).getTitle());
        bundle.putString("answer1", cardColorEvalueItems.get(position).getanswer1());
        bundle.putString("answer2", cardColorEvalueItems.get(position).getAnswer2());
        bundle.putString("answer3", cardColorEvalueItems.get(position).getanswer3());
        bundle.putString("imageName", cardColorEvalueItems.get(position).getImageName());

        if (position == getItemCount() - 1) {
            bundle.putBoolean("isLastPage", true);
        }

        CardColorEvalueFragment cardColorEvalueFragment = new CardColorEvalueFragment();
        ModulesFragment modulesFragment = new ModulesFragment();
        cardColorEvalueFragment.setArguments(bundle);
        modulesFragment.setArguments(bundle);
        return cardColorEvalueFragment;
    }



    @Override
    public int getItemCount() {
        return cardColorEvalueItems.size();
    }
}