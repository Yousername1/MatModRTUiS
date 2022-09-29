package src;

import java.util.*;
import java.io.*;

public class WriteToTheFile {
    public void toWrite(HashMap<Double, Double> database) {
        try{
            File file = new File("\"C:\\Users\\ram00\\Desktop\\datas.txt\"");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(database);
            oos.flush();
            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
