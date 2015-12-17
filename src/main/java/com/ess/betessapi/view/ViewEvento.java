/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ess.betessapi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author Nuno Oliveira
 */
public class ViewEvento {
    
	// views Evento
        private  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        private  PrintStream out = System.out;
        
	public String viewUpdateEvento(){

		String readinput;
		this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
		try {
			readinput = this.in.readLine();
			return readinput;

		} catch (IOException e) {
			e.printStackTrace();
                        return "";
		}
	}

	
        
        public void viewEvento(String evento) {
            this.out.println(evento);
        }
        

}
