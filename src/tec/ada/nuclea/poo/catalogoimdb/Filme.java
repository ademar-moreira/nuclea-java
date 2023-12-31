package tec.ada.nuclea.poo.catalogoimdb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Filme {
    private final String nome;
    private LocalDate dataLancamento;
    private int orcamento;
    private String descircao;
    private Diretor diretor;
    private Ator[] elenco;
    public Filme (String nome, LocalDate dataLancamento, int orcamento, String descricao) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descircao = descricao;
    }

    public Filme(String filmeString) {
        this.nome = filmeString;
    }

    public void adicionarAtor(Ator ator) {
        if (this.elenco == null) {
            this.elenco = new Ator[]{ator};
        } else {
            ArrayList<Ator> novoElenco = new ArrayList<>(Arrays.asList(this.elenco));
            if (!novoElenco.contains(ator)) {
                novoElenco.add(ator);
                this.elenco = novoElenco.toArray(new Ator[0]);
            }
        }
    }

    public void adicionarDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public String getNome() {
        return this.nome;
    }

    public LocalDate getDataLancamento() {
        return this.dataLancamento;
    }
    public int getOrcamento() {
        return this.orcamento;
    }
    public String getDescricao() {
        return this.descircao;
    }
    public Diretor getDiretor() {
        return this.diretor;
    }
    public Ator[] getElenco() {
        return this.elenco;
    }
}
