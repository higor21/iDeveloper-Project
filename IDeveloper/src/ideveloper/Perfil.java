/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideveloper;

import java.io.*;


/** 
 * Classe que contém dos dados do perfil do usuário
 * 
 * @author Higor Felype
 */
public class Perfil extends Quadro{
    private String nome;
    private String curso;

    /**
     * Construtor da classe Perfil
     * 
     * @param desc Descrição
     * @param nome Nome
     * @param curso Curso
     * @param ft Arquivo da foto
     */
    public Perfil(String desc, String nome, String curso, File ft) {
        super(desc,ft);
        this.nome = nome;
        this.curso = curso;
    }       

    /** 
     * Construtor vazio do Perfil
     */
    public Perfil(){
        super("sem descricao!",null);
    }
    
    /**
     * Retorna um String contendo o nome do curso de um usuário
     * @return nome do curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Altera o valor do curso que está no perfil instanciado
     * @param curso novo curso
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * Retorna o nome que está no perfil do usuário instanciado
     * 
     * @return Retorna o nome que está no perfil do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome que está no perfil do usuário instanciado
     * 
     * @param nome Nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + '\n';
    }
}
