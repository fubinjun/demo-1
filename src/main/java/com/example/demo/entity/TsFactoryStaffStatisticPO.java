package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TsFactoryStaffStatisticPO {
	private long id;
    private int userId;
    private long passId;
    private String passNo;
    private int staffId;
    private int passQuantity;
    private int realQuantity;
    private int selfCount;
    private int filmCount;
    private int decoCount;
    private int custCardCount;
    private int custPacketCount;
    private long created;
    private int modified;
	
}
