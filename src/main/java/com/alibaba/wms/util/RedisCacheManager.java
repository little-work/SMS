package com.alibaba.wms.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;


public class RedisCacheManager {

		
		public RedisTemplate<String, Object> redisTemplate;

	    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
	        this.redisTemplate = redisTemplate;
	    }
	    
	    /**
	     * 判断key存不存在
	     * @param key
	     * @return
	     */
	  public boolean isKeyExit(String key){
		  try {
	            return redisTemplate.hasKey(key);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
		  
	  }
	  /**
	   * 通过键获取值
	   * @param key
	   * @return
	   */
	  public String getValue(String key){
		  return (String) redisTemplate.boundValueOps(key).get();
	  }
	  /**
	   * redis存放键值对
	   * @param key
	   * @param value
	   */
	  
	  public void setKeyVaule(String key,String value){
		  redisTemplate.opsForValue().set(key, value);
	  }

	/*   
	 public static void main(String[] args) {
	    	ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-redis.xml");
	        final RedisTemplate<String, Object> redisTemplate = appCtx.getBean("redisTemplate",RedisTemplate.class);
	       redisTemplate.opsForValue().set("lilin", DigestUtils.md5Hex("123456"));
	        
	        //添加一个 key 
	       // ValueOperations<String, Object> value = redisTemplate.opsForValue();
	        //value.set("lp", "hello word");
	        
	        
	        //获取 这个 key 的值
	        System.out.println((String) redisTemplate.boundValueOps("ifremember").get());
	        //System.out.println(redisTemplate.hasKey("lilin"));
	      
	    	
		}
	  */
	  
	  
	  
	    
}
