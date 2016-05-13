package org.mel.tutorials.jpa.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.mel.tutorials.jpa.IDEntity;

@Entity
public class IDCard extends IDEntity {

	private String cardNo;

	@OneToOne(cascade=CascadeType.REFRESH, mappedBy="card")
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public IDCard() {
	}

	public IDCard(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Override
	public String toString() {
		return "IDCard [cardNo=" + cardNo + "]";
	}

}
