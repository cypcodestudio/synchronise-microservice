package com.cypcode.synchronise_microservice;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sync")
public class SyncController {

	@Autowired
	private SyncService syncService;
	
	@GetMapping
	public void sync() throws InterruptedException{
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				syncService.update();

				System.out.println(syncService.count);
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				syncService.update();

				System.out.println(syncService.count);
			}
		});
		
		Thread thread3 = new Thread(new Runnable() {
			public void run() {
			syncService.update();

			System.out.println(syncService.count);
			}
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		
		thread1.join();
		thread2.join();
		thread3.join();

		
	}
}
