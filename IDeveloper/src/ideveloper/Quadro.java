/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideveloper;

import java.io.File;
import java.io.Serializable;

/**
 * Essa Classe serve como base para as Classes perfil e Publicação
 * 
 * @author Higor Felype
 * @see Serializable
 * 
 * @see Perfil
 * @see Publicacao
 */
public abstract class Quadro implements Serializable {
    private File foto;
    private String Descricao;    

    /**
     * Construtor da classe Quadro, que implementa a classe Serializable.
     * Sendo o primeiro parâmetro a descrição da foto e o segundo o arquivo da mesma
     * 
     * @param desc  Descrição
     * @param ft    Arquivo da foto
     */
    public Quadro(String desc, File ft) {
        this.Descricao = desc;
        this.foto = ft;
    }    

    /**
     * Método da classe Quadro que retorna um arquivo
     * 
     * @return Retorna um arquivo que contém a foto
     */
    public File getFoto() {
        return foto;
    }

    /**
     * Troca o arquivo que contém a foto, onde o parâmetro é o caminho do mesmo.
     * 
     * @param caminho novo caminho (File)
     */
    public void setFoto(File caminho) {
        this.foto = caminho;
    }
    
    /**
     * Método da classe Quadro que retorna uma String
     * 
     * @return Descrição da foto como uma String
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * Altera o valor da descrição da foto 
     * 
     * @param Descricao String que contém a nova descrição
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
}
