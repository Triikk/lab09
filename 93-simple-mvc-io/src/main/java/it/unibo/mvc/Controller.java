package it.unibo.mvc;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentFile;

    private static final File DEFAULT_FILE = new File(System.getProperty("user.home")
                                                + File.separator
                                                + "output.txt");

    public void setFile(File file){
        this.currentFile = file;
    }

    public File getFile(File file){
        return this.currentFile;
    }

    public String getPath(){
        return this.currentFile.getPath();
    }

    public void save(String string) throws IOException{
        try (final DataOutputStream outputStream = new DataOutputStream(
            new FileOutputStream(DEFAULT_FILE))) {
                outputStream.writeUTF(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
