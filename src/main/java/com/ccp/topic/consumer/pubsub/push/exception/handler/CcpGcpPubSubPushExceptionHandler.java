package com.ccp.topic.consumer.pubsub.push.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.topic.consumer.pubsub.push.application.CcpGcpPubSubPushApplicationStarter;

@RestControllerAdvice
public class CcpGcpPubSubPushExceptionHandler {


	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Throwable.class })
	public void handle(Throwable e) {
		CcpJsonRepresentation values = new CcpJsonRepresentation(e);
		CcpGcpPubSubPushApplicationStarter.notifyError.apply(values.renameKey("message", "msg"));
	}
}
