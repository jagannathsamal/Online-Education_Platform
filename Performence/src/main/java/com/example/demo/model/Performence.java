package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private int id;

}
