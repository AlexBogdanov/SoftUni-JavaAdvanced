package p01JarOfT;

import p01JarOfT.Jar.Jar;
import p01JarOfT.Pickle.Pickle;

public class Main {

    public static void main(String[] args) {
        
        Jar<Pickle> jar = new Jar<>();

        jar.add(new Pickle());
        jar.add(new Pickle());

        Pickle pickle = jar.remove();

    }

}
