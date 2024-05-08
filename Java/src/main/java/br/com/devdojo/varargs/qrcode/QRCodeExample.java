package br.com.devdojo.varargs.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class QRCodeExample {
    public static void main(String[] args) throws Exception {
        String text = "https://www.google.com"; // O URL que o QR Code irá abrir
        String imagePath = "C:\\Users\\Renan\\Desktop\\image.png"; // O caminho para a imagem que você deseja incorporar

        // Configuração do QR Code
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        // Criação do QR Code
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 300, 300, hints);

        // Criação da imagem do QR Code
        BufferedImage qrImage = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < 300; x++) {
            for (int y = 0; y < 300; y++) {
                qrImage.setRGB(x, y, bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF);
            }
        }

        // Carregamento da imagem personalizada
        BufferedImage logoImage = ImageIO.read(new File(imagePath));

        // Cálculo da posição para centralizar a imagem personalizada no QR Code
        int centerX = (qrImage.getWidth() - logoImage.getWidth()) / 2;
        int centerY = (qrImage.getHeight() - logoImage.getHeight()) / 2;

        // Desenho da imagem personalizada no QR Code
        qrImage.getGraphics().drawImage(logoImage, centerX, centerY, null);

        // Salvar o QR Code com a imagem personalizada
        File qrCodeFile = new File("path/to/save/qrcode.png");
        ImageIO.write(qrImage, "png", qrCodeFile);

        System.out.println("QR Code com imagem incorporada criado com sucesso.");
    }
}
