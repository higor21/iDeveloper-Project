/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideveloper;

import java.io.File;


/**
 * Claee Publicação que é herdera da classe quadro
 * 
 * @author Higor Felype
 * 
 * @see Quadro
 */
public class Publicacao extends Quadro{
    private boolean limiteT; // condição para ser transformado em um grupo
    private int aprovacoes;
    private int reprovacoes;
    private String tema;  

    /**
     * Construtor da classe Publicacao
     *
     * @param tema Tema
     * @param desc Descrição
     * @param ft arquivo da foto
     */
    public Publicacao(String tema, String desc,File ft) {
        super(desc,ft);         
        this.limiteT = false;   
        this.aprovacoes = 0;    
        this.reprovacoes = 0;   
        this.tema = tema;       
    }

    /** 
     * Verifica se a publicação já pode ser transformada em um grupo
     */
    public void isLimiteT() {
        if(this.reprovacoes/this.aprovacoes < 0.2 && this.aprovacoes > 1000)
            this.limiteT = true;
    }

    /**
     * Método que retorna a quantidade de reprovações
     *
     * @return rerorna a quantidade de aprovações atual
     */
    public int getAprovacoes() {
        return aprovacoes;
    }

    /**
     * imprementa a quantidade de aprovações em uma unidade
     */
    public void setAprovacoes() {
        this.aprovacoes++;
    }

    /**
     * Indica a quantidade de reprovações 
     * 
     * @return retorna o número de reprovações atual
     */
    public int getReprovacoes() {
        return reprovacoes;
    }

    /**
     * incrementa a quantidade de reprovações em uma unidade
     */
    public void setReprovacoes() {
        this.reprovacoes++;
    }

    /**
     * Método da classe Publicação que retorna uma string
     * 
     * @return retorna uma string com o tema da Publicação instanciada
     */
    public String getTema() {
        return tema;
    }

    /**
     * Altera o valor do tema da classe instanciada
     * @param tema Tema (String)
     */
    public void setTema(String tema) {
        this.tema = tema;
    }
    
}
