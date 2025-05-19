package com.AdoptSmile.AdoptSmile.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.AdoptSmile.AdoptSmile.Model.Usuario;
import com.AdoptSmile.AdoptSmile.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, Usuario usuario) {
        Usuario usuarioToUpdate = usuarioRepository.findById(id).orElse(null);
        if (usuarioToUpdate != null) {
            usuarioToUpdate.setNombre(usuario.getNombre());
            usuarioToUpdate.setCorreo(usuario.getCorreo());
            return usuarioRepository.save(usuarioToUpdate);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario patch(Long id, Usuario usuario) {
        Usuario usuarioToPatch = usuarioRepository.findById(id).orElse(null);
        if (usuarioToPatch != null) {
            if (usuario.getNombre() != null) {
                usuarioToPatch.setNombre(usuario.getNombre());
            }
            if (usuario.getCorreo() != null) {
                usuarioToPatch.setCorreo(usuario.getCorreo());
            }
            return usuarioRepository.save(usuarioToPatch);
        } else {
            return null;
        }
    }

    public Usuario findByNombre(String nombre) {
    return usuarioRepository.findByNombre(nombre);
}
}
