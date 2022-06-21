package com.google.sps.servlets;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list-images")
public class listImages extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //list all of the uploaded files

        String projectId = "mluna-sps-summer22";
        String bucketName = "mluna-sps-summer22.uc.r.appspot.com";

        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
        Bucket bucket = storage.get(bucketName);
        Page<Blob> blobs = bucket.list();

        // output <image> elements as html
        response.setContentType("text/html;");
        for (Blob blob : blobs.iterateAll()){
            String imgtag = String.format("<img src=\"%s\"/>", blob.getMediaLink());
            response.getWriter().println(imgtag);
            response.getWriter().println("<br>");
        }

    }
}
