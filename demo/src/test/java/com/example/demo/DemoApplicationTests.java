package com.example.demo;

import com.example.demo.Model.entity.UserDetail;
import com.example.demo.Repostiory.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserRepository userRepository;
    @Test
	void contextLoads() {
	}

	 @Test
    public void testCreate()  {
         UserDetail userDetail = new UserDetail();
         userDetail.setId(1L);
         userDetail.setStatus(true);
         userDetail.setSurName("singh");
         userDetail.setPin("638566");
         userDetail.setDoj(LocalDateTime.parse("2016-03-04 11:30:40",  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
         userDetail.setDob(LocalDateTime.parse("2001-03-04 11:30:40",  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
         userRepository.save(userDetail);
         assertNotNull(userRepository.findById(1L).get());
     }

    @Test
    public void testUpdate()  {
        UserDetail userDetail = new UserDetail();
        userDetail.setPin("287547");
        userRepository.save(userDetail);
        assertNotEquals("5746747",userRepository.findById(1L).get());
    }

/*
    @Test
    public void testDelete()  {

        userRepository.deleteById(1L);
      //  assertThat(userRepository.existsById(1L)).isFalse();
    }

    @Test
    public void testReadALL()
    {
        List<UserDetail> list = userRepository.findAll();
       // assertThat(list).size().isGreaterThan(0);
    }
*/

    @Test
    public void testSingleUser()
    {
       UserDetail userDetail = userRepository.findById(1L).get();
       assertEquals("283203",userDetail.getPin());
    }
}
