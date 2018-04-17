/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*PROTOCOLO DE COMUNICAÇÃO:
    º 1 == entrar no sistema
    º 2 == se cadastrar no sistema
    º 3 == salva os dados no sistema

*/
package ideveloper;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Higor Felype
 */
public class Sistema implements Runnable{

    private static final TimeLine timeLine = new TimeLine();
    private static final ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Usuario User = null;
    
    /**
     * construtor vazio da classe Sistema
     */
    public Sistema(){
    }
   
    /**
     * Método que verifica se a senha e o e-mail enviado pelo cliente está relacionado com algum usuário
     * armazenado nos usuários cadastrados no sistema.
     * 
     * @param S1 Email
     * @param S2 Senha
     * @return return 'true' se os dados se relacionam com algum usuário. Caso contrário, retorna 'false'.
     */
    private static boolean verificarEntrada(String S1, String S2) {
        for(Usuario i: Sistema.usuarios){
            //System.out.println( "("+ S1 + " / " + S2 +" / " + i.getEmail() + " / "  + i.getSenha() + ")");
            if(S1.equals(i.getEmail()) && S2.equals(i.getSenha())){
                User = i;
                //System.out.println("user escolhido: " + auxU);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método principal(main) da classe Sistema que relaciona o mesmo com o cliente. Este método é responsável pela comunicação 
     * cliente-servidor.
     * 
     * @param args parâmetro comum do método principal
     */
    public static void main(String args[]){
        ServerSocket servidor;
        Sistema sistema = new Sistema();
        Thread T = new Thread(sistema);
        T.start();
        
        String dadosEntrada[];
        
        try {
            servidor = new ServerSocket(12345);
            // loop infinito
            while (true) {
                // Aceitar uma conexao
                System.out.println("esperando conexão ...");
                Socket cliente = servidor.accept();
                System.out.println("Conexão OK");
                ObjectOutputStream objOut = new ObjectOutputStream(cliente.getOutputStream());
                ObjectInputStream objIn = new ObjectInputStream(cliente.getInputStream());
                
                dadosEntrada = ((String) objIn.readObject()).split(";|;\\s");
                
                switch (dadosEntrada[0]) {
                    case "1":
                        //System.out.println("dados: " + dadosEntrada[1] + dadosEntrada[2] + '\n' + Sistema.usuarios.get(0).getEmail() + ' '+ Sistema.usuarios.get(0).getSenha());
                        if(Sistema.verificarEntrada(dadosEntrada[1],dadosEntrada[2])){
                            objOut.writeObject(true);
                            System.out.println(User);
                            objOut.writeObject(User);
                            System.out.println(User);
                        }else{
                            objOut.writeObject(false);
                        }
                        break;
                    case "2":
                        if(!Sistema.verificarEntrada(dadosEntrada[1],dadosEntrada[2])){
                            objOut.writeObject(true);
                            Sistema.usuarios.add((Usuario) objIn.readObject());
                        }else
                            objOut.writeObject(false);
                        break;
                    case "3":
                        Usuario U = (Usuario) objIn.readObject();
                        if(Sistema.usuarios.contains(U)){
                            Sistema.usuarios.replaceAll((UnaryOperator<Usuario>) U); // salvando os dados do usuário (SE NÃO DER CERTO VAI O for)
                            objOut.writeObject(true);
                        }else
                            objOut.writeObject(false);
                        break;
                    default:
                        break;
                }
            }
            
        } catch (IOException E) {
            System.out.println("Erro: falha no sistema de entrada de dados");
            E.printStackTrace();
        } catch (ClassNotFoundException E){
            System.out.println("Erro: falha ao tentar ler o objeto");
            E.printStackTrace();
        }
    }
    /**
     * 
     */
    @Override
    public void run() {
        while(true){
            for(int i=0; i<Sistema.usuarios.size(); i++){
                for(int k=0; k<Sistema.usuarios.get(i).getGrupos().size(); k++)
                    if(!Sistema.timeLine.verficGrupo(Sistema.usuarios.get(i).getGrupos().get(k)))
                        Sistema.timeLine.addGrupo(Sistema.usuarios.get(i).getGrupos().get(k));
                for(int k=0; k<Sistema.usuarios.get(i).getPublicacoes().size(); k++)
                    if(!Sistema.timeLine.verifPublic(Sistema.usuarios.get(i).getPublicacoes().get(k)))
                        Sistema.timeLine.addPublicacao(Sistema.usuarios.get(i).getPublicacoes().get(k));
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
