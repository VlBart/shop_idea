/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 *
 * @author Andrei
 */
public interface Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, FileUploadException, ServletException;
    
}
