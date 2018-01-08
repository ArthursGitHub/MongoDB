package com.mkyong.hosting.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.hosting.dao.HostingDao;
import com.mkyong.hosting.model.Hosting;
import com.mkyong.seq.dao.SequenceDao;
import com.mkyong.seq.exception.SequenceException;

@Service
public class HostingBoImpl implements HostingBo {

	private static final String HOSTING_SEQ_KEY = "hosting";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private HostingDao hostingDao;

	@Override
	public void save(String name) throws SequenceException {

		Hosting hosting = new Hosting();

		hosting.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		hosting.setName(name);
		hostingDao.save(hosting);

		System.out.println(hosting);

	}

}