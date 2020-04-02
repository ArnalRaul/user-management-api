package com.usermanagement.dao;

import com.usermanagement.entity.Worker;

public interface workerDao {
	Worker getWorkerById(String id);
	void   saveWorker(Worker worker);
	boolean deleteWorkerById(String id);
	boolean changeWorkerPassword(String id, String password);
}
