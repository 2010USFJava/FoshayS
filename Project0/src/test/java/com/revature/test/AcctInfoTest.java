package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.service.AcctInfo;

public class AcctInfoTest {

	@Test
	public void accountInfoTest() {
		AcctInfo ai = new AcctInfo(); 
		int count = 0;
		ai.accountInfo(count);
	}

}
