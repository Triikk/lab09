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

    private File file = new File(System.getProperty("user.home")
                                        + File.separator
                                        + "output.txt");

    public void setFile(File file){
        this.file = file;
    }

    public File getFile(){
        return this.file;
    }

    public String getPath(){
        return this.file.getPath();
    }

    public void save(String string) throws IOException{
        try (final DataOutputStream outputStream = new DataOutputStream(
            new FileOutputStream(this.file))) {
                outputStream.writeUTF(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
