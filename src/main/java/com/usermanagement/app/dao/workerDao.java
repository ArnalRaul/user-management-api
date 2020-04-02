package com.usermanagement.app.dao;

import com.usermanagement.app.entity.Worker;

public interface workerDao {
	Worker getWorkerById(String id);
	void   saveWorker(Worker worker);
	boolean deleteWorkerById(String id);
	boolean changeWorkerPassword(String id, String password);
}
