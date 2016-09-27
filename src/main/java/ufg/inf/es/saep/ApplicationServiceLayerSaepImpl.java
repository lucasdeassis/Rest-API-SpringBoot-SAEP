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
	public String getDocumentoHtml(Long idDocumento, String tipoDoDocumento) {
            if(tipoDoDocumento.equals("parecer")){
                return "Parecer numero " + idDocumento + "!";
            }
            else {
                return "Radoc numero " + idDocumento + "!";
            }
                
	}

	@Override
	public InputStream getDocumentoPdf(Long idParecer, String tipoDoDocumento) {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();            
	    
	    //TODO: definir o titulo do documento PDF
		Document document = new Document();
		try {

            PdfWriter.getInstance(document,
                out);

            document.open();
            if(tipoDoDocumento.equals("parecer")){
                document.add(new Paragraph("PDF de parecer."));
            }
            else {
                document.add(new Paragraph("PDF do radoc."));
            }
            document.close(); 
            
            return new ByteArrayInputStream(out.toByteArray());
            
        } catch (DocumentException e) {
            e.printStackTrace();
        }
		return null;
	}

}
