package com.alura.literalura.services;

import com.alura.literalura.dto.DadosAutor;
import com.alura.literalura.dto.DadosResposta;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AutorService {
    private final ConverteDados converteDados;
    private final ConsumoApi consumoApi;

    public AutorService(ConverteDados converteDados, ConsumoApi consumoApi) {
        this.converteDados = converteDados;
        this.consumoApi = consumoApi;
    }

    public List<DadosAutor> buscaAutores() {
        var json = consumoApi.obterDados("");

        return converteDados.obterDados(json, DadosResposta.class).livro().stream()
                .flatMap(l -> l.autor().stream())
                .distinct().sorted(Comparator.comparing(DadosAutor::nome)).toList();
    }

    public List<DadosAutor> buscaAutoresPorAnoNascimentoFalecimento(int anoInicial, int anoFinal) {
        var json = consumoApi.obterDados("?author_year_start=" + anoInicial + "&author_year_end=" + anoFinal);

        return converteDados.obterDados(json, DadosResposta.class).livro().stream()
                .flatMap(l -> l.autor().stream()).distinct()
                .sorted(Comparator.comparing(DadosAutor::nome)).toList();
    }
}
