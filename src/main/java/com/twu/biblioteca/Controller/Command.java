package com.twu.biblioteca.Controller;

import java.io.IOException;

/**
 * Created by songyang on 9/27/14.
 */
public interface Command {
    public void execute() throws IOException;
    public String description();
}
