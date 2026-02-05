package com.alura.literalura.menu;

import com.alura.literalura.services.LivroService;
import org.springframework.stereotype.Component;

import static com.alura.literalura.menu.MenuPrincipal.scanner;

@Component
public class MenuLivros {

    private final LivroService livroService;

    public MenuLivros(LivroService livroService) {
        this.livroService = livroService;
    }

    public void imprimeLivroPorNome() {
        System.out.print("Digite o nome do livro que deseja buscar: ");
        String nomeLivro = scanner.nextLine();

        System.out.println("Buscando informações sobre o livro: " + nomeLivro.toUpperCase() + "\n");

        livroService.buscaLivrosNome(nomeLivro)
                .forEach(livro -> System.out.println(livro + "\n"));
    }

    public void imprimeTodosLivros() {
        System.out.println("Listando todos os livros disponíveis...\n");

        livroService.buscaTodosLivros()
                .forEach(livro -> System.out.println(livro + "\n"));
    }

}
