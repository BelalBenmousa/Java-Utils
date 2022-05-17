package n1.ex4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Deserialitzar  {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\Belal\\Desktop\\fichero.txt");
            ObjectOutputStream sos = new ObjectOutputStream(fos);
            sos.writeObject("Hola");
            sos.close();

            FileInputStream fis = new FileInputStream("C:\\Users\\Belal\\Desktop\\fichero.txt");
            ObjectInputStream sis = new ObjectInputStream(fis);
            System.out.println((String)sis.readObject());
            sis.close();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
