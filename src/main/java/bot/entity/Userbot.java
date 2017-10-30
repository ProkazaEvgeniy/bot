package bot.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "userbot")
public class Userbot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="first_name")
	private String firstName;

	@Column(name="has_bot")
	private Boolean hasBot;

	@Id
	@SequenceGenerator(name="USERBOT_ID_GENERATOR", sequenceName="userbot_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERBOT_ID_GENERATOR")
	private Integer id;

	@Column(name="id_t")
	private Integer idT;

	@Column(name="last_name")
	private String lastName;

	@Column(name="user_name")
	private String userName;

	public Userbot() {
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Boolean getHasBot() {
		return this.hasBot;
	}

	public void setHasBot(Boolean hasBot) {
		this.hasBot = hasBot;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdT() {
		return this.idT;
	}

	public void setIdT(Integer idT) {
		this.idT = idT;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}