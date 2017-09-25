package org.henry.wx_account.service;


import java.util.Date;
import java.util.List;

import org.henry.wx_account.bean.Account;
import org.henry.wx_account.bean.QueryAccount;
import org.henry.wx_account.dao.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WxService {
	@Autowired
	AccountMapper accountMapper;

	public List<Account> getAcountAll() {
		
		return accountMapper.getAll();
	}

	@Transactional
	public void insertOrUpdate(String openid) {
		
		List<Account> list  = accountMapper.queryByUserId(openid);
		if(list ==null && list.size()>0){
			Account account = new Account();
			account.setCreateDate(new Date());
			account.setType("添加用户");
			account.setMoney(0);
			account.setUserId(openid);
			account.setRemark("注册用户");
			accountMapper.insert(account);
		}
		
		
	}

	public List<Account> getAccountBy(String openid, String type, String start_date, String end_date) {
		
		QueryAccount q = new QueryAccount();
		q.setUserId(openid);
		q.setType(type);
		q.setStart_date(start_date);
		q.setEnd_date(end_date);
		
		return accountMapper.queryBy(q);
	}

	public void add(Account account) {
		
		accountMapper.insert(account);
	}
	
	
	
	
}
