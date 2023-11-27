package product.model;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class ProductBean {
	private int num;
	
	@Length(min = 3,max = 10,message = "3~10자리 ")
	private String name;//3~10
	
	private String company;
	
	@NotEmpty(message = "파일 선택 안함")
	private String image;//파일 선택 안함, // 검정양복.jpg
	
	private int stock;
	
	@Min(value = 3000,message = "최소 3000원 이상")
	private String price;//최소 3000원 이상 
	
	private String category;
	
	@Length(min = 5,max = 10,message = "5~10자")
	private String contents;//5~10자리
	
	private int point;
	private String inputdate;
	
	private MultipartFile upload;
	
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		if(this.upload != null) { // 
			System.out.println(upload.getName()); //upload
			System.out.println(upload.getOriginalFilename()); // 검정양복.jpg
			image = upload.getOriginalFilename();
		}
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	
	
}