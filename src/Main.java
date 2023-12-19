package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.DataInputStream;

public class Main {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        boolean opcao = true;

        ArrayList<String> lista = new ArrayList<String>();

        while (opcao) {
            System.out.println("Escolha uma opção do menu:");
            System.out.println("1 - Adicionar item a lista");
            System.out.println("2 - Remover item da lista");
            System.out.println("3 - Imprimir a lista");
            System.out.println("4 - Exportar lista");
            System.out.println("5 - Importar lista");
            System.out.println("0 - Sair");

            int menu = scn.nextInt();
            switch (menu) {
                case 0:
                    opcao = false;
                    break;

                case 1:
                    AddList(lista);
                    break;

                case 2:
                    RemList(lista);
                    break;

                case 3:
                    PrintList(lista);
                    break;

                case 4:
                    Export(lista);
                    break;

                case 5:
                    try {
                        Import(lista);
                    } catch (FileNotFoundException e) {
                        System.out.println("Ocorreu um erro");
                    }


            }
            scn = new Scanner(System.in);
            System.out.println("Voltar ao menu? y/n");
            if (scn.hasNextLine()) {
                if (Objects.equals(scn.nextLine(), "n")) {
                    opcao = false;
                }
            } else {
                break;
            }
        }
    }

    public static void AddList(ArrayList<String> lista) {
        System.out.println("Digite a tarefa que você gostaria de adicionar a lista");
        if (scn.nextLine() != null) {
            lista.add(scn.nextLine());
        }
    }

    public static void RemList(ArrayList<String> lista) {
        boolean opcao = true;
        while (opcao) {
            System.out.println("Digite o numero da tarefa que você gostaria de remover da lista");
            if (scn.nextLine() != null) {
                lista.remove(Integer.parseInt(scn.nextLine()));
            }
            System.out.println("De novo? y/n");
            if (Objects.equals(scn.nextLine(), "n")) {
                opcao = false;
            }
        }
    }

    public static void PrintList(ArrayList<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ": " + lista.get(i));
        }
    }

    public static void Export(ArrayList<String> lista) {
        try {
            FileWriter arquivo = new FileWriter("List.txt");
            for (int i = 0; i < lista.size(); i++) {
                arquivo.write("( )" + lista.get(i) + ";\n");
            }
            arquivo.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }
    }

    public static void Import(ArrayList<String> lista)
            throws FileNotFoundException {
        lista.clear();
        try {
            File arquivo = new File("/home/cathy/codes/ToDoList/List.txt");
            scn = new Scanner(arquivo);
            while (scn.hasNextLine()) {
                lista.add(scn.nextLine());
            }

            System.out.println("O arquivo foi importado com sucesso");

        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um erro");
        }
    }
}

