package com.tramp;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DateTime {

	@Id
	private long id;

	private Date sqlDate;
	private Time sqlTime;
	private Timestamp sqlTimestamp;
	
	//java.sql.date/etc are just wrappers to java.util.Date/etc.
	//if u have java.util.Date just use @Temporal(TemporalType.DATE/TIME/TIMESTAMP) to mark it 
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getSqlDate() {
		return sqlDate;
	}

	public void setSqlDate(Date sqlDate) {
		this.sqlDate = sqlDate;
	}

	public Time getSqlTime() {
		return sqlTime;
	}

	public void setSqlTime(Time sqlTime) {
		this.sqlTime = sqlTime;
	}

	public Timestamp getSqlTimestamp() {
		return sqlTimestamp;
	}

	public void setSqlTimestamp(Timestamp sqlTimestamp) {
		this.sqlTimestamp = sqlTimestamp;
	}

}
