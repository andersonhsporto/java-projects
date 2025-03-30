/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.anderson.clientes.sistema.service;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author ahigo
 */
public class CEPModel {

    @SerializedName(value = "logradouro")
    String address;

    @SerializedName(value = "complemento")
    String addressComplent;

    @SerializedName(value = "localidade")
    String city;

    @SerializedName(value = "uf")
    String uf;
    
    @SerializedName(value = "bairro")    
    String neighborhood;

    public String getAddress() {
        return address;
    }

    public String getAddressComplent() {
        return addressComplent;
    }

    public String getCity() {
        return city;
    }

    public String getUf() {
        return uf;
    }

    public String getNeighborhood() {
        return neighborhood;
    }    
    
}
