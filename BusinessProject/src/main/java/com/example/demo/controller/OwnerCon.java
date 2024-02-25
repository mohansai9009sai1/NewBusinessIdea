package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Owner;
import com.example.demo.entity.OwnerRepo;

@RestController
public class OwnerCon {
	
	@Autowired
	OwnerRepo repo;
	
	@PostMapping("/createdata")
	public ResponseEntity<Owner> saveOwner( @RequestBody Owner owner) {
		return new ResponseEntity<Owner>(repo.save(owner),HttpStatus.CREATED);
	}
	@GetMapping("/gettingdata")
	 public ResponseEntity<List<Owner>> getDetails(){
		return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
		 
	 }
	@GetMapping("/details/{id}")
	public ResponseEntity<Owner> fetchDetails(@PathVariable int id){
		Optional<Owner> owner=repo.findById(id);
		if(owner.isPresent()){
			return  new ResponseEntity<>(owner.get(),HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}}
		
		@PutMapping("/detail/{id}")
		 public ResponseEntity<Owner> updateDetails(@PathVariable int id,@RequestBody Owner own ){
			Optional<Owner> owner1=repo.findById(id);
			if(owner1.isPresent()){
				owner1.get().setName(own.getName());
				owner1.get().setType(own.getType());
				owner1.get().setMobile(own.getMobile());
				
			
				return  new ResponseEntity<>(repo.save(owner1.get()),HttpStatus.ACCEPTED);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
			}}
		
		@DeleteMapping("/delete/{id}") 
		
		public ResponseEntity<Object> deletedata(@PathVariable int id){
            	   Optional<Owner> owner1 =repo.findById(id);
            	   if(owner1.isPresent()) {
            		   repo.deleteById(id);
            	   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            	   }  else {
            		   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            	   }
	}}
