package br.com.clientapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({ 
	@NamedQuery(name = "listOrder", query = "SELECT o FROM Order o "),
	@NamedQuery(name = "searchOrder", query = "SELECT o FROM Order o "
			+ "WHERE (:controlId is null OR o.controlId = :controlId) "
			+ "AND (:date is null OR o.date = :date) "
			+ "AND (:productName is null OR o.productName = :procuctName) "
			+ "AND (:productValue is null OR o.productValue = :productValue) "
			+ "AND (:productQuantity is null OR o.productQuantity = :productQuantity) "
			+ "AND (:totalValue is null OR o.totalValue = :totalValue) "
			+ "AND (:clientId is null OR o.client.id = :clientId) ")
})

@Entity
@Table(name="STORE_ORDER")
@XmlRootElement
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3875152675206683438L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ORDER")
	private Integer controlId;
	
	@Temporal(TemporalType.TIME)
	@Column(name="DT_ORDER")
	private Date date;
	
	//possível tabela de domínio para produto
	@Column(name="PRODUCT_NAME_ORDER")
	private String productName;
	
	@Column(name="PRODUCT_VALUE_ORDER")
	private Double productValue;
	
	@Column(name="PRODUCT_QUANTITY_ORDER")
	private Integer productQuantity;
	
	@Column(name="TOTAL_VALUE_ORDER")
	private Double totalValue;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID_CLIENT")
	private Client client;

	public Integer getControlId() {
		return controlId;
	}

	public void setControlId(Integer controlId) {
		this.controlId = controlId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductValue() {
		return productValue;
	}

	public void setProductValue(Double productValue) {
		this.productValue = productValue;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((controlId == null) ? 0 : controlId.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productQuantity == null) ? 0 : productQuantity.hashCode());
		result = prime * result + ((productValue == null) ? 0 : productValue.hashCode());
		result = prime * result + ((totalValue == null) ? 0 : totalValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (controlId == null) {
			if (other.controlId != null)
				return false;
		} else if (!controlId.equals(other.controlId))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productQuantity == null) {
			if (other.productQuantity != null)
				return false;
		} else if (!productQuantity.equals(other.productQuantity))
			return false;
		if (productValue == null) {
			if (other.productValue != null)
				return false;
		} else if (!productValue.equals(other.productValue))
			return false;
		if (totalValue == null) {
			if (other.totalValue != null)
				return false;
		} else if (!totalValue.equals(other.totalValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [controlId=" + controlId + ", date=" + date + ", procuctName=" + productName + ", productValue="
				+ productValue + ", productQuantity=" + productQuantity + ", totalValue=" + totalValue + ", client="
				+ client + "]";
	}
	
}
