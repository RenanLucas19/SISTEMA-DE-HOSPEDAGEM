import java.util.ArrayList;
import java.util.Scanner;

public class Quarto{
    private boolean Disponibilidade;
    private String Localizacao;
    private float preco;
    private int Numero_do_quarto;
    
    public Quarto(boolean disponibilidade, String localizacao, float preco, int numero_do_quarto) {
        this.Disponibilidade = disponibilidade;
        this.Localizacao = localizacao;
        this.preco = preco;
        this.Numero_do_quarto = numero_do_quarto;
    }

    public boolean isDisponibilidade() {
        return Disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        Disponibilidade = disponibilidade;
    }

    public String getLocalizacao() {
        return Localizacao;
    }

    public void setLocalizacao(String localizacao) {
        Localizacao = localizacao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getNumero_do_quarto() {
        return Numero_do_quarto;
    }

    public void setNumero_do_quarto(int numero_do_quarto) {
        Numero_do_quarto = numero_do_quarto;
    }

    public String toString(){
        return "Esta disponivel: " + Disponibilidade +
                "Esta localizado: " + Localizacao +
                "O numero do quarto é o: " + Numero_do_quarto +
                "O valor do quarto é de: R$ " + preco;
    }

    public void CadastrandoQuarto(ArrayList<Quarto>AdcionandoQuarto){
        Scanner ler = new Scanner(System.in);
        AdcionandoQuarto = new ArrayList<>();

        System.out.println("Informe o quarto que deseja cadastrar: ");
        Numero_do_quarto = ler.nextInt();
        
        System.out.println("Informe a disponibilidade do quarto: ");
        String disponibilidade = ler.next();
        Disponibilidade = disponibilidade.equalsIgnoreCase("sim");
        
        System.out.println("Qual a localização do quarto: ");
        Localizacao = ler.nextLine();
        
        System.out.println("Informe qual o valor do quarto: ");
        preco = ler.nextFloat();

        Quarto quartos = new Quarto(Disponibilidade, disponibilidade, preco, Numero_do_quarto);

        AdcionandoQuarto.add(quartos);

        ler.close();
    }

    public String BuscarQuarto(ArrayList<Quarto> quartos, int numeroDoQuarto){
        for(Quarto quarto : quartos){
            if(quarto.getNumero_do_quarto() == numeroDoQuarto){
                return quarto.toString();//retorna o quarto se encontrar a reserva
            }
        }
        return null;//retorna null se a reserva não for encontrada
    }
    
    public void EditarQuarto(ArrayList<Quarto> quartos, int numerDoQuarto){
        Scanner modificar = new Scanner(System.in);

        for(Quarto quarto : quartos){
            if(quarto.getNumero_do_quarto() == numerDoQuarto){
                System.out.println("Informe a nova disponibilidade do quarto: ");
                String disponibilidade = modificar.next();
                boolean NovaDisponibilidade = disponibilidade.equalsIgnoreCase("nao");

                System.out.println("Informe a nova localizacao do quarto: ");
                String NovaLocalizacao = modificar.next();

                System.out.println("Informe o novo valor do quarto: ");
                float NovoPreco = modificar.nextFloat();

                quarto.setDisponibilidade(NovaDisponibilidade);
                quarto.setLocalizacao(NovaLocalizacao);
                quarto.setPreco(NovoPreco);

                System.out.println("Informacoes do quarto atualizados com sucesso!!!");
                modificar.close();

                return;
            }
        }
    }
}