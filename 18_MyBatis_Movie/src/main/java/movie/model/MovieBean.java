package movie.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class MovieBean {
	private int num;
	
	@NotEmpty(message = "��ȭ ������ �Է��ϼ���")
	private String title;
	
	@NotEmpty(message = "����� �Է��ϼ���")
	private String continent;
	
	@NotEmpty(message = "���� �Է��ϼ���")
	private String nation;
	
	@NotNull(message = "�帣�� �����ϼ���")
	private String genre;
	
	@NotNull(message = "����� �����ϼ���")
	private String grade;
	
	@NotEmpty(message = "�⿬ ��츦 �Է��ϼ���")
	private String actor;
	
	public MovieBean() {
		
	}
	
	public MovieBean(int num, String title, String continent, String nation, String genre, String grade, String actor) {
		super();
		this.num = num;
		this.title = title;
		this.continent = continent;
		this.nation = nation;
		this.genre = genre;
		this.grade = grade;
		this.actor = actor;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	
}
