package facades;

import dtos.UserDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class UserFacadeTest {
    UserFacade uf = new UserFacade("startcode_test");
    UserDTO user1;
    @BeforeEach
    void setUp() {
        Connection con = null;
        try {
            con = DBConnector.connection("startcode_test");
            String createTable = "CREATE TABLE IF NOT EXISTS `startcode_test`.`usertable` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `fname` VARCHAR(45) NULL,\n" +
                    "  `lname` VARCHAR(45) NULL,\n" +
                    "  `pw` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            con.prepareStatement(createTable).executeUpdate();
            con.prepareStatement("DELETE FROM `startcode_test`.`usertable`").executeUpdate();

//            String SQL = "INSERT INTO startcode_test.usertable (fname, lname, pw, phone, address) VALUES (?,?,?,?,?)";
//            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, "Hans");
//            ps.setString(2, "Hansen");
//            ps.setString(3, "Hemmelig123");
//            ps.setString(4, "40404040");
//            ps.setString(5,"Rolighedsvej 3");
//            ps.executeUpdate();
            user1 = uf.create(new UserDTO("Hans", "Hansen", "Hemmelig123", "40404040", "Rolighedsvej 3"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
        System.out.println("Create");
        UserDTO user = uf.create(new UserDTO("Helle", "Haugaard", "Hemmelig123", "40404040", "Rolighedsvej 3"));
        assertEquals("Helle", user.getFname());
    }

    @Test
    void update() {
        System.out.println("Update");
        UserDTO user = uf.update(new UserDTO(user1.getId(),"Annie", "Andersen", "Hemli", "40404040", "Rolighedsvej 3"));
        assertEquals("Annie", user.getFname());
    }

    @Test
    void getById() {
        System.out.println("GetById");
        UserDTO user = uf.getById(user1.getId());
        assertEquals("Hans", user.getFname());
    }

    @Test
    void getAll() {
        System.out.println("GetAll");
        int size = uf.getAll().size();
        assertEquals(1, size);
    }
}