package dev.anderson.clientes.sistema.service;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ahigo
 */
public class SearchCEPFactory {

    public static CEPModel factory(String cep) {
        System.out.println(cep);
        try {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            InputStream input = url.openStream();
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();

            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }

            Gson gson = new Gson();
            return gson.fromJson(json.toString(), CEPModel.class);
        } catch (Exception e) {

        }
        return null;
    }

}
