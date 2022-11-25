package com.trinh.webapi.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trinh.webapi.dto.MyItem;
import com.trinh.webapi.model.OrderStatus;
import com.trinh.webapi.repository.OrderRepository;
import com.trinh.webapi.repository.OrderStatusRepository;
import com.trinh.webapi.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderStatusRepository statusRepository;

	@Override
	public List<MyItem> reportReceipt(Date date, int limit) {
		List<MyItem> list = new ArrayList<>();
        for (OrderStatus s: statusRepository.findAll()) {
            MyItem myItem = new MyItem();
            myItem.setLabel(s.getDescription());
            myItem.setValue(orderRepository.countByStatus(s));
            list.add(myItem);
        }
        return list;
	}
	
	@Override
	public List<MyItem> newReportReceipt(Date date, int limit) {
		List<MyItem> list = new ArrayList<>();
		Long value;
        for (int i = limit - 1; i >= 0; i--) {
            Date d = subDays(date, i);
            MyItem myItem = new MyItem();
            myItem.setLabel(covertD2S(d, "dd/MM"));
            value = orderRepository.countItem(d);
            myItem.setValue(value == null ? 0 : value);
            list.add(myItem);
        }
        return list;
	}

	@Override
	public Date addDays(Date date, int days) {
		GregorianCalendar cal =  new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
	}

	@Override
	public Date subDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, -days);
        return cal.getTime();
	}

	@Override
	public String covertD2S(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
	}

}
