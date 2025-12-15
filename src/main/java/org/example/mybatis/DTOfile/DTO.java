package org.example.mybatis.DTOfile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTO {
    Long fromId;
    Long toId;
    int amount;
}
