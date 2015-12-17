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
public class ViewApostador {
    private  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private  PrintStream out = System.out;
   

	public String viewUpdateApostador(){
               
                
		String readinput;
		this.out.print("Introduza novos dados de Apostador:(Name, Email, BetESSCoins) \n");
		try {
			readinput = this.in.readLine();
			return readinput;

		} catch (IOException e) {
			e.printStackTrace();
                        return "";
		}
	}

	public void viewDeleteApostador(String output){
		this.out.println("Remover Apostador"+this.viewApostador(output));

	}

	public String viewApostador(String view){

		this.out.println(view);
		return view;

	}
}
