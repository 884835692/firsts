package com.ljh.firsts.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;


/**
 * 
 * 
 * 
 **/
public class Product{


  /****/

  private Long id;


  /**商品名称**/

  private String name;


  /**商品价格**/

  private BigDecimal price;


  /**状态 0 下架  1 上架**/

  private Integer state;


  /****/

  private Date createTime;


  /****/

  private Date updateTime;


  /**商品描述**/

  private String desc;


  /**商品唯一标识**/
@NotNull()
  private Long productId;


  /**开始预售时间**/

  private Date startShowTime;


  /**商品描述图**/

  private String imgUrl;




  public void setId(Long id) { 
  }


  public Long getId() { 
  }


  public void setName(String name) { 
  }


  public String getName() { 
  }


  public void setPrice(BigDecimal price) { 
  }


  public BigDecimal getPrice() { 
  }


  public void setState(Integer state) { 
  }


  public Integer getState() { 
  }
  public String getCreateTimeString(){
      if (this.createTime == null) return "";
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      return simpleDateFormat.format(createTime);
  }

  public void setCreateTime(Date createTime) { 
  }


  public Date getCreateTime() { 
  }


  public void setUpdateTime(Date updateTime) { 
  }


  public Date getUpdateTime() { 
  }


  public void setDesc(String desc) { 
  }


  public String getDesc() { 
  }


  public void setProductId(Long productId) { 
  }


  public Long getProductId() { 
  }


  public void setStartShowTime(Date startShowTime) { 
  }


  public Date getStartShowTime() { 
  }


  public void setImgUrl(String imgUrl) { 
  }


  public String getImgUrl() { 
  }

}