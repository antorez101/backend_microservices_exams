package com.microservices.exams.service;

import org.springframework.stereotype.Service;

import com.course.commons.service.CommonsServiceImpl;
import com.course.entity.Examen;
import com.microservices.exams.repository.ExamenRepository;

@Service
public class ExamenServiceImpl extends CommonsServiceImpl<Examen, ExamenRepository> implements ExamenService{

}
