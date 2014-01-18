package com.sur.balaji.service.sms;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class SMSDeliveryService {

	private ThreadPoolExecutor threadPool;
	protected final Log log = LogFactory.getLog(SMSDeliveryService.class);

	public SMSDeliveryService() {
		threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	}

	public Future execute(SMSPushTask smsTask)
			throws RejectedExecutionException {

		Future futureObject = threadPool.submit(smsTask);
		return futureObject;
	}
}
