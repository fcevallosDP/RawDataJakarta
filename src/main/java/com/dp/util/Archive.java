/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TimerTask;

public class Archive extends TimerTask {

@Override 
public void run() {   //Sobreescribimos el método run
 try {         
    String linea;
    //Colocamos la ruta del archivo .bat que ejecutaremos
    Process p = Runtime.getRuntime().exec("C:\\oracle\\execute.bat");
    //Definimos un BufferedReader para leer la impresión que realice la ejecución de nuestro script
    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));         
    while ((linea = input.readLine()) != null) {  
    //Mientras que nuestro input imprima data, imprimeremos la salida por consola        
       System.out.println(linea);         
    }         
      input.close(); //Cerramos el input
    } catch (Exception err) {         
      err.printStackTrace();     
    } 
  }

}