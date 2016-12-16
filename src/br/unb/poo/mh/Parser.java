package br.unb.poo.mh;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


//Define o espaço como separador da string da entrada.
public class Parser {

    public List<String> parse(String s){
        List<String> separados = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(s, " ");

        while(st.hasMoreTokens()){
            separados.add(st.nextToken());
        }

        return separados;
    }
}
