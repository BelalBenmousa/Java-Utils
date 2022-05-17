package n1.ex3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Modifica l’exercici anterior. Ara, en lloc de mostrar el resultat per la pantalla, guarda el resultat en un fitxer TXT.
public class main {
    public static void main(String args[]) throws IOException {
        File carpeta = new File("C:\\Users\\Belal\\Desktop\\");
        if (!carpeta.exists()) {
            System.out.println(carpeta + " NO existe.");
            return;
        }
        imprimeArbol(carpeta, "");
    }

    public static void imprimeArbol(File carpeta, String tabulador) throws IOException {
        File contenido[] = carpeta.listFiles();
        FileWriter fw = new FileWriter("C:\\Users\\Belal\\Desktop\\files.txt");
        List<String> arrayList = new ArrayList<>();
        if (contenido != null) {
            for (int i = 0; i < contenido.length; i++) {
                long lastModified = contenido[i].lastModified();
                Date date = new Date(lastModified);
                if (contenido[i].isDirectory()) {
                    //System.out.println(tabulador + "|-" + contenido[i].getName() + " D " + date);
                    arrayList.add(tabulador + "|-" + contenido[i].getName() + " D " + date);
                    imprimeArbol(contenido[i], tabulador + "|  ");

                   // fw.write(contenido[i].getName() + " D " + date);
                } else if (contenido[i].isFile()) {
                    arrayList.add(tabulador + "|-" + contenido[i].getName() + " F " + date);
                    //System.out.println(tabulador + "|-" + contenido[i].getName() + " F " + date);
                }
            }
        }
        arrayList.stream().forEach(System.out::println);
        for(String str: arrayList) {
            fw.write(str + System.lineSeparator());
        }
        fw.close();
    }
}