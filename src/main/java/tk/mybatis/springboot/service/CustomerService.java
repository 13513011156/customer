package tk.mybatis.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.springboot.mapper.CustomerMapper;
import tk.mybatis.springboot.model.Customer;
import tk.mybatis.springboot.model.vo.UserVo;
import tk.mybatis.springboot.util.UUIDGenerator;

import java.util.List;

@Service
public class CustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;

	public PageInfo<Customer> findAll(Customer customer, UserVo user) {
		Example example = new Example(Customer.class);
		Example.Criteria criteria = example.createCriteria();
		if (customer.getName() != null && customer.getName().length() > 0) {
			criteria.andLike("name", "%" + customer.getName() + "%");
		}
		PageHelper.startPage(customer.getPage(),customer.getRows());
		List<Customer>list=customerMapper.selectByExample(example);
		return new PageInfo<Customer>(list);
	}

	public int delete(String id) {
		return customerMapper.deleteByPrimaryKey(id);
	}

	public Customer findById(String id) {
		return  customerMapper.selectByPrimaryKey(id);
	}

	public int savecustomer(Customer customer) {
		int k=0;
		if (customer.getId()!=null && !"".equalsIgnoreCase(customer.getId())) {//编辑
			return  customerMapper.updateByPrimaryKeySelective(customer);
		}else {//新增
			customer.setId(UUIDGenerator.getUUID());
			customer.setState("启动");
			k=customerMapper.insert(customer);
			return k;
		}
	}

	public List<Customer> findAll() {
		return customerMapper.selectAll();
	}

}
