package com.aspectexample.aop.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Client implements IClient {

    private String nom;
    private Compte cp;

    public Client() {
        this.cp = new Compte();
    }

    public Client(Compte cp) {
        this.cp = cp;
    }



    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Compte getCp() {
        return cp;
    }
    public void setCp(Compte cp) {
        this.cp = cp;
    }
    public void retirer(double mt){

        cp.debiter(mt);

    }
    public void verser(double mt){
        cp.approvisionner(mt);
    }


}
