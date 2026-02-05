package com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias({"title", "titulo"}) String titulo,
                         @JsonAlias({"authors", "autor"}) List<DadosAutor> autor,
                         @JsonAlias({"languages", "idiomas"}) List<String> idioma,
                         @JsonAlias({"download_count", "numeroDownloads"}) Integer numeroDownloads) {

    @Override
    public @NotNull String toString() {
        return """
                Título: %s;
                Autor(es): %s;
                Idioma: %s;
                Número de Downloads: %d
                """.formatted(titulo, autor, idioma, numeroDownloads);
    }
}
