/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ess.betessapi.view;

import com.ess.betessapi.models.Apostador;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ListIterator;


/**
 *
 * @author Nuno Oliveira
 */
public class ViewBetESS {
    
    
    public void viewApostadores(ListIterator lista){

    while(lista.hasNext()){
                System.out.println(lista.next());
        }
    }
   
}
