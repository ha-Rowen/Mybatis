package org.example.mybatis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class MyBatisApplicationTests {
    @Autowired
    private DataSource dataSource;
    @Test
    void DB_Cenecting() throws SQLException{
        try (Connection connection = dataSource.getConnection()) {
            Assertions.assertNotNull(connection);
        }
    }

}
