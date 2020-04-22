package com.ally.sevenprojectgoods.bean;

public class SevenProjectGoods {
	private Integer id;

	private Integer pgPid;

	private Integer pgCid;

	private Integer pgGid;

	private String psName;

	private String pgModel;

	private Integer pgNum;

	private String pgNote;

	private String ClassName;

	private String GoodsName;
	
	private String GoodsModel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPgPid() {
		return pgPid;
	}

	public void setPgPid(Integer pgPid) {
		this.pgPid = pgPid;
	}

	public Integer getPgCid() {
		return pgCid;
	}

	public void setPgCid(Integer pgCid) {
		this.pgCid = pgCid;
	}

	public Integer getPgGid() {
		return pgGid;
	}

	public void setPgGid(Integer pgGid) {
		this.pgGid = pgGid;
	}

	public String getPsName() {
		return psName;
	}

	public void setPsName(String psName) {
		this.psName = psName == null ? null : psName.trim();
	}

	public String getPgModel() {
		return pgModel;
	}

	public void setPgModel(String pgModel) {
		this.pgModel = pgModel == null ? null : pgModel.trim();
	}

	public Integer getPgNum() {
		return pgNum;
	}

	public void setPgNum(Integer pgNum) {
		this.pgNum = pgNum;
	}

	public String getPgNote() {
		return pgNote;
	}

	public void setPgNote(String pgNote) {
		this.pgNote = pgNote == null ? null : pgNote.trim();
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getGoodsName() {
		return GoodsName;
	}

	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}

	public String getGoodsModel() {
		return GoodsModel;
	}

	public void setGoodsModel(String goodsModel) {
		GoodsModel = goodsModel;
	}


}