package me.kyllian.netflixstatistix.user;

import java.io.*;

public class WatchingProfile implements Serializable {

    public String badTest = "nothing";

    //test
    // TODO: Consider adding watching data
    // idk what to do here actually


    public static WatchingProfile fromString(String serialized) {
        try {
            byte b[] = serialized.getBytes();
            ByteArrayInputStream bi = new ByteArrayInputStream(b);
            ObjectInputStream si = new ObjectInputStream(bi);
            return (WatchingProfile) si.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String toString() {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream so = new ObjectOutputStream(bo);
            so.writeObject(this);
            so.flush();
            return bo.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
