package com.jumpyTech.GestionStock.model;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable{
@Id
@GeneratedValue
private Integer id;
@Column(name="CreationDate")
@JsonIgnore
private Instant creationDate;

@Column(name="lastModifiedDate")
@JsonIgnore
private Instant lastUpdateDate;

@PrePersist
void prePersist() {
	creationDate=Instant.now();
}
@PreUpdate
void preUpdate() {
	lastUpdateDate=Instant.now();
}

}
