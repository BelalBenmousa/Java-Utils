package n1.ex2;

import java.io.File;
import java.util.Date;

//Afegeix a la classe de l’exercici anterior, la funcionalitat de llistar un arbre de directoris amb el contingut de tots els seus nivells (recursivament) de manera que s'imprimeixin en pantalla en ordre alfabètic dins de cada nivell, indicant a més si és un directori (D) o un fitxer (F), i la seva última data de modificació.
public class main {
    public static void main(String args[]) {
        File carpeta = new File("C:\\Users\\Belal\\Desktop\\");
        if (!carpeta.exists()) {
            System.out.println(carpeta + " NO existe.");
            return;
        }
        imprimeArbol(carpeta, "");
    }

    public static void imprimeArbol(File carpeta, String tabulador) {
        File contenido[] = carpeta.listFiles();
        if (contenido != null) {
            for (int i = 0; i < contenido.length; i++) {
                long lastModified = contenido[i].lastModified();
                Date date = new Date(lastModified);
                if (contenido[i].isDirectory()) {
                    System.out.println(tabulador + "|-" + contenido[i].getName() + " D " + date);
                    imprimeArbol(contenido[i], tabulador + "|  ");
                } else if (contenido[i].isFile()) {
                    System.out.println(tabulador + "|-" + contenido[i].getName() + " F " + date);
                }
            }
        }
    }
}
