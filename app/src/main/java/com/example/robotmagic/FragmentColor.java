package com.example.robotmagic;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class FragmentColor extends Fragment {
    private ProfileFragment ProfileFragments;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colors, container, false);
        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
        List<CardColorItem> cardColorItems = getCardItems();
        CardColorAdapter cardColorAdapter = new CardColorAdapter(getChildFragmentManager(), getLifecycle(), cardColorItems);
        viewPager.setAdapter(cardColorAdapter);
        return view;
    }


    private List<CardColorItem> getCardItems() {
        List<CardColorItem> cardColorItems = new ArrayList<>();
        cardColorItems.add(new CardColorItem("Amarillo / Yellow", "Puedes ver el amarillo en el sol, los campos de girasoles, frutas como plátanos y mangos, señales de tráfico, flores como tulipanes y narcisos, y hasta en patitos amarillos. ¡Está en muchos lugares, solo tienes que prestar atención!", "amarillo_card"));
        cardColorItems.add(new CardColorItem("Rojo / Red", "El rojo es como el color de la emoción y la energía. Puedes encontrarlo en cosas emocionantes como manzanas rojas, coches veloces y flores brillantes. También está en el semáforo cuando te dice \"¡Detente!\".", "rojo_card"));
        cardColorItems.add(new CardColorItem("Azul / Blue", "El azul es como el color del cielo en un día despejado y del océano profundo. Puedes encontrarlo en cosas frescas y tranquilas. También está en la ropa cómoda que usas, como los jeans, y en el agua refrescante. El azul es como un abrazo relajante que te hace sentir tranquilo y contento.", "azul_card"));
        cardColorItems.add(new CardColorItem("Verde / Green", "El verde es un color muy especial. Nos hace pensar en la naturaleza, como los árboles, las plantas y el césped. También es el color de muchas frutas y verduras saludables, como las manzanas verdes o el brócoli.", "verde_color"));
        cardColorItems.add(new CardColorItem("Morado / Purple", "El morado es un color muy especial, es como el color de los magos y las hadas de los cuentos, tambien lo encuentras en frutas como las uvas y en animales. Cuando ves morado, piensa en un mundo lleno de encanto y aventuras. ¡Es un color mágico!", "morado_color"));
        return cardColorItems;
    }
}
