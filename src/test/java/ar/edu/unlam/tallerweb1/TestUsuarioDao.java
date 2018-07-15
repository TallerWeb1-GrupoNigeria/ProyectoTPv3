package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-applicationContext.xml" })
public class TestUsuarioDao {

    @Inject
    private UsuarioDao usuarioDao;

    private Usuario usuario;


    @Test
    public void consultarUsuario() {

        /* Inicialización */
        usuario = new Usuario();
        //usuario.setId(1L);
        usuario.setEmail("l@lllllll");
        usuario.setPassword("1");
        usuario.setNombre("pedro");
        usuario.setRol("admin");
        Usuario	usuario1 = new Usuario();
        //usuario1.setId(1L);
        usuario1.setEmail("l@iiiiiiil");
        usuario1.setPassword("1");
        usuario1.setNombre("pedro");
        usuario1.setRol("admin");
        
       

        /* Operación */
        usuarioDao.registrarUsuario(usuario1);
        usuarioDao.registrarUsuario(usuario);
        
        Usuario resultado = usuarioDao.buscarUsuarioPorId(usuario.getId());
        long idresultado = resultado.getId();
       
        /* Verificación */
     
        assertThat(resultado.getId()).isEqualTo(usuario.getId());

    }

}