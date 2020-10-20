package com.microservices.exams.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.commons.controller.CommonsController;
import com.course.entity.Examen;
import com.microservices.exams.service.ExamenService;

@RestController
public class ExamenController extends CommonsController<Examen, ExamenService> {
	
	@PutMapping(path = "/{idCurso}")
	public ResponseEntity<?> examenUpate(@PathVariable Long idCurso, @RequestBody Examen examen){
		
		Examen examenDB = service.findById(idCurso).orElse(null);
		if (null != examenDB && !examen.getPreguntas().isEmpty()) {			
			Optional.of(examenDB.getPreguntas())
				.ifPresent(preguntas -> preguntas.stream()
						.filter(Objects::nonNull)
						.filter(pregunta -> examen.getPreguntas().contains(pregunta))
						.forEach(pregunta -> examenDB.removePregunta(pregunta))
						);		
			examenDB.setPreguntas(examen.getPreguntas());			
			return new ResponseEntity<Examen>(examenDB, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
