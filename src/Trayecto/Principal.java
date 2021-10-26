/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trayecto;
import java.util.*;
import java.io.*;
/**
 *
 * @author NB-3170
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int regis=Particulas.cantReg();
        String ID[]= new String[regis];
        double coorPolares[][]=new double [regis][2];
        double coorCarte[][]= new double [regis][2];
        String IDdist[]= new String [4];
        double distancia[]= new double[4];
        Particulas.leoArchivo(ID, coorPolares);
        Particulas.coorCartesianas(coorPolares, coorCarte);
        Particulas.mostrar(ID, coorPolares, coorCarte);
        Particulas.calculos(IDdist, distancia, coorCarte, ID);
        Particulas.mostrarCalculos(IDdist, distancia);
        
    }
    
}
