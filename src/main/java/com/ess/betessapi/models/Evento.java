package com.ess.betessapi.models;

import com.ess.betessapi.models.Aposta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.Instant;

public class Evento implements Subject {

	public enum Resultado {
		VITORIA,
		DERROTA,
		EMPATE
	}

	private static AtomicInteger uniqueId=new AtomicInteger();

	private String equipa1;
	private String equipa2;
	private Resultado resultado_final;
	private Date dataEvento;
	private int id;
	private Vector<Aposta> listaApostas;
	private boolean isOpen;
	private Odd odds;
        private Bookie creator;
        private Bookie closer;

	public Evento(String equipa1, String equipa2, Date data) {
		this.equipa1 = equipa1;
		this.equipa2 = equipa2;
		this.isOpen = false;
		this.resultado_final = null;
		this.dataEvento = data;
		this.id=uniqueId.getAndIncrement();
		this.odds = new Odd();
		this.listaApostas = new Vector<Aposta>();
                this.creator = null;
                this.closer = null;
                
	}
        public Evento(String equipa1, String equipa2,Bookie bookie, Date data) {
		this.equipa1 = equipa1;
		this.equipa2 = equipa2;
		this.isOpen = false;
		this.resultado_final = null;
		this.dataEvento = data;
		this.id=uniqueId.getAndIncrement();
		this.odds = new Odd();
		this.listaApostas = new Vector<Aposta>();
                this.creator = bookie;
                this.closer = null;
	}

	public Evento() {
		this.equipa1 = null;
		this.equipa2 = null;
		this.isOpen = false;
		this.resultado_final = null;
		this.dataEvento = null;
		this.id=uniqueId.getAndIncrement();
		this.odds = new Odd();
		this.listaApostas = new Vector<Aposta>();

		this.closer = null;
                this.creator = null;
	}
        public Evento(Bookie bookie) {
		this.equipa1 = null;
		this.equipa2 = null;
		this.isOpen = false;
		this.resultado_final = null;
		this.dataEvento = null;
		this.id=uniqueId.getAndIncrement();
		this.odds = new Odd();
		this.listaApostas = new Vector<Aposta>();
                this.creator = bookie; 
                this.closer = null;
	}

	public void setEquipa1(String equipa1) {
		this.equipa1 = equipa1;
	}

	public String getEquipa2() {
		return this.equipa2;
	}

	public void setEquipa2(String equipa2) {
		this.equipa2 = equipa2;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public boolean fechaEvento(Bookie bookie, char resultadofinal){

			switch (resultadofinal) {
				case '1':
					this.resultado_final = Resultado.VITORIA;
					break;
				case 'x':
					this.resultado_final = Resultado.EMPATE;
					break;
				case '2':
					this.resultado_final = Resultado.DERROTA;
					break;
			}
		this.isOpen = false;
                this.closer = bookie;
		this.notifyApostadores();
		return true;
	}

	public void registaAposta(Apostador apostador, String apostaT) {

		Aposta aposta = new Aposta();
		aposta.createAposta(apostaT);
		aposta.setApostador(apostador);
		aposta.setOdd_fixada(this.odds);

		this.listaApostas.add(aposta);

	}

	public boolean actualizaOdd(int odd1, int oddx, int odd2 ){
		this.odds.setOddx(oddx);
		this.odds.setOdd1(odd1);
		this.odds.setOdd2(odd2);
		return true;
	}

	public void setEstado() {
		// TODO - implement Aposta.setEstado

	}
        
        public int calculateAward(Aposta aposta) {
            int premio = 0;
            switch (aposta.getResultado()) {
                case VITORIA:
                        premio = (int) (aposta.getM_aposta() * aposta.getOdd_fixada().getOdd1());
                        break;
                case EMPATE:
                        premio = (int) (aposta.getM_aposta() * aposta.getOdd_fixada().getOddx());
                        ;
                        break;
                case DERROTA:
                        premio = (int) (aposta.getM_aposta() * aposta.getOdd_fixada().getOdd2());
                        ;
                        break;
            }   
            return premio;
        }

	public void notifyApostadores() {
            int premio =0;
            if (!this.isOpen){
                Enumeration<Aposta> lista_apostas = this.listaApostas.elements();
                while (lista_apostas.hasMoreElements()) {
                        Aposta aposta = lista_apostas.nextElement();

                        if (this.resultado_final == aposta.getResultado()) premio = calculateAward(aposta);

                        aposta.getApostador().update(premio+"");
                }
            }
	}

	public void setOdds(float odd_1, float odd_x, float odd_2) {
		this.odds = new Odd(odd_1,odd_x,odd_2);
	}

	public void updateOdds(float odd_1, float odd_x, float odd_2){
	    this.odds.setOdd1(odd_1);
		this.odds.setOdd2(odd_2);
		this.odds.setOddx(odd_x);
	}

    @Override
    public String toString() {
        return "Evento{" +
            "equipa1='" + equipa1 + '\'' +
            ", equipa2='" + equipa2 + '\'' +
            ", resultado_final=" + resultado_final +
            ", estado=" + isOpen +
            ", data da aposta" + dataEvento.toString() +
            ", ultima odd" + this.odds.toString() +
            '}';    
    }
    
    public void updateEvento(String readinput){

		
        String[] tokens = readinput.split(",");
        this.setEquipa2(tokens[1]);
        this.setEquipa1(tokens[0]);
        this.setDataEvento(Date.from(Instant.now()));

		
	}
    

}