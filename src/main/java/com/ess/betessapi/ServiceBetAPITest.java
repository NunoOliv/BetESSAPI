package com.ess.betessapi;

import com.ess.betessapi.Controller.BetESSAPI;
import com.ess.betessapi.models.Evento;
import com.ess.betessapi.models.Apostador;
import com.ess.betessapi.models.Bookie;

public class ServiceBetAPITest {

    public static void main(String[] args) {

        // criar casa de apostas
        BetESSAPI casaApostas = new BetESSAPI();

        // Criar dois eventos na casa de apostas
        Evento evento1 = casaApostas.registaEvento();
        casaApostas.actualizaOdd(evento1, 1, 2, 3);
        Evento evento2 = casaApostas.registaEvento();
        casaApostas.actualizaOdd(evento2,1, 5, 3);


        Evento evento3 = casaApostas.registaEvento();
        evento3.actualizaOdd(1, 5, 3);

        // Registar dois apostadores
        Apostador apostador1 = casaApostas.registaApostador();
        casaApostas.actualizaApostador(apostador1);
        casaApostas.viewApostadores();
        casaApostas.deleteApostador(apostador1);
        casaApostas.viewApostadores();

        casaApostas.viewEventos();
        casaApostas.viewApostadores();

        // Registar apostas
        casaApostas.registaAposta(apostador1, evento1);
        casaApostas.registaAposta(apostador1, evento2);
        // regsitar bookies
        // TODO - implementar funcionalidades de bookie
         Bookie bookie1 = casaApostas.registaBookie();
         Evento evento4 = casaApostas.registaEvento(bookie1);
         casaApostas.fechaEvento(bookie1, evento4, '1');
         
         
        // fechar eventos
        casaApostas.fechaEvento(bookie1, evento1, 'x');
        casaApostas.fechaEvento(bookie1, evento2, 'x');

        




    }

}
