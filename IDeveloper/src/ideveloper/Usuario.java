/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideveloper;

import java.io.*;
import java.util.*;


/**
 * Classe que contém os dados de um Usuário
 *
 * @author Higor Felype
 */
public class Usuario implements Serializable{
    private Perfil perfil;
    private String email;
    private String senha;
    private final ArrayList<Publicacao> publicacoes;
    private final ArrayList<Grupo> grupos;
    
    /**
     * Construtor da classe Usuário, que recebe dois parâmetros contendo od dados principais do usuário
     * 
     * @param email Email
     * @param senha Senha
     */
    public Usuario(String email,String senha){
        this.publicacoes = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.perfil = new Perfil();
        this.email = email;
        this.senha = senha;
    }
    
    /**
     * método que retorna um ArrayList contendo as publicações associadas ao usuário intanciado
     * 
     * @return retorna um ArrayList contendo a lista de publicações 
     */
    public ArrayList<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    /**
     * método que retorna um ArrayList contendo as grupos associados ao usuário intanciado
     * 
     * @return retorna um ArrayList contendo a lista de grupos 
     */
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }
    
    /**
     * Método da classe Usuario etorna o perfio associado as usuário instanciado
     * 
     * @return Retorna o perfio associado as usuário instanciado
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * Altera o perfil de um usuário com um perfil passado por parâmetro
     * 
     * @param perfil novo Perfil
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    /** 
     * Retorna uma String com o e-mail associado ao usuário instancido.
     *
     * @return Retorna o e-mail do usuário 
     */
    public String getEmail() {
        return email;
    }

    /**
     * Altera o campo do e-mail associado ao nome do usuário
     * 
     * @param email E-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna uma String com a senha associada ao usuário instancido.
     * 
     * @return Retorna a senha do usurário como uma String
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Atera a senha do usuário com uma nova senha passada por parâmetro
     * 
     * @param senha Senha 
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Adiciona uma nova publicação as publicações que o usuário contém com uma publicação passada por parâmetro
     * 
     * @param P Publicação
     */
    public void addPublicacao(Publicacao P){
        if(P != null)
            this.publicacoes.add(P);
    }
    
    /**
     * Remove a publicação da posição do ArrayList de publicações que o usuário instanciado contém
     * 
     * @param i posição da publicação
     */
    public void remuvePublicacao(int i){
        this.publicacoes.remove(i);
    }
    
    /**
     * Promove a edição do Perfil do usuário, alterando os dados do perfil, como: foto, curso, ...
     *
     * @param desc Descriçao
     * @param nome Nome
     * @param curso Curso
     * @param foto Foto
     */
    public void editPerfil(String desc, String nome, String curso, File foto){
        this.perfil = new Perfil(desc, nome, curso, foto);
    }
    
    /**
     * método da classe Usuário que compara um Objeto passado por parâmetro com o Usuário instanciado 
     * 
     * @param obj Objeto 
     * @return retorna 'true' se o Objeto passado por parâmetro for um Usuário que contem a mesma senha e email do Usuário instanciado.
     * Caso contrário, retorna 'false'.
     */
    @Override
    public boolean equals(Object obj) {
        final Usuario other = (Usuario) obj;
        return !((this.getClass() != obj.getClass()) || (obj == null) || (!other.email.equals(this.email)) || (other.senha.equals(this.senha)));
    }

    /**
     * Trata da impressão os dados de um usuário (não sendo todos)
     * 
     * @return retorna uma String com os dados do usuário
     */
    @Override
    public String toString() {
        return perfil + " / " + email + " / " + senha ;
    }
    
}
