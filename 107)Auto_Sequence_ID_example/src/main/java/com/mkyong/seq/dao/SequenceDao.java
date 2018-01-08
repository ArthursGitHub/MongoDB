package com.mkyong.seq.dao;

import com.mkyong.seq.exception.SequenceException;

public interface SequenceDao {

	long getNextSequenceId(String key) throws SequenceException;

}