package cn.bite.travel.service.impl;

import cn.bite.travel.dao.CategoryDao;
import cn.bite.travel.dao.impl.CategoryDaoImpl;
import cn.bite.travel.domain.Category;
import cn.bite.travel.service.CategoryService;
import cn.bite.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 旅游分类 业务接口实现
 * 最红优化 放入缓redis存
 */
public class CategoryServiceImpl implements CategoryService {
    //声明dao层对象
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        //每一次加载首页从数据库读取信息 数据库压力大
        //使用ridis技术 改进
        /**
         * 从jedisUtils 获取redis客户端对象
         */
        Jedis jedis = JedisUtil.getJedis();
        //获取客户端对象 操作redis数据库
        //先判断redis 是否存在 key category 的信息范围 返回set集合
        //查询 reids中 所有信息
        //Set<String> categorys = jedis.zrange("category", 0, -1);
        //改进 获取分类id
        Set<Tuple> categorys = jedis.zrangeWithScores("category",0,-1);


        List<Category> list = null;
        //判断当前 redis 是否存在 categorys
        if(categorys==null||categorys.size()==0){
            System.out.println("从数据库读取");
            //调用categorydao 查询mysql 返回信息
            list = categoryDao.findAll();
            //遍历集合 获取每一个category对象
            for(int i=0;i<list.size();i++){
                //将当前cid和cname存储到redis中
                jedis.zadd("category",list.get(i).getCid(),list.get(i).getCname());
            }
        }else{
            //不为空
            //创建一个list集合
            list = new ArrayList<Category>();
            //创建一个category对象
           /* Category category = new Category();
           for(String name:categorys){
               category.setCid(category.getCid());
               list.add(category);
           }*/

           for(Tuple tuple:categorys){
               Category category = new Category();
               category.setCname(tuple.getElement());
               category.setCid((int)tuple.getScore());
               //将分类的尸体对象添加list集合
               list.add(category);
           }
        }
        return list;
        //return categoryDao.findAll();
    }
}
