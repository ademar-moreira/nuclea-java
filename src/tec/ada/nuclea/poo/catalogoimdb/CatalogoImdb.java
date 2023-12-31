package tec.ada.nuclea.poo.catalogoimdb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CatalogoImdb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao seu catálogo de filmes");
        OperacoesFilmes operacoesFilmes = new OperacoesFilmes();
        boolean sair = false;
        while (!sair) {
            System.out.println("""
                    1 - Cadastrar filmes
                    2 - Cadastrar atores
                    3 - Cadastrar diretores
                    4 - Associar um filme aos seus atores
                    5 - Associar um filme ao seu diretor
                    6 - Pesquisar filme cadastrados pelo nome
                    7 - Sair
                    Digite uma opção:""");
            String input = sc.next();
            sc.nextLine();
            int opcao;
            try {
                opcao = Integer.parseInt(input);
                if (opcao < 1 || opcao > 7) {
                    System.err.println("Entrada inválida! - Digite um número entre 1 e 7.");
                }
                if (opcao == 1) {
                    System.out.println("Cadastrar Filmes");
                    String continuar = "S";

                    while (continuar.equalsIgnoreCase("S")) {
                        System.out.println("Digite o nome do filme: ");
                        String nome = sc.nextLine();

                        System.out.println("Digite a data de lançamento (dd/MM/yyyy): ");
                        String dataString = sc.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        LocalDate data = null;
                        boolean dataValida = false;
                        while (!dataValida) {
                            try {
                                data = LocalDate.parse(dataString, formatter);
                                dataValida = true;
                            } catch (DateTimeParseException e) {
                                System.out.println("Data inválida. Digite a data de lançamento novamente (dd/MM/yyyy): ");
                                dataString = sc.next();
                            }
                        }

                        int orcamento = 0;
                        boolean orcamentoValido = false;
                        while (!orcamentoValido){
                            System.out.println("Digite o valor do orçamento do filme: ");
                            input = sc.nextLine();

                            try {
                                orcamento = Integer.parseInt(input);
                                orcamentoValido = true;
                            }catch (NumberFormatException e) {
                                System.err.println("Entrada inválida! - Digite um número inteiro");
                            }
                        }

                        System.out.println("Digite a descrição do filme: ");
                        String descricao = sc.nextLine();

                        Filme filme = new Filme(nome, data, orcamento, descricao);

                        operacoesFilmes.salvarFilme(filme);

                        System.out.println("Deseja cadastrar outro filme? ");
                        continuar = sc.nextLine();
                        while (!continuar.equalsIgnoreCase("S") && !continuar.equalsIgnoreCase("N")) {
                            System.err.println("Entrada inválida! - Digite apenas S ou N");
                            System.out.println("Deseja Cadastrar outro filme? ");
                            continuar = sc.nextLine();
                        }
                    }
                    ArrayList<Filme> filmesSalvos = operacoesFilmes.getFilmesDoBancoDeDados();
                    for (Filme film : filmesSalvos) {
                        System.out.print(film.getNome() + "   " + film.getDataLancamento() + "    " + film.getOrcamento()
                                + "    " +film.getDescricao() + "\n");
                    }

                }
                if (opcao == 2) {
                    System.out.println("Cadastrar atores");
                    String continuar = "S";

                    while (continuar.equalsIgnoreCase("S")) {
                        System.out.println("Digite o nome do ator: ");
                        String nome = sc.nextLine();

                        System.out.println("Digite a data de nascimento: ");
                        String dataString = sc.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        LocalDate data = null;
                        boolean dataValida = false;
                        while (!dataValida) {
                            try {
                                data = LocalDate.parse(dataString, formatter);
                                dataValida = true;
                            } catch (DateTimeParseException e) {
                                System.out.println("Data inválida. Digite a data de nascimento novamente (dd/MM/yyyy): ");
                                dataString = sc.next();
                            }
                        }

                        System.out.println("Digite a nacionalidade: ");
                        String nacionalidade = sc.nextLine();

                        Ator ator = new Ator(nome, data, nacionalidade);

                        operacoesFilmes.salvarAtor(ator);

                        System.out.println("Deseja Cadastrar outro ator? ");
                        continuar = sc.nextLine();
                        while (!continuar.equalsIgnoreCase("S") && !continuar.equalsIgnoreCase("N")) {
                            System.err.println("Entrada inválida! - Digite apenas S ou N");
                            System.out.println("Deseja cadastrar outro ator? ");
                            continuar = sc.nextLine();
                        }
                    }
                    ArrayList<Ator> atoresSalvos = operacoesFilmes.getAtoresDoBandoDeDados();
                    for (Ator actor: atoresSalvos) {
                        System.out.print(actor.getNome() + "   " + actor.getDataNascimento() + "   "
                                + actor.getNacionalidade() + "\n");
                    }
                }

                if (opcao == 3) {
                    System.out.println("Cadastrar diretores");
                    String continuar = "S";

                    while (continuar.equalsIgnoreCase("S")) {
                        System.out.println("Digite o nome do diretor: ");
                        String nome = sc.nextLine();

                        System.out.println("Digite a data de nascimento: ");
                        String dataString = sc.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        LocalDate data = null;
                        boolean dataValida = false;
                        while (!dataValida) {
                            try {
                                data = LocalDate.parse(dataString, formatter);
                                dataValida = true;
                            } catch (DateTimeParseException e) {
                                System.out.println("Data inválida. Digite a data de nascimento novamente (dd/MM/yyyy): ");
                                dataString = sc.next();
                            }
                        }

                        System.out.println("Digite a nacionalidade: ");
                        String nacionalidade = sc.nextLine();

                        Diretor diretor = new Diretor(nome, data, nacionalidade);

                        operacoesFilmes.salvarDiretor(diretor);

                        System.out.println("Deseja Cadastrar outro diretor? ");
                        continuar = sc.nextLine();
                        while (!continuar.equalsIgnoreCase("S") && !continuar.equalsIgnoreCase("N")) {
                            System.err.println("Entrada inválida! - Digite apenas S ou N");
                            System.out.println("Deseja cadastrar outro diretor? ");
                            continuar = sc.nextLine();
                        }
                    }
                    ArrayList<Diretor> diretoresSalvos = operacoesFilmes.getDiretoresDoBancoDeDados();
                    for (Diretor director: diretoresSalvos) {
                        System.out.print(director.getNome() + "   " + director.getDataNascimento() + "   "
                                + director.getNacionalidade() + "\n");
                    }
                }

                if (opcao == 4) {
                    System.out.println("Associar um filme com seus atores");
                    String continuar = "S";

                    while (continuar.equalsIgnoreCase("S")) {

                        System.out.println("Digite o nome do filme para associar aos atores");
                        String filmeString = sc.nextLine();
                        String cont = "S";
                        while (cont.equalsIgnoreCase("S")) {

                            System.out.println("Digite o nome do ator para vincular ao filme");
                            String nomeAtorString = sc.nextLine();

                            operacoesFilmes.associarAtorAoFilme(filmeString, nomeAtorString);

                            System.out.printf("Deseja vincular outro ator ao filme %s?\n", filmeString);
                            cont = sc.nextLine();
                            while (!cont.equalsIgnoreCase("S") && !cont.equalsIgnoreCase("N")) {
                                System.err.println("Entrada inválida! - Digite apenas S ou N");
                                System.out.printf("Deseja vincular outro ator ao filme %s?\n", filmeString);
                                cont = sc.nextLine();
                            }
                        }

                        System.out.println("Deseja associar outro filme com seus atores? ");
                        continuar = sc.nextLine();
                        while (!continuar.equalsIgnoreCase("S") && !continuar.equalsIgnoreCase("N")) {
                            System.err.println("Entrada inválida! - Digite apenas S ou N");
                            System.out.println("Deseja Cadastrar outro diretor? ");
                            continuar = sc.nextLine();
                        }
                    }
                    ArrayList<Filme> filmesSalvos = operacoesFilmes.getFilmesDoBancoDeDados();
                    for (Filme film : filmesSalvos) {
                        System.out.print(film.getNome() + "   " + film.getDataLancamento() + "    " + film.getOrcamento()
                                + "    " + Arrays.toString(film.getElenco()) + "\n");
                    }
                }

                if (opcao == 5) {
                    System.out.println("Associar um filme ao seu diretor");
                    String continuar = "S";

                    while (continuar.equalsIgnoreCase("S")) {

                        System.out.println("Digite o nome do filme para associar ao diretor");
                        String filmeString = sc.nextLine();
                        System.out.println("Digite o nome do diretor para vincular ao filme");
                        String nomeDiretorString = sc.nextLine();

                        operacoesFilmes.associarDiretorAoFilme(filmeString, nomeDiretorString);

                        System.out.println("Deseja associar outro filme com seu diretor? ");
                        continuar = sc.nextLine();
                        while (!continuar.equalsIgnoreCase("S") && !continuar.equalsIgnoreCase("N")) {
                            System.err.println("Entrada inválida! - Digite apenas S ou N");
                            System.out.println("Deseja associar outro filme com seu diretor? ");
                            continuar = sc.nextLine();
                        }
                    }
                }

                if (opcao == 6) {
                    System.out.println("Pesquisar filme cadastrados pelo nome");
                    String continuar = "S";

                    while (continuar.equalsIgnoreCase("S")) {

                        System.out.println("Digite o nome do filme");
                        String nomeFilme = sc.nextLine();

                        Filme filmeEncontrado = operacoesFilmes.pesquisarFilmePorNome(nomeFilme);

                        if (filmeEncontrado != null) {
                            System.out.println("Filme encontrado:");
                            System.out.println("Nome: " + filmeEncontrado.getNome());
                            System.out.println("Data de Lançamento: " + filmeEncontrado.getDataLancamento());
                            System.out.println("Orçamento: " + filmeEncontrado.getOrcamento());
                            System.out.println("Descrição: " + filmeEncontrado.getDescricao());
                            System.out.println("Diretor: " + filmeEncontrado.getDiretor().getNome());
                            System.out.println("Elenco: ");
                            List<Ator> atores = Arrays.asList(filmeEncontrado.getElenco());
                            atores.forEach(ator -> System.out.println("        "+ ator.getNome()));
                        }

                        System.out.println("Deseja pesquisar outro filme? ");
                        continuar = sc.nextLine();
                        while (!continuar.equalsIgnoreCase("S") && !continuar.equalsIgnoreCase("N")) {
                            System.err.println("Entrada inválida! - Digite apenas S ou N");
                            System.out.println("Deseja pesquisar outro filme? ");
                            continuar = sc.nextLine();
                        }
                    }
                }

                if (opcao == 7) {
                    System.out.println("Saindo do sistema");
                    sair = true;
                }

            }catch (NumberFormatException e) {
                System.err.println("Entrada inválida! - Digite um número inteiro de 1 a 7.");

            }
        }
    }
}
