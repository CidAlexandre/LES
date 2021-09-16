package com.pethouse.api.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.pethouse.api.dao.IDAO;
import com.pethouse.api.dao.address.AddressDAO;
import com.pethouse.api.dao.creditcard.CreditCardDAO;
import com.pethouse.api.dao.customer.CustomerDAO;
import com.pethouse.api.domain.model.Address;
import com.pethouse.api.domain.model.CreditCard;
import com.pethouse.api.domain.model.Customer;
import com.pethouse.api.strategy.IStrategy;
import com.pethouse.api.strategy.UpdateFields;
import com.pethouse.api.strategy.address.AddressConstraints;
import com.pethouse.api.strategy.creditcard.CreditCardConstraints;
import com.pethouse.api.strategy.customer.CustomerConstraints;
import com.pethouse.api.strategy.customer.CustomerUpdatePassword;

public abstract class AbstractFacade {
	
	protected Map<String, IDAO> daos = new HashMap<>();
	protected Map<String, Map<String, List<IStrategy>>> businessRule = new HashMap<>();
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private AddressDAO addressDAO;

	@Autowired
	private CreditCardDAO creditCardDAO;
	
	@Autowired
	private CustomerConstraints customerConstraints;

	@Autowired
	private CustomerUpdatePassword customerUpdatePassword;
	
	@Autowired
	private UpdateFields updateFields;
	
	@Autowired
	private AddressConstraints addressConstraints;
	
	@Autowired
	private CreditCardConstraints cardConstraints;
	
	public void initialize() {
		
		//-------------------------Hash Customer-------------------------//
		
		daos.put(Customer.class.getName(), customerDAO); 
		
		List<IStrategy> bnsRulesCustomer = new ArrayList<>();
		List<IStrategy> bnsRulesPasswordCustomer = new ArrayList<>();
		List<IStrategy> bnsRulesUpdateCustomer = new ArrayList<>();
		
		bnsRulesCustomer.add(customerConstraints);
		bnsRulesPasswordCustomer.add(customerUpdatePassword);
		bnsRulesUpdateCustomer.add(updateFields);
		
		Map<String, List<IStrategy>> mapKeyCustomer = new HashMap<>();
		
		mapKeyCustomer.put("CREATE", bnsRulesCustomer);
		mapKeyCustomer.put("UPDATE", bnsRulesUpdateCustomer);
		mapKeyCustomer.put(null, bnsRulesPasswordCustomer);
		
		businessRule.put(Customer.class.getName(), mapKeyCustomer);
		
		//-------------------------Hash Address-------------------------//
		
		daos.put(Address.class.getName(), addressDAO);
		
		List<IStrategy> bnsRulesAddress = new ArrayList<>();
		List<IStrategy> bnsRulesUpdateAddress = new ArrayList<>();
		
		bnsRulesAddress.add(addressConstraints);
		bnsRulesUpdateAddress.add(addressConstraints);
		
		Map<String, List<IStrategy>> mapkeyAddress = new HashMap<>();
		
		mapkeyAddress.put("CREATE", bnsRulesAddress);
		mapkeyAddress.put("UPDATE", bnsRulesUpdateAddress);
		
		businessRule.put(Address.class.getName(), mapkeyAddress);
		
		//-------------------------Hash CreditCard-------------------------//
	
		daos.put(CreditCard.class.getName(), creditCardDAO);
		
		List<IStrategy> bnsRulesCreditCard = new ArrayList<>();
		List<IStrategy> bnsRulesUpdateCreditCard = new ArrayList<>();
		
		bnsRulesCreditCard.add(cardConstraints);
		bnsRulesUpdateCreditCard.add(cardConstraints);
		
		Map<String, List<IStrategy>> mapKeyCreditCard = new HashMap<>();
		
		mapKeyCreditCard.put("CREATE", bnsRulesCreditCard);
		mapKeyCreditCard.put("UPDATE", bnsRulesUpdateCreditCard);
		
		businessRule.put(CreditCard.class.getName(), mapKeyCreditCard);
	}
	
}
