package com.example.felipe.felipecarvalho.model;

import java.util.ArrayList;
import java.util.List;

public class Tipo {
    private int id;
    private String descricao;
    public static List<Tipo> list;

    public Tipo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        if (list.isEmpty()) {
            list = new ArrayList<>();
            populaLista();
        }
    }

    private void populaLista() {
        list.add(new Tipo(1, "Erro"));
        list.add(new Tipo(2, "Melhoria"));
        list.add(new Tipo(3, "Elogio"));
    }
}
