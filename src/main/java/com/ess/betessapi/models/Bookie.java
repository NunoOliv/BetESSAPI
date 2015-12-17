/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ess.betessapi.models;

/**
 *
 * @author Nuno Oliveira
 */
public class Bookie implements Observer {
    private String email;
    private String name;

    public Bookie(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Bookie() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
	public String toString() {
		return "Apostador{" +
				"email='" + email + '\'' +
				
				", name='" + name + '\'' +
				'}';
	}
        
        @Override
	public void update(String notificacao) {


		System.out.println("\nBookie(" + this.name + "):" + notificacao + "\n");
	}
    public void createBookie(String readinput){
	
            this.updateBookie( readinput);
	}

        
        public void updateBookie(String readinput){
                
		
			String[] tokens = readinput.split(",");
			this.setName(tokens[0]);
			this.setEmail(tokens[1]);	
	}
}
