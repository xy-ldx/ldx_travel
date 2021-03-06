package cn.itcast.travel.domain;

import java.util.Date;
import java.util.List;



import cn.itcast.travel.util.DateUtils;

public class OrdersAndProduct {
	 	private String id;
	    private String orderNum;
	   // @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	    private Date orderTime;
	    private String orderTimeStr;
	    private Integer orderStatus; //订单状态  0 未支付  1已支付
	    private String orderStatusStr;
	    private int peopleCount;
	    private Product product;
	    private List<Traveller> travellers;
	    private Member member;
	    private Integer payType;//支付方式 0 支付宝 1 微信 2其他
	    private String payTypeStr;
	    private String orderDesc;

	    
	    
	    
	    
	  
	   
	    private String productName; // 名称
	   
	    
	    private double productPrice; // 产品价格
	   

		

	 


	    public String getOrderNum() {
	        return orderNum;
	    }

	    public void setOrderNum(String orderNum) {
	        this.orderNum = orderNum;
	    }

	    public Date getOrderTime() {
	        return orderTime;
	    }

	    public void setOrderTime(Date orderTime) {
	        this.orderTime = orderTime;
	    }

	    public String getOrderTimeStr() {
	        if(orderTime!=null){
	            orderTimeStr= DateUtils.date2String(orderTime,"yyyy-HH-mm HH:mm:ss");
	        }
	        return orderTimeStr;
	    }

	    public void setOrderTimeStr(String orderTimeStr) {

	        this.orderTimeStr = orderTimeStr;
	    }

	    public int getOrderStatus() {
	        return orderStatus;
	    }

	    public void setOrderStatus(int orderStatus) {
	        this.orderStatus = orderStatus;
	    }

	    public String getOrderStatusStr() {
	        if(orderStatus!=null){
	            if(orderStatus==0){
	                orderStatusStr="未支付";

	            }else if(orderStatus==1){
	                orderStatusStr="已支付";

	            }
	        }
	        return orderStatusStr;
	    }

	    public void setOrderStatusStr(String orderStatusStr) {
	        this.orderStatusStr = orderStatusStr;
	    }

	    public int getPeopleCount() {
	        return peopleCount;
	    }

	    public void setPeopleCount(int peopleCount) {
	        this.peopleCount = peopleCount;
	    }

	    public Product getProduct() {
	        return product;
	    }

	    public void setProduct(Product product) {
	        this.product = product;
	    }

	    public List<Traveller> getTravellers() {
	        return travellers;
	    }

	    public void setTravellers(List<Traveller> travellers) {
	        this.travellers = travellers;
	    }

	    public Member getMember() {
	        return member;
	    }

	    public void setMember(Member member) {
	        this.member = member;
	    }

	    public Integer getPayType() {
	        return payType;
	    }

	    public void setPayType(Integer payType) {
	        this.payType = payType;
	    }

	    public String getPayTypeStr() {
	        if(payType!=null){
	            if(payType==0){
	                payTypeStr="支付宝";
	            }else if(payType==1){
	                payTypeStr="微信";
	            }else if(payType==2){
	                payTypeStr="其他";
	            }
	        }
	        return payTypeStr;
	    }

	    public void setPayTypeStr(String payTypeStr) {
	        this.payTypeStr = payTypeStr;
	    }

	    public String getOrderDesc() {
	        return orderDesc;
	    }

	    public void setOrderDesc(String orderDesc) {
	        this.orderDesc = orderDesc;
	    }
	    
	    
	    
	    
	    
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }
	    public double getProductPrice() {
	        return productPrice;
	    }

	    public void setProductPrice(double productPrice) {
	        this.productPrice = productPrice;
	    }


}
