package com.qr.generator.controller;

import com.qr.generator.service.QRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/qr")
public class MainController {
    @Autowired
    private final QRService qrService;

    public MainController(QRService qrService) {
        this.qrService = qrService;
    }

    @GetMapping("/base64")
    public String getQRBase64(@RequestParam String text) {
        return qrService.generateQRAsBase64(text);
    }
}
