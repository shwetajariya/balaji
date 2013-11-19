package com.sur.balaji.service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import com.sur.balaji.model.SMSMessageEntry;

@Service
public class QueueService {

	Queue<SMSMessageEntry> queue;
	
	public QueueService() {
		queue = new ConcurrentLinkedQueue<SMSMessageEntry>();
	}
	
	public void add(SMSMessageEntry smsMessageEntry){
		queue.add(smsMessageEntry);
	}
	
	public SMSMessageEntry get(){
		return queue.poll();
	}
}
