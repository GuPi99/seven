package com.ally.sevencensus.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SevenCensus {
    private Integer id;

    private Integer productId;

    private BigDecimal saleVolume;

    private BigDecimal monthMoney;

    private String saleNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date censusDate;

    private Integer staffId;
    
    private Integer cSid;
    
    private String productName;
    
    private String staffName;
    
    private String censusName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getSaleVolume() {
        return saleVolume;
    }

    public void setSaleVolume(BigDecimal saleVolume) {
        this.saleVolume = saleVolume;
    }

    public BigDecimal getMonthMoney() {
        return monthMoney;
    }

    public void setMonthMoney(BigDecimal monthMoney) {
        this.monthMoney = monthMoney;
    }

    public String getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber == null ? null : saleNumber.trim();
    }

    public Date getCensusDate() {
        return censusDate;
    }

    public void setCensusDate(Date censusDate) {
        this.censusDate = censusDate;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Integer getcSid() {
		return cSid;
	}

	public void setcSid(Integer cSid) {
		this.cSid = cSid;
	}

	public String getCensusName() {
		return censusName;
	}

	public void setCensusName(String censusName) {
		this.censusName = censusName;
	}

	@Override
	public String toString() {
		return "SevenCensus [productId=" + productId + ", saleVolume=" + saleVolume + ", monthMoney=" + monthMoney
				+ ", staffId=" + staffId + ", productName=" + productName + ", staffName=" + staffName + ", censusName="
				+ censusName + "]";
	}
    
	
    
}