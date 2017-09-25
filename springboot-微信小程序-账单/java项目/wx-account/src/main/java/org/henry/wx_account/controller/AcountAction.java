package org.henry.wx_account.controller;



import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.henry.wx_account.bean.Account;

import org.henry.wx_account.service.WxService;
import org.henry.wx_account.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ҵ��д��actin���ˣ������Ķ��߼��� �������Գ�ȡ��service��
 * @author henry
 *
 */
@Controller
public class AcountAction {

	@Autowired
    private WxService wxService;	
	Logger logger = LoggerFactory.getLogger(AcountAction.class);
	
	
     @SuppressWarnings("rawtypes")
	@Autowired
	RedisTemplate redisTemplate;
	



	
	
	
	
	@RequestMapping("/")
	public @ResponseBody List<Account> index(){
		
		List<Account> list = wxService.getAcountAll();
		logger.info("---------------index");
	
		 
		/* long expires_in =3600;
		 String token ="123f09dsf";
		 String value="3240fjds";
		 redisTemplate.opsForValue().set(token,value , expires_in, TimeUnit.SECONDS);
	
		*/
		return list;
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/wx_login")
	public @ResponseBody Map<String,String> wx_login(String code,String encryptedData,String iv ){
		Map<String,String> result=new HashMap<String, String>();
		logger.info("��¼");
		try {
			//�Ȳ�����encryptedData �����ٲ���
			if(StringUtils.isNotBlank(code)){
				
				
				Map<String, Object> sessionKeyAndOPenid = CommonUtil.getSessionKeyAndOPenid(code);
				//sessionKeyAndOPenid.get("openid");//�������ݿ⵽user_id
				//sessionKeyAndOPenid.get("session_key");
				//{openid=oCEcg0T6whakY-JCO3CZZniqoSLI, session_key=6EE4BK2TIYT/f9nmMmXMlA==, expires_in=7200}
				System.out.println(sessionKeyAndOPenid);
				String openid = sessionKeyAndOPenid.get("openid").toString();
				//����openid ��Ϊuser_id ע���û�
				 wxService.insertOrUpdate(openid);
				
				String session_key =  sessionKeyAndOPenid.get("session_key").toString();
				String expires_in_str = sessionKeyAndOPenid.get("expires_in").toString();
				String seek=openid+"###"+session_key;
				String token = CommonUtil.creatToken(seek);
				Long expires_in = Long.valueOf(expires_in_str);
				
				redisTemplate.opsForValue().set(token,seek, expires_in-1000, TimeUnit.SECONDS);
				
				result.put("token", token);
				result.put("status", "ok");
			}else{
				result.put("msg", "code null");
				result.put("status", "error");
			}
		} catch (Exception e) {
			result.put("status","error");
			result.put("msg", "��¼ʧ�ܣ�");
			logger.error("��¼ʧ��",e);
			
		}
		
		
		return result;
		
	}
	
	
	@RequestMapping("/wx_check")
	public @ResponseBody Map<String,String> wx_check(String token){
		logger.info("check",token);
		
	Map<String,String> result=new HashMap<String, String>();
		
		try {
			//�Ȳ�����encryptedData �����ٲ���
			if(StringUtils.isNotBlank(token)){
				
				
		
				
				Object t = redisTemplate.opsForValue().get(token);
				
				if(t !=null){
					
					result.put("status","ok");
					result.put("msg", "��֤�ɹ�");
				}
				
				
			}
		} catch (Exception e) {
			result.put("status", "error");
			result.put("msg", "��֤ʧ�ܣ�");
			logger.error("��¼ʧ��",e);
			
		}
		
		
		return result;
		
	}
	

	
	
	
	
	
/*	@RequestMapping("/test")
	public  @ResponseBody String test_(){
		Map<String, String> sessionKeyAndOPenid = CommonUtil.getSessionKeyAndOPenid("code");
		
		String sessionKeyBody = CommonUtil.getSessionKeyBody("code");
		String creatToken = CommonUtil.creatToken("123");
		
		System.out.println(sessionKeyAndOPenid);
		System.out.println(sessionKeyBody);
		System.err.println(creatToken);
		return sessionKeyBody;
	}
	*/
	
	

	@RequestMapping("/account/add")
	public @ResponseBody Map<String,Object> addAccount(String token,String type,String money,String remark){
		Map<String,Object> result = new HashMap<String, Object>();
		
		logger.info("����");
		
		try {
			Object t = redisTemplate.opsForValue().get(token);
			
			if(t ==null){
				result.put("status","error");
				result.put("msg", "login");
			}
			
			String value = (String) t;
			String openid = value.split("###")[0];
			
			int money_int = 0;
			if(StringUtils.isNotBlank(money)){
				
				Integer v = Integer.valueOf(money);
				money_int = v;
			}
			
			if(StringUtils.isBlank(type)){
				type="����";
			}
			
			if(StringUtils.isBlank(remark)){
				type="�ޱ�ע";
			}

			Account account = new Account();
			account.setUserId(openid);
			account.setMoney(money_int);
			account.setType(type);
			account.setRemark(remark);
			
			
			wxService.add(account);
			
			result.put("status","ok");
			result.put("msg", "�����ɹ�");
		} catch (Exception e) {
			result.put("status","error");
			result.put("msg","����ʧ�ܣ�");
			logger.error("����ʧ��",e);
		}
		
		
		return result;
		
	}
	
	
	
	

	
	@RequestMapping("/account/get")
	public  @ResponseBody Map<String,Object> getAccount(String token,String type,String startTime_str,String endTime_str){
		Map<String,Object> result = new HashMap<String, Object>();
		logger.info("��ѯ");
	//��֤token
		try {
			Object t = redisTemplate.opsForValue().get(token);
			
			if(t ==null){
				result.put("status", "error");
				result.put("msg", "login");
			}
			
			String value = (String) t;
			String openid = value.split("###")[0];
			
			String start_date =null;
			String end_date =null;
			
			if(StringUtils.isNotBlank(startTime_str)){
				
			}
			if(StringUtils.isNotBlank(endTime_str)){
				
			}
			 /**
			    * 2017-08-08 22:23:01 ʱ���ʽ
			    */
			
			if(StringUtils.isBlank(type)){
				type=null;
			}
			
			List<Account> list = wxService.getAccountBy(openid,type,start_date,end_date);
			if(list !=null && list.size()>0){
				for(Account a :list){
					
	//				a.setCreateDateStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(a.getCreateDate()));
					a.setCreateDateStr(new SimpleDateFormat("yyyy-MM-dd").format(a.getCreateDate()));
				}
			}
			result.put("status","ok");
			result.put("msg", "��ѯ�ɹ�");
			result.put("data", list);
		} catch (Exception e) {
			result.put("status", "error");
			result.put("msg", "��ѯʧ��");
			logger.error("��ѯʧ��",e);
		}
		
		return result;
		
	}
	
	
}
