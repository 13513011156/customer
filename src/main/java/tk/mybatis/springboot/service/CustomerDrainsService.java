package tk.mybatis.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.mapper.CustomerDrainsMapper;
import tk.mybatis.springboot.mapper.CustomerMapper;
import tk.mybatis.springboot.model.Customer;
import tk.mybatis.springboot.model.CustomerDrains;

import java.util.Date;
import java.util.List;

@Service
public class CustomerDrainsService{

	@Autowired
	private CustomerDrainsMapper customerDrainsMapper;
	@Autowired
	private CustomerMapper customerMapper;

	/*找所有流失的用户*/
	public PageInfo<CustomerDrains> findAll(CustomerDrains customerDrains) {
		PageHelper.startPage(customerDrains.getPage(),customerDrains.getRows());
		if(!"".equalsIgnoreCase(customerDrains.getCustomerName()) && customerDrains.getCustomerName()!=null){
			Customer customer=new Customer();
			customer.setName(customerDrains.getCustomerName());
			customer=customerMapper.selectOne(customer);
			String customerId=customer.getId();
			if(!"" .equalsIgnoreCase(customerId)&& customerId!=null){
				customerDrains.setCustomerId(customerId);
			}
		}
		List<CustomerDrains> list=customerDrainsMapper.findAll(customerDrains);
		return new PageInfo<CustomerDrains>(list);
	}

	public int waitDrains(String id) {
		CustomerDrains customerDrains=new CustomerDrains();
		customerDrains.setId(id);
		customerDrains.setStatus("暂缓流失");
		return customerDrainsMapper.updateByPrimaryKeySelective(customerDrains);
	}

	public int okDrains(CustomerDrains customerDrains) {
		customerDrains.setStatus("确定流失");
		customerDrains.setDrainDate(new Date());
		customerDrains.setCustomerName(null);
		return customerDrainsMapper.updateByPrimaryKeySelective(customerDrains);
	}

	public CustomerDrains findById(String id) {
		return customerDrainsMapper.findById(id);
	}


}
