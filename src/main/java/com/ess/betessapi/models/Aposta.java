package com.ess.betessapi.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Aposta {

	private Apostador apostador;
	private float m_aposta;
	private Evento.Resultado resultado;
	private Odd odd_fixada;
	


	public Aposta(){
		this.apostador = null;
		this.m_aposta = 0;
		this.resultado = null;
		this.odd_fixada = null;
		
	}

	public Aposta(Apostador apostador, float m_aposta, char resultado, Odd odd_actual) {
		this.apostador = apostador;
		this.m_aposta = m_aposta;
		switch (resultado) {
			case '1':
				this.resultado = Evento.Resultado.VITORIA;
				break;
			case 'x':
				this.resultado = Evento.Resultado.EMPATE;
				break;
			case '2':
				this.resultado = Evento.Resultado.DERROTA;
				break;
		}
		this.odd_fixada = odd_actual.clone();
		
	}

	// getter and setters

	public Apostador getApostador() {
		return apostador;
	}

	public Evento.Resultado getResultado() {
		return resultado;
	}

	public float getM_aposta() {
		return m_aposta;
	}

	public Odd getOdd_fixada() {
		return odd_fixada;
	}

	public void setOdd_fixada(Odd odd_fixada) {
		this.odd_fixada = odd_fixada.clone();
	}

	public void setM_aposta(float m_aposta) {
		this.m_aposta = m_aposta;
	}

	public void setApostador(Apostador apostador) {
		this.apostador = apostador;
	}

	public void setResultado(Evento.Resultado resultado) {
		this.resultado = resultado;
	}


//	Views para Apostador
        public void createAposta(String readinput){
		
			String[] tokens = readinput.split(",");


			switch (tokens[1]) {
				case "1":
					this.setResultado(Evento.Resultado.VITORIA);
					break;
				case "x":
					this.setResultado(Evento.Resultado.EMPATE);
					break;
				case "2":
					this.setResultado(Evento.Resultado.DERROTA);
					break;
			}

			this.setM_aposta(Float.parseFloat(tokens[0]));

		

	}
	
}