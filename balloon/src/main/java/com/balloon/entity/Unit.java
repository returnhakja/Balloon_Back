package com.balloon.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
<<<<<<< HEAD
=======
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
>>>>>>> a049122424fba70fa426308a8f4ffd27ef67eb79

import org.springframework.data.domain.Persistable;

import com.balloon.dto.UnitDTO;
<<<<<<< HEAD
//import com.fasterxml.jackson.annotation.JsonIgnore;
=======
import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
>>>>>>> a049122424fba70fa426308a8f4ffd27ef67eb79

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "unit")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Unit implements Persistable<String>{
<<<<<<< HEAD
   
//   @JsonIgnore
   @Id
   @Column(name="unit_code", length = 10)
   private String unitCode;
   
   @Column(name="unit_name", length = 20)
   private String unitName;
   
   @Column(length = 15)
   private String bell;
   
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "parent_unit", referencedColumnName = "unit_code")
   private Unit parentUnit;
   
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentUnit")
   private List<Unit> childUnits;

   
   public UnitDTO toDTO(Unit unitEntity) {
      UnitDTO unitDTO = UnitDTO.builder()
                  .unitCode(unitEntity.getUnitCode())
                  .unitName(unitEntity.getUnitName())
                  .bell(unitEntity.getBell())
                  .parentUnit(unitEntity.getParentUnit())
                  .childUnits(unitEntity.getChildUnits())
                  .build();
      
      return unitDTO;
   }

   @Override
   public String getId() {
      return unitCode;
   }

   @Override
   public boolean isNew() {
      return unitCode == null;
   }
   
}
=======
	
//	@JsonIgnore
	@Id
	@Column(name="unit_code", length = 10)
	private String unitCode;
	
	@NotBlank
	@Column(name="unit_name", length = 20)
	private String unitName;
	
	@NotNull
	@Column(length = 15)
	private String bell;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "parent_unit", referencedColumnName = "unit_code")
	private Unit parentUnit;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parentUnit")
	private List<Unit> childUnits;

	
	public UnitDTO toDTO(Unit unitEntity) {
		UnitDTO unitDTO = UnitDTO.builder()
						.unitCode(unitEntity.getUnitCode())
						.unitName(unitEntity.getUnitName())
						.bell(unitEntity.getBell())
						.parentUnit(unitEntity.getParentUnit())
						.childUnits(unitEntity.getChildUnits())
						.build();
		
		return unitDTO;
	}

	@Override
	public String getId() {
		return unitCode;
	}

	@Override
	public boolean isNew() {
		return unitCode == null;
	}
	
	/* 부서전화번호만 업데이트할 때 */
	public void updateBell(UnitDTO unitDTO) {
		this.bell = unitDTO.getBell();
	}
	
	/* 부서전화번호와 부서명만 업데이트 할 때 */
	public void updateUnitNameAndBell(UnitDTO unitDTO) {
		this.unitName = unitDTO.getUnitName();
		this.bell = unitDTO.getBell();
	}
	
	
	
}
>>>>>>> a049122424fba70fa426308a8f4ffd27ef67eb79
