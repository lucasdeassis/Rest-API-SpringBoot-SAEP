package ufg.inf.es.saep;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class ApplicationServiceLayerSaepImpl implements ApplicationServiceLayerSaep {

	private int observacoesLength;
	private int parecerLength;
	private int radocLength;
	
    @Override
    public InputStream parecerAsHtml(Long idParecer) {
        String html = "Parecer numero " + idParecer + "!";        
        parecerLength = html.getBytes(StandardCharsets.UTF_8).length;
        
        InputStream is = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
        return is;

    }

    @Override
    public InputStream parecerAsPdf(Long idParecer) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // TODO: definir o titulo do documento PDF
        Document document = new Document();
        try {

            PdfWriter.getInstance(document, out);

            document.open();
            document.add(new Paragraph("PDF de parecer."));

            document.close();

            parecerLength = out.toByteArray().length;
            
            return new ByteArrayInputStream(out.toByteArray());

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean criarParecer(Long idParecer, InputStream parecer) {
        // Caso o parecer com o id fornecido ja exista, retorna ERRO
        if (idParecer == 13) {
        	parecerLength = 0;
            return false;
        } else // Aqui supoe-se que seja criado o parecer no servidor e retorna
        // OK
        {
            return true;
        }
    }

    @Override
    public InputStream radocAsHtml(Long idRadoc) {
        String html = "Radoc numero " + idRadoc + "!";
        radocLength = html.getBytes(StandardCharsets.UTF_8).length;
        InputStream is = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
        return is;

    }

    @Override
    public InputStream radocAsPdf(Long idRadoc) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // TODO: definir o titulo do documento PDF
        Document document = new Document();
        try {

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph("PDF do radoc."));

            document.close();
            radocLength = out.toByteArray().length;
            
            return new ByteArrayInputStream(out.toByteArray());

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    // TODO: finalizar metodo
    @Override
    public boolean criarRadoc(Long idRadoc, InputStream parecer) {
        // Caso o radoc com o id fornecido ja exista, retorna ERRO
        if (idRadoc == 13) {
        	radocLength = 0;
            return false;
        } else // Aqui supoe-se que seja criado o radoc no servidor e retorna OK
        {
            return true;
        }
    }

    @Override
    public boolean deletarParecer(Long idDocumento) {
        // Caso o parecer com o id fornecido não exista, retorna ERRO
        if (idDocumento == 15) {
        	parecerLength = 0;
            return false;
        } else // Aqui supoe-se que seja deletado o parecer no servidor e retorna OK
        {
            return true;
        }
    }

    @Override
    public boolean deletarRadoc(Long idDocumento) {
        // Caso o radoc com o id fornecido não exista, retorna ERRO
        if (idDocumento == 15) {
        	radocLength = 0;
            return false;
        } else // Aqui supoe-se que seja deletado o radoc no servidor e retorna OK
        {
            return true;
        }
    }

	@Override
	public int obterTamanhoParecer(Long idParecer) {
		return parecerLength;
	}

	@Override
	public int obterTamanhoRadoc(Long idRadoc) {
		 return radocLength;
	}

	@Override
	public InputStream observacoesAsJson(Long idDocumento) {
		JSONObject observacoesJSON  = new JSONObject();
		
		ArrayList<String> observacoesLista = new ArrayList<String>();
		
		observacoesLista.add("Data de parecer inadequada.");
		observacoesLista.add("Período de férias descrito não confere com o documentado.");
		observacoesLista.add("Cronograma de horas cumpridas não confere com o plano de atividades.");
		observacoesLista.add("Faltas excessivas para licença.");
		
		observacoesJSON.put("Observações Parecer" + idDocumento, observacoesLista);
		
		String stringJSON = observacoesJSON.toString();
		observacoesLength = stringJSON.getBytes().length;
		
		return new ByteArrayInputStream(stringJSON.getBytes());
	}

	@Override
	public int obterTamanhoObservacoes(Long idParecer) {
		return observacoesLength;
	}

}
