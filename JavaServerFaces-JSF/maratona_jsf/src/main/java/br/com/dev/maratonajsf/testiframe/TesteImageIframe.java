package br.com.dev.maratonajsf.testiframe;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

import javax.enterprise.context.SessionScoped;
import javax.imageio.ImageIO;
import javax.inject.Named;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

@Named
@SessionScoped
public class TesteImageIframe implements Serializable {

    public String getImageFilePath() {
        // Substitua este retorno pelo caminho absoluto ou URL da imagem
        return "C:\\Users\\Renan\\Desktop\\JWT Java token authentication_.pdf";
    }

    public InputStream convertWordToImage() {

        try (FileInputStream pdfStream = new FileInputStream("C:\\Users\\Renan\\Desktop\\JWT Java token authentication_.pdf");
             XWPFDocument document = new XWPFDocument(pdfStream)) {
            XWPFPicture picture = document.getParagraphArray(0).getRuns().get(0).getEmbeddedPictures().get(0);
            XWPFPictureData pictureData = picture.getPictureData();
            byte[] imageData = pictureData.getData();
            return new ByteArrayInputStream(imageData);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] renderPdfToImageOrHtml() {
        try (PDDocument document = PDDocument.load(new URL("C:\\Users\\Renan\\Desktop\\JWT Java token authentication_.pdf").openStream())) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            BufferedImage image = pdfRenderer.renderImageWithDPI(0, 300); // Render the first page at 300 DPI

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "PNG", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
