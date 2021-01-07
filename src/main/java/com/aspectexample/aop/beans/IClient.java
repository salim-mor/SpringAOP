package com.aspectexample.aop.beans;


public interface IClient {
    public void verser(double mt);
    public void retirer(double mt);

    public String getNom();
    public void setNom(String nom);
    public Compte getCp() ;
    public void setCp(Compte cp) ;
}
