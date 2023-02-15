package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotNull //Verifica se o campo não está nulo
        @NotBlank //usa-se somente para campos String. verifica se o campo não está vazio nem nulo
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull //não usa @NotBlank, pq especialidade não é uma String
        Especialidade especialidade,
        @NotNull
        @Valid //diz para o BeanValidation que este atributo é um outro dto e nele vai ter anotações do BeanValidation que tb quero que ele valide.
                //pois é para ele validar também este outro objeto endereco como um dos meus atributos.
        DadosEndereco endereco) {
}
