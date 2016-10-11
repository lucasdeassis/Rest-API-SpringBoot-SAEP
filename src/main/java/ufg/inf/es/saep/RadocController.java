/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufg.inf.es.saep;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RadocController {

    @Autowired
    private ApplicationServiceLayerSaepRadoc asls;

    @RequestMapping(value="/radoc/saep/{id}", method=RequestMethod.GET, headers="Accept=text/html")
    public void obterRadocAsHtml(@PathVariable Long id, HttpServletResponse response) {
        	InputStream htmlStream = asls.radocAsHtml(id);
        	response.setContentType("text/html");
        	Utils.flushBuffer(htmlStream, response);
    }
    
    
    @RequestMapping(value="/radoc/saep/{id}", method=RequestMethod.GET, headers="Accept=application/pdf")
    public void obterRadocAsPdf(@PathVariable Long id, HttpServletResponse response) {
      
    	InputStream pdfStream = asls.radocAsPdf(id);
    	response.setContentType("application/pdf");
    	response.setHeader("Content-Disposition", "inline; filename=\"radoc"+id+".pdf\"");
    	Utils.flushBuffer(pdfStream, response);
    }
}


