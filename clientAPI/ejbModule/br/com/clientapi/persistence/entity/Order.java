package br.com.clientapi.persistence.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TB_ORDER")
//@PrimaryKeyJoinColumn(name="ORDER_CONTROL_ID")
public class Order implements Serializable {

//	número controle - número aleatório informado pelo cliente.
//	data cadastro (opcional) 
//	nome - nome do produto
//	valor - valor monetário unitário produto
//	quantidade (opcional) - quantidade de produtos.
//	codigo cliente - identificação numérica do cliente.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3875152675206683438L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_CONTROL_ID")
	private Integer controlId;
	
	@Column(name="ORDER_DATE")
	private Date date;
	
	@Column(name="ORDER_PRODUCT_NAME")
	private String procuctName;
	
	@Column(name="ORDER_PRODUCT_VALUE")
	private Double value;
	
	@Column(name="ORDER_PRODUCT_QUANTITY")
	private Integer quantity;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "ORDER_CLIENT_ID", referencedColumnName = "CLIENT_ID")
	private Client client;
	
	
	
	
}
