package com.nilmani.jobworkmanagement.controller

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.awt.image.BufferedImage


@RestController
class QRCodeController {
    @GetMapping(path = ["/api/v1/getqrcode"], produces = [MediaType.IMAGE_PNG_VALUE])
    @Throws(Exception::class)
    fun generateQRCodeImage(@RequestParam url: String?): BufferedImage? {
        //QRcode generator logic
        val qrCodeWriter = QRCodeWriter()
        val bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 250, 250)
        return MatrixToImageWriter.toBufferedImage(bitMatrix)
    }
}
