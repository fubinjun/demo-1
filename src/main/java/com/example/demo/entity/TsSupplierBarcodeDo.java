package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ts_supplier_barcode")
public class TsSupplierBarcodeDo {

	@Id
	private Long id;
	@Column(name = "barcode")
	private String barcode;
	@Column(name = "gift_card_no")
	private String giftCardNo;
	@Column(name = "gift_detail")
	private String giftDetail;
}
