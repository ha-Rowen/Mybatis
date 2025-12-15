package org.example.mybatis.Controller;

import org.example.mybatis.DTOfile.DTO;
import org.example.mybatis.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class controller {

    private final TransferService Ts;
    public controller(TransferService Ts)
    {
        this.Ts=Ts;
    }

    @GetMapping("/")
    public ResponseEntity<String> mainPage( DTO dto)
    {
        Long FromId = dto.getFromId ();
        Long ToId   = dto.getToId   ();
        int  amount = dto.getAmount ();

        Ts.transhfer(FromId,ToId,amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
