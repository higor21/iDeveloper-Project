/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideveloper;

import java.util.ArrayList;

/**
 * Classe que é responsável pela página onde ficam todas as publicações e grupos que são vistas(os) pelos usuários
 * 
 * @author Higor Felype
 */
public class TimeLine {
    private final ArrayList<Publicacao> publicacoes;
    private final ArrayList<Grupo> grupos;

    /** 
     * Construtor da classe. Ele apenas instancias seus dados privados
     * 
     */
    public TimeLine(){
        this.publicacoes = new ArrayList<>();
        this.grupos = new ArrayList<>();
    }

    /**
     * Método que é responsável pelo retorno de uma publicação cuja posição é indicada pelo parâmetro 
     * 
     * @param i posição da publicação
     * @return Retorna a publicação referente a posição indicada
     */
    public Publicacao getPublicacoes(int i){
        return publicacoes.get(i);
    }

    /**
     * Método que é responsável pelo retorno de um grupo cuja posição é indicada pelo parâmetro 
     * 
     * @param i posição do grupo
     * @return Retorna o grupo referente a posição indicada
     */
    public Grupo getGrupos(int i){
        return grupos.get(i);
    }
    
    /**
     * Incrementa mais uma publicação ao vetor que contém as publicações a serem espostas na TimeLine
     * 
     * @param P Publicação a ser inserida
     */
    public void addPublicacao(Publicacao P){
        if(P!=null)
            this.publicacoes.add(P);
    }
    
    /**
     * Incrementa mais um grupo ao vetor que contém os grupos a serem espostas na TimeLine
     * 
     * @param G Grupo a ser inserido
     */
    public void addGrupo(Grupo G){
        if(G!=null)
            this.grupos.add(G);
    }
    
    /**
     * Verifica se um grupo está contido na TimeLine
     *
     * @param G Grupo a ser encontrado
     * @return retorna 'true' se o grupo está na TimeLine. Caso contrário, retorna 'false'.
     */
    public boolean verficGrupo(Grupo G){
        return this.grupos.contains(G);
    }
    
    /**
     * Verifica se uma Publicação está contida na TimeLine
     *
     * @param P Publicação a ser encontrada
     * @return retorna 'true' se a Publicação está na TimeLine. Caso contrário, retorna 'false'.
     */
    public boolean verifPublic(Publicacao P){
        return this.publicacoes.contains(P);
    }
}
