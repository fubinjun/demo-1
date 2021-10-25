package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TsShopFahuoDo {
    private long id;
    private long wayBillId;
    private long userId;
    private Long orderId;
    private String oid;
    private List<String> barcode;
    private int status;
    private String tid;
    private int isSplit;
    private int isCron;
    private int ddUserId;
    private int dfSubUserId;
    private int created;
    private int modified;
	
}
