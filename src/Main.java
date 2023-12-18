package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner scn = new Scanner(System.in);
    public static void main(String args[]) {
        boolean opcao = true;

        ArrayList<String> lista = new ArrayList<String>();

        System.out.println("Escolha uma opção do menu:");
        System.out.println("1 - Adicionar item a lista");
        System.out.println("2 - Remover item da lista");
        System.out.println("3 - Imprimir a lista");

        AddList(lista);

        Export(lista);

        PrintList(lista);
        try{
            Import(lista);
        }catch (FileNotFoundException e){
            System.out.println("Socorro");
        }


    }

    public static void AddList(ArrayList<String> lista) {
        boolean opcao = true;
        while (opcao) {
            System.out.println("Digite a tarefa que você gostaria de adicionar a lista");
            lista.add(scn.nextLine());
            System.out.println("De novo? y/n");
            if (Objects.equals(scn.nextLine(), "n")) {
                opcao = false;
            }
        }
    }

    public static void RemList(ArrayList<String> lista) {
        boolean opcao = true;
        while (opcao) {
            System.out.println("Digite o numero da tarefa que você gostaria de remover da lista");
            lista.remove(scn.nextInt());
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
                arquivo.write(lista.get(i) + "( )" + "\n");
            }
            arquivo.close();
        } catch (IOException e) {
            System.out.println("Um erro ocorreu");
            e.printStackTrace();
        }
    }

    public static void Do(ArrayList<String> lista) {
        System.out.println("Digite o index da tarefa para marcar como feita");
        int tarefa = scn.nextInt();
        lista.set(tarefa, lista.get(tarefa) + "(X)");
    }

    public static void Import(ArrayList<String> lista) throws FileNotFoundException {

        try {
            File file = new File("List.txt");

            scn = new Scanner(file);

            String lol = scn.nextLine();

            System.out.println(lol);
        } catch (FileNotFoundException e) {
            System.out.println("Um erro ocorreu");
        }
    }
}

