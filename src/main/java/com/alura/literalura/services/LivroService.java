package com.alura.literalura.services;

import com.alura.literalura.dto.DadosLivro;
import com.alura.literalura.dto.DadosResposta;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


@Service
public class LivroService {

    private final ConverteDados converteDados;
    private final ConsumoApi consumoApi;

    public LivroService(ConverteDados converteDados, ConsumoApi consumoApi) {
        this.converteDados = converteDados;
        this.consumoApi = consumoApi;
    }

    public List<DadosLivro> buscaLivrosNome(String nomeLivro) {
        String urlPesquisa = "?search=" + nomeLivro.toLowerCase().replace(" ", "-");

        var json = consumoApi.obterDados(urlPesquisa);

        return converteDados.obterDados(json, DadosResposta.class)
                .livro().stream()
                .distinct().sorted(Comparator.comparing(DadosLivro::titulo)).toList();
    }

    public List<DadosLivro> buscaTodosLivros() {
        String urlTodosLivros = "";

        var json = consumoApi.obterDados(urlTodosLivros);

        return converteDados.obterDados(json, DadosResposta.class)
                .livro().stream()
                .distinct().sorted(Comparator.comparing(DadosLivro::titulo)).toList();
    }
}
