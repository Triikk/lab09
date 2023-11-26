package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String string = null;
    private List<String> history = new ArrayList<>();

    @Override
    public void setString(String string) {
        if(string.equals(null)){
            throw new NullPointerException("The string provided was null");
        }
        this.string = string;
    }

    @Override
    public String getString() {
        return this.string;
    }

    @Override
    public List<String> getPrintedStrings() {
        return this.history;
    }

    @Override
    public void print() {
        if(this.string.equals(null)){
            throw new IllegalStateException("The current string is unset");
        }
        System.out.println(this.string);
        history.add(this.string);
    }

}
