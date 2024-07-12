package com.example.niias.services;

import com.example.niias.models.Parameter;
import com.example.niias.repositories.ParameterRepository;
import com.example.niias.web.view.CreateParameterViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ParameterServiceImpl {

    @Autowired
    private ParameterRepository parameterRepository;

    @Autowired
    private ModelMapper modelMapper;


    public void addParameter(CreateParameterViewModel newParameter) {
        Parameter parameter = modelMapper.map(newParameter, Parameter.class);
        parameterRepository.saveAndFlush(parameter);
    }
}