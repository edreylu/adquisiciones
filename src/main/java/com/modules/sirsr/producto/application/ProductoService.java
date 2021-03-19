/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modules.sirsr.producto.application;

import com.modules.sirsr.clavePresupuestaria.application.ClavePresupuestariaDTO;
import com.modules.sirsr.clavePresupuestaria.application.ClavePresupuestariaService;
import com.modules.sirsr.config.Mensaje;
import com.modules.sirsr.config.WebUtils;
import com.modules.sirsr.objetoGasto.application.ObjetoDeGastoService;
import com.modules.sirsr.producto.domain.Producto;
import com.modules.sirsr.producto.domain.ProductoRepository;
import com.modules.sirsr.tipoProducto.domain.TipoProducto;
import com.modules.sirsr.tipoProducto.domain.TipoProductoRepository;
import com.modules.sirsr.usuario.application.UsuarioDTO;
import com.modules.sirsr.usuario.application.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Edward Reyes
 */
@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ObjetoDeGastoService objetoDeGastoService;
    private final UsuarioService usuarioService;
    private final ClavePresupuestariaService clavePresupuestariaService;
    private final TipoProductoRepository tipoProductoRepository;
    private final ProductoMapper productoMapper;
    private Mensaje msg;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, ObjetoDeGastoService objetoDeGastoService, UsuarioService usuarioService, ClavePresupuestariaService clavePresupuestariaService, TipoProductoRepository tipoProductoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.objetoDeGastoService = objetoDeGastoService;
        this.usuarioService = usuarioService;
        this.clavePresupuestariaService = clavePresupuestariaService;
        this.tipoProductoRepository = tipoProductoRepository;
        this.productoMapper = productoMapper;
    }

    public List<ProductoDTO> findAll() {
        return productoMapper.toProductoDTOs(productoRepository.findAll());
    }

    public List<ProductoDTO> findByIdTipoProducto() {
        List<ClavePresupuestariaDTO> clavePresupuestariaDTOS = clavePresupuestariaService.findByClaveUr();
        List<String> objetosDegasto = clavePresupuestariaDTOS
                                    .stream()
                                    .map(clavePresupuestariaDTO -> clavePresupuestariaDTO.getObjetoGasto().getObjetoGasto())
                                    .collect(Collectors.toList());
        List<TipoProducto> tiposProducto = tipoProductoRepository.findByObjetoGastoStrIn(objetosDegasto);

        List<Integer> tiposProductoF = tiposProducto.stream().map(tipoProducto -> tipoProducto.getIdTipoProducto()).collect(Collectors.toList());
        return productoMapper.toProductoDTOs(productoRepository.findByIdTipoProductoIn(tiposProductoF));
    }

    public ProductoDTO findById(int id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        ProductoDTO productoDTO = productoMapper.toProductoDTO(productoOptional.get());
        return productoDTO;
    }

    public Mensaje save(ProductoDTO productoDTO) {
        return msg;
    }

    public Mensaje update(ProductoDTO productoDTO, int id) {
        return msg;
    }

    public Mensaje deleteById(int id) {
        return msg;
    }

}
