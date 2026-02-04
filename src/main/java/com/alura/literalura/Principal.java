package com.alura.literalura;

import com.alura.literalura.dto.DadosResposta;
import com.alura.literalura.services.ConsumoApi;
import com.alura.literalura.services.ConverteDados;

import java.util.Scanner;

public class Principal {

    Scanner scanner = new Scanner(System.in);
    ConsumoApi consumoApi = new ConsumoApi();
    ConverteDados converteDados = new ConverteDados();

    public Principal() {
    }

    public void iniciar() {

        System.out.println("""
                =================================================
                Bem-vindo ao Literalura - Sua Biblioteca Virtual!;
                Pesquise sobre seus livros.""");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Olá, " + nome + "! Vamos explorar o mundo dos livros juntos.");
        System.out.println("""
                Menu de Opções:
                1. Buscar Livro por Nome
                2. Listar Todos os Livros
                3. Sair
                """);


        int opcao = scanner.nextInt();
        scanner.nextLine();


        while (opcao != 3) {
            switch (opcao) {
                case 1 -> buscarLivroPorNome();
                case 2 -> listarTodosLivros();
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println("""
                    Menu de Opções:
                    1. Buscar Livro por Nome
                    2. Listar Todos os Livros
                    3. Sair
                    """);
            opcao = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public void buscarLivroPorNome() {
        System.out.print("Digite o nome do livro que deseja buscar: ");

        String nomeLivro = scanner.nextLine();

        String urlPesquisa = "?search=" + nomeLivro.toLowerCase().replace(" ", "-");

        System.out.println("Buscando informações sobre o livro: " + nomeLivro.toUpperCase());

        var json = consumoApi.obterDados(urlPesquisa);

        String resultadoPesquisa = converteDados.obterDados(json, DadosResposta.class).toString();

        System.out.println(resultadoPesquisa);
    }

    public void listarTodosLivros() {
        System.out.println("Listando todos os livros disponíveis...");

        String urlTodosLivros = "";

        var json = consumoApi.obterDados(urlTodosLivros);

        String resultadoLista = converteDados.obterDados(json, DadosResposta.class).toString();

        System.out.println(resultadoLista);
    }


}
