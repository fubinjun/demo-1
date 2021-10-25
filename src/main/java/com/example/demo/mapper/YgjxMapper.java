package com.example.demo.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.TsShopFahuoPo;

import java.util.List;


@Mapper
public interface YgjxMapper {
    List<TsShopFahuoPo> getFaHuoInfo(String userId);
}
