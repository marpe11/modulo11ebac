public class ExercicioModulo13 {
    // Classe abstrata Pessoa
    public abstract class Pessoa {
        private String nome;

        // Construtor
        public Pessoa(String nome) {
            this.nome = nome;
        }

        // Getter e Setter para nome
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        // Método abstrato que as subclasses devem implementar
        public abstract void exibirInformacoes();
    }

    // Classe concreta PessoaFisica
    public class PessoaFisica extends Pessoa {
        private String cpf;

        // Construtor
        public PessoaFisica(String nome, String cpf) {
            super(nome);
            this.cpf = cpf;
        }

        // Getter e Setter para CPF
        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        @Override
        public void exibirInformacoes() {
            System.out.println("Nome: " + getNome());
            System.out.println("CPF: " + cpf);
        }
    }

    // Classe concreta PessoaJuridica
    public class PessoaJuridica extends Pessoa {
        private String cnpj;

        // Construtor
        public PessoaJuridica(String nome, String cnpj) {
            super(nome);
            this.cnpj = cnpj;
        }

        // Getter e Setter para CNPJ
        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }

        @Override
        public void exibirInformacoes() {
            System.out.println("Nome: " + getNome());
            System.out.println("CNPJ: " + cnpj);
        }
    }

}
