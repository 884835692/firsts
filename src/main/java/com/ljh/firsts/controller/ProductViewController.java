package com.ljh.firsts.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljh.firsts.model.Product;
import com.ljh.firsts.service.ProductService;
import com.ljh.firsts.utils.CommonQueryBean;

@Controller
@RequestMapping("/productview")
public class ProductViewController {
	 @Autowired
	    private ProductService productService;
	 @RequestMapping("/add")
	    public String add() {
	        return "add";
	    }
	    //添加实际的业务逻辑
	    @RequestMapping("/addProduct")
	    public String listUser(@Valid Product product, BindingResult bindingResult, Model model) throws Exception {
	        int result = productService.insert(product);
	        if (result < 0) {
	            model.addAttribute("resutl", result);
	        }
	        return "redirect:listProduct";
}
	    //删除
	    @RequestMapping("/deleteProduct")
	    public String deleteUser(Long id) throws Exception {
	        productService.deleteByPrimaryKey(id);
	        return "redirect:listProduct";
	    }
	    //查找(用于单个查询)
	    @RequestMapping("/getProduct")
	    public String getProduct(Long id, Model model) throws Exception {
	        Product product = productService.selectByPrimaryKey(id);
	        model.addAttribute("product", product);
	        return "productShow";
	    }
	    //分页遍历，默认每页3条
	    @RequestMapping("/listProduct")
	    public String listProduct(@RequestParam(value = "name",defaultValue = "") String name,
	                           Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
	                           @RequestParam(value = "pageSize", defaultValue = "3") int pageSize) throws Exception {
	        Product record = new Product();
	        if (StringUtils.isNotEmpty(name)) {
	            record.setName(name);
	            model.addAttribute("name", name);
	        }
	        //计算总数量
	        long total = productService.count(record);
	        //计算总页数
	        int totalPageNum = (int)total / pageSize;
	        if (total % pageSize > 0) totalPageNum ++;
	        //分页相关参数
	        CommonQueryBean query= new CommonQueryBean();
	        query.setPageSize(pageSize);
	        query.setPageNum(pageNum);
	        query.setStart((pageNum-1) * pageSize);
	        List<Product> list = productService.list4Page(record, query);
	        model.addAttribute("total", total);
	        model.addAttribute("totalPage", totalPageNum);
	        model.addAttribute("list", list);
	        model.addAttribute("pageSize", pageSize);
	        model.addAttribute("pageNum", pageNum);        
	        return "index";
	    }
	    //修改
	    @RequestMapping("/update")
	    public String updateUser(Long id, Model model) throws Exception {
	        Product product = productService.selectByPrimaryKey(id);
	        model.addAttribute("product", product);
	        return "update";
	    }
	    //修改实际的业务逻辑
	    @RequestMapping("/updateProduct")
	    public String findUser(Product product) throws Exception {
	        productService.updateItem(product);
	        return "redirect:listProduct";
	    }
	    @RequestMapping(value = "/queryByOrderNo", method = RequestMethod.GET)
	    @ResponseBody
	    public List<Product> queryByOrderNo(String orderNo) {
	        List<Product> list = productService.listByOrderNo(orderNo);
	        //为了避免查询不出数据导致的返回数据空白
	        if (CollectionUtils.isEmpty(list)) {
	            list = new ArrayList<Product>();
	        }
	        return list;
	    }
}
