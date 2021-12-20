package com.example.demo.Service;

import com.example.demo.Exception.UserException;
import com.example.demo.Model.entity.UserDetail;
import com.example.demo.Model.sharedobject.User;
import com.example.demo.Repostiory.UserRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public User saveMethod(User user)
    {
        System.out.println("hgfg");
        if(user != null)
        {
            UserDetail userDetail = new UserDetail();
           // userDetail.setId(user.getId());

            userDetail.setUserName(user.getUserName());
            userDetail.setSurName(user.getSurName());
            userDetail.setDob(user.getDob());
            userDetail.setDoj(user.getDoj());
            userDetail.setPhoneNumber(user.getPhoneNumber());
            userDetail.setStatus(true);

            userRepository.save(userDetail);
        }
       return user;
    }

    public User updateMethod(User user, Long id) {
       try {
           if (user != null) {
               Optional<UserDetail> userDetail = userRepository.findById(id);
               if (userDetail != null) {
                   userDetail.get().setUserName(user.getUserName());
                   userDetail.get().setDob(user.getDob());
                   userDetail.get().setDoj(user.getDoj());
                   userDetail.get().setPhoneNumber(user.phoneNumber);
                   userDetail.get().setPin(user.getPin());
                   userDetail.get().setSurName(user.surName);
                   userRepository.save(userDetail.get());
               } else
                   throw new UserException("User does not exit");
           }

       }
       catch (Exception e){
           e.printStackTrace(); }
        return user;
    }


    public void inactivateUserMethod(Long id) {
        try {
                Optional<UserDetail> userDetail = userRepository.findById(id);
                if (userDetail != null) {
                    userDetail.get().setStatus(false);
                    userRepository.save(userDetail.get());
                } else
                    throw new UserException("User does not exit");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUserMethod(Long id) {
        try {
            Optional<UserDetail> userDetail = userRepository.findById(id);
            if (userDetail != null) {
                userRepository.delete(userDetail.get());
            } else
                throw new UserException("User does not exit");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  public List<UserDetail> sortUserByDob()
  {
    return ( userRepository.orderBydob());
  }
    public List<UserDetail> sortUserByDoj()
    {
        return ( userRepository.orderBydoj());
    }


    public ResponseEntity<List<UserDetail>> searchForUser(Specification<UserDetail> specs) {
        return new ResponseEntity<>(userRepository.findAll(Specification.where(specs)), HttpStatus.OK);
    }
}