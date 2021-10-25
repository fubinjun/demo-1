package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.TsFactoryStaffStatisticPO;
import com.example.demo.entity.TsMobileGiftDo;
import com.example.demo.entity.TsShopFahuoDo;
import com.example.demo.entity.TsShopFahuoPo;
import com.example.demo.entity.TsSupplierBarcodeDo;
import com.example.demo.mapper.YgjxMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("ygjxService")
public class YgjxServiceImpl implements YgjxService{
	@Autowired
	private YgjxMapper ygjxMapper;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void jxtest(String userId) {

		String sql = "select * from ts_shop_fahuo where df_sub_user_id = ?";

		List<TsShopFahuoPo> tsShopFahuoPoList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<TsShopFahuoPo>(TsShopFahuoPo.class),new Object[]{userId});
		//		for (TsShopFahuoPo shop_Fahuo : tsShopFahuoPoList) {
		//			System.out.println(shop_Fahuo);
		//		}
		//        List<TsShopFahuoPo> tsShopFahuoPoList = ygjxMapper.getFaHuoInfo(userId);
		//        HashSet<Integer> strlist = new HashSet<>();
//		 List<String> barcodeList = new ArrayList<>();
		 StringBuffer barcodeString = new StringBuffer();
		HashMap<Integer, List<TsShopFahuoPo>> fahuoNumMap = new HashMap<Integer, List<TsShopFahuoPo>>();

		for (TsShopFahuoPo tsShopFahuoPo : tsShopFahuoPoList) {
			if (!StringUtils.isEmpty(tsShopFahuoPo)) {
				String barcode = tsShopFahuoPo.getBarcode();
				if (StringUtils.hasText(barcode)) {
					String[] leng = barcode.split(",");
//					barcodeList.addAll(Arrays.asList(leng));
					barcodeString.append(",").append(barcode);
					if(!fahuoNumMap.containsKey(leng.length)) {
						List<TsShopFahuoPo> shopFahuoPoList = new ArrayList<TsShopFahuoPo>();
						shopFahuoPoList.add(tsShopFahuoPo);
						fahuoNumMap.put(leng.length, shopFahuoPoList);
					}else {
						fahuoNumMap.get(leng.length).add(tsShopFahuoPo);
					}
					//                    strlist.add(leng.length);
					//                    for (int a = 0; a < leng.length; a++) {
					//                        barcodeList.add(leng[a]);
					//                    }
				}
			}
			//            TsShopFahuoDo tsShopFahuoDo = new TsShopFahuoDo();
			//            tsShopFahuoDo.setId(tsShopFahuoPo.getId());
			//            tsShopFahuoDo.setWayBillId(tsShopFahuoPo.getWayBillId());
			//            tsShopFahuoDo.setUserId(tsShopFahuoPo.getUserId());
			//            tsShopFahuoDo.setOrderId(tsShopFahuoPo.getOrderId());
			//            tsShopFahuoDo.setOid(tsShopFahuoPo.getOid());
			//            tsShopFahuoDo.setBarcode(barcodeList);
			//            tsShopFahuoDo.setStatus(tsShopFahuoPo.getStatus());
			//            tsShopFahuoDo.setTid(tsShopFahuoPo.getTid());
			//            tsShopFahuoDo.setIsSplit(tsShopFahuoPo.getIsSplit());
			//            tsShopFahuoDo.setIsCron(tsShopFahuoPo.getIsCron());
			//            tsShopFahuoDo.setDdUserId(tsShopFahuoPo.getDdUserId());
			//            tsShopFahuoDo.setDfSubUserId(tsShopFahuoPo.getDfSubUserId());
			//            tsShopFahuoDoList.add(tsShopFahuoDo);
		}
		sql = "select id,barcode,gift_card_no,gift_detail from ts_supplier_barcode where barcode in (?)";
		String substring = barcodeString.substring(1);
		List<TsSupplierBarcodeDo> tsSupplierBarcodeDoList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<TsSupplierBarcodeDo>(TsSupplierBarcodeDo.class),substring);

		Set<Integer> keySet = fahuoNumMap.keySet();
		for (Integer integer : keySet) {

			List<TsShopFahuoPo> shopFahuoPoList = fahuoNumMap.get(integer);
			TsFactoryStaffStatisticPO tsFactoryStaffStatisticPO = new TsFactoryStaffStatisticPO();
			tsFactoryStaffStatisticPO.setUserId(Integer.parseInt(userId));
			tsFactoryStaffStatisticPO.setPassId(0);
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
			Date d= new Date();
			String str = sdf.format(d);
			String passNod = str.substring(5,5).replace("-","");
			String passNo = "K"+passNod+shopFahuoPoList.size();
			tsFactoryStaffStatisticPO.setPassNo(passNo);
			int a = 0;
			for (TsShopFahuoPo shopFahuoPo : shopFahuoPoList){
				String[] leng = shopFahuoPo.getBarcode().split(",");
				for (int i = 0; i < leng.length; i++) {
//					leng[i]
				}
			}
			tsFactoryStaffStatisticPO.setUserId(Integer.parseInt(userId));
//			tsFactoryStaffStatisticPO.setPassQuantity(sttin);
			tsFactoryStaffStatisticPO.setRealQuantity(a);
		}
		//        for(Integer sttin : strlist){
		//                TsFactoryStaffStatisticPO tsFactoryStaffStatisticPO = new TsFactoryStaffStatisticPO();
		//                tsFactoryStaffStatisticPO.setUserId(Integer.parseInt(userId));
		//                tsFactoryStaffStatisticPO.setPassId(0);
		//                SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
		//                Date d= new Date();
		//                String str = sdf.format(d);
		//                String passNod = str.substring(5,5).replace("-","");
		//                String size = String.format("%03d", sttin);
		//                String passNo = "K"+passNod+size;
		//                tsFactoryStaffStatisticPO.setPassNo(passNo);
		//                int a = 0;
		//                for (TsShopFahuoDo tsShopFahuodo : tsShopFahuoDoList){
		//                    if (sttin == tsShopFahuodo.getBarcode().size()){
		//                        a++;
		//                    }
		//                }
		//                tsFactoryStaffStatisticPO.setUserId(Integer.parseInt(userId));
		//                tsFactoryStaffStatisticPO.setPassQuantity(sttin);
		//                tsFactoryStaffStatisticPO.setRealQuantity(a);
		//            }





	}
}
