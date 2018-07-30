package tk.mybatis.springboot.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.springboot.model.Customer;
import tk.mybatis.springboot.model.vo.UserVo;
import tk.mybatis.springboot.service.CustomerService;
import tk.mybatis.springboot.util.ExcelUtil;
import tk.mybatis.springboot.util.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService ;

    @Autowired
    private ExcelUtil excelUtil;

    @RequestMapping(value="/findAll")
    @ResponseBody
    public Map<String, Object> findAll(Customer customer, Integer pageIndex, Integer pageSize, HttpServletRequest request){
        UserVo user=(UserVo) request.getSession().getAttribute("user");
        customer.setPage(pageIndex+1);
        customer.setRows(pageSize);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        PageInfo<Customer> customerPageInfo = customerService.findAll(customer,user);
        resultMap.put("data", customerPageInfo.getList());
        resultMap.put("total",customerPageInfo.getTotal());
        return resultMap;
    }


  @RequestMapping(value="/remove")
    @ResponseBody
    public JsonResult<Integer> delete(String id){
        int i=0;
        try{
            i= customerService.delete(id);
        }catch (Exception e){
            return new JsonResult<Integer>(e);
        }
        return new JsonResult<Integer>(i);
    }
 
  @RequestMapping(value="/findById")
    @ResponseBody
    public JsonResult<Customer> findById(String id){
        Customer customer=new Customer();
        try{
            customer= customerService.findById(id);
        }catch (Exception e){
            return new JsonResult<Customer>(e);
        }
        return new JsonResult<Customer>(customer);
    }

    @RequestMapping(value="/save")
    @ResponseBody
    public JsonResult<Integer> savecustomer(Customer customer){
        int i=0;
        try{
            i= customerService.savecustomer(customer);
        }catch (Exception e){
            return new JsonResult<Integer>(e);
        }
        return new JsonResult<Integer>(i);
    }


    @RequestMapping(value="/exportExcel" , method={RequestMethod.GET} )
    public String downLoginLogExcel(HttpServletRequest request , HttpServletResponse response, @RequestParam("type") int type){
        downloadFile(response, excelUtil.getExcel(type));
        return null;
    }

    /**
     * 下载文件
     * @param response
     * @param file
     */
    protected void downloadFile(HttpServletResponse response , File file) {

        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());

        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
