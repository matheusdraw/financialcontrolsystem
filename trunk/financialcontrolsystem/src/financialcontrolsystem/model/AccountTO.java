package financialcontrolsystem.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountTO {

	private int id;
	private String name;
	private Float initialValue;
	private Date dateInitialValue;
	private SimpleDateFormat sdf;

	public AccountTO() {
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(Float initialValue) {
		this.initialValue = initialValue;
	}

	public void setDateInitialValue(String dateInitialValue) {

		try {
			this.dateInitialValue = sdf.parse(dateInitialValue);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getDateInitialValue() {
		String dateInitialValue = sdf.format(this.dateInitialValue);
		return dateInitialValue;
	}
}
