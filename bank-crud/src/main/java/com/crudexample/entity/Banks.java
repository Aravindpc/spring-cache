package com.crudexample.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="banks")
public class Banks {
	
	public Banks(String bank_reg_number, String bank_identification_code, String bank_name, String country,
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bank_id")
	private long id;
	
	@Column(name="bank_reg_number", nullable = false)
	private String bank_reg_number;

	@Column(name="bank_identification_code", nullable = false)
	private String bank_identification_code;
	
	@Column(name="bank_name", nullable = false)
	private String bank_name;
	
	@Column(name="country", nullable = false)
	private String country;
	
	@Column(name="registered_address", nullable = false)
	private String registered_address;
	
	@Column(name = "maker_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime maker_date;
	
	@Column(name = "checker_date", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime checker_date;
	
	@Column(name="maker_id", nullable = false)
	private String maker_id;
	
	@Column(name="checker_id", nullable = true)
	private String checker_id;
	
	@Column(name="modified_by", nullable = true)
	private String modified_by;

	@Column(name = "modified_date", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime modified_date;

}
