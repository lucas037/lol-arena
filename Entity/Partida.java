package Entity;

import Controller.Dados;
import java.time.Duration;

public class Partida {
    int turno;
    int jogadorAtual;
    private Jogador [] jogadores = new Jogador[2];
    private int vencedor; //0 para nenhum,1 para jogador 1, 2 para jogador 2
    private Duration tempoPorTurno;
    private int turnos;
    private int turnoMaximo;

    public Partida(Jogador[] jogadores) {
        jogadorAtual = 0;
        setJogadores(jogadores);
        setTurnos(0);
        setTurnoMaximo(100);
        setVencedor(0);
        turno = 0;
    }

    public int getTurno() {
        return turno;
    }

    public int getJogadorAtual() {
        return this.jogadorAtual;
    }

    public Jogador[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogador[] jogadores) {
        this.jogadores = jogadores;
    }

    public Jogador getJogadorAtacante() {
        return jogadores[0];
    }

    public Jogador getJogadorDefensor() {
        return jogadores[1];
    }

    public int getVencedor() {
        return vencedor;
    }

    public void setVencedor(int vencerdor) {
        this.vencedor = vencerdor;
    }

    public Duration getTempoPorTurno() {
        return tempoPorTurno;
    }

    public void setTempoPorTurno(Duration tempoPorTurno) {
        this.tempoPorTurno = tempoPorTurno;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public int getTurnoMaximo() {
        return turnoMaximo;
    }

    public void setTurnoMaximo(int turnoMaximo) {
        this.turnoMaximo = turnoMaximo;
    }

    public void utilizarHabilidade(HabilidadePendente habilidade) {
        jogadores[0].utilizarHabilidade(habilidade);
    }

    public void passarTurno() {
    }

    public void inverterJogadores() {
        if (turno == 30) {
            Dados.fimPartidaEmpate();
        }

        turno++;

        jogadores[0].passarTurno();
        jogadores[1].meuTurno();

        Jogador jogadorAux = jogadores[0];
        jogadores[0] = jogadores[1];
        jogadores[1] = jogadorAux;

        if (jogadorAtual == 0) {
            jogadorAtual = 1;
        }
        else {
            jogadorAtual = 0;
        }

    }

    public String toString() {
        String str = "";

        return str;
    }
}
