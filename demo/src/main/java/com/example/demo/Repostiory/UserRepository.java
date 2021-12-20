package com.example.demo.Repostiory;

import com.example.demo.Model.entity.UserDetail;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


@Repository
@RepositoryRestResource
public interface UserRepository extends JpaRepository<UserDetail, Long>, JpaSpecificationExecutor<UserDetail> {

    @Query("SELECT a FROM UserDetail a ORDER BY a.dob ASC")
    List<UserDetail> orderBydob();

    @Query("SELECT a FROM UserDetail a ORDER BY a.doj ASC")
    List<UserDetail> orderBydoj();


}

