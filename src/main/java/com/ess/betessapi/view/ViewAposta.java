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
public  class ViewAposta {
    private  BufferedReader in;
    private PrintStream out;
    
    public String viewCreateAposta(){
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = System.out;

        String readinput;
        this.out.println("Introduza o resultado e o montante a apostar: montante, resultado\n");
        try {
                readinput = this.in.readLine();


        } catch (IOException e) {
                e.printStackTrace();
                return "";
        }
        return readinput;
	}
}
