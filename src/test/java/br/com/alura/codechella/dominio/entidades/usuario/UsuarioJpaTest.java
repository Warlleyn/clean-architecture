package br.com.alura.codechella.dominio.entidades.usuario;

import br.com.alura.codechella.dominio.entidades.FabricaUsuario;
import br.com.alura.codechella.dominio.entidades.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Objects;

public class UsuarioJpaTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNulloOuNoFormatoInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99", "teste", LocalDate.parse("1990-09-08"), "teste@.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(null, "teste", LocalDate.parse("1990-09-08"), "teste@.com"));

        Assertions.assertDoesNotThrow(() -> new Usuario("123.456.789-99", "teste", LocalDate.parse("1990-09-08"), "teste@.com"));

    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario(){
        FabricaUsuario fabricaUsuario = new FabricaUsuario();

        String nomeTeste, complemento;

        nomeTeste = "teste";
        Usuario usuario = fabricaUsuario.comNomeCpfNascimento(nomeTeste, "123.456.789-99", LocalDate.parse("1990-09-08"));
        Assertions.assertTrue(Objects.nonNull(usuario));
        Assertions.assertEquals(nomeTeste, usuario.getNome());

        complemento = "apto 201";
        usuario = fabricaUsuario.incluiEndereco("04905-002", 40, complemento);
        Assertions.assertTrue(Objects.nonNull(usuario.getEndereco()));
        Assertions.assertEquals(complemento, usuario.getEndereco().getComplemento());
    }

    @Test
    public void naoDeveCadastrarUsuarioMenorDe18Anos(){
        LocalDate dataParaIdadeIncorreta = LocalDate.now().minusYears( 17);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456.789-99", "teste", dataParaIdadeIncorreta, "teste@.com"));

    }
}
