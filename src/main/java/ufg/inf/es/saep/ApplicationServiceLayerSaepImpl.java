package ufg.inf.es.saep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ApplicationServiceLayerSaepImpl implements ApplicationServiceLayerSaep {

	@Override
	public String getParecerHtml(Long idParecer) {
		return "Parecer numero" + idParecer + "!";
	}

	@Override
	public InputStream getParecerPdf(Long idParecer) {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();            

		Document document = new Document();
		try {

            PdfWriter.getInstance(document,
                out);

            document.open();
            document.add(new Paragraph("PDF de parecer."));
            document.close(); // no need to close PDFwriter?

            //TODO: return InputStream from document
            return new ByteArrayInputStream(out.toByteArray());
            
        } catch (DocumentException e) {
            e.printStackTrace();
        }
		return null;
	}

}
