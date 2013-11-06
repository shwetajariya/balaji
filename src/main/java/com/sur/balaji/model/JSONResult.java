package com.sur.balaji.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

//@JsonPropertyOrder({ "Result", "Record", "Records", "TotalRecordCount" })
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class JSONResult implements Serializable {

	private static final long serialVersionUID = -8758405990172905774L;
	
	@JsonProperty("Result")
	private String result;
	@JsonProperty("Records")
	private List<? extends ModelBase> records;
	@JsonProperty("Record")
	private ModelBase record;
	@JsonProperty("TotalRecordCount")
	private Integer totalRecordCount;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public List<? extends ModelBase> getRecords() {
		return records;
	}
	public void setRecords(List<? extends ModelBase> records) {
		this.records = records;
	}
	
	public ModelBase getRecord() {
		return record;
	}
	public void setRecord(ModelBase record) {
		this.record = record;
	}
	
	public Integer getTotalRecordCount() {
		return totalRecordCount;
	}
	public void setTotalRecordCount(Integer totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
	
	@Override
	public String toString() {
		return "JSONResult [Result=" + result + ", Records=" + records +
				", Record=" + record + ", TotalRecordCount=" + totalRecordCount + "]";
	}
}
