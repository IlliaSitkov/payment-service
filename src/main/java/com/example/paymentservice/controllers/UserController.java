package com.example.paymentservice.controllers;

import com.example.paymentservice.dtos.PaymentModeDto;
import com.example.paymentservice.handlers.BillHandler;
import com.example.paymentservice.handlers.UserHandler;
import com.example.paymentservice.models.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserHandler userHandler;
    private final BillHandler billHandler;

    public UserController(UserHandler userHandler, BillHandler billHandler) {
        this.userHandler = userHandler;
        this.billHandler = billHandler;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> setPaymentMode(@PathVariable Long id, @RequestBody PaymentModeDto paymentModeDto) throws Exception {
        userHandler.setPaymentMode(id, paymentModeDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> attemptToBanUser(@PathVariable Long id) throws Exception {
        boolean userBanned = userHandler.attemptToBanUser(id);
        return ResponseEntity.ok().body(userBanned);
    }

    @PostMapping("/{id}/bills")
    public Bill createBill(@PathVariable Long id) throws Exception {
        return billHandler.processBillRequestForUser(id);
    }

}
