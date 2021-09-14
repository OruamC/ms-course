package com.devsuperior.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@RefreshScope
@Controller
@RequestMapping("/workers")
public class WorkerResource {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerResource.class);
	
	private Environment env;
	private WorkerRepository repository;

	@Autowired
	public WorkerResource(WorkerRepository repository, Environment env) {
		this.repository = repository;
		this.env = env;
	}
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfig() {
//		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = this.repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker worker = this.repository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
}
