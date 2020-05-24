package com.capgemini.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entities.WalletUser;
import com.capgemini.service.WalletUserService;
import com.capgemini.daos.WalletUserDao;
import com.capgemini.dto.Login;
import com.capgemini.exception.TransactionException;

@Service
@Transactional
public class WalletUserServiceImpl implements WalletUserService {

	
	@Autowired
	private WalletUserDao walletuserdao;

	@Override
	public List<WalletUser> getAllWalletUser() {
		// TODO Auto-generated method stub
		return walletuserdao.findAll();
	}
	
	@Override
	public WalletUser saveUser(WalletUser user) {
		return walletuserdao.save(user);
	}

	@Override
	public boolean addAccount(WalletUser walletuser) {
	
		WalletUser accountResult= walletuserdao.save(walletuser);
		if(accountResult!=null) {
			return true;
		}
		else
			return false;
	}
	
	@Override
	public WalletUser validateUser(Login userLogin) throws TransactionException{
		
		Optional<WalletUser> optionalUser= walletuserdao.LoginDetails(userLogin.getUsername());
		WalletUser user;
		if(optionalUser.isPresent()) {
			user=optionalUser.get();
			if(user.getPass().equals(userLogin.getPass())){
				return user;
			}
			throw new TransactionException("Incorrect Password");
			
		}
		else
			throw new TransactionException("Incorrect User Name");
			
		

	}

	

	
	
}
