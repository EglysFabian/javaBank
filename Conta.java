package Programa;

public class Conta {
    
    private static int contadorDeNumeroConta = 1;
    
    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeNumeroConta;
        this.pessoa = pessoa;
        contadorDeNumeroConta += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    public String toString(){
        return "\nNúmero da conta:" + this.getNumeroConta()+
               "\nNome:" + this.pessoa.getNome() +
               "\nCPF:" + this.pessoa.getCpf() +
               "\nEmail:" + this.pessoa.getEmail()+
               "\nSaldo:" + Utils.doubleToString(this.getSaldo()) + 
               "\n";
    }
    public void depositar(Double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("Seu deposito foi realizado com sucesso!");
        }
        else{
            System.out.println("Não foi possível realizar o seu deposito.");       
        }
    }
    public void sacar(Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Seu saque foi realizado com sucesso!");
        }
        else{
            System.out.println("Não foi possível realizar o seu saque.");           
        }
    }
    public void tranferir(Conta contaDestino, Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo()- valor);
            contaDestino.saldo = contaDestino.getSaldo() + valor;
            System.out.println("Sua tranferencia foi realizada com sucesso!");
        }
        else{
            System.out.println("Não foi possível realizar o sua transferencia.");
        }
    }
}