package org.example.mybatis.Controller;

import org.example.mybatis.DTOfile.DTO;
import org.example.mybatis.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class controller {

    private final TransferService Ts;
    public controller(TransferService Ts)
    {
        this.Ts=Ts;
    }

    @GetMapping("/d")
    public ResponseEntity<String> af()
    {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> mainPage(@RequestBody DTO dto)
    {
        Long FromId = dto.getFromId ();
        Long ToId   = dto.getToId   ();
        int  amount = dto.getAmount ();

        Ts.transhfer(FromId,ToId,amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
