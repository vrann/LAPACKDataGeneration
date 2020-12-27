package com.vrann;

public class JMatgen {

    private static boolean initialized = false;

    private JMatgen()
    {
    }

    // Initialize the native library.
    static
    {
        initialize();
    }

    /**
     * Initializes the native library. Note that this method
     * does not have to be called explicitly, since it will
     * be called automatically when this class is loaded.
     */
    public static void initialize()
    {

        if(!initialized) {
            String jnilib = com.github.fommil.jni.JniNamer.getJniName("jcublas2");
            String natives = System.getProperty("jcublas2", jnilib);
            com.github.fommil.jni.JniLoader.load(natives.split(","));
            initialized = true;
        }
    }

}
