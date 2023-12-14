package tec.ada.nuclea.catalogoimdb;

import java.time.LocalDate;

public class ProfissionalCinema {
    private String nome;
    private LocalDate dataNascimento;
    private String nacionalidade;
    private Filme[] filmes;

    public ProfissionalCinema(String nome, LocalDate dataNascimento, String nacionalidade, Filme[] filmes) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.filmes = filmes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Filme[] getFilmes() {
        return filmes;
    }

    public void setFilmes(Filme[] filmes) {
        this.filmes = filmes;
    }
}
