package Colaboradores;

public class Gerente extends Funcionario{
    private String equipeGerenciada;
    private float bonus;
    public Gerente() {}

    public Gerente(String nome, String matricula, float salario, String equipeSobGerencia, float bonus) {
        super(nome, matricula, salario);
        this.equipeGerenciada = equipeSobGerencia;
        this.bonus = bonus;
    }


    public String getEquipeGerenciada() {
        return equipeGerenciada;
    }
    public void setEquipeGerenciada(String equipeSobGerencia) {
        this.equipeGerenciada = equipeSobGerencia;
    }


    public float getBonus() {
        return bonus;
    }
    public void setBonus(float bonus) {
        this.bonus = bonus;
    }


    @Override
    public String toString() {
        System.out.println("\nGERENTE");
        return super.toString() + "\nEquipe sob Gerencia: " + equipeGerenciada + "\nBonus Anual: " + bonus + ".";
    }

    @Override
    public String trabalhar() {
        
        return "\nO Gerente " + getNome() + " esta trabalhando em varios projetos ";
    }

    @Override
    public String relatarProgresso() {
        return "\nO Gerente " + getNome() + " este gerenciando a equipe " + equipeGerenciada +".\n";
    }

    @Override
    public float calcularSalario() {
        return getSalario() + getBonus();
    }
}