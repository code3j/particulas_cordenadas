/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trayecto;

import java.io.*;
import java.util.*;

/**
 *
 * @author NB-3170
 */
public class Particulas {

    public static int cantReg() throws IOException {
        Scanner leo = new Scanner(new File("Coordenadas.txt"));
        int cantRegis = 0;
        while (leo.hasNextLine()) {
            leo.nextLine();
            cantRegis++;

        }
        leo.close();
        return cantRegis;
    }

    public static void leoArchivo(String ID[], double coorPolares[][]) throws IOException {
        Scanner leo = new Scanner(new File("Coordenadas.txt"));
        int i = 0;
        while (leo.hasNext()) {
            ID[i] = leo.next();
            System.out.println(" ");
            for (int j = 0; j < coorPolares[0].length; j++) {
                coorPolares[i][j] = leo.nextDouble();

            }
            i++;
        }
        leo.close();

    }

    public static void coorCartesianas(double coorPolares[][], double coorCarte[][]) {

        for (int i = 0; i < coorPolares.length; i++) {
            double x = 0;
            double y = 0;
            double r = 0;
            double angulo = 0;
            double anguloRadi = 0;
            for (int j = 0; j < coorCarte[0].length; j++) {
                if (j == 0) {
                    r = coorPolares[i][j];
                }
                if (j == 1) {

                    angulo = coorPolares[i][j];

                    anguloRadi = (Math.PI * angulo) / 180;

                    x = r * Math.cos(anguloRadi);

                    y = r * Math.sin(anguloRadi);

                    for (int l = 0; l < coorCarte[0].length; l++) {
                        coorCarte[i][0] = x;
                        coorCarte[i][1] = y;
                    }

                }
            }
        }
    }

    public static void mostrar(String ID[], double coorPolares[][], double coorCarte[][]) {
        System.out.println("       Polares     Cartesianas");
        System.out.println("Punto   r    angulo     x      y");
        for (int i = 0; i < ID.length; i++) {

            System.out.printf("%-3s ", ID[i]);
            for (int j = 0; j < coorPolares[0].length; j++) {
                System.out.printf("%7.2f", coorPolares[i][j]);
            }
            for (int k = 0; k < coorCarte[0].length; k++) {
                System.out.printf("%7.2f", coorCarte[i][k]);
            }
            System.out.println("");
        }

    }

    public static void calculos(String IDdist[], double distancia[], double coorCarte[][], String ID[]) {
        String idjunto = "", temp = "", anterior = "";

        double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        double dif1 = 0;
        double dif2 = 0;
        for (int i = 0; i < 2; i++) {

            anterior = ID[i];
            idjunto = temp + anterior;
            temp = idjunto;
            if (i==1) {
                IDdist[0] = idjunto;
                
            }
        }
        idjunto="";
        temp=""; anterior="";
        for (int i = 1; i < 3; i++) {
            anterior = ID[i];
            idjunto = temp + anterior;
            temp = idjunto;
            if (i==2) {
                IDdist[1] = idjunto;
                
            }
        }
        idjunto="";
        temp=""; anterior="";
        for (int i = 2; i < 4; i++) {
            anterior = ID[i];
            idjunto = temp + anterior;
            temp = idjunto;
            if (i==3) {
                IDdist[2] = idjunto;
                
            }
        }
        idjunto="";
        temp=""; anterior="";
        for (int i = 3; i < 5; i++) {
            anterior = ID[i];
            idjunto = temp + anterior;
            temp = idjunto;
            if (i==4) {
                IDdist[3] = idjunto;
              
            }
        }
        
        
        //calculo de distancia p1p2
        for (int j = 0; j< 1; j++) {

            for (int k = 0; k <1; k++) {
                x1 = coorCarte[0][0];
                y1 = coorCarte[0][1];
                x2 = coorCarte[1][0];
                y2 = coorCarte[1][1];
                if (k <1) {
                    dif1= x2-x1;
                    dif2=y2-y1;
                    distancia[0]=Math.sqrt(Math.pow(dif1,2)+Math.pow(dif2,2));
                }

            }

        }
        for (int i = 1; i <2; i++) {
            for (int k = 1; k <2; k++) {
                x1 = coorCarte[1][0];
                y1 = coorCarte[1][1];
                x2 = coorCarte[2][0];
                y2 = coorCarte[2][1];
                if (k <2) {
                    dif1= x2-x1;
                    dif2=y2-y1;
                    distancia[1]=Math.sqrt(Math.pow(dif1,2)+Math.pow(dif2,2));
                }

            }

        }
        for (int i = 2; i <3; i++) {
            for (int k = 2; k <3; k++) {
                x1 = coorCarte[2][0];
                y1 = coorCarte[2][1];
                x2 = coorCarte[3][0];
                y2 = coorCarte[3][1];
                if (k <3) {
                    dif1= x2-x1;
                    dif2=y2-y1;
                    distancia[2]=Math.sqrt(Math.pow(dif1,2)+Math.pow(dif2,2));
                }

            }

        }
        for (int i = 2; i <3; i++) {
            for (int k = 2; k <3; k++) {
                x1 = coorCarte[3][0];
                y1 = coorCarte[3][1];
                x2 = coorCarte[4][0];
                y2 = coorCarte[4][1];
                if (k <3) {
                    dif1= x2-x1;
                    dif2=y2-y1;
                    distancia[3]=Math.sqrt(Math.pow(dif1,2)+Math.pow(dif2,2));
                }

            }

        }
        //mayor distancia 
        
        
    }
    public static void mostrarCalculos(String IDdist[], double distancia[]){
        //recorrido mayor 
        
      
        int  indice=0;
        double mayor =distancia[0];
        
        for (int i = 1; i < distancia.length; i++) {
             if(distancia[i]>mayor){
                 mayor=distancia[i];
                 indice=i;
             }
        }
        //recorrido total
       double suma=0; double temp=0;
        for (int i = 0; i <distancia.length; i++) {
            suma= distancia[i];
            suma+=temp;
            temp=suma;
        }
      
        
        
        System.out.println("");
        System.out.println("Punto   Distancia(mts)");
        for (int i = 0; i < distancia.length; i++) {
           
            System.out.printf("%-10s ",IDdist[i]);
            System.out.printf("%5.2f",distancia[i]);
             System.out.println(" ");
        }
        System.out.printf("La particula Q realizo un recorrido total de: %3.2f metros ",suma);
        System.out.println("\nEl mayor tramo recorrido por Q en todo el trayecto fue: "+IDdist[indice]);
    }

}
