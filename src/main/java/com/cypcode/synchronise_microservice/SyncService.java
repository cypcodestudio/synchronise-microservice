package com.cypcode.synchronise_microservice;

import org.springframework.stereotype.Service;

@Service
public class SyncService {

	public int count;
	
	public synchronized void update() {
		count++;
	}
}
