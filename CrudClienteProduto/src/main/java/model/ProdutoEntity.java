package model;

public class ProdutoEntity {
	private int codigoProduto;
	private String nomeProduto;
	private Double vlrProduto;
	
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public Double getVlrProduto() {
		return vlrProduto;
	}
	public void setVlrProduto(Double vlrProduto) {
		this.vlrProduto = vlrProduto;
	}
	
}
