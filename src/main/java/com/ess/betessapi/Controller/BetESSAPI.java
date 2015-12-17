package com.ess.betessapi.Controller;


import com.ess.betessapi.models.Apostador;
import com.ess.betessapi.models.Bookie;
import com.ess.betessapi.models.Evento;
import com.ess.betessapi.view.ViewAposta;
import com.ess.betessapi.view.ViewApostador;
import com.ess.betessapi.view.ViewBetESS;
import com.ess.betessapi.view.ViewBookie;
import com.ess.betessapi.view.ViewEvento;
import java.time.Instant;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class BetESSAPI {

	private Vector<Evento> listaEventos;
	private Vector<Apostador> listaApostadores;
        private Vector<Bookie> listaBookies;
	private double betESStotal;
	private String name;

	

	public BetESSAPI() {
		this.betESStotal = 0;
		this.listaEventos = new Vector<Evento>();
		this.listaApostadores = new Vector<Apostador>();
                this.listaBookies = new Vector<Bookie>();
		this.name = "BetESSAPI";
		
	}

	public void registaAposta(Apostador apostador, Evento evento) {
            
            evento.registaAposta(apostador,(new ViewAposta()).viewCreateAposta());
	}

	// Interface sobre Eventos

	public boolean actualizaOdd(Evento evento, int odd_1, int odd_x, int odd_2){

		return evento.actualizaOdd(odd_1,odd_x,odd_2);
	}

	public boolean  fechaEvento(Bookie bookie, Evento evento, char resultado){
		return evento.fechaEvento(bookie,resultado);
	}

	public void viewEventos(){
                ArrayList<String> eventos = new ArrayList<> ();
		ListIterator<Evento> listIterator = this.listaEventos.listIterator();
		while (listIterator.hasNext()) {
			eventos.add(listIterator.next().toString());
		}
                for(String s: eventos) {
                    (new ViewEvento()).viewEvento(s);
                }
	}

	public Evento registaEvento(String equipa1, String equipa2) {

		Evento aposta = new Evento(equipa1,equipa2, Date.from(Instant.now()));
		this.listaEventos.add(aposta);
		return aposta;
	}

	public Evento registaEvento() {


		Evento newevento = new Evento();

		newevento.updateEvento((new ViewEvento()).viewUpdateEvento());
		this.listaEventos.add(newevento);
		return newevento;
	}
        public Evento registaEvento(String equipa1, String equipa2, Bookie bookie) {

		Evento aposta = new Evento(equipa1,equipa2, bookie, Date.from(Instant.now()));
		this.listaEventos.add(aposta);
		return aposta;
	}

	public Evento registaEvento(Bookie bookie) {


		Evento newevento = new Evento(bookie);

		newevento.updateEvento((new ViewEvento()).viewUpdateEvento());
		this.listaEventos.add(newevento);
		return newevento;
	}

	// Interface sobre Apostadores

	public void viewApostadores(){

		ListIterator<Apostador> lista = this.listaApostadores.listIterator();
		(new ViewBetESS()).viewApostadores(lista);
	}

	public Apostador registaApostador(String nome, String  email, double coins){

		Apostador newuser = new Apostador(nome, email, coins);
		listaApostadores.add(newuser);
		return newuser;
	}

	public Apostador registaApostador() {


		Apostador newuser = new Apostador();
                
		newuser.updateApostador((new ViewApostador()).viewUpdateApostador());
		this.listaApostadores.add(newuser);


		return newuser;
	}

	public Apostador actualizaApostador(Apostador apostador) {


		apostador.updateApostador((new ViewApostador()).viewUpdateApostador());


		return apostador;
	}

	public boolean deleteApostador(Apostador apostador){
		new ViewApostador().viewDeleteApostador(apostador.toString());
		return this.listaApostadores.remove(apostador);

	}

	// Interface sobre Bookies

        public Bookie registaBookie(String nome, String  email){

		Bookie newuser = new Bookie(nome, email);
		listaBookies.add(newuser);
		return newuser;
	}

	public Bookie registaBookie() {


		Bookie newuser = new Bookie();
                
		newuser.updateBookie((new ViewBookie()).viewUpdateBookie());
		this.listaBookies.add(newuser);


		return newuser;
	}

	public Bookie actualizaBookie(Bookie bookie) {


		bookie.updateBookie((new ViewBookie()).viewUpdateBookie());


		return bookie;
	}

	public boolean deleteBookie(Bookie bookie){
		new ViewApostador().viewDeleteApostador(bookie.toString());
		return this.listaApostadores.remove(bookie);

	}
	// TO-DO

	// Objects view
	@Override
	public String toString() {
		return "BetESSAPI{" +
				"name=" + name +
				", betESStotal=" + betESStotal +
				'}';
	}


}