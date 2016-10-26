package ufg.inf.es.saep;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
    @RequestMapping(value="/saep/status", method=RequestMethod.GET)
    @ResponseBody
    public String obterStatusSaep(HttpServletResponse response) {
    	response.setStatus(200);
    	return "OK";
    }
}
