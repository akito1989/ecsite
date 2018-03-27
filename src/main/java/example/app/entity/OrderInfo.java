package example.app.entity;

import java.sql.Date;

public class OrderInfo {
	    private Integer code;

	    private Date date;

	    private Integer codeNumber;

	    private String name;

	    private String email;

	    private String postal1;

	    private String postal2;

	    private String address;

	    private String tel;

	    private Integer codeSales;

	    private Integer codeProduct;

	    private Integer price;

	    private Integer quantity;



	    public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}

		public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public Integer getCodeNumber() {
	        return codeNumber;
	    }

	    public void setCodeNumber(Integer codeNumber) {
	        this.codeNumber = codeNumber;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPostal1() {
	        return postal1;
	    }

	    public void setPostal1(String postal1) {
	        this.postal1 = postal1;
	    }

	    public String getPostal2() {
	        return postal2;
	    }

	    public void setPostal2(String postal2) {
	        this.postal2 = postal2;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getTel() {
	        return tel;
	    }

	    public void setTel(String tel) {
	        this.tel = tel;
	    }


	    public Integer getCodeSales() {
	        return codeSales;
	    }

	    public void setCodeSales(Integer codeSales) {
	        this.codeSales = codeSales;
	    }

	    public Integer getCodeProduct() {
	        return codeProduct;
	    }

	    public void setCodeProduct(Integer codeProduct) {
	        this.codeProduct = codeProduct;
	    }

	    public Integer getPrice() {
	        return price;
	    }

	    public void setPrice(Integer price) {
	        this.price = price;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }


}
