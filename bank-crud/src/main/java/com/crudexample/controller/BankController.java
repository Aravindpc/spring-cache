package com.crudexample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crudexample.dto.BankSimpledto;
import com.crudexample.dto.Bankdto;
import com.crudexample.entity.Banks;
import com.crudexample.services.BankService;

@Controller
@RequestMapping("/banks")
public class BankController {

	@Autowired
	private BankService bankService;

	@GetMapping("/getBanks")
	public ResponseEntity<List<Bankdto>> getBanks(HttpServletRequest request) {
		System.out.println(request.getHeader("bank-global-header"));
		List<Bankdto> output = bankService.getAllBank();
		return ResponseEntity.ok(output);
	}
	@GetMapping("/getOneBank")
	public ResponseEntity<BankSimpledto> getOneBank(@RequestParam(value = "bankid") Long bank_id) {
		BankSimpledto output = bankService.getBank(bank_id);
		return ResponseEntity.ok(output);
	}
	
	@PostMapping(value = "/createBank")
	public ResponseEntity<Banks> register(@RequestBody Bankdto banks) {
		Banks output =bankService.createBank(banks);
		
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateBank/{id}")
	public ResponseEntity<Banks> update(@PathVariable(value="id")Long bank_id,@RequestBody Bankdto banks) {
		Banks output =bankService.updateBank(banks,bank_id);
		
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
	@DeleteMapping(value = "/deletebank")
	public ResponseEntity<Boolean> delete(@RequestParam(value = "bankid") Long bank_id) {
		boolean output =bankService.deleteBank(bank_id);
		
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
}
