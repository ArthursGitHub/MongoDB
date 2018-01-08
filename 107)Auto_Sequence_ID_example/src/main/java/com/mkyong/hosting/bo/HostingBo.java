package com.mkyong.hosting.bo;

import com.mkyong.seq.exception.SequenceException;

public interface HostingBo {

	void save(String name) throws SequenceException;

}