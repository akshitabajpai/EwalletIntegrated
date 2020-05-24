package com.capgemini.service;

import com.capgemini.dto.Login;
import com.capgemini.entities.WalletUser;

import java.util.List;



public  interface WalletUserService {
		boolean addAccount(WalletUser walletuser);
		List<WalletUser> getAllWalletUser();
		
		WalletUser saveUser(WalletUser user);
		WalletUser validateUser(Login userLogin);
		
	
}

