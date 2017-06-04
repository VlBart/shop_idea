/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

//import com.ibm.useful.http.FileData;
//import com.ibm.useful.http.PostData;

import com.sun.istack.logging.Logger;
import dao.entity.Model;
import dao.entity.Producer;
import dao.entity.Type;
import logic.DictionaryLogic;
import logic.ModelLogic;
import logic.ProducerLogic;
import manager.ConfigurationManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author Andrei
 */
public class ModelsCommand implements Command {


    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(ModelsCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, FileUploadException, ServletException {
        String page = null;
        String imageURL = null;
        String action = request.getParameter("action");
        String idModel = request.getParameter("idModel");
        String subcommand = request.getParameter("subcommand");
        String cmd = request.getParameter("cmd");
        if ("delete".equals(action)) {
            ModelLogic.deleteModel(idModel);
            List<Model> models = ModelLogic.getModels();
            request.getSession().setAttribute("models", models);
            return page = ConfigurationManager.getInstance()
                    .getProperty(ConfigurationManager.CHANGE_MODELS_PAGE_PATH);

        } else if ("change".equals(action)) {
            List<Producer> producers = ProducerLogic.getProducers();
            List<Type> types = DictionaryLogic.getType();
            request.setAttribute("types", types);
            request.setAttribute("producers", producers);
            Model model = ModelLogic.findModel(idModel);
            request.setAttribute("model", model);


            return page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.MODEL_FORM_PAGE_PATH);

        } else if ("add".equals(action)) {
            List<Producer> producers = ProducerLogic.getProducers();
            List<Type> types = DictionaryLogic.getType();
            request.setAttribute("types", types);
            request.setAttribute("producers", producers);
            return page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADD_MODEL_PAGE_PATH);
        }
        if ("submit".equals(subcommand)) {
            String idProducer = request.getParameter("idProducer");
            String idType = null;
            String modelName = request.getParameter("modelName");
            String amount = null;
            String price = null;
            String age = null;
            String fileName = null;
            InputStream filecontent = null;
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem item : items) {
                String fieldName = item.getFieldName();
                if (item.isFormField()) {
                    if (fieldName.equals("idProducer")) {
                        idProducer = item.getString("UTF-8");
                    }
                    if (fieldName.equals("idType")) {
                        idType = item.getString("UTF-8");
                    }
                    if (fieldName.equals("modelName")) {
                        modelName = item.getString("UTF-8");
                    }
                    if (fieldName.equals("amount")) {
                        amount = item.getString("UTF-8");
                    }
                    if (fieldName.equals("price")) {
                        price = item.getString("UTF-8");
                    }
                    if (fieldName.equals("age_for")) {
                        age = item.getString("UTF-8");
                    }


                } else {
                    fileName = FilenameUtils.getName(item.getName());
                    filecontent = item.getInputStream();
                }
            }
            // FileData tempFile=multidata.getFileData("file_send");
            if (filecontent != null) {
                FileOutputStream fos = null;
                try {
                    File f = new File("d:\\programs\\Github\\shop_idea\\src\\main\\webapp\\image\\" + fileName);
                    imageURL = ".\\image\\" + fileName;
                    fos = new FileOutputStream(f);
                    try {
                        fos.write(IOUtils.toByteArray(filecontent));
                    } catch (IOException ex) {
                        LOGGER.getLogger(ModelsCommand.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        fos.close();
                    } catch (IOException ex) {
                        LOGGER.getLogger(ModelsCommand.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    LOGGER.getLogger(ModelsCommand.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fos.close();
                    } catch (IOException ex) {
                        LOGGER.getLogger(ModelsCommand.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else imageURL = "";
            Model resultModel = new Model();
            if (idModel != null)
                resultModel.setId(Integer.parseInt(idModel));
            resultModel.setIdProducer(Integer.parseInt(idProducer));
            //resultModel.setIdRefreshRate(Integer.parseInt(idRefreshRate));
            resultModel.setIdType(Integer.parseInt(idType));
            resultModel.setAmount(Integer.parseInt(amount));
            resultModel.setPrice(Integer.parseInt(price));
            resultModel.setAge_for(Integer.parseInt(age));
            resultModel.setName(modelName);
            //                resultModel.setHdmiNumber(Integer.parseInt(hdmiNumber));
            //              resultModel.setWebTv(Short.parseShort(webTV));
            //            resultModel.setThreeD(Short.parseShort(threed));
            resultModel.setImageURL(imageURL);


            if ("update".equals(cmd))
                ModelLogic.updateModel(resultModel);
            else if ("insert".equals(cmd))
                ModelLogic.insertModel(resultModel);
            List<Model> models = ModelLogic.getModels();
            request.getSession().setAttribute("models", models);
            return page = ConfigurationManager.getInstance()
                    .getProperty(ConfigurationManager.CHANGE_MODELS_PAGE_PATH);


        } else if ("update".equals(subcommand)) {
            String idProducer = request.getParameter("idProducer") ;
            String amount = request.getParameter("amount") ;
            String price = request.getParameter("price") ;
            String age = request.getParameter("age_for") ;
            String modelName = request.getParameter("modelName") ;
            Model resultModel ;
            resultModel = ModelLogic.findModel(idModel);
            resultModel.setIdProducer(Integer.parseInt(idProducer));
            resultModel.setAmount(Integer.parseInt(amount));
            resultModel.setPrice(Integer.parseInt(price));
            resultModel.setAge_for(Integer.parseInt(age));
            resultModel.setName(modelName);
            if ("update".equals(cmd))
                ModelLogic.updateModel(resultModel);

            return page = ConfigurationManager.getInstance()
                    .getProperty(ConfigurationManager.CHANGE_MODELS_PAGE_PATH);
        }

            return page;

        }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("file_send")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
            if (content.trim().startsWith("number")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }




    }