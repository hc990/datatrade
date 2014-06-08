package com.toolstar.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.opensymphony.xwork2.ActionSupport;
import com.toolstar.mongodb.entity.Category;
import com.toolstar.mongodb.entity.Commodity;
import com.toolstar.service.CategoryService;
import com.toolstar.service.CommodityService;

public class CommodityController extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4321057574563375286L;

	Page<Commodity> commoditys;

	@Autowired
	CategoryService categoryService;  

	@Autowired
	CommodityService commodityService;

	private String tsNo;

	private Collection<Commodity> rtn = new ArrayList<Commodity>();

	/**
	 * @author huangchong
	 * @since 2014.2.22 <th>商品名称</th> <th>分类</th> <th>品牌</th> <th>价格</th> <th>图片
	 *        </th> <th>创建时间</th>
	 **/
	public String search() throws Exception {
		// TODO Auto-generated method stub
		Set<Category> categories = categoryService.getSubCategories(tsNo);
		//Collection<Commodity> rtn = new ArrayList<Commodity>();
		for (Category category : categories) {
			Set<Category> subCategories = category.getSubCategories();
			for (Category subCategory : subCategories) {
				Set<Category> subsubCategories = subCategory.getSubCategories();
				for (Category subsubCategory : subsubCategories) {
					Collection<Commodity> commodityGroups = commodityService
							.getCommoditiesByPTsNo(subsubCategory.getTsNo());
					rtn = CollectionUtils.union(rtn, commodityGroups);
				}
			}
		}
		return SUCCESS;
	}

	public Page<Commodity> getCommoditys() {
		return commoditys;
	}


	public Collection<Commodity> getRtn() {
		return rtn;
	}

	public void setRtn(Collection<Commodity> rtn) {
		this.rtn = rtn;
	}

	public String getTsNo() {
		return tsNo;
	}

	public void setTsNo(String tsNo) {
		this.tsNo = tsNo;
	}

}
