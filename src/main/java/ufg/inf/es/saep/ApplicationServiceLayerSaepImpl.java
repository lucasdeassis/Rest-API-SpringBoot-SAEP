package ufg.inf.es.saep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ApplicationServiceLayerSaepImpl implements ApplicationServiceLayerSaep {

	//TODO: colocar o conteudo do parecer em um PDF formatado ou apenas em string pura?
	@Override
	public String getParecerHtml(Long idParecer) {
		return "Parecer numero" + idParecer + "!";
	}

	@Override
	public InputStream getParecerPdf(Long idParecer) {
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

}
