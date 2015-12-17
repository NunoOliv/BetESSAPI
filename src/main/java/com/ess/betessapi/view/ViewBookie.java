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
public class ViewBookie {
    
    private  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private  PrintStream out = System.out;
   

	public String viewUpdateBookie(){
               
                
		String readinput;
		this.out.print("Introduza novos dados de Bookie:(Name, Email) \n");
		try {
			readinput = this.in.readLine();
			return readinput;

		} catch (IOException e) {
			e.printStackTrace();
                        return "";
		}
	}

	public void viewDeleteBookie(String output){
		this.out.println("Remover Bookie"+this.viewBookie(output));

	}

	public String viewBookie(String view){

		this.out.println(view);
		return view;

	}
}
