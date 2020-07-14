
package com.emergentes.utiles;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fecha {
    public static Calendar calendar = Calendar.getInstance();
    private static String fechaCompras;
    public Fecha(){
    
    }
    public static String Fecha(){
         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
         fechaCompras=sdf.format(calendar.getTime());
         return fechaCompras;
    }
    
    public static String FechaBD(){
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         fechaCompras = sdf.format(calendar.getTime());
         return fechaCompras;
    }
    
}
