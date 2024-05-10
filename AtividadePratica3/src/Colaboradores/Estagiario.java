package Colaboradores;

public class Estagiario extends Funcionario{
    private Float horasTrabalhadas;
    private String supervisor;

    public Estagiario(){}

    public Estagiario(String nome, String matricula, float salario, float horasTrabalhadas, String supervisor) {
        super(nome, matricula, salario);
        this.horasTrabalhadas = horasTrabalhadas;
        this.supervisor = supervisor;
    }


    public Float getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    public void setHorasTrabalhadas(Float horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
    @Override
    public String toString() {
        System.out.println("\nESTAGIARIO");
        return super.toString() + "\nHoras de Trabalho: " + horasTrabalhadas + 
                                    "\nSupervisor: " + supervisor;
    }


    @Override
    public String trabalhar() {
        return "\nO estagiario " + getNome() +
                 " aprendera todo o trabalho da empresa!";
    }

    @Override
    public String relatarProgresso() {
        return "\nO estagiario " + getNome() + 
                " esta sendo otimo, sob a supervisao do " + supervisor + ".\n";
    }

    @Override
    public float calcularSalario() {
        return getSalario() * horasTrabalhadas;
    }
}