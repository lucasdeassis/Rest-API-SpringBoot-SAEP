package ufg.inf.es.saep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

@Service
@Component
public abstract class ParecerServiceSaepImpl implements ApplicationServiceLayerSaep {

	@Override
	public InputStream parecerAsHtml(Long idParecer) {
				String html = "Parecer numero " + idParecer + "!";
                InputStream is = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
                return is;
                
	}

	@Override
	public InputStream parecerAsPdf(Long idParecer) {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();            
	    
	    //TODO: definir o titulo do documento PDF
		Document document = new Document();
		try {

            PdfWriter.getInstance(document,
                out);

            document.open();
            document.add(new Paragraph("PDF de parecer."));
    
            document.close(); 
            
            return new ByteArrayInputStream(out.toByteArray());
            
        } catch (DocumentException e) {
            e.printStackTrace();
        }
		return null;
	}
        
        
        @Override
       public boolean criarParecer(Long idParecer, InputStream parecer){
           //Caso o parecer com o id fornecido ja exista, retorna ERRO
           if(idParecer == 13){
               return false;
           }
           else //Aqui supoe-se que seja criado o parecer no servidor e retorna OK
               return true;
       }

}
