/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidenciaaprendizaje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author emmas
 */
public class EvidenciaAprendizaje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        try {
            BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
            
            // TODO code application logic here

            int[]vector ={3,4,5,6,7,8,9,12,13,14,15,16,18,19,24,27,35,38,49};
            System.out.println("ingresa el valor a buscar:");
            int valorBuscado = Integer.parseInt(reader.readLine());
         

            if (busquedaBinaria(vector,valorBuscado) != -1){
                System.out.println("valor existe, en el lugar" );
            }else{
            System.out.println("valor no exite");
            vector=agregarElemento(vector, valorBuscado);
            System.out.println("se agrega valor al arreglo");
            quickSort(vector, 0, vector.length-1);
            System.out.println("vector ordenando:" + Arrays.toString(vector));
            }
            System.out.println();
        } catch (IOException ex) {
            Logger.getLogger(EvidenciaAprendizaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
static int[] agregarElemento(int[] a, int e) {
    a  = Arrays.copyOf(a, a.length + 1);
    a[a.length - 1] = e;
    return a;
}

public static int busquedaBinaria(int  vector[], int dato){
  int n = vector.length;
  int centro,inf=0,sup=n-1;
   while(inf<=sup){
     centro=(sup+inf)/2;
     if(vector[centro]==dato) return centro;
     else if(dato < vector [centro] ){
        sup=centro-1;
     }
     else {
       inf=centro+1;
     }
   }
   return -1;
 } 
 
public static int particion(int[] arr, int vinicio, int vfinal){
        int pivote = arr[vfinal];
 
        for(int i=vinicio; i<vfinal; i++){
            if(arr[i]<pivote){
                int temp= arr[vinicio];
                arr[vinicio]=arr[i];
                arr[i]=temp;
                vinicio++;
            }
        }
 
        int temp = arr[vinicio];
        arr[vinicio] = pivote;
        arr[vfinal] = temp;
 
        return vinicio;
}

public static void quickSort(int[] arr, int inicio, int vfinal){
		 
        int particion = particion(arr, inicio, vfinal);
 
        if(particion-1>inicio) {
            quickSort(arr, inicio, particion - 1);
        }
        if(particion+1<vfinal) {
            quickSort(arr, particion + 1, vfinal);
        }
}
    //fin
    
    
}
