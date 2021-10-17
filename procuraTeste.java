// Luiz Felipe Baracat Iavarone - 21335002
// Higor Mantas de Oliveira Lins - 21245760
// Wanderley Lobregat Neto - 21324602
// Lucas Santana - 21295502
// Nathan Cavalcante - 21316482


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class procuraTeste {
    

    public static int contador = 0;
    public static List<String> list = new ArrayList<String>();
    public static List<String> nome = new ArrayList<String>();
    public static List<String> sexo = new ArrayList<String>();
    public static List<String> endereco = new ArrayList<String>();
    public static List<String> cidade = new ArrayList<String>();
    public static List<String> email = new ArrayList<String>();
    public static List<String> telefone = new ArrayList<String>();
    public static List<String> idade = new ArrayList<String>();

    public static void main(String[] args) {

        try {
            File file = new File("arquivoDados.csv");
            Scanner scanner = new Scanner(file);

            // enquanto não chegar ao final do arquivo
            while (scanner.hasNextLine()) {
                // leia a próxima linha do arquivo
                String linha = scanner.nextLine();
                //System.out.println(linha);
                list.add(linha);
                contador++;
            }

            int contador2 = 0;

            while(contador2<contador){
                String variavelTratamento = list.get(contador2);
                String[] tratamento = variavelTratamento.split(",");
                int controleArray = 0;

                while(controleArray <= 6){
                    if(controleArray==0){
                        nome.add(tratamento[controleArray]);
                    }else if(controleArray==1){
                        sexo.add(tratamento[controleArray]);
                    }else if(controleArray==2){
                        endereco.add(tratamento[controleArray]);
                    }else if(controleArray==3){
                        cidade.add(tratamento[controleArray]);
                    }else if(controleArray==4){
                        email.add(tratamento[controleArray]);
                    }else if(controleArray==5){
                        telefone.add(tratamento[controleArray]);
                    }else if(controleArray==6){
                        idade.add(tratamento[controleArray]);
                    }
                    controleArray++;
                }
                contador2++;           
            }

            scanner.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        int controleExcucao = 0;
        Scanner inputNome = new Scanner(System.in , "UTF-8");

        while(controleExcucao<1){
            System.out.println("Digite o nome que deseja buscar");
            String entradaDados = inputNome.nextLine();
            if(entradaDados.equals("exit")){
                controleExcucao++;
            }else{
                //Pesquisa por regex, traz todos os possiveis metodos
                //pesquisarNome(entradaDados);

                //Pesquisa por metodo binario
                int posicao = pesquisaBinaria(entradaDados);
                if(posicao>0){
                    System.out.println("Infos: "+nome.get(posicao)+" Sexo: "+sexo.get(posicao)+" Endereco: "+endereco.get(posicao)+" Cidade: "+cidade.get(posicao)+" Email: "+email.get(posicao)+" Telefone: "+telefone.get(posicao)+" Idade: "+idade.get(posicao));
                }else{
                    System.out.println("Nome não encontrado");
                }
            }
        }
        inputNome.close();

    }
    
    public static boolean pesquisarNome(String nomeProcurar){
        int teste = 0;
        int testeEncontradoAlgumValor = 0;
        while(teste<contador){
            String comparador = nome.get(teste);
            boolean palavra = comparador.matches(".*"+nomeProcurar+".*");
            if(palavra){
                System.out.println("Linha: "+teste+" Nome: "+nome.get(teste)+" Sexo: "+sexo.get(teste)+" Endereco: "+endereco.get(teste)+" Cidade: "+cidade.get(teste)+" Email: "+email.get(teste)+" Telefone: "+telefone.get(teste)+" Idade: "+idade.get(teste));
                System.out.println("Comparações Realizadas: "+teste);
                testeEncontradoAlgumValor++;
            }else{
                
            }
            teste++;
        };
        if(testeEncontradoAlgumValor==0){
            System.out.println("Nome não encontrado");
            return false;
        }else{
            return true;
        }
    }


    public static int contarCompara;

    public static int pesquisaBinaria(String chave) {
        int inicio, meio, fim;

        inicio = 0;
        fim = nome.size() - 1;
        contarCompara = 0;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            contarCompara++;
            if (chave.equals(nome.get(meio))) {
                return meio;
            }
            contarCompara++;

            if (chave.compareTo(nome.get(meio)) < 0) { 
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        System.out.println("Quantidade de comparações realizadas> "+contarCompara);
        return -1; 

    }

}