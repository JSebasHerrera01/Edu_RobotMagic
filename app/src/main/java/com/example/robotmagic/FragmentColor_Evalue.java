package com.example.robotmagic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class FragmentColor_Evalue extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colors_evalue, container, false);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
        List<CardColorEvalueItem> cardColorEvalueItems = getCardItems();
        CardColorEvalueAdapter cardColorEvalueAdapter = new CardColorEvalueAdapter(getChildFragmentManager(), getLifecycle(), cardColorEvalueItems);
        viewPager.setAdapter(cardColorEvalueAdapter);
        return view;
    }


    private List<CardColorEvalueItem> getCardItems() {
        List<CardColorEvalueItem> CardColorEvalueItem = new ArrayList<>();
        CardColorEvalueItem.add(new CardColorEvalueItem("¿Donde puedes ver el color Azul?", "En los Arboles", "En el Cielo", "En la tierra", "cielo_colores"));
        CardColorEvalueItem.add(new CardColorEvalueItem("¿Cuál es el color que predomina en la imagen?", "Azul", "Verde", "Morado", "colorpredomina_colores"));
        CardColorEvalueItem.add(new CardColorEvalueItem("¿De qué color es el sol?", "Azul", "Morado", "Amarillo", "sol_colores"));
        return CardColorEvalueItem;
    }
}
