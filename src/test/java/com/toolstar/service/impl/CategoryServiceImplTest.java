package com.toolstar.service.impl;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.codahale.metrics.Timer;
import com.toolstar.mongodb.entity.Category;
import com.toolstar.service.CategoryService;
import com.toolstar.service.CommodityService;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.name;


public class CategoryServiceImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImplTest.class);

    private static final int MAX_ITERATIONS = 1000;

    //private Slf4jReporter logReporter;

    private static ConsoleReporter logReporter;

    private Timer timer;

    private static ApplicationContext context = new ClassPathXmlApplicationContext(
            new String[]{"applicationContext-mongodb.xml"});

    private CategoryService categoryService = context.getBean("categoryService", CategoryServiceImpl.class);
    private CommodityService commodityService = context.getBean("commodityService", CommodityService.class);

    @Before
    public void init() {
        MetricRegistry metricRegistry = new MetricRegistry();
//        this.logReporter = Slf4jReporter
//                .forRegistry(metricRegistry)
//                .outputTo(LOGGER)
//                .build();
        logReporter = ConsoleReporter.forRegistry(metricRegistry).build();
        timer = metricRegistry.timer(name(CategoryServiceImplTest.class, "timer"));
    }

    @Test
    public void testGetCategorys() {
        //logReporter.start(3, TimeUnit.SECONDS);
        //Repository categoryRepository = context.getBean(
        //"categoryMongoRepository", CategoryMongoRepository.class);
        //String tsNo = "0-0/1-0/2-0/3-9/4-8";
        //System.out.println(tsNo.length());
        //String tsNo = "0-0/1-0/2-0";
        //System.out.println(tsNo.length());
        //tsNo = "0-0/1-0";
        //System.out.println(tsNo.length());
        Timer.Context context = timer.time();
        Set<Category> categories = categoryService.getSubCategories("0-0/1-0/2-2");
        context.close();
        logReporter.report();
        Collection<Category> rtn = new ArrayList<Category>();
        for (Category category : categories) {
            //Timer.Context context = timer.time();
            getSubCategories(rtn, category);

//			for (Category subCategory : subCategories) {
//				Set<Category> subsubCategories = subCategory.getSubCategories();
//				for (Category subsubCategory : subsubCategories) {
//					Collection<Commodity> commodityGroups = commodityService
//							.getCommoditiesByPTsNo(subsubCategory.getTsNo());
            //rtn = CollectionUtils.union(rtn, subCategories);
//				}
//			}
        }

    }

    void getSubCategories(Collection<Category> rtn, Category category) {
        Set<Category> subCategories = category.getSubCategories();
        for (Category subCategory : subCategories) {
            System.out.println(subCategory.getCtgName());
            System.out.println(subCategory.getTsNo());
            rtn.add(subCategory);
            getSubCategories(rtn, subCategory);
        }
        //return rtn;

    }


}
