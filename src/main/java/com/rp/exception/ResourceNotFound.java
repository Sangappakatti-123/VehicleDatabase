package com.rp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
	public ResourceNotFound(String resourcename, String fieldname, Object fieldvalue) {
		super(resourcename+" not found for "+fieldname+":"+fieldvalue);
	}
}
