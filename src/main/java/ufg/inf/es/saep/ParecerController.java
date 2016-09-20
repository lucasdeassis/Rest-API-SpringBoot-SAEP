	package saep;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParecerController {
	private static final long STATUS_OK = 200;
    private static final String template = "Parecer %s!";
    //private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/parecer/saep/{id}", method=RequestMethod.GET)
    public Parecer parecer(@PathVariable Long id) {
        return new Parecer(STATUS_OK,
                            String.format(template, id));
    }
}