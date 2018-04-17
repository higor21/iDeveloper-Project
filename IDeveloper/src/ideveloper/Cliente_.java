/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideveloper;

import java.io.*;
import java.net.*;


/**
 *
 * @author Higor Felype
 */
public class Cliente_{

    /**
     * Construtor vazio da classe Cliente_
     */
    public Cliente_(){}
    
    /**
     * Método da classe Cliente_ que é responsável pelo acesso do Usuário a suas informações que estão guardadas no servidor.
     * Informações como: perfil, nome, grupos, publicações, entre outras
     * 
     * @param email Email 
     * @param senha Senha
     * @return Retorna um objeto do tipo Usuario que contém as informações associadas ao e-mail e senha enviados como parâmetro
     */
    public static Usuario entrar(String email,String senha) {
        String S = "1;" + email + ';' + senha;
        Usuario U = null;
        try {
            Socket s_cliente;
             s_cliente =  new Socket("127.0.0.1", 12345);
            ObjectOutputStream outputO = new ObjectOutputStream(s_cliente.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(s_cliente.getInputStream());
            outputO.writeObject(S);
            System.out.println("enviando " + S);
            if((Boolean) input.readObject()){
                System.out.println("passou aqui");
                U = (Usuario) input.readObject();
                System.out.println("passou aqui");
            }            
            s_cliente.close();
        } catch (IOException E) {
            System.out.println("Erro: 5");
            E.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: 6");
            ex.printStackTrace();
        }
        return U;
    }
    
    /**
     * Método da classe Cliente_ que é responsável pelo cadastro de um usuário ao sistema. O método recebe um novo usuário a ser cadastrado.
     *
     * @param U novo usuário
     * @return retorna 'true' se o usuário foi cadastrado com sucesso. Caso contrário, retorna 'false'.
     */
    public static boolean Cadastrar(Usuario U){
        String S = "2;" + U.getEmail() + ';' + U.getSenha();
        try{
            Socket s_cliente;
            s_cliente =  new Socket("127.0.0.1", 12345);
            ObjectOutputStream outputO = new ObjectOutputStream(s_cliente.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(s_cliente.getInputStream());
            
            outputO.writeObject(S);
            
            if(((Boolean) input.readObject())){
                outputO.writeObject(U);
                s_cliente.close();
                return true;
            }
            s_cliente.close();
        }catch(IOException E){
            System.out.println("Erro: 3");
            E.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: 4");
            ex.printStackTrace();
        }
        return false;
    }
    
    /**
     * Este método fica responsável por salvar um objeto com os dados do Usuário. Nesse caso, um usuário será enviado
     * ao servido e ele salvará/atualizará os dados do usuário
     * 
     * @param U Usuário 
     * @return retorna 'true' se o usuário foi salvo. Caso contrário, retorna 'false'.
     */
    public static boolean Salvar(Usuario U){
        try{
            Socket s_cliente;
            s_cliente =  new Socket("127.0.0.1", 12345);
            ObjectOutputStream outputO = new ObjectOutputStream(s_cliente.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(s_cliente.getInputStream());
            
            outputO.writeObject("3");
            outputO.writeObject(U);
            
            return (Boolean) input.readObject();
        }catch(IOException E){
            System.out.println("Erro: 1");
            E.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: 2");
            ex.printStackTrace();
        }
        return false;
    }
}
