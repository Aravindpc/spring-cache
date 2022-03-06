package com.crudexample.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bankdto {
	
	public Bankdto(String bank_reg_number, String bank_identification_code, String bank_name, String country,
			String registered_address, LocalDateTime maker_date, LocalDateTime checker_date, String maker_id,
			String checker_id, String modified_by, LocalDateTime modified_date) {
		super();
		this.bank_reg_number = bank_reg_number;
		this.bank_identification_code = bank_identification_code;
		this.bank_name = bank_name;
		this.country = country;
		this.registered_address = registered_address;
		this.maker_date = maker_date;
		this.checker_date = checker_date;
		this.maker_id = maker_id;
		this.checker_id = checker_id;
		this.modified_by = modified_by;
		this.modified_date = modified_date;
	}


	private long id;
	
	
	private String bank_reg_number;

	
	private String bank_identification_code;

	private String bank_name;
	
	private String country;
	
	private String registered_address;
	
    private LocalDateTime maker_date;
	
    private LocalDateTime checker_date;
	
	private String maker_id;
	
	private String checker_id;
	
	private String modified_by;

    private LocalDateTime modified_date;

}
