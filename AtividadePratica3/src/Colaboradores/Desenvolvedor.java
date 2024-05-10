package Colaboradores;

public class Desenvolvedor extends Funcionario{
    private String linguagens;
    public Desenvolvedor() {}

    public Desenvolvedor(String nome, String matricula, float salario, String linguagens){
        super(nome, matricula, salario);
        this.linguagens = linguagens;
    }


    public String getLinguagens() {
        return linguagens;
    }
    public void setLinguagens(String linguagens) {
        this.linguagens = linguagens;
    }

    @Override
    public String toString() {
        System.out.println("\n--DESENVOLVEDOR--");
        return super.toString() + "\nLinguagens: " + linguagens + ".";
    }

    @Override
    public String trabalhar() {
        return "\nO Dev " + getNome()+ " esta aprendendo " + linguagens + ".";
    }

    @Override
    public String relatarProgresso() {
        return "\nO Dev " + getNome() + " esta desenvolvendo em" + linguagens + ".\n";
    }

    @Override
    public float calcularSalario() {
        return getSalario(); 
    }
}