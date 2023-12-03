package com.example.robotmagic;

// CardColorAdapter.java
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;



public class CardColorAdapter extends FragmentStateAdapter {

    private List<CardColorItem> cardColorItems;

    public CardColorAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<CardColorItem> cardColorItems) {
        super(fragmentManager, lifecycle);
        this.cardColorItems = cardColorItems;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("title", cardColorItems.get(position).getTitle());
        bundle.putString("description", cardColorItems.get(position).getDescription());
        bundle.putString("imageName", cardColorItems.get(position).getImageName());

        if (position == getItemCount() - 1) {
            bundle.putBoolean("isLastPage", true);
        }

        CardColorFragment cardColorFragment = new CardColorFragment();
        ModulesFragment modulesFragment = new ModulesFragment();
        cardColorFragment.setArguments(bundle);
        modulesFragment.setArguments(bundle);

        return cardColorFragment;
    }



    @Override
    public int getItemCount() {
        return cardColorItems.size();
    }
}
