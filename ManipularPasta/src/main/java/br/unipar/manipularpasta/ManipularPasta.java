/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.manipularpasta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author renat
 */
public class ManipularPasta {

public static void main(String[] args) {

      String pasta = "C:/Users/renat/Documents/pasta1/";
    String nomeArquivo = "arquivo.txt";

    File pastaArquivos = new File(pasta);

    // Criar a pasta se não existir
    if (!pastaArquivos.exists()) {
        if (pastaArquivos.mkdirs()) {
             JOptionPane.showMessageDialog(null,"Pasta criada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null,"Falha ao criar a pasta.");
            return; 
// Encerrar o programa se a pasta não puder ser criada
        }
    }

    File arquivo = new File(pasta + nomeArquivo);

    try {
        // Criar o arquivo
        arquivo.createNewFile();
         JOptionPane.showMessageDialog(null,"Arquivo criado com sucesso!");

        // Escrever a tabuada do 9 no arquivo
        FileWriter escritor = new FileWriter(arquivo);
      
        for (int i = 1; i <= 10; i++) {
            int resultado = 9 * i;
            escritor.write("9 x " + i + " = " + resultado + "\n");
        }
        escritor.close();

        // Ler o arquivo e imprimir no console
        Scanner scanner = new Scanner(arquivo);
    while (scanner.hasNextLine()) {
            String descricao = (scanner.nextLine());

        JOptionPane.showMessageDialog(null,"Conteúdo do arquivo:"+descricao);
        }

        scanner.close();

        //Da a opção ao usuario de se deja deletar o arquivo

    int confirm = JOptionPane.showConfirmDialog(null,
     "Deseja deletar o arquivo de texto","DELETAR",JOptionPane.YES_NO_OPTION);

        if(confirm == JOptionPane.YES_OPTION){     
        if (arquivo.delete()) {
             JOptionPane.showMessageDialog(null,"Arquivo excluído com sucesso!");
        } else {
             JOptionPane.showMessageDialog(null,"Falha ao excluir o arquivo.");
        }
        }else{
        JOptionPane.showMessageDialog(null, "Exclusão cancelada pelo Usuario!");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

