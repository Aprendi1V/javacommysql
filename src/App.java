import java.sql.SQLException;
import java.util.Scanner;

public class App {

    public static  Produto produtogeral;
    public static void main(String[] args) throws Exception {
       
        // Testa o banco de dados
        ConexaoMysql db1 = new ConexaoMysql();
        String sql = " create table cidade if not exists "+
                        " ( cd_cidade int primary key auto_increment,"
                        +"  nome varchar(200))";
        db1.OpenDatabase();
        db1.ExecutaQuery(sql);

        sql = " insert into cidade "+
                        " ( nome) values ('Rio de Janeiro')";
        db1.ExecutaQuery(sql);
        db1.CloseDatabase();


        // Produto produtogeral;
        produtogeral = new Produto();
        char resposta = ' '; 
        Scanner Tecla = new Scanner(System.in);

        while (resposta != 'S')
        {
           ExibirMenu();
           resposta = Tecla.next().charAt(0);
           switch (resposta)
           {
            case 'E':  // entrada de estoque;
            case 'e':
                    EntradaEstoque(Tecla); 
            break; 
            case 'P':
            case 'p':
                      CadastrarProduto(Tecla);
            break;
            case  'A':
            case 'a':
                    SaldoEstoque();
            break;
         } // fim case
        } 

   

        Tecla.close(); 
       
    }
    private static void SaldoEstoque() {

        
    }
    private static void CadastrarProduto(Scanner Tecla2) throws SQLException {
        // dados iniciais do produto
        System.out.println("Código do produto: ");
        String Aux = Tecla2.next(); Tecla2.nextLine();
        produtogeral.CodigoBarra = Aux;
        System.out.println("Nome do produto: ");
        Aux = Tecla2.next(); Tecla2.nextLine();
        produtogeral.Nome = Aux;
        System.out.println("Marca: ");
        Aux = Tecla2.next(); Tecla2.nextLine();
        produtogeral.Marca = Aux;
        // preço, qtde, estominimo
        System.out.println("Preço unitário: ");
        Aux = Tecla2.next(); Tecla2.nextLine();
        Aux = Aux.replaceAll(",", ".");
        Double Valor = Double.parseDouble(Aux);
        produtogeral.PrecoUnitario = Valor;
        
        System.out.println("Estoque inicial: ");
        Aux = Tecla2.next(); Tecla2.nextLine();
        int Aux2 = Integer.parseInt(Aux);
        produtogeral.CreditarEstoque(Aux2);

        System.out.println("Estoque mínimo: ");
        Aux = Tecla2.next(); Tecla2.nextLine();
        Aux2 = Integer.parseInt(Aux);
       

       

        // System.out.println("Produto inserido com sucesso!");
    }
    private static void EntradaEstoque(Scanner Tecla2)
    {
        System.out.println("Qual a qtde? ");
        int Qtde = Tecla2.nextInt();
        Tecla2.nextLine();
        produtogeral.CreditarEstoque(Qtde);

        System.out.println("\nEstoque atualizado! ");
    }

    private static void TesteEstoque()
    {
        produtogeral.setEstoque(100);
    }

    private static void Teste()
    {
  
        Produto Produto1;
        Produto1 = new Produto();

        Produto1.Nome = "Extrato de Tomate";
        Produto1.Marca = "Cica";
        Produto1.setEstoque(100); 

        // Seta o preço do produto e depois ajusta
        // em 5%
        Produto1.PrecoUnitario = 1000.0;
        System.out.println("Produto: "+Produto1.Nome
                    +"\nEstoque: "+Produto1.getEstoque()
                    +"\nPreço: "+Produto1.PrecoUnitario);
        // Ajustar
        Produto1.AjustarValorEmPercentual(5.00);
        System.out.println("\nApós ajustar em 5% "
                     +"\nPreço: "+Produto1.PrecoUnitario); 
         // Vender Produto
         Double Total = Produto1.VenderProduto(12);
         System.out.println("\nVendi 12 unidades. "
                  +"\nValor total: "+Total
                  +"\nEstoque atual: "+Produto1.SaldoEstoque()); 

    }
    
    private static void ExibirMenu() {
        System.out.println(
            "\n========== MENU OPÇÕES ========="
            +"\nP - Cadastrar Produto"
            +"\nE - Entrada Estoque"
            +"\nQ - Saída Estoque"
            +"\nA - Saber Estoque atual"
            +"\nV - Vender Produto"
            +"\nS - Sair do sistema"
            +"\n================================");
    }
}
