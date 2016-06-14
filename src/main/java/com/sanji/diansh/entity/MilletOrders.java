package com.sanji.diansh.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractAuditable;

/**
 * 小米订单 （tb_MIUI表）实体类
 * @author 神盾局
 *
 */
@Entity
@Table(name="tb_MilletOrders")
public class MilletOrders extends AbstractAuditable<MilletOrders,Long>{

	private static final long serialVersionUID = 1L;
	public String herf;// 访问地址
	public String name;//名字
	public String orderNum;//订单号
	public String payByRateIndex;//按比例支付指数
	public String payOrdCnt;// 单价格
	public String tradeIndexCrc;//
	
	public MilletOrders(){
		super();
	}
	public String getHerf() {
		return herf;
	}
	public void setHerf(String herf) {
		this.herf = herf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getPayByRateIndex() {
		return payByRateIndex;
	}
	public void setPayByRateIndex(String payByRateIndex) {
		this.payByRateIndex = payByRateIndex;
	}
	public String getPayOrdCnt() {
		return payOrdCnt;
	}
	public void setPayOrdCnt(String payOrdCnt) {
		this.payOrdCnt = payOrdCnt;
	}
	public String getTradeIndexCrc() {
		return tradeIndexCrc;
	}
	public void setTradeIndexCrc(String tradeIndexCrc) {
		this.tradeIndexCrc = tradeIndexCrc;
	}
	
	
}
