package n1.ex1;

import java.io.File;
import java.util.Arrays;

//Crea una classe que llisti alfabèticament el contingut d'un directori rebut per paràmetre.
public class main {
public static void main(String args[]) {
    File carpeta = new File("C:\\Users\\Belal\\Desktop\\");
    // File carpeta = new File(".");
    if (!carpeta.exists()) {
        System.out.println(carpeta + " NO existe.");
        return;
    }
    imprimeArbol(carpeta, "");
}
    public static void imprimeArbol(File carpeta, String tabulador) {
        File contenido[] = carpeta.listFiles();
        Arrays.sort(contenido);
        if (contenido != null) {
            for (int i = 0; i < contenido.length; i++) {
                if (contenido[i].isDirectory()) {
                    System.out.println(tabulador + "|-" + contenido[i].getName());
                    imprimeArbol(contenido[i], tabulador + "|  ");
                }
            }
        }
    }
}

