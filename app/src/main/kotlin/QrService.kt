package org.example.app

import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import java.io.ByteArrayOutputStream
import com.google.zxing.client.j2se.MatrixToImageWriter
import java.io.StringWriter

object QrService {
    fun generate(url: String): ByteArray {
        val bitMatrix = QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, 512, 512)
        val outputStream = ByteArrayOutputStream()
        MatrixToImageWriter.writeToStream(bitMatrix,"PNG", outputStream)
        return outputStream.toByteArray()
    }
}