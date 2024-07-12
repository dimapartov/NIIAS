package com.example.niias.repositories;
import com.example.niias.models.Parameter;
import com.example.niias.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {
    //code
}