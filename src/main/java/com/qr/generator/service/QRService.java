package com.qr.generator.service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

@Service
public class QRService {

    public String generateQRAsBase64(String text) {
        try {
            BitMatrix matrix = new MultiFormatWriter()
                    .encode(text, BarcodeFormat.QR_CODE, 300, 300);

            BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);

            byte[] qrBytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(qrBytes);

        } catch (Exception e) {
            throw new RuntimeException("Error generando QR", e);
        }
    }
}