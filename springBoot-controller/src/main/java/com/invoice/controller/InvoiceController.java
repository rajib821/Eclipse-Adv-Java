package com.invoice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.request.InvoiceReq;

@RestController
public class InvoiceController {

    @PostMapping("/invoice/generateInvoice")
    public String generateInvoiceId(@RequestBody InvoiceReq invoiceRequest) {
    	System.out.println("[customerId : "+invoiceRequest.getCustomerId()+
    			" ] [item : "+invoiceRequest.getItem()+
    			" ] [price : "+invoiceRequest.getPrice()+
    			" ] [Qty : "+invoiceRequest.getQty()+
    			" ] [totalAmt : "+invoiceRequest.getTotalAmt()+
    			" ] "
    			);
        return "invoice id : 8642";
    }
}
