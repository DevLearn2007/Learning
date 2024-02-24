package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exception.ShapeException;
import com.example.demo.model.ContentRequest;
import com.example.demo.model.ContentSpliter;
import com.example.demo.model.DateMapper;
import com.example.demo.model.DateMsg;
import com.example.demo.model.MessageBox;
import com.example.demo.utils.DateUtils;
import com.example.demo.utils.StringUtils;

import jakarta.validation.Valid;

@RestController
@RequestMapping("loma/v1/")
public class MasterController {
	@Autowired
	Environment env;
	
	
	@GetMapping("/{shape}")
	public MessageBox getShareInfo(@PathVariable String shape) {
		if(Objects.isNull(shape)) {
			throw new ShapeException("Invalid Input");
		}
		String msg=env.getProperty(shape);
		System.out.println(env.getProperty("Dev"));
		if(Objects.isNull(msg)) {
			throw new ShapeException("Shape information not found");
		}
		return new MessageBox(msg);
		
	}
	
	@PostMapping("/content/summary")
	public ContentSpliter getContentSummary(@RequestBody @Valid ContentRequest request) {
		return StringUtils.getDataFilter(request.content());
	}
	
	@PostMapping("/date2content")
	public MessageBox convertDate2Msg(@RequestBody @Valid DateMsg request) {
		return new MessageBox(DateUtils.dateToSTring(request.dateTime()));
	}
	
	@PostMapping("/dateDiff")
	public MessageBox getDaysFromDates(@RequestBody @Valid DateMapper mapper) {
		return new MessageBox(DateUtils.getDays(mapper));
	}
	
//	@PostMapping("/content2date")
//	public DateMsg convertMsg2Date(@RequestBody @Valid MessageBox request) {
//		return StringUtils.getDataFilter(request.msg());
//	}
	
	

}
