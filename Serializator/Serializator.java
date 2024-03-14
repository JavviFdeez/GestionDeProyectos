package Serializator;

import java.io.*;


public class Serializator {

    public static<T> boolean serializeObject(T obj,String filename){
        boolean result=false;
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename)
        )){
            oos.writeObject(obj);
            result=true;
        }catch(IOException e){
        }
        return result;
    }

    public static<T> T deserializeObject(String filename){
        T result=null;
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename)
        )){
            result=(T)ois.readObject();
        }catch(IOException | ClassNotFoundException e){
        }
        return result;
    }
}


