package com.example.felipe.felipecarvalho.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {
    private int id;
    private String descricao;
    public static List<Empresa> list = new ArrayList<>();

    public Empresa() {

    }

    public Empresa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static List<Empresa> getList() {
        return list;
    }

    public static void setList(List<Empresa> list) {
        Empresa.list = list;
    }


    @Override
    public String toString() {
        return this.descricao;
    }
}
