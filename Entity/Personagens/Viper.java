package Entity.Personagens;

import Controller.Dados;
import Entity.HabilidadePendente;
import Entity.Personagem;
import Entity.Habilidade;
import Entity.Jogador;

public class Viper extends Personagem {
    public Viper() {
        super("Viper", "Caçadora de Recompensas", 100, geradorHabilidades());
    }

    private static Habilidade[] geradorHabilidades() {
        Habilidade[] habilidades = new Habilidade[4];
        String nome;
        String descricao;
        int energia;

        nome = "Nuvem Venenosa";
        descricao = "Viper dispara um emissor de gás nos inimigos. \nDano(15); Múltiplos Alvos.";
        energia = 1;
        habilidades[0] = new Habilidade(nome, descricao, energia, 2+energia);

        nome = "Cortina Tóxica";
        descricao = "Viper dispara uma longa linha de gás. \nDano(25); Múltiplos Alvos.";
        energia = 2;
        habilidades[1] = new Habilidade(nome, descricao, energia, 2+energia);

        nome = "Veneno de Cobra";
        descricao = "Viper lança um cilindro, que se rompe e de gera uma zona química. \nDano(20); Stun(1); Múltiplos Alvos.";
        energia = 3;
        habilidades[2] = new Habilidade(nome, descricao, energia, 2+energia);

        nome = "Poço Peçonhento";
        descricao = "Viper cria uma grande nuvem que reduzindo a vida de um inimigo para um mínimo de 1. \nDano Máximo: (50); Invulnerável(2); Ignora Defesa.";
        energia = 4;
        habilidades[3] = new Habilidade(nome, descricao, energia, 2+energia);

        return habilidades;
    }

    public boolean[][] verificarHabilidade(boolean[][] vivos, boolean[] invulneraveis, int idPersonagem, int idHabilidade) {
        if (idHabilidade == 0) {
            vivos = bloquearAliados(vivos);
            vivos = bloquearInvulneraveis(vivos, invulneraveis);
        }
        else if (idHabilidade == 1) {
            vivos = bloquearAliados(vivos);
            vivos = bloquearInvulneraveis(vivos, invulneraveis);
        }
        else if (idHabilidade == 2) {
            vivos = bloquearAliados(vivos);
            vivos = bloquearInvulneraveis(vivos, invulneraveis);
        }
        else if (idHabilidade == 3) {
            vivos = bloquearAliados(vivos);
        }

        return vivos;
    }

    public void utilizarHabilidade(HabilidadePendente habilidade) {
        int idPersonagem = habilidade.getIdPersonagem();
        int idHabilidade = habilidade.getIdHabilidade();
        int idJogadorAlvo = habilidade.getIdJogadorAlvo();
        int idPersonagemAlvo = habilidade.getIdPersonagemAlvo();

        Jogador[] jogadores = Dados.partida.getJogadores();

        jogadores[0].getPersonagens().get(idPersonagem).getHabilidades()[idHabilidade].setCountdownAtual();

        if (idHabilidade == 0) {
            for (int i = 0; i < 3; i++) {
                if (jogadores[idJogadorAlvo].getPersonagens().get(i).getVida() > 0 && jogadores[idJogadorAlvo].getPersonagens().get(i).getInvulneravel() == 0) {
                    jogadores[idJogadorAlvo].getPersonagens().get(i).dano(15);
                }
            }
        }

        else if (idHabilidade == 1) {
            for (int i = 0; i < 3; i++) {
                if (jogadores[idJogadorAlvo].getPersonagens().get(i).getVida() > 0 && jogadores[idJogadorAlvo].getPersonagens().get(i).getInvulneravel() == 0) {
                    jogadores[idJogadorAlvo].getPersonagens().get(i).dano(25);
                }
            }
        }

        else if (idHabilidade == 2) {
            for (int i = 0; i < 3; i++) {
                if (jogadores[idJogadorAlvo].getPersonagens().get(i).getVida() > 0 && jogadores[idJogadorAlvo].getPersonagens().get(i).getInvulneravel() == 0) {
                    jogadores[idJogadorAlvo].getPersonagens().get(i).dano(20);
                    jogadores[idJogadorAlvo].getPersonagens().get(i).stunnar(1);
                }
            }
        }

        else if (idHabilidade == 3) {
            if (jogadores[idJogadorAlvo].getPersonagens().get(idPersonagemAlvo).getVida() <= 50) {
                jogadores[idJogadorAlvo].getPersonagens().get(idPersonagemAlvo).setVida(1);
            }
            else {
                jogadores[idJogadorAlvo].getPersonagens().get(idPersonagemAlvo).dano(50);
            }
        }

        Dados.partida.setJogadores(jogadores);
    }
}
