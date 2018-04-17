/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideveloper;

import java.util.ArrayList;

/**
 * Classe Grupo que contém uma publicação e usuários participantes. Essa classe serve para 
 * criar um novo grupo para uma nova pesquisa ou um novo trabalho.
 * 
 * @author Higor Felype
 */
public class Grupo {
    private final Publicacao publicacao;
    private int limitIntegrantes; 
    private final ArrayList<Usuario> participantes = new ArrayList<>();

    /**
     * Construtor da classe Grupo
     * 
     * @param publicacao Publicação para criação do grupo
     * @param limitIntegrantes Limite de integrantes do grupo
     */ 
    public Grupo(Publicacao publicacao, int limitIntegrantes) {
        this.publicacao = publicacao;
        this.limitIntegrantes = limitIntegrantes;
    }

    /**
     * Método da classe grupo que retorna uma publicação
     * 
     * @return Retorna a publicação da qual o grupo é formado
     */
    public Publicacao getPublicacao() {
        return publicacao;
    }

    /**
     * Método da classe Grupo que retorna um elemento do tipo ArrayList
     * 
     * @return Retorna uma lista de Usuários que participam do grupo instanciado
     */
    public ArrayList<Usuario> getParticipantes() {
        return participantes;
    }
    
    /**
     * Adiciona um novo usuário ao grupo instanciado
     * 
     * @param U Usuario que será adicionado na lista de participantes do grupo
     */
    public void addPartic(Usuario U){
        if(U!=null)
            this.participantes.add(U);
    }
    
    /**
     * Retira o participante do grupo que está na posição indicada
     * 
     * @param i posição do participante a ser retirado
     */
    public void retPartic(int i){
        this.participantes.remove(i);
    }
    
    // Gets e Sets

    /**
     * Pega o limite de participantes do grupo
     * 
     * @return Retorna o limite de participantes do grupo
     */
    public int getLimitIntegrantes() {
        return limitIntegrantes;
    }

    /** 
     * Incremente em uma unidade a quantidade de integrantes do grupo
     */ 
    public void setLimitIntegrantes() {
        this.limitIntegrantes++;
    }    
}
