package com.example.robotmagic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class CardNumberAdapter extends FragmentStateAdapter {
    private List<CardNumberItem> cardNumberItems;

    public CardNumberAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<CardNumberItem> cardNumbersItems) {
        super(fragmentManager, lifecycle);
        this.cardNumberItems = cardNumbersItems;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("title", cardNumberItems.get(position).getTitle());
        bundle.putString("description", cardNumberItems.get(position).getDescription());
        bundle.putString("imageName", cardNumberItems.get(position).getImageName());

        if (position == getItemCount() - 1) {
            bundle.putBoolean("isLastPage", true);
        }

        CardNumberFragment cardNumberFragment = new CardNumberFragment();
        ModulesFragment modulesFragment = new ModulesFragment();
        cardNumberFragment.setArguments(bundle);
        modulesFragment.setArguments(bundle);

        return cardNumberFragment;
    }



    @Override
    public int getItemCount() {
        return cardNumberItems.size();
    }
}
