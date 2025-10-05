package com.SingletonJVW;

import java.util.ArrayList;
import java.util.List;

public class AgendaMusical {
    // Eager Initialization
    private static AgendaMusical instance = new AgendaMusical();

    // ATRIBUTOS GLOBAIS
    private String nomeFestival;
    private String usuarioLogado;
    private int capacidadeMaxima;
    private boolean statusProducao = false;
    private List<String> eventosAgendados;
    private int itensEmFalta = 0;

    // Construtor PRIVADO
    private AgendaMusical() {
        this.eventosAgendados = new ArrayList<>();
    }

    // Método PÚBLICO
    public static AgendaMusical getInstance() {
        return instance;
    }

    public void iniciarProducao() {
        this.statusProducao = true;
    }

    public void finalizarProducao() {
        this.statusProducao = false;
    }

    public void registrarFaltaDeItem() {
        this.itensEmFalta++;
    }

    // GETTERS & SETTERS

    public String getNomeFestival() {
        return nomeFestival;
    }

    public void setNomeFestival(String nomeFestival) {
        this.nomeFestival = nomeFestival;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public boolean isStatusProducao() {
        return statusProducao;
    }

    public List<String> getEventosAgendados() {
        return eventosAgendados;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public int getItensEmFalta() {
        return itensEmFalta;
    }
}
