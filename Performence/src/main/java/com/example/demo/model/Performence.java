package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="performence_details")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Performence {
	@Id
	@Min(value = 1, message = "ID must be greater than 0")
	private int id;

}
