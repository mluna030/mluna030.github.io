/*
    1. This code handles a POST request and gets the value of the parameter named 
        - "text-input"
    2. The code then prints the value to both the server logs and as the response

    **Note servlet has not been triggered yet**
*/
package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class ContactEmailHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String getEmail = request.getParameter("email-input");
    
    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: " + getEmail);

    // Write the value to the response so the user can see it.
    response.getWriter().println("You submitted: " + getEmail);

    
    
    // Redirects user back to home page
    //response.sendRedirect("https://mluna-sps-summer22.uc.r.appspot.com/");
  }
}
