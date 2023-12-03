package com.example.robotmagic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class FragmentNumber_Evalue extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numbers_evalue, container, false);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
        List<CardColorEvalueItem> cardColorEvalueItems = getCardItems();
        CardColorEvalueAdapter cardColorEvalueAdapter = new CardColorEvalueAdapter(getChildFragmentManager(), getLifecycle(), cardColorEvalueItems);
        viewPager.setAdapter(cardColorEvalueAdapter);
        return view;
    }


    private List<CardColorEvalueItem> getCardItems() {
        List<CardColorEvalueItem> CardColorEvalueItem = new ArrayList<>();
        CardColorEvalueItem.add(new CardColorEvalueItem("¿Cual es el resultado de la suma?", "6 (Seis)", "7 (Siete)", "8 (Ocho)", "suma_uno_numeros"));
        CardColorEvalueItem.add(new CardColorEvalueItem("¿Cual es el resultado de la resta?", "3 (Tres)", "4 (Cuatro)", "7 (Siete)", "resta_uno_numeros"));
        return CardColorEvalueItem;
    }
}
