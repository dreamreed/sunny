package com.debug.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "address")
public class Address implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer areaId;
	private String areaName;
	private Integer areaPid;
	// Constructors

	/** default constructor */
	public Address() {
	}

	/** full constructor */
	public Address(Integer areaId, String areaName, Integer areaPid) {
		this.areaId = areaId;
		this.areaName = areaName;
		this.areaPid = areaPid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "area_id")
	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	@Column(name = "area_name", length = 30)
	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Column(name = "area_pid")
	public Integer getAreaPid() {
		return this.areaPid;
	}

	public void setAreaPid(Integer areaPid) {
		this.areaPid = areaPid;
	}


	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(getId())
				.toHashCode();
	}

	public boolean equals(Object obj) {
		if(this.getId() == null){
			return false;
		}
		if(!(obj instanceof Address)){
			return false;
		}
		if(this == obj) {
			return true;
		}
		Address other = (Address)obj;
		return new EqualsBuilder()
				.append(getId(), other.getId())
				.isEquals();
	}

}