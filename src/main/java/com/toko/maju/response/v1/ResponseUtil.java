package com.toko.maju.response.v1;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {

	public static APIResponse<Object> successResponse(Object data) {
		return buildResponse(APIStatus.OK, data, HttpStatus.OK);
	}

	private static APIResponse<Object> buildResponse(APIStatus apiStatus, Object data, HttpStatus httpStatus) {
		return new APIResponse<Object>(apiStatus, data);
	}

}
