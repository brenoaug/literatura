package com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosResposta(@JsonAlias({"results", "resultado"}) List<DadosLivro> livro) {

    @Override
    public @NotNull String toString() {
        return "Dados do Livro: \n" + livro;
    }
}
