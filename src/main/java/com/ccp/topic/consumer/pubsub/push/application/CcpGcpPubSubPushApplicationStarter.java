package com.ccp.topic.consumer.pubsub.push.application;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.ccp.decorators.CcpJsonRepresentation;
import com.ccp.especifications.db.utils.CcpEntity;
import com.ccp.topic.consumer.pubsub.push.controller.CcpGcpPubSubConsumerController;
import com.ccp.topic.consumer.pubsub.push.exception.handler.CcpGcpPubSubPushExceptionHandler;

@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@ComponentScan(basePackageClasses = {
		CcpGcpPubSubConsumerController.class,
		CcpGcpPubSubPushExceptionHandler.class
})
@SpringBootApplication
public class CcpGcpPubSubPushApplicationStarter {
	public static Function<CcpJsonRepresentation, CcpJsonRepresentation> notifyError;
	public static CcpEntity entity;
	
	public static void main(Function<CcpJsonRepresentation, CcpJsonRepresentation> notifyError, 
			CcpEntity entity,
			String... args) {
		CcpGcpPubSubPushApplicationStarter.notifyError = notifyError;
		CcpGcpPubSubPushApplicationStarter.entity = entity;
		
		SpringApplication.run(CcpGcpPubSubPushApplicationStarter.class, args);
	}

	
}
