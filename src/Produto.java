public class Produto {
    String Nome;
    String Marca;
    String CodigoBarra;
    Double PrecoUnitario;
    private int QtdeEstoque;
    
    public Double VenderProduto(int qtdeVenda)
    {
        Double ValordaVenda = PrecoUnitario*qtdeVenda;
        DebitarEstoque(qtdeVenda);
        return ValordaVenda;
    }
    
    public int SaldoEstoque()
    {
        return QtdeEstoque;
    }
    // Aplica um ajuste no preço (positivo/negativo)
    // Atenção: Passar o PERCENTUAL do Reajuste
    // Devolve: O preço já corrigido.
    public Double AjustarValorEmPercentual(Double ajuste)
    {
         Double Calculo =(PrecoUnitario / 100) * ajuste;
         PrecoUnitario += Calculo; // altera o preço
         return PrecoUnitario;
    }


    // Retirar uma qtde X do estoque.
    // a funçao nao valida o valor passado
    public void DebitarEstoque(int qtde)
    {
        QtdeEstoque = QtdeEstoque - qtde;
        AlertaEstoqueMinimo(); 
    }
    public void CreditarEstoque(int qtde)
    {
        QtdeEstoque = QtdeEstoque + qtde;
    }

    
    // Seta nova informação de estoque
    public void setEstoque(int qtde)
    {
       if (qtde < 0)
       System.out.println("Para reduzir o estoque use DEBITARestoque");
       else this.QtdeEstoque   =  qtde;
    }

    public int getEstoque()
    {
      return this.QtdeEstoque; 
    }
    // Alertar quando o estoque ABAIXO do MINIMO for atingido
    public  void AlertaEstoqueMinimo()
    {
        
        System.out.println("Atenção. Comprar mais de "
            +this.Nome);
    }
}
