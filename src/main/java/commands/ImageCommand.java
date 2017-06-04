/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.entity.Model;
import logic.ModelLogic;
import manager.ConfigurationManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author Vlad
 */
public class ImageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try
            {
              
                //проверка пришел ли запрос в multipart формате 
                String temptype=request.getContentType();
                if(temptype.indexOf("multipart/form-data")!=-1)
                {

                   //разбор формата multipart и помещение информации из запроса в поля объекта
                   //класса PostData
                     //PostData multidata=new PostData(request);

                   //извлечение посланной информации
                    // String fileDescription=multidata.getParameter("description ");
                    List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                    String fileName = null;
                    InputStream filecontent = null;
                    for (FileItem item : items) {
                        String fieldName = item.getFieldName();

                        if (!item.isFormField() & item.getFieldName().equals("file_send")) {
                            fileName = FilenameUtils.getName(item.getName());
                            filecontent = item.getInputStream();
                        }
                    }
                            //FileData tempFile=multidata.getFileData("file_send");

                      if(filecontent!=null){
                            File f = new File("d:\\programs\\Github\\shop_idea\\src\\main\\webapp\\image\\" + fileName);
                            String idModel = request.getParameter("idModel");
                            String imageURL = ".\\image\\" + fileName;
                            ModelLogic.updateImage(Integer.parseInt(idModel),imageURL);
                            List<Model> models = ModelLogic.getModels();
                            request.getSession().setAttribute("models", models);
                            FileOutputStream fos = new FileOutputStream(f);
                            fos.write(IOUtils.toByteArray(filecontent));
                            fos.close();
                            

                       }

             }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    return ConfigurationManager.getInstance().getProperty(ConfigurationManager.CHANGE_MODELS_PAGE_PATH);
    }

    
}
