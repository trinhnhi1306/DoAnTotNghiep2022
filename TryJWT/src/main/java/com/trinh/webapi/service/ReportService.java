package com.trinh.webapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.trinh.webapi.dto.MyItem;

public interface ReportService {
	public List<MyItem> reportReceipt(Date date, int limit);
	public List<MyItem> newReportReceipt(Date date, int limit);
	public Date addDays(Date date, int days);
    public Date subDays(Date date, int days);
    public String covertD2S(Date date, String format);
}
