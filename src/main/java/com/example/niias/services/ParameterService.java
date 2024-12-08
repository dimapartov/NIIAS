package com.example.niias.services;

import com.example.niias.models.Parameter;
import com.example.niias.repositories.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ParameterService {

    @Autowired
    private ParameterRepository parameterRepository;


    public List<Parameter> getAllParameters() {
        return parameterRepository.findAll();
    }

    public Optional<Parameter> getParameterById(Long id) {
        return parameterRepository.findById(id);
    }

    public Parameter saveParameter(Parameter parameter) {
        return parameterRepository.save(parameter);
    }

    public void deleteParameter(Long id) {
        parameterRepository.deleteById(id);
    }

    public List<Parameter> getParametersByType(String type) {
        return parameterRepository.findAllByTypeEquals(type);
    }

}